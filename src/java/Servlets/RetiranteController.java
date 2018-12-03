/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Log;
import Beans.Paciente;
import Beans.Retirante;
import Beans.Usuario;
import DAO.RetiranteDAO;
import Facade.LogFacade;
import Facade.PacientesFacade;
import Facade.RetirantesFacade;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eu
 */
@WebServlet(name = "RetiranteController", urlPatterns = {"/RetiranteController"}, loadOnStartup = 3)
public class RetiranteController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        List<Retirante> retirante = RetirantesFacade.listaRetirantes();
        ServletContext medContext = config.getServletContext();
        medContext.setAttribute("retirantes", retirante);
    }

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
        if (session.getAttribute("usuario") == null) {
            LogFacade.inserir(new Log("Sessão do usuário expirada"));
            session.invalidate();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.include(request, response);
        } else {
            session = request.getSession();
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            if (usuario.getPerfil().equalsIgnoreCase("Administrador")) {
                request.setAttribute("perfil", true);
            }
            session.setAttribute("usuario", usuario);
            session.setMaxInactiveInterval(20 * 60);

            if (action.equals("carregarCadastro")) {
                LogFacade.inserir(new Log(usuario.getIdUsuario(), "Usuário acessou o cadastro de retirantes"));
                request.setAttribute("successAlert", new Gson().toJson("false"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrarRetirante.jsp");
                rd.forward(request, response);
            } else if (action.equals("carregarGerenciamento")) {
                LogFacade.inserir(new Log(usuario.getIdUsuario(), "Usuário acessou o gerenciamento de retirantes"));
                request.setAttribute("successAlert", new Gson().toJson("false"));
                request.setAttribute("errorAlert", new Gson().toJson("false"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciarRetirantes.jsp");
                rd.forward(request, response);
            } else if (action.equals("carregarCadastro")) {
                request.setAttribute("successAlert", new Gson().toJson("false"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrarRetirante.jsp");
                rd.forward(request, response);
            } else if (action.equals("cadastrarRetirante")) {
                Retirante r = new Retirante();
                r = criaRetirante(request);
                RetirantesFacade.cadastrarRetirante(r);
                r = RetirantesFacade.buscarRetirantePorCpf(r.getCpfRetirante());
                String idPaciente = request.getParameter("paciente");
                RetirantesFacade.inserirRetirantePaciente(idPaciente, r.getIdRetirante());
                atualizarRetirantesLista(request);
                request.setAttribute("successAlert", new Gson().toJson("true"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastrarRetirante.jsp");
                requestDispatcher.forward(request, response);

            } else if (action.equals("pesquisarRetirante")) {
                String pesquisa = request.getParameter("pesquisa");
                List<Retirante> retiranteList = RetirantesFacade.buscarRetirantesNome(pesquisa);
                if (retiranteList.size() == 0) {
                    request.setAttribute("errorAlert", new Gson().toJson("true"));
                } else {
                    request.setAttribute("errorAlert", new Gson().toJson("false"));
                }
                request.setAttribute("retirantes", retiranteList);
                request.setAttribute("successAlert", new Gson().toJson("false"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gerenciarRetirantes.jsp");
                requestDispatcher.forward(request, response);

            } else if (action.equals("editar")) {
                String id = request.getParameter("idRetirante");
                Retirante retirante = RetirantesFacade.buscarRetirantePorId(id);
              //  request.setAttribute("retiranteJson", new Gson().toJson(retirante.getPaciente().getId().toString()));
                request.setAttribute("retiranteJson", new Gson().toJson(retirante.getVincolo()));
                request.setAttribute("retirante", retirante);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarRetirante.jsp");
                requestDispatcher.forward(request, response);
            } else if (action.equals("editarRetirante")) {
                Retirante retirante = criaRetirante(request);
                String idPaciente = request.getParameter("paciente");
                RetirantesFacade.inserirRetirantePaciente(idPaciente, retirante.getIdRetirante());
                RetirantesFacade.alterarRetirante(retirante);
                atualizarRetirantesLista(request);
                request.setAttribute("successAlert", new Gson().toJson("true"));
                request.setAttribute("errorAlert", new Gson().toJson("false"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gerenciarRetirantes.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }

    private void atualizarRetirantesLista(HttpServletRequest request) {
        ServletContext pacContext = request.getServletContext();
        pacContext.setAttribute("retirantes", RetirantesFacade.listaRetirantes());
    }

    private Retirante criaRetirante(HttpServletRequest request) {
        String id = request.getParameter("idRetirante");
        String nome = request.getParameter("nomeRetirante");
        String cpf = request.getParameter("cpfRetirante");
        cpf = cpf.replaceAll("\\W", "");
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String stringData = request.getParameter("dtNascimento");
        stringData = stringData.replaceAll("-", "/");
        java.util.Date dataNascimento = null;
        try {
            dataNascimento = format.parse(stringData);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String telefone = request.getParameter("telefone");
        telefone = telefone.replaceAll("\\W", "");
        String email = request.getParameter("emailRetirante");
        String parentesco = request.getParameter("parentesco");
        String cep = request.getParameter("cepRetirante");
        String cidade = request.getParameter("cidadeRetirante");
        String estado = request.getParameter("estadoRetirante");
        String bairro = request.getParameter("bairroRetirante");
        String endereco = request.getParameter("enderecoRetirante");
        String numeroEndereco = request.getParameter("numeroEnderecoRetirante");
        String complemento = request.getParameter("complementoRetirante");

        Retirante retirante = new Retirante();
        retirante.setNomeRetirante(nome);
        retirante.setCpfRetirante(cpf);
        java.sql.Date dtNascimento = new java.sql.Date(dataNascimento.getTime());
        retirante.setDnRetirante(dtNascimento);
        retirante.setTelefone(telefone);
        retirante.setEmail(email);
        retirante.setVincolo(parentesco);
        retirante.setCep(cep);
        retirante.setCidade(cidade);
        retirante.setEstado(estado);
        retirante.setBairro(bairro);
        retirante.setEndereco(endereco);
        retirante.setNumEndereco(numeroEndereco);
        retirante.setComplemento(complemento);
        if (id != null) {
            retirante.setIdRetirante(Integer.parseInt(id));
        }
        return retirante;
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
