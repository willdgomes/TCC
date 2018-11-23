/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Usuario;
import DAO.UsuarioDAO;
import Facade.UsuariosFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "CadastroUsuarioController", urlPatterns = {"/CadastroUsuarioController"})
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
        HttpSession session = request.getSession(false);
        String action = request.getParameter("action");
        if (session == null) {
            RequestDispatcher rd = request.
                    getRequestDispatcher("/index.html");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema!");
            rd.forward(request, response);
        } else {
            if(action.equals("carregarGerenciamento")){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciarUsuarios.jsp");
                rd.forward(request, response);
            }else
                 if(action.equals("carregarCadastro")){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrarUsuarios.jsp");
                rd.forward(request, response);
            }else
            if (action.equals("cadastrarUsuario")) {
                
                Usuario usuario= criaUsuario(request);
                UsuariosFacade.cadastrar(usuario);
                Usuario usuarioSession = new Usuario();
                usuario = (Usuario)session.getAttribute("usuario");
                if (usuarioSession != null) {
                    session = request.getSession();
                    session.setAttribute("usuario", usuarioSession);
                    session.setMaxInactiveInterval(20 * 60);
                    RequestDispatcher rd = null;
                    rd = getServletContext().getRequestDispatcher("/cadastrarUsuario.jsp");
                    rd.include(request, response);
                } else {
                    request.setAttribute("msg", "Erro ao cadastrar o usuario!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                    rd.forward(request, response);
                }
            }
        }
    }

    private Usuario criaUsuario(HttpServletRequest request) {
        String id = request.getParameter("idUsuario");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String perfil = request.getParameter("perfil");

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
        usuario.setDataNascimento(dataNascimento);
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
