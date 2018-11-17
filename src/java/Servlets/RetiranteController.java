/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Paciente;
import Beans.Retirante;
import Beans.Usuario;
import DAO.RetiranteDAO;
import Facade.PacientesFacade;
import Facade.RetirantesFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "RetiranteController", urlPatterns = {"/RetiranteController"})
public class RetiranteController extends HttpServlet {
 public void init(ServletConfig config) throws ServletException {
        RetirantesFacade retirantesFacade = new RetirantesFacade();
        List<Retirante> retirante = new ArrayList<Retirante>();
        retirante = retirantesFacade.listaRetirantes();
        ServletContext medContext = config.getServletContext();
        medContext.setAttribute("retirantes", retirante);
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
            if (action.equals("cadastrarRetirante")) {

                RetirantesFacade.cadastrarRetirante(criaRetirante(request));
                RequestDispatcher rd = null;
                rd = getServletContext().getRequestDispatcher("/cadastrarRetirantes.jsp");
                rd.forward(request, response);
                
            } else if (action.equals("pesquisarRetirante")) {
                String pesquisa = request.getParameter("pesquisa");
//                List<Retirante> retiranteList = RetirantesFacade.buscarRetirantesNome(pesquisa);
                RequestDispatcher rd = null;
//                if (retiranteList.size() > 0) {
//                    request.setAttribute("retirantes", retiranteList);
//                } else {
//                    request.setAttribute("mensagem", "Retirante não cadastrado no sistema");
//                }
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gerenciarRetirantes.jsp");
//                requestDispatcher.forward(request, response);

            } else if (action.equals("editar")) {
                 String id = request.getParameter("idRetirante");                
              //  Retirante retirante = RetirantesFacade.buscarRetirantePorId(id);
                //request.setAttribute("retirante", retirante);
                RequestDispatcher rd = null;
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarRetirante.jsp");
                requestDispatcher.forward(request, response);
            } else if (action.equals("editarMedicamento")) {
                
                RetirantesFacade.alterarRetirante(criaRetirante(request));
                atualizarRetirantesLista(request);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gerenciarRetirantes.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    
    
    
    }
     
    private void atualizarRetirantesLista(HttpServletRequest request) {
        ServletContext pacContext = request.getServletContext();
        pacContext.setAttribute("retirantes", RetirantesFacade.listaRetirantes());
    }
    private Retirante criaRetirante(HttpServletRequest request) {
        String id = new String();
        if(!request.getParameter("idRetirante").isEmpty()){
         id = request.getParameter("idRetirante");
        }
        String nome = request.getParameter("nomeRetirante");
        String cpf = request.getParameter("cpfRetirante");
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String stringData = request.getParameter("dtNascimento");
        stringData = stringData.replaceAll("-", "/");
        java.util.Date dataNascimento = null;
        try {
            dataNascimento = format.parse(stringData);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String telefone = request.getParameter("telefone");
        String email = request.getParameter("emailRetirante");
        String paciente = request.getParameter("paciente");
        String parentesco = request.getParameter("parentesco");
        String cep = request.getParameter("cepRetirante");
        String cidade = request.getParameter("cidadeRetirante");
        String estado = request.getParameter("estadoRetirante");
        String bairro = request.getParameter("bairroRetirante");
        String endereco = request.getParameter("enderecoRetirante");
        String numeroEndereco = request.getParameter("numeroEnderecoRetirante");
        String complemento = request.getParameter("complementoRetirante");

        Retirante retirante = new Retirante();
        retirante.setNomeRetirante(nome);
        retirante.setCpfRetirante(cpf);
        java.sql.Date dtNascimento = new java.sql.Date(dataNascimento.getTime());
        retirante.setDnRetirante(dtNascimento);
        retirante.setTelefone(telefone);
        retirante.setEmail(email);
        retirante.setVincolo(parentesco);
        retirante.setCep(cep);
        retirante.setCidade(cidade);
        retirante.setEstado(estado);
        retirante.setBairro(bairro);
        retirante.setEndereco(endereco);
        retirante.setNumEndereco(numeroEndereco);
        retirante.setComplemento(complemento);
        if(!id.isEmpty())
            retirante.setIdRetirante(Integer.parseInt(id));
        return retirante;
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
