package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastrarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/tags/page.tag");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_t_page_0(_jspx_page_context))
        return;
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_t_page_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:page
    org.apache.jsp.tag.web.page_tag _jspx_th_t_page_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.page_tag.class) : new org.apache.jsp.tag.web.page_tag();
    _jspx_th_t_page_0.setJspContext(_jspx_page_context);
    String _jspx_temp0 = "Farmácia APPP";
    _jspx_th_t_page_0.setTitle(_jspx_temp0);
    _jspx_th_t_page_0.setJspBody(new cadastrarUsuario_jspHelper( 0, _jspx_page_context, _jspx_th_t_page_0, null));
    _jspx_th_t_page_0.doTag();
    return false;
  }

  private class cadastrarUsuario_jspHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public cadastrarUsuario_jspHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("        <div class=\"main w-100\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"panel panel-default col-sm pt-4\">\n");
      out.write("                    <div class=\"panel-heading text-center\">\n");
      out.write("                        <h2>Cadastro de Usuários</h2>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body pt-3\">\n");
      out.write("                        <div class=\"col-sm-12\">\n");
      out.write("                            <form action=\"PacienteController\" method=\"POST\" class=\"card border-info\">\n");
      out.write("                                <div class=\"card-body p-5\">\n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col\">\n");
      out.write("                                            <label for=\"nome\" class=\"text-dark\">Nome:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"nomeusuario\" required name=\"nome\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col-md-4\" >\n");
      out.write("                                            <label for=\"cpf\" class=\"text-dark\">CPF:</label>\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"cpfUsuario\" required name=\"cpf\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-4\">\n");
      out.write("                                            <label for=\"dtnasc\" class=\"text-dark\">Data de nascimento:</label>\n");
      out.write("                                            <input type=\"date\" class=\"form-control\" id=\"dtnascUsuario\" required name=\"dataNascimento\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-4\">\n");
      out.write("                                            <label for=\"telefone\" class=\"text-dark\">Telefone:</label>\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"telefoneUsuario\" name=\"telefone\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col-md-8\">\n");
      out.write("                                            <label for=\"email\" class=\"text-dark\">E-mail:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"emailUsuario\" name=\"email\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>                                    \n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col-md-8\">\n");
      out.write("                                            <label for=\"perfil\" class=\"text-dark\">Perfil:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"perfilUsuario\" name=\"perfil\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>                                    \n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"col-md-1 offset-md-11\" >\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-primary\">Salvar</button\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    ");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
