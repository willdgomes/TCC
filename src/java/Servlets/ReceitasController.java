/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Medicamento;
import Beans.Paciente;
import Beans.Receita;
import Facade.MedicamentosFacade;
import Facade.PacientesFacade;
import Facade.ReceitasFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.List;
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
@WebServlet(name = "ReceitasController", urlPatterns = {"/ReceitasController"})
public class ReceitasController extends HttpServlet {

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
        String action = request.getParameter("action");
        if (session.getAttribute("usuario") == null) {
            session.invalidate();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.include(request, response);
        } else {
            if (action.equals("cadastrarReceita")) {
                String idPaci = request.getParameter("idPaci");
                String nomeMedico = request.getParameter("medicoNomeReceita");
                String crmMedico = request.getParameter("medicoCrmReceita");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                String stringDataVencimento = request.getParameter("dataVencimentoReceita");
                stringDataVencimento = stringDataVencimento.replaceAll("-", "/");
                java.util.Date dataVencimento = null;
                try {
                    dataVencimento = format.parse(stringDataVencimento);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                java.sql.Date dtVencimento = new java.sql.Date(dataVencimento.getTime());
                String[] listaMedicamento = request.getParameterValues("nome");
                Paciente paciente = new Paciente();
                paciente = PacientesFacade.buscarId(idPaci);
                Receita receita = new Receita(paciente, nomeMedico, crmMedico, (java.sql.Date) dtVencimento);
                


                //validar receita para cadastrar
                
                
                
                ReceitasFacade.inserirReceita(receita);
                receita = ReceitasFacade.buscarPorIdPaciente(paciente.getId());
                List<Medicamento> listMed = new ArrayList<Medicamento>();
                for(int i=0; i<listaMedicamento.length; i++){
                    listMed.add(MedicamentosFacade.buscarMedicamentoPorNomeInserir(listaMedicamento[i]));
                    ReceitasFacade.inserirMedicamentosReceitas(listMed.get(i).getId(), receita.getId());
                }
                RequestDispatcher rd = null;
                rd = getServletContext().getRequestDispatcher("/cadastrarReceita.jsp");
                rd.include(request, response);
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
