/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Dispensa;
import Beans.Lote;
import Beans.Medicamento;
import Beans.Paciente;
import Beans.Receita;
import Beans.Retirante;
import Beans.Usuario;
import Facade.DispensasFacade;
import Facade.LotesFacade;
import Facade.MedicamentosFacade;
import Facade.PacientesFacade;
import Facade.ReceitasFacade;
import Facade.RetirantesFacade;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
        Usuario usuario = new Usuario();
        usuario = (Usuario) session.getAttribute("usuario");
        String action = request.getParameter("action");
        if (session == null) {
            RequestDispatcher rd = request.
                    getRequestDispatcher("/index.html");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema!");
            rd.forward(request, response);
        } else {
            if(usuario.getPerfil().equalsIgnoreCase("Administrador"))
                request.setAttribute("perfil",true);
            if(action.equals("carregarDispensa")){
            request.setAttribute("errorAlert", new Gson().toJson("false"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dispensarMedicamento.jsp");
                requestDispatcher.forward(request, response);
            }
            else
            if (action.equals("dispensarMedicamento")) {
                String idPaciente = request.getParameter("idPaci");
                String cpfRetirante = request.getParameter("cpfRetirante");
                String[] listaMedicamento = request.getParameterValues("nome");
                String[] quantidadeMed = request.getParameterValues("quantidade");
                
                Paciente paciente = new Paciente();
                paciente = PacientesFacade.buscarId(idPaciente);
                Retirante retirante = new Retirante();
                retirante = RetirantesFacade.buscarRetirantePorCpf(cpfRetirante);
                if(retirante.getIdRetirante() != null){
                if(!RetirantesFacade.buscarRetirantePaciente(idPaciente, retirante.getIdRetirante())){
                    request.setAttribute("msg", "Este retirante não está autorizado.");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dispensarMedicamento.jsp");
                    requestDispatcher.forward(request, response);
                }
                
                dispensa.setPaciente(paciente);
                dispensa.setRetirante(retirante);
                dispensa.setUsuario(usuario);
                Date dtAtual = new Date();
                java.sql.Date dataAtual = new java.sql.Date(dtAtual.getTime());
                dispensa.setDataDispensa(dataAtual);
                
                Receita receita = new Receita();
                List<Receita> listaReceitas = new ArrayList<Receita>();
                listaReceitas = ReceitasFacade.buscarReceitaValidaPorPaciente(paciente.getId());
                List<Medicamento> listMed = new ArrayList<Medicamento>();
                Medicamento med = new Medicamento();
                for(int i=0; i<listaMedicamento.length; i++){
                    listMed.add(MedicamentosFacade.pegarMedicamentoPorNome(listaMedicamento[i]));
                }
                
                if(listaReceitas.size()<1){
                    request.setAttribute("msg", "Não há receitas cadastradas ou válidas.");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dispensarMedicamento.jsp");
                    requestDispatcher.forward(request, response);
                }else{
                    for(int i = 0; i<listaReceitas.size(); i++){
                        for(int j = 0; j<listMed.size();j++){
                            boolean medRec = MedicamentosFacade.buscarMedicamentoReceita(listMed.get(j).getId(), listaReceitas.get(i).getId());
                            if(!medRec){
                                request.setAttribute("msg", "Medicamento não consta na receita.");
                                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dispensarMedicamento.jsp");
                                requestDispatcher.forward(request, response);
                            }
                        }
                    }
                    //verifica medicamentos_receitas
                }
                int idPac = DispensasFacade.inserir(dispensa);
                dispensa.setId(idPac);
                
                Lote lote = new  Lote();
                for(int i=0; i<listaMedicamento.length; i++){
                    int qtdeMed = Integer.parseInt(quantidadeMed[i]);
                    DispensasFacade.inserirDispensaMedicamento(dispensa.getId(), listMed.get(i).getId(), qtdeMed);
                    lote = LotesFacade.pegarLotePorVencimento(listMed.get(i).getId(), qtdeMed);
                    
                    
                    if(lote!=null){
                        lote.setQtde(lote.getQtde()-qtdeMed);
                        LotesFacade.atualizarLote(lote);
                    }else{
                        request.setAttribute("msg", "Quantidade insuficiente no estoque.");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dispensarMedicamento.jsp");
                        requestDispatcher.forward(request, response);
                    }
                    }                
                request.setAttribute("errorAlert", new Gson().toJson("false"));
                }
                else
                    request.setAttribute("errorAlert", new Gson().toJson("true"));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dispensarMedicamento.jsp");
                requestDispatcher.forward(request, response);
                }
//verificar receita. data de vencimento, medicamentos e retirante e paciente

            
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
