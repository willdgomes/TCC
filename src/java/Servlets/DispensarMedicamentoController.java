/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Medicamento;
import DAO.MedicamentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eu
 */
@WebServlet(name = "MedicamentoController", urlPatterns = {"/MedicamentoController"})
public class DispensarMedicamentoController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MedicamentoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MedicamentoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            //----
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            String stringData = "2019-12-27";
            stringData = stringData.replaceAll("-", "/");
            java.util.Date dataVencimento = null;
            try{
                dataVencimento = format.parse(stringData);
            }catch(ParseException e){
                e.printStackTrace();
            }
            
            java.sql.Date sqlDataVencimento = new java.sql.Date(dataVencimento.getTime());
            Medicamento med = new Medicamento(3, "nome remedio2", "lote lote2", sqlDataVencimento, "remedio2");
            MedicamentoDAO medDAO = new MedicamentoDAO();
            medDAO.atualizarMedicamento(med);
            //----
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
