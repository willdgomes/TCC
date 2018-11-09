/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Lote;
import Beans.Medicamento;
import Beans.Paciente;
import DAO.MedicamentoDAO;
import DAO.PacienteDAO;
import Facade.LotesFacade;
import Facade.MedicamentosFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
 * @author gomes
 */
@WebServlet(name = "GerenciarMedicamentoController", urlPatterns = {"/GerenciarMedicamentoController"}, loadOnStartup = 1)
public class GerenciarMedicamentoController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        MedicamentosFacade medicamentosFacade = new MedicamentosFacade();
        List<Medicamento> medicamentos = new ArrayList<Medicamento>();
        medicamentos = medicamentosFacade.listarMedicamentos();
        ServletContext medContext = config.getServletContext();
        medContext.setAttribute("medicamentos", medicamentos);
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
        String action = request.getParameter("action");
        if (session.getAttribute("usuario") == null) {
            session.invalidate();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.include(request, response);
        } else {
            if (action.equals("insereMedicamentoLote")) {
                
                //busca medicamento para inserir lote no estoque
                
                MedicamentosFacade medFacade = new MedicamentosFacade();
                Medicamento medicamento = new Medicamento();
                String nomeMedicamento = request.getParameter("nomeMed");
                String qtde = request.getParameter("qtdeCaixa");
                String numeroLote = request.getParameter("NumeroLote");
                Date dataVencimentoLote = new Date();
                medicamento = medFacade.pegarMedicamentoPorNome(nomeMedicamento);
                Lote lote = new Lote(1, medicamento, 8, dataVencimentoLote);
                LotesFacade.inserir(lote);
            }
            else if (action.equals("pesquisarMedicamento")) {
                MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
                List<Medicamento> medicamentoList = medicamentoDAO.buscarMedicamentosParam(request.getParameter("pesquisa"));
                if (session != null) {
                    RequestDispatcher rd = null;
                    if (medicamentoList.size() > 0) {
                        request.setAttribute("medicamentos", medicamentoList);
                    } else {
                        request.setAttribute("mensagem", "Medicamento não cadastrado no sistema");
                    }
                    rd = getServletContext().getRequestDispatcher("/gerenciarMedicamentos.jsp");
                    rd.include(request, response);
                } else {
                    request.setAttribute("msg", "Usuário e/ou senha incorreto(s)!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                    rd.forward(request, response);
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
