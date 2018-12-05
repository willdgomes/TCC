/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Log;
import Beans.Lote;
import Beans.Medicamento;
import Beans.Usuario;
import Beans.Receita;
import Facade.DispensasFacade;
import Facade.LogFacade;
import Facade.LotesFacade;
import Facade.MedicamentosFacade;
import Facade.ReceitasFacade;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
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
            ServletContext relContext = request.getServletContext();
            
            //Carrega ultimos 6 meses
            List<String> meses = new ArrayList<String>();
                meses.add("Jan");
                meses.add("Fev");
                meses.add("Mar");
                meses.add("Abr");
                meses.add("Maio");
                meses.add("Jun");
                meses.add("Jul");
                meses.add("Ago");
                meses.add("Set");
                meses.add("Out");
                meses.add("Nov");
                meses.add("Dez");
                Integer mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
                
                List<String> periodo = new ArrayList<String>();
                int maxMes = mes;

                for (int i = mes - 6; i <= mes; i++) {
                    maxMes = i;
                    if (i == 12) {
                        maxMes = 0;
                    }
                    periodo.add(meses.get(maxMes));
                }
            
            if (action.equals("carregarSaidaMedicamentos")) {
                //CARREGA TABELA SAIDA POR MES
                LinkedList tdQuantidade = new LinkedList();
                List<Medicamento> medicamentos = MedicamentosFacade.listarMedicamentos();
                List<String> quantidade = new ArrayList<String>();
                List<String> nomeMed = new ArrayList<String>();

                Integer totalMed = medicamentos.size();

                for (Medicamento medicamento : medicamentos) {
                    nomeMed.add(medicamento.getNome());
                    for (int i = mes - 6; i <= mes; i++) {
                        Integer quant = DispensasFacade.buscaQntdMedMes(medicamento.getId(), i);
                        quantidade.add(quant.toString());
                    }
                    tdQuantidade.add(quantidade);
                    quantidade = new ArrayList<String>();
                }

                //CARREGA TABELA SAIDA TOTAL
                List<String> totalSaida = new ArrayList<String>();
                for (Medicamento medicamento : medicamentos) {
                    Integer total = DispensasFacade.buscaTotalSaidaPorMed(medicamento.getId());
                    totalSaida.add(total.toString());
                }

                relContext.setAttribute("totalMedJson", new Gson().toJson(totalMed.toString()));
                relContext.setAttribute("quantidadeJson", new Gson().toJson(tdQuantidade.toArray()));
                relContext.setAttribute("nomeMedJson", new Gson().toJson(nomeMed.toArray()));
                relContext.setAttribute("totalSaidaJson", new Gson().toJson(totalSaida.toArray()));
                relContext.setAttribute("periodoJson", new Gson().toJson(periodo.toArray()));
                LogFacade.inserir(new Log(usuario.getIdUsuario(), "Usuário acessou relatório de saída de medicamentos"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/relatorioEstoque.jsp");
                rd.forward(request, response);
            } else if (action.equals("carregarListaAtividades")) {
                List logs = LogFacade.buscarLog();
                request.setAttribute("logs", logs);
                request.setAttribute("losgJson", new Gson().toJson(logs.toArray()));
                request.setAttribute("errorAlert", new Gson().toJson("false"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/log.jsp");
                rd.forward(request, response);
            } else if (action.equals("pesquisarLogPeriodo")) {

                String dtInicio = request.getParameter("dataInicio");
                String dtFim = request.getParameter("dataFim");
                List logs = LogFacade.buscarLogPeriodo(dtInicio, dtFim);
                request.setAttribute("logs", logs);
                if (logs.size() == 0) {
                    request.setAttribute("errorAlert", new Gson().toJson("true"));
                } else {
                    request.setAttribute("errorAlert", new Gson().toJson("false"));
                }
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/log.jsp");
                rd.forward(request, response);
                
            } else if (action.equals("carregarRelatoriosGerais")) {

                List<String> nomeMaisRetirou = new ArrayList<String>();
                List<String> totalMaisRetirou = new ArrayList<String>();
                List<String> totalCadastroReceita = new ArrayList<String>();
                List<String> nomeReceitaPorPaciente = new ArrayList<String>();
                List<String> totalReceitaPorPaciente = new ArrayList<String>();

                List<Receita> listaReceitas = ReceitasFacade.buscarMaiorNumReceitas();
                for (Receita receita : listaReceitas){
                    nomeReceitaPorPaciente.add(receita.getPaciente().getNome());
                    totalReceitaPorPaciente.add(receita.getId().toString());
                }
                Integer totalR = ReceitasFacade.buscaTotalReceita();
               request.setAttribute("totalReceitas", totalR);
                relContext.setAttribute("nomeMaisRetirouJson", new Gson().toJson(nomeMaisRetirou.toArray()));
                relContext.setAttribute("totalMaisRetirouJson", new Gson().toJson(totalMaisRetirou.toArray()));
                relContext.setAttribute("nomeReceitaPorPacienteJson", new Gson().toJson(nomeReceitaPorPaciente.toArray()));
                relContext.setAttribute("totalReceitaPorPacienteJson", new Gson().toJson(totalReceitaPorPaciente.toArray()));
                LogFacade.inserir(new Log(usuario.getIdUsuario(), "Usuário acessou relatórios gerais de receitas"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/relatorioGeral.jsp");
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
