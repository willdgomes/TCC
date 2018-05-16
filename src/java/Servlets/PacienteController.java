/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Paciente;
import Beans.Usuario;
import DAO.PacienteDAO;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author gomes
 */
@WebServlet(name = "PacienteController", urlPatterns = {"/PacienteController"})
public class PacienteController extends HttpServlet {

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
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            request.setAttribute("msg", "Acesso negado!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Paciente paciente = new Paciente();
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.inserirPaciente(paciente);
        Client client = ClientBuilder.newClient();
//        if (request.getParameter("tipo") != null) {
//            if (request.getParameter("tipo").equals("busca")) {
//                String nome = request.getParameter("buscaFuncionario");
//                List<Funcionario> lista = new ArrayList<>();
//                if (nome.equals("")) {
//                    Response resp = client.target("http://localhost:21836/WSFinal/webresources/funcionarios").request(MediaType.APPLICATION_JSON).get();
//                    lista = resp.readEntity(new GenericType<List<Funcionario>>() {
//                    });
//                } else {
//                    Response resp = client.target("http://localhost:21836/WSFinal/webresources/funcionarios/nome/" + nome).request(MediaType.APPLICATION_JSON).get();
//                    lista = resp.readEntity(new GenericType<List<Funcionario>>() {
//                    });
//                }
//                request.setAttribute("lista", lista);
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/buscar_funcionarios.jsp");
//                rd.forward(request, response);
//            }
//        }
//        if (request.getParameter("tipo") != null) {
//            if (request.getParameter("tipo").equals("cadastro")) {
//                List<Empresa> lista = new ArrayList<>();
//                lista = empresaDAO.buscarNomes();
//                request.setAttribute("lista", lista);
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrar_funcionario.jsp");
//                rd.forward(request, response);
//            }
//        }
//        if (request.getParameter("tipo") != null) {
//            if (request.getParameter("tipo").equals("cadastrar")) {
//                usuario.setLogin(request.getParameter("login"));
//                usuario.setNome(request.getParameter("nome"));
//                usuario.setSenha(request.getParameter("senha"));
//                usuarioDAO.inserirUsuario(usuario);
//                endereco.setBairro(request.getParameter("bairro"));
//                endereco.setCidade(request.getParameter("cidade"));
//                endereco.setCep(request.getParameter("cep"));
//                endereco.setRua(request.getParameter("rua"));
//                endereco.setNumero(Integer.valueOf(request.getParameter("numero")));
//                endereco.setUf(request.getParameter("uf"));
//                funcionario.setNome(request.getParameter("nome"));
//                funcionario.setCpf(request.getParameter("cpf"));
//                funcionario.setEmailFuncionario(request.getParameter("email"));
//                funcionario.setCelular(request.getParameter("celular"));
//                funcionario.setIdEmpresa(Integer.valueOf(request.getParameter("idEmpresa")));
//                funcionario.setEnderecoFuncionario(endereco);
//                client.target("http://localhost:21836/WSFinal/webresources/funcionarios").request(MediaType.APPLICATION_JSON).post(Entity.json(funcionario));
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/PortalController");
//                rd.forward(request, response);
//            }
//        }
//        if (request.getParameter("tipo") == null) {
//            if (request.getParameter("fun") != null) {
//                List<Empresa> lista = new ArrayList<>();
//                lista = empresaDAO.buscarNomes();
//                funcionario = client.target("http://localhost:21836/WSFinal/webresources/funcionarios/" + request.getParameter("fun")).request(MediaType.APPLICATION_JSON).get(Funcionario.class);
//                request.setAttribute("funcionario", funcionario);
//                request.setAttribute("lista", lista);
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/alterar_funcionario.jsp");
//                rd.forward(request, response);
//            }
//        }
//        if (request.getParameter("tipo") != null) {
//            if (request.getParameter("tipo").equals("alterar")) {
//                endereco.setBairro(request.getParameter("bairro"));
//                endereco.setCidade(request.getParameter("cidade"));
//                endereco.setCep(request.getParameter("cep"));
//                endereco.setRua(request.getParameter("rua"));
//                endereco.setNumero(Integer.valueOf(request.getParameter("numero")));
//                endereco.setUf(request.getParameter("uf"));
//                funcionario.setIdFuncionario(Integer.valueOf(request.getParameter("id")));
//                funcionario.setNome(request.getParameter("nome"));
//                funcionario.setCpf(request.getParameter("cpf"));
//                funcionario.setEmailFuncionario(request.getParameter("email"));
//                funcionario.setCelular(request.getParameter("celular"));
//                funcionario.setIdEmpresa(Integer.valueOf(request.getParameter("idEmpresa")));
//                funcionario.setEnderecoFuncionario(endereco);
//                client.target("http://localhost:21836/WSFinal/webresources/funcionarios/" + request.getParameter("id")).request(MediaType.APPLICATION_JSON).put(Entity.json(funcionario));
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/PortalController");
//                rd.forward(request, response);
//            }
//        }
//        if (request.getParameter("tipo") == null) {
//            if (request.getParameter("func") != null) {
//                usuarioDAO.deletarUsuario(Integer.valueOf(request.getParameter("func")));
//                client.target("http://localhost:21836/WSFinal/webresources/funcionarios/" + request.getParameter("func")).request(MediaType.APPLICATION_JSON).delete();
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/PortalController");
//                rd.forward(request, response);
//            }
//        }
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
