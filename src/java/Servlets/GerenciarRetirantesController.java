/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Retirante;
import Beans.Paciente;
import DAO.PacienteDAO;
import DAO.RetiranteDAO;
import Facade.RetirantesFacade;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "GerenciarRetirantesController", urlPatterns = {"/GerenciarRetirantesController"})
public class GerenciarRetirantesController extends HttpServlet {
public void init(ServletConfig config) throws ServletException {
        RetirantesFacade retirantesFacade = new RetirantesFacade();
        List<Retirante> retirante = new ArrayList<Retirante>();
        retirante = retirantesFacade.listaRetirantes();
        ServletContext medContext = config.getServletContext();
        medContext.setAttribute("medicamentos", retirante);
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
      HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            session.invalidate();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.include(request, response);
        }
        else {
            String pesquisa = request.getParameter("pesquisa");
            
            //Paciente paciente = new Paciente();
            RetiranteDAO retiranteDAO = new RetiranteDAO();
            List<Paciente> pacienteList = retiranteDAO.buscarRetirantesParam(pesquisa);
            if (session != null) {            
                RequestDispatcher rd = null;
                if(pacienteList.size() > 0)
                    request.setAttribute("retirantes", pacienteList);
                else
                    request.setAttribute("mensagem", "Retirante não cadastrado no sistema");
                rd = getServletContext().getRequestDispatcher("/gerenciarPacientes.jsp");
                rd.include(request, response);
            }
            else {
                request.setAttribute("msg", "Usuário e/ou senha incorreto(s)!");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                rd.forward(request, response);
            }
        }
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
