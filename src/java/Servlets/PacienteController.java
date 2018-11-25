/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Paciente;
import Beans.Usuario;
import DAO.PacienteDAO;
import DAO.UsuarioDAO;
import Facade.PacientesFacade;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Init;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author gomes
 */
@WebServlet(name = "PacienteController", urlPatterns = {"/PacienteController"}, loadOnStartup = 2)
public class PacienteController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {        
        super.init(config);
        List<Paciente> pacientes = PacientesFacade.buscarTodos();
        ServletContext pacContext = config.getServletContext();
        pacContext.setAttribute("pacientes", pacientes);
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
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        if (session.getAttribute("usuario") == null) {
            session.invalidate();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            rd.include(request, response);
        } else {
            if(action.equals("carregarCadastro")){
                request.setAttribute("successAlert",new Gson().toJson("false"));
                  RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrarPacientes.jsp");
                    rd.forward(request, response);
            }else
            if (action.equals("cadastrarPaciente")) {
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("cpf");
                cpf = cpf.replaceAll("\\W","");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                String stringData = request.getParameter("dataNascimento");
                stringData = stringData.replaceAll("-", "/");
                java.util.Date dataNascimento = null;
                try {
                    dataNascimento = format.parse(stringData);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String telefone = request.getParameter("telefone");
                telefone = telefone.replaceAll("\\W","");
                String email = request.getParameter("email");
                String cep = request.getParameter("cep");
                String cidade = request.getParameter("cidade");
                String estado = request.getParameter("estado");
                String bairro = request.getParameter("bairro");
                String endereco = request.getParameter("endereco");
                String numeroEndereco = request.getParameter("numeroEndereco");
                String complemento = request.getParameter("complemento");

                Paciente paciente = new Paciente();
                paciente.setNome(nome);
                paciente.setCpf(cpf);
                java.sql.Date dtNascimento = new java.sql.Date(dataNascimento.getTime());
                paciente.setDataNascimento(dtNascimento);
                paciente.setTelefone(telefone);
                paciente.setEmail(email);
                paciente.setCep(cep);
                paciente.setCidade(cidade);
                paciente.setEstado(estado);
                paciente.setBairro(bairro);
                paciente.setEndereco(endereco);
                paciente.setNumEndereco(numeroEndereco);
                paciente.setComplemento(complemento);

                PacientesFacade.inserir(paciente);
                atualizarPacientesLista(request);
                RequestDispatcher rd = null;
                request.setAttribute("successAlert",new Gson().toJson("true"));
                rd = getServletContext().getRequestDispatcher("/cadastrarPacientes.jsp");
                rd.include(request, response);
            } else if (action.equals("pesquisaParam")) {
                String pesquisa = request.getParameter("pesquisa");
                PacientesFacade pacientesFacade = new PacientesFacade();
                List<Paciente> pacienteList = pacientesFacade.buscaPacientesParam(pesquisa);
                if (session != null) {
                    request.setAttribute("pacientes", pacienteList);
                    if (pacienteList.size() == 0) {
                        request.setAttribute("mensagem", "Paciente não cadastrado no sistema");
                    }
                    response.setContentType("text/html;charset=UTF-8");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gerenciarPacientes.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    request.setAttribute("msg", "Usuário e/ou senha incorreto(s)!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                    rd.forward(request, response);
                }
            } else if (action.equals("editar")) {
                String id = request.getParameter("idPaciente");
                PacientesFacade pacientesFacade = new PacientesFacade();
                Paciente paciente = pacientesFacade.buscarId(id);
                request.setAttribute("paciente", paciente);
                RequestDispatcher rd = null;
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarPacientes.jsp");
                requestDispatcher.forward(request, response);
            } else if (action.equals("editarPaciente")) {
                String id = request.getParameter("idPaciente");
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("cpf");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                String stringData = request.getParameter("dataNascimento");
                stringData = stringData.replaceAll("-", "/");
                java.util.Date dataNascimento = null;
                try {
                    dataNascimento = format.parse(stringData);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String telefone = request.getParameter("telefone");
                String email = request.getParameter("email");
                String cep = request.getParameter("cep");
                String cidade = request.getParameter("cidade");
                String estado = request.getParameter("estado");
                String bairro = request.getParameter("bairro");
                String endereco = request.getParameter("endereco");
                String numeroEndereco = request.getParameter("numeroEndereco");
                String complemento = request.getParameter("complemento");

                Paciente paciente = new Paciente();
                paciente.setId(Integer.parseInt(id));
                paciente.setNome(nome);
                paciente.setCpf(cpf);
                java.sql.Date dtNascimento = new java.sql.Date(dataNascimento.getTime());
                paciente.setDataNascimento(dtNascimento);
                paciente.setTelefone(telefone);
                paciente.setEmail(email);
                paciente.setCep(cep);
                paciente.setCidade(cidade);
                paciente.setEstado(estado);
                paciente.setBairro(bairro);
                paciente.setEndereco(endereco);
                paciente.setNumEndereco(numeroEndereco);
                paciente.setComplemento(complemento);

                PacientesFacade.alterar(paciente);
                atualizarPacientesLista(request);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gerenciarPacientes.jsp");
                requestDispatcher.forward(request, response);

            }
        }

    }

    private void atualizarPacientesLista(HttpServletRequest request) {
        ServletContext pacContext = request.getServletContext();
        pacContext.setAttribute("pacientes", PacientesFacade.buscarTodos());
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
