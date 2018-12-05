    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package Servlets;

    import Beans.Log;
    import Beans.Medicamento;
    import Beans.Usuario;
    import Beans.Dispensa;
    import Beans.Lote;
    import Facade.DispensasFacade;
    import Facade.LogFacade;
    import Facade.LotesFacade;
    import Facade.MedicamentosFacade;
    import com.google.gson.Gson;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.ArrayList;
    import java.util.List;
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletContext;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    import javax.servlet.jsp.PageContext;

    /**
     *
     * @author Eu
     */
    @WebServlet(name = "InicialController", urlPatterns = {"/InicialController"})
    public class InicialController extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            if (session.getAttribute("usuario") == null) {
                session.invalidate();
                LogFacade.inserir(new Log("Sessão do usuário expirada"));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                rd.include(request, response);
            } else {
                session = request.getSession();
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                if(usuario.getPerfil().equalsIgnoreCase("Administrador"))
                    request.setAttribute("perfil",true);

                LogFacade.inserir(new Log(usuario.getIdUsuario(),"Usuário acessou a tela inicial"));
                //CARREGA TABELA
                   List medicamentosVenc = LotesFacade.buscarLotesProxVencimento();
                       request.setAttribute("medicamentosVenc",medicamentosVenc);
                //CARREGAA ULTIMAS SAIDAS
                
                List<Dispensa> dispensa = DispensasFacade.buscaDispensa();
                
                for (Dispensa dis : dispensa) {
                    Medicamento med = MedicamentosFacade.pegarMedicamentoPorId(DispensasFacade.medicamentoPorDispensa(dis.getId()));
                    dis.setMedicameto(med);
                    Lote l = LotesFacade.pegarLotePorVencimento(med.getId(),0);
                    dis.setLote(l);
                }
                      request.setAttribute("saidas",dispensa);
                //CARREGA GRAFICO
                List<Medicamento> medicamentos = MedicamentosFacade.listarMedicamentos();
                List<String> quantidade = new ArrayList<String>();
                List<String> nomeMed = new ArrayList<String>();
                for (Medicamento medicamento : medicamentos) {
                    nomeMed.add(medicamento.getNome());
                    Integer quant = LotesFacade.buscarQuantidade(medicamento.getId().toString());
                    quantidade.add(quant.toString());
                }
                ServletContext medContext = request.getServletContext();
                medContext.setAttribute("quantidadeJson", new Gson().toJson(quantidade.toArray()));
                medContext.setAttribute("nomeMedJson", new Gson().toJson(nomeMed.toArray()));

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
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
