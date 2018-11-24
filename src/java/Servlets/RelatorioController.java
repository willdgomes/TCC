/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Lote;
import Beans.Medicamento;
import Facade.LotesFacade;
import Facade.MedicamentosFacade;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Eu
 */
@WebServlet(name = "RelatorioController", urlPatterns = {"/RelatorioController"})
public class RelatorioController extends HttpServlet {
    
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
     
        ServletContext medContext = request.getServletContext();
        LinkedList tdQuantidade = new LinkedList();
        List<Medicamento> medicamentos = MedicamentosFacade.listarMedicamentos();
        List<String> quantidade = new ArrayList<String>();
        List<String> nomeMed = new ArrayList<String>();
        for (Medicamento medicamento : medicamentos) {
            nomeMed.add(medicamento.getNome());
            Integer quant =LotesFacade.buscarQuantidade(medicamento.getId().toString()); 
            quantidade.add("1");
            quantidade.add(quant.toString());
            quantidade.add("1");
            quantidade.add(quant.toString());
            tdQuantidade.add(quantidade);
            quantidade = new ArrayList<String>();
        }
        
        Integer totalMed = medicamentos.size();
        List<String> periodo = new ArrayList<String>();
        periodo.add("jan");
        periodo.add("fev");
        periodo.add("mar");
        periodo.add("abr");
        periodo.add("maio");
        periodo.add("Jun");
        
        medContext.setAttribute("totalMedJson",new Gson().toJson(totalMed.toString()));
        medContext.setAttribute("quantidadeJson",new Gson().toJson(tdQuantidade.toArray()));
        medContext.setAttribute("nomeMedJson",new Gson().toJson(nomeMed.toArray()));
        medContext.setAttribute("periodoJson",new Gson().toJson(periodo.toArray()));
           RequestDispatcher rd = getServletContext().getRequestDispatcher("/relatorioEstoque.jsp");
            rd.forward(request, response);
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
