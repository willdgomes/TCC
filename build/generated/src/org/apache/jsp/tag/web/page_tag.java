package org.apache.jsp.tag.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class page_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public void setJspContext(JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList<String> _jspx_nested = null;
    java.util.ArrayList<String> _jspx_at_begin = null;
    java.util.ArrayList<String> _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public JspContext getJspContext() {
    return this.jspContext;
  }
  private java.lang.String title;

  public java.lang.String getTitle() {
    return this.title;
  }

  public void setTitle(java.lang.String title) {
    this.title = title;
  }

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  private void _jspInit(ServletConfig config) {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(config);
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void doTag() throws JspException, java.io.IOException {
    PageContext _jspx_page_context = (PageContext)jspContext;
    HttpServletRequest request = (HttpServletRequest) _jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse) _jspx_page_context.getResponse();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    ServletConfig config = _jspx_page_context.getServletConfig();
    JspWriter out = jspContext.getOut();
    _jspInit(config);
    if( getTitle() != null ) {
      _jspx_page_context.setAttribute("title", getTitle());
}

    try {
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("        <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\r\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/extras.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- header -->\r\n");
      out.write("        <nav class=\"navbar sticky-top bg-light\">\r\n");
      out.write("            <div class=\"row no-gutters w-100\">\r\n");
      out.write("                <div class=\"col\">\r\n");
      out.write("                    <div class=\"d-block d-lg-none toggler\">\r\n");
      out.write("                        <a class=\"btn\" tabindex=\"0\" role=\"button\">\r\n");
      out.write("                            <i class=\"toggler-menu material-icons\">menu</i><i class=\"toggler-clear material-icons d-none\">clear</i>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-4 col-sm-3 offset-1\">\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"InicialController\"><div style=\"width:100px; height:40px;\">Sistema Gerenciador de Medicamentos - APPP</div></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col\">\r\n");
      out.write("                    <div class=\"d-block d-sm-block\">\r\n");
      out.write("                        <ul class=\"nav justify-content-end\">\r\n");
      out.write("                            <li class=\"nav-item\">\r\n");
      out.write("                                <a class=\"nav-link btn\" tabindex=\"0\" role=\"button\" data-toggle=\"popover\" data-placement=\"bottom\" data-html=\"true\" data-content=\"<div class='popup-box'><div class='header'>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.nome}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("<br /><small>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.perfil}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("</small></div><div class='body'>\r\n");
      out.write("\r\n");
      out.write("                                   <ul class='nav flex-column'>\r\n");
      out.write("                                   <li class='nav-item'>\r\n");
      out.write("                                   <a class='nav-link' href='alteraSenhaUsuario.jsp'>Alterar senha</a>\r\n");
      out.write("                                   </li>\r\n");
      out.write("                                   </ul>\r\n");
      out.write("\r\n");
      out.write("                                   </div><div class='footer'><a class='btn btn-light btn-block' href='Logout' role='button'>sair</a></div></div>\"><i class=\"material-icons\">account_circle</i></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <!-- sidebar -->\r\n");
      out.write("        <div class=\"d-flex flex-nowrap\">\r\n");
      out.write("            <div class=\"sidebar d-none d-lg-block bg-light\">\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"nav flex-column\">\r\n");
      out.write("<li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"InicialController\"><i class=\"material-icons\">home</i> <span class=\"align-top\">Tela inicial</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"cadastrarReceita.jsp\"><i class=\"material-icons\">receipt</i> <span class=\"align-top\">Cadastrar     Receita Médica</span></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" tabindex=\"0\" data-toggle=\"collapse\" href=\"#menuGerenciamento\" role=\"button\" aria-expanded=\"false\" aria-controls=\"menuDashboard\"><strong><i class=\"material-icons\">content_paste</i><span class=\"align-top\">Gerenciar</span> <div class=\"float-right caret\"><i class=\"material-icons\">arrow_drop_down</i></div></strong></a>\r\n");
      out.write("                        <div class=\"collapse show\" id=\"menuGerenciamento\">\r\n");
      out.write("                            <ul class=\"nav flex-column\">\r\n");
      out.write("                                <li class=\"nav-sub-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" href=\"PacienteController?action=carregarGerenciamento\"><i class=\"material-icons\">person</i> <span class=\"align-top\">Pacientes</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-sub-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" href=\"RetiranteController?action=carregarGerenciamento\"><i class=\"material-icons\">group</i> <span class=\"align-top\">Retirantes</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" tabindex=\"0\" data-toggle=\"collapse\" href=\"#menuEstoque\" role=\"button\" aria-expanded=\"false\" aria-controls=\"menuDashboard\"><strong><i class=\"material-icons\">content_paste</i> <span class=\"align-top\">Estoque</span> <div class=\"float-right caret\"><i class=\"material-icons\">arrow_drop_down</i></div></strong></a>\r\n");
      out.write("                        <div class=\"collapse show\" id=\"menuEstoque\">\r\n");
      out.write("                            <ul class=\"nav flex-column\">\r\n");
      out.write("                                <li class=\"nav-sub-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" href=\"DispensaController?action=carregarDispensa\"><i class=\"material-icons\">indeterminate_check_box</i> <span class=\"align-top\">Dispensar Medicamento</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-sub-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" href=\"MedicamentoController?action=inserirMedicamento\"><i class=\"material-icons\">add_box</i> <span class=\"align-top\">Inserir Medicamento</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" tabindex=\"0\" data-toggle=\"collapse\" href=\"#menuApps\" role=\"button\" aria-expanded=\"false\" aria-controls=\"menuApps\"><strong><i class=\"material-icons\">apps</i> <span class=\"align-top\">Relatórios</span> <div class=\"float-right caret closed\"><i class=\"material-icons\">arrow_drop_down</i></div></strong></a>\r\n");
      out.write("                        <div class=\"collapse\" id=\"menuApps\">\r\n");
      out.write("                            <ul class=\"nav flex-column\">\r\n");
      out.write("                                <li class=\"nav-sub-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" href=\"RelatorioController?action=carregarSaidaMedicamentos\"><i class=\"material-icons\">add_box</i> <span class=\"align-top\">Saída Medicamentos</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- main -->    \r\n");
      out.write("            ");
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getJspBody() != null)
        getJspBody().invoke(_jspx_sout);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch( Throwable t ) {
      if( t instanceof SkipPageException )
          throw (SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof IllegalStateException )
          throw (IllegalStateException) t;
      if( t instanceof JspException )
          throw (JspException) t;
      throw new JspException(t);
    } finally {
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
      _jspDestroy();
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${perfil}", java.lang.Boolean.class, (PageContext)this.getJspContext(), null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <li class=\"nav-sub-item\">\r\n");
        out.write("                                    <a class=\"nav-link\" href=\"MedicamentoController?action=carregarGerenciamento\"><i class=\"material-icons\">local_pharmacy</i> <span class=\"align-top\">Medicamentos</span></a>\r\n");
        out.write("                                </li>\r\n");
        out.write("                                <li class=\"nav-sub-item\">\r\n");
        out.write("                                    <a class=\"nav-link\" href=\"UsuarioController?action=carregarGerenciamento\"><i class=\"material-icons\">person</i> <span class=\"align-top\">Usuários</span></a>\r\n");
        out.write("                                </li>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      throw new SkipPageException();
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${perfil}", java.lang.Boolean.class, (PageContext)this.getJspContext(), null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <li class=\"nav-sub-item\">\r\n");
        out.write("                                    <a class=\"nav-link\" href=\"RelatorioController?action=carregarListaAtividades\"><i class=\"material-icons\">line_style</i <span class=\"align-top\">Atividades dos usuários</span></a>\r\n");
        out.write("                                </li>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      throw new SkipPageException();
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
