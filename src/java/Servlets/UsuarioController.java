/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Log;
import Beans.Usuario;
import DAO.UsuarioDAO;
import Facade.LogFacade;
import Facade.UsuariosFacade;
import JavaMail.JavaMail;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gomes
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (session == null) {
            LogFacade.inserir(new Log("Sessão do usuário expirada"));
            RequestDispatcher rd = request.
            getRequestDispatcher("/index.html");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema!");
            rd.forward(request, response);
        } else {
            Usuario usuario = (Usuario)session.getAttribute("usuario");
            if(usuario.getPerfil().equalsIgnoreCase("Administrador"))
                request.setAttribute("perfil",true);
            session.setAttribute("usuario", usuario);
            session.setMaxInactiveInterval(20 * 60);
            if(action.equals("minhaConta")){
                
            } else
            if (action.equals("carregarGerenciamento")) {
                atualizarUsuariosLista(request);
                LogFacade.inserir(new Log(usuario.getIdUsuario(),"Usuário acessou o gerenciamento de usuários"));
                request.setAttribute("successAlert", new Gson().toJson("false"));
                request.setAttribute("errorAlert", new Gson().toJson("false"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciarUsuarios.jsp");
                rd.forward(request, response);
            } else if (action.equals("pesquisarUsuario")) {
                String pesquisa = request.getParameter("pesquisa");
                List<Usuario> usuariosList = UsuariosFacade.buscarUsuario(pesquisa);
                ServletContext usuContext = request.getServletContext();
                usuContext.setAttribute("usuarios", usuariosList);
                LogFacade.inserir(new Log(usuario.getIdUsuario(),"Usuário pesquisou pelo(a) usuário(a) "+ pesquisa));
                if (usuariosList.size() == 0) {
                        request.setAttribute("errorAlert", new Gson().toJson("true"));
                }
                else{
                    request.setAttribute("errorAlert", new Gson().toJson("false"));
                }
                request.setAttribute("successAlert", new Gson().toJson("false"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciarUsuarios.jsp");
                rd.forward(request, response);
            } else if (action.equals("editar")) {
                String id = request.getParameter("idUsuario");
                if(id == null)
                    id = usuario.getIdUsuario().toString();
                Usuario usuarioEditar = UsuariosFacade.buscarUsuarioPorId(id);
                LogFacade.inserir(new Log(usuario.getIdUsuario(),"Usuário acessou a página de edição do usuário "+usuarioEditar.getNome()));
                request.setAttribute("usuario", usuarioEditar);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarUsuario.jsp");
                requestDispatcher.forward(request, response);
            } else if (action.equals("carregarCadastro")) {
                LogFacade.inserir(new Log(usuario.getIdUsuario(),"Usuário acessou o cadastro de usuários"));
                request.setAttribute("successAlert", new Gson().toJson("false"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrarUsuario.jsp");
                rd.forward(request, response);
            } else if (action.equals("cadastrarUsuario")) {
                UsuariosFacade.cadastrar(criaUsuario(request));
                atualizarUsuariosLista(request);
                LogFacade.inserir(new Log(usuario.getIdUsuario(),"Usuário cadastrou outro usuário"));
                request.setAttribute("successAlert", new Gson().toJson("true"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrarUsuario.jsp");
                rd.include(request, response);
            } else if (action.equals("editarUsuario")) {
                UsuariosFacade.alterar(criaUsuario(request));
                atualizarUsuariosLista(request);
                 String nome = request.getParameter("nome");
                LogFacade.inserir(new Log(usuario.getIdUsuario(),"Usuário editou o(a) usuário(a) "+nome));
                request.setAttribute("successAlert", new Gson().toJson("true"));
                request.setAttribute("errorAlert", new Gson().toJson("false"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciarUsuarios.jsp");
                rd.include(request, response);
            }
        }
    }

     private void atualizarUsuariosLista(HttpServletRequest request) {
        ServletContext servContext = request.getServletContext();
        servContext.setAttribute("usuarios", UsuariosFacade.listarUsuarios());
    }

    private Usuario criaUsuario(HttpServletRequest request) {
        String id = request.getParameter("idUsuario");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String perfil = request.getParameter("perfilUsuario");

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String stringData = request.getParameter("dataNascimento");
        stringData = stringData.replaceAll("-", "/");
        java.util.Date dataNascimento = null;
        try {
            dataNascimento = format.parse(stringData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date dtNascimento = new java.sql.Date(dataNascimento.getTime());

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setLogin(login);
        usuario.setSenha("1234");
        usuario.setPerfil(perfil);
        usuario.setDataNascimento(dtNascimento);
        JavaMail.sendEmail(usuario.getEmail(), usuario.getSenha());
        if (id != null) {
            usuario.setIdUsuario(Integer.parseInt(id));
        }
        return usuario;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
