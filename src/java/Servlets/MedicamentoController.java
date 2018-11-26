/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Lote;
import Beans.Medicamento;
import Beans.Paciente;
import Beans.Usuario;
import DAO.MedicamentoDAO;
import DAO.PacienteDAO;
import Facade.LotesFacade;
import Facade.MedicamentosFacade;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "MedicamentoController", urlPatterns = {"/MedicamentoController"}, loadOnStartup = 1)
public class MedicamentoController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        List<Medicamento> medicamentos = MedicamentosFacade.listarMedicamentos();
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
            Usuario usuarioSession = new Usuario();
            session = request.getSession();
            session.setAttribute("usuario", usuarioSession);
            session.setMaxInactiveInterval(20 * 60);
            
            if (action.equals("carregarCadastro")) {
                request.setAttribute("successAlert", new Gson().toJson("false"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrarMedicamento.jsp");
                rd.forward(request, response);
            } else 
                if (action.equals("cadastrarMedicamento")) {
                MedicamentosFacade.cadastrar(criarMedicamento(request));
                request.setAttribute("successAlert", new Gson().toJson("true"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrarMedicamento.jsp");
                rd.forward(request, response);
            } else
                if (action.equals("carregarGerenciamento")) {
                request.setAttribute("successAlert", new Gson().toJson("false"));
                request.setAttribute("errorAlert", new Gson().toJson("false"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerenciarMedicamentos.jsp");
                rd.forward(request, response);
            } else
                if(action.equals("inserirMedicamento")){
                 request.setAttribute("successAlert", new Gson().toJson("false"));
                 RequestDispatcher rd = getServletContext().getRequestDispatcher("/inserirMedicamento.jsp");
                 rd.forward(request, response);}
                else
                if (action.equals("insereMedicamentoLote")) {
                //busca medicamento para inserir lote no estoque
                MedicamentosFacade medFacade = new MedicamentosFacade();
                Medicamento medicamento = new Medicamento();
                String nomeMedicamento = request.getParameter("nomeMed");
                String qtde = request.getParameter("qtdeCaixa");
                String numeroLote = request.getParameter("numeroLote");

                String dtVenc = request.getParameter("vencimentoLote");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                dtVenc = dtVenc.replaceAll("-", "/");
                Date data = null;
                try {
                    data = format.parse(dtVenc);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                java.sql.Date dataVencimentoLote = new java.sql.Date(data.getTime());
                Lote lote = LotesFacade.pegarLotePorNumero(Integer.parseInt(numeroLote));
                if (lote == null) {
                    medicamento = medFacade.pegarMedicamentoPorNome(nomeMedicamento);
                    lote = new Lote(Integer.parseInt(numeroLote), medicamento, Integer.parseInt(qtde), dataVencimentoLote);
                    LotesFacade.inserir(lote);
                } else {
                    lote.setQtde(lote.getQtde() + Integer.parseInt(qtde));
                    LotesFacade.atualizarLote(lote);
                }
                request.setAttribute("successAlert", new Gson().toJson("true"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/inserirMedicamento.jsp");
                requestDispatcher.forward(request, response);
            } else 
                    if (action.equals("pesquisarMedicamento")) {
                String pesquisa = request.getParameter("pesquisa");
                List<Medicamento> medicamentoList = MedicamentosFacade.buscarMedicamento(pesquisa);
                request.setAttribute("medicamentos", medicamentoList);
                if (medicamentoList.size() == 0) {
                    request.setAttribute("errorAlert", new Gson().toJson("true"));
                }
                else{
                    request.setAttribute("errorAlert", new Gson().toJson("false"));
                }
                request.setAttribute("successAlert", new Gson().toJson("false"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gerenciarMedicamentos.jsp");
                requestDispatcher.forward(request, response);
            } else 
                if (action.equals("editar")) {
                String id = request.getParameter("idMedicamento");
                MedicamentosFacade medicamentosFacade = new MedicamentosFacade();
                Medicamento medicamento = medicamentosFacade.pegarMedicamentoPorId(Integer.parseInt(id));
                request.setAttribute("medicamento", medicamento);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarMedicamento.jsp");
                requestDispatcher.forward(request, response);
            } else 
                if (action.equals("editarMedicamento")) {
                MedicamentosFacade.alterar(criarMedicamento(request));
                atualizarMedicamentosLista(request);
                request.setAttribute("successAlert", new Gson().toJson("true"));
                request.setAttribute("errorAlert", new Gson().toJson("false"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gerenciarMedicamentos.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }

    private Medicamento criarMedicamento(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String id = request.getParameter("idMedicamento");
        String fabricante = request.getParameter("fabricante");
        String composicao = request.getParameter("composicao");
        String dosagem = request.getParameter("dosagem");
        String medida = request.getParameter("medida");
        String descricao = request.getParameter("descricao");

        Medicamento medicamento = new Medicamento();
        if (id != null) {
            medicamento.setId(Integer.parseInt(id));
        }
        medicamento.setNome(nome);
        medicamento.setNomeFabricante(fabricante);
        medicamento.setComposicao(composicao);
        medicamento.setDosagem(Double.parseDouble(dosagem));
        medicamento.setMedida(medida);
        medicamento.setDescricao(descricao);
        return medicamento;
    }

    private void atualizarMedicamentosLista(HttpServletRequest request) {
        ServletContext pacContext = request.getServletContext();
        pacContext.setAttribute("medicamentos", MedicamentosFacade.listarMedicamentos());
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
