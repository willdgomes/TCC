/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Paciente;
import DAO.PacienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "GerenciarPacientesController", urlPatterns = {"/GerenciarPacientesController"})
public class GerenciarPacientesController extends HttpServlet {

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
//        HttpSession session = request.getSession();
//        if (session.getAttribute("usuario") != null) {
//            session.invalidate();
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
//            rd.include(request, response);
//        } else {
//            String pesquisa = request.getParameter("pesquisa");
//            String nome = request.getParameter("nome");
//            String cpf = request.getParameter("cpf");
//            String dt = request.getParameter("dataNascimento");
//            String stringData = request.getParameter("dataNascimento");
//            Date dataNascimento = Date.valueOf(stringData);
//            String telefone = request.getParameter("telefone");
//            String email = request.getParameter("email");
//            String cep = request.getParameter("cep");
//            String cidade = request.getParameter("cidade");
//            String estado = request.getParameter("estado");
//            String bairro = request.getParameter("bairro");
//            String endereco = request.getParameter("endereco");
//            String numeroEndereco = request.getParameter("numeroEndereco");
//            String complemento = request.getParameter("complemento");
//
//            Paciente paciente = new Paciente();
//            paciente.setNome(nome);
//            paciente.setCpf(cpf);
//            paciente.setDataNascimento(dataNascimento);
//            paciente.setTelefone(telefone);
//            paciente.setEmail(email);
//            paciente.setCep(cep);
//            paciente.setCidade(cidade);
//            paciente.setEstado(estado);
//            paciente.setBairro(bairro);
//            paciente.setEndereco(endereco);
//            paciente.setNumEndereco(numeroEndereco);
//            paciente.setComplemento(complemento);
//
//            PacienteDAO pacienteDAO = new PacienteDAO();
//            pacienteDAO.inserirPaciente(paciente);
//            if (paciente != null) {
//                session = request.getSession();
//                session.setAttribute("paciente", paciente);
//                session.setMaxInactiveInterval(20 * 60);
//                RequestDispatcher rd = null;
//                rd = getServletContext().getRequestDispatcher("/cadastrarPacientes.jsp");
//                rd.include(request, response);
//            } else {
//                request.setAttribute("msg", "Erro ao cadastrar o paciente!");
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
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
