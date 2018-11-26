/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Dispensa;
import Beans.Medicamento;
import Beans.Paciente;
import Beans.Retirante;
import Facade.MedicamentosFacade;
import Facade.PacientesFacade;
import Facade.ReceitasFacade;
import Facade.RetirantesFacade;
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

/**
 *
 * @author gomes
 */
@WebServlet(name = "DispensaController", urlPatterns = {"/DispensaController"})
public class DispensaController extends HttpServlet {

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
        
        Dispensa dispensa = new Dispensa();
        HttpSession session = request.getSession(false);
        String action = request.getParameter("action");
        if (session == null) {
            RequestDispatcher rd = request.
                    getRequestDispatcher("/index.html");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema!");
            rd.forward(request, response);
        } else {
            if (action.equals("selecionaMedicamento")) {
                String idPaciente = request.getParameter("idPaci");
                String cpfRetirante = request.getParameter("cpfRetirante");
                String[] listaMedicamento = request.getParameterValues("nome");
                String[] quantidadeMed = request.getParameterValues("quantidade");
                
                Paciente paciente = new Paciente();
                paciente = PacientesFacade.buscarId(idPaciente);
                Retirante retirante = new Retirante();
                retirante = RetirantesFacade.buscarRetirantePorCpf(cpfRetirante);
                if(!RetirantesFacade.buscarRetirantePaciente(idPaciente, retirante.getIdRetirante())){
                    // retirante nao bate com paciente
                }
                List<Medicamento> listMed = new ArrayList<Medicamento>();
                Medicamento med = new Medicamento();
                for(int i=0; i<listaMedicamento.length; i++){
                    listMed.add(MedicamentosFacade.pegarMedicamentoPorNome(listaMedicamento[i]));
                }
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
