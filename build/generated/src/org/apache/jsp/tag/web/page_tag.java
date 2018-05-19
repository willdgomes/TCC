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

  public void doTag() throws JspException, java.io.IOException {
    PageContext _jspx_page_context = (PageContext)jspContext;
    HttpServletRequest request = (HttpServletRequest) _jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse) _jspx_page_context.getResponse();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    ServletConfig config = _jspx_page_context.getServletConfig();
    JspWriter out = jspContext.getOut();
    if( getTitle() != null ) {
      _jspx_page_context.setAttribute("title", getTitle());
}

    try {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/extras.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- header -->\n");
      out.write("        <nav class=\"navbar sticky-top bg-light\">\n");
      out.write("            <div class=\"row no-gutters w-100\">\n");
      out.write("              <div class=\"col\">\n");
      out.write("                <div class=\"d-block d-lg-none toggler\">\n");
      out.write("                  <a class=\"btn\" tabindex=\"0\" role=\"button\">\n");
      out.write("                    <i class=\"toggler-menu material-icons\">menu</i><i class=\"toggler-clear material-icons d-none\">clear</i>\n");
      out.write("                  </a>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-4 col-sm-3 text-center\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\"><div style=\"width:100px; height:40px; background-color:#ddd;\">APPP</div></a>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col\">\n");
      out.write("                <div class=\"d-block d-sm-block\">\n");
      out.write("                  <ul class=\"nav justify-content-end\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                      <a class=\"nav-link btn\" tabindex=\"0\" role=\"button\" data-toggle=\"popover\" data-placement=\"bottom\" data-html=\"true\" data-content=\"<div class='popup-box'><div class='header'>notificações <span class='badge badge-secondary'>1</span></div><div class='body'>\n");
      out.write("\n");
      out.write("                        <div class='list-group list-group-flush'>\n");
      out.write("                          <a href='#' class='list-group-item list-group-item-action active'>\n");
      out.write("                            <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>\n");
      out.write("                            <small>Donec id elit non mi porta.</small>\n");
      out.write("                          </a>\n");
      out.write("                          <a href='#' class='list-group-item list-group-item-action'>\n");
      out.write("                            <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>\n");
      out.write("                            <small>Donec id elit non mi porta.</small>\n");
      out.write("                          </a>\n");
      out.write("                          <a href='#' class='list-group-item list-group-item-action'>\n");
      out.write("                            <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>\n");
      out.write("                            <small>Donec id elit non mi porta.</small>\n");
      out.write("                          </a>\n");
      out.write("                          <a href='#' class='list-group-item list-group-item-action'>\n");
      out.write("                            <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>\n");
      out.write("                            <small>Donec id elit non mi porta.</small>\n");
      out.write("                          </a>\n");
      out.write("                          <a href='#' class='list-group-item list-group-item-action'>\n");
      out.write("                            <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>\n");
      out.write("                            <small>Donec id elit non mi porta.</small>\n");
      out.write("                          </a>\n");
      out.write("                          <a href='#' class='list-group-item list-group-item-action'>\n");
      out.write("                            <p class='mb-1'>Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>\n");
      out.write("                            <small>Donec id elit non mi porta.</small>\n");
      out.write("                          </a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                      </div><div class='footer'><a class='btn btn-light btn-block' href='#' role='button'>ver todas as notificações</a></div></div>\"><i class=\"material-icons red\">notifications</i></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                      <a class=\"nav-link btn\" tabindex=\"0\" role=\"button\" data-toggle=\"popover\" data-placement=\"bottom\" data-html=\"true\" data-content=\"<div class='popup-box'><div class='header'>Renan Nelsen<br /><small>administrador</small></div><div class='body'>\n");
      out.write("\n");
      out.write("                        <ul class='nav flex-column'>\n");
      out.write("                          <li class='nav-item'>\n");
      out.write("                            <a class='nav-link' href='#'>minha conta</a>\n");
      out.write("                          </li>\n");
      out.write("                          <li class='nav-item'>\n");
      out.write("                            <a class='nav-link' href='#'>configurações</a>\n");
      out.write("                          </li>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                      </div><div class='footer'><a class='btn btn-light btn-block' href='#' role='button'>sair</a></div></div>\"><i class=\"material-icons\">account_circle</i></a>\n");
      out.write("                    </li>\n");
      out.write("                  </ul>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        <!-- sidebar -->\n");
      out.write("        <div class=\"d-flex flex-nowrap\">\n");
      out.write("            <div class=\"sidebar d-none d-lg-block bg-light\">\n");
      out.write("\n");
      out.write("            <ul class=\"nav flex-column\">\n");
      out.write("              <li class=\"header\">menu</li>\n");
      out.write("              <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" tabindex=\"0\" data-toggle=\"collapse\" href=\"#menuDashboard\" role=\"button\" aria-expanded=\"false\" aria-controls=\"menuDashboard\"><i class=\"material-icons\">content_paste</i> <span class=\"align-top\">Gerenciar</span> <div class=\"float-right caret\"><i class=\"material-icons\">arrow_drop_down</i></div></a>\n");
      out.write("                <div class=\"collapse show\" id=\"menuDashboard\">\n");
      out.write("                  <ul class=\"nav flex-column\">\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link active\" href=\"#\"><i class=\"material-icons\">face</i> <span class=\"align-top\">Pacientes</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link\" href=\"#\"><i class=\"material-icons\">local_pharmacy</i> <span class=\"align-top\">Medicamentos</span></a>\n");
      out.write("                    </li>\n");
      out.write("                  </ul>\n");
      out.write("                </div>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" tabindex=\"0\" data-toggle=\"collapse\" href=\"#menuDashboard\" role=\"button\" aria-expanded=\"false\" aria-controls=\"menuDashboard\"><i class=\"material-icons\">content_paste</i> <span class=\"align-top\">Estoque</span> <div class=\"float-right caret\"><i class=\"material-icons\">arrow_drop_down</i></div></a>\n");
      out.write("                <div class=\"collapse show\" id=\"menuDashboard\">\n");
      out.write("                  <ul class=\"nav flex-column\">\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link active\" href=\"#\"><i class=\"material-icons\">face</i> <span class=\"align-top\">Dispensar Medicamento</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link\" href=\"#\"><i class=\"material-icons\">local_pharmacy</i> <span class=\"align-top\">Inserir Medicamento</span></a>\n");
      out.write("                    </li>\n");
      out.write("                  </ul>\n");
      out.write("                </div>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" tabindex=\"0\" data-toggle=\"collapse\" href=\"#menuApps\" role=\"button\" aria-expanded=\"false\" aria-controls=\"menuApps\"><i class=\"material-icons\">apps</i> <span class=\"align-top\">adipiscing</span> <div class=\"float-right caret closed\"><i class=\"material-icons\">arrow_drop_down</i></div></a>\n");
      out.write("                <div class=\"collapse\" id=\"menuApps\">\n");
      out.write("                  <ul class=\"nav flex-column\">\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link\" href=\"#\"><i class=\"material-icons\">keyboard_arrow_right</i> <span class=\"align-top\">lorem</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link\" href=\"#\"><i class=\"material-icons\">keyboard_arrow_right</i> <span class=\"align-top\">lorem</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link\" href=\"#\"><i class=\"material-icons\">keyboard_arrow_right</i> <span class=\"align-top\">lorem</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link\" href=\"#\"><i class=\"material-icons\">keyboard_arrow_right</i> <span class=\"align-top\">lorem</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link\" href=\"#\"><i class=\"material-icons\">keyboard_arrow_right</i> <span class=\"align-top\">lorem</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link\" href=\"#\"><i class=\"material-icons\">keyboard_arrow_right</i> <span class=\"align-top\">lorem</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-sub-item\">\n");
      out.write("                      <a class=\"nav-link\" href=\"#\"><i class=\"material-icons\">keyboard_arrow_right</i> <span class=\"align-top\">lorem</span></a>\n");
      out.write("                    </li>\n");
      out.write("                  </ul>\n");
      out.write("                </div>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        <!-- main -->    \n");
      out.write("        ");
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getJspBody() != null)
        getJspBody().invoke(_jspx_sout);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
    }
  }
}
