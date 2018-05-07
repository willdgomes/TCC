package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class selecionarRemedioDispensa_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_th_t_page_0.setJspBody(new selecionarRemedioDispensa_jspHelper( 0, _jspx_page_context, _jspx_th_t_page_0, null));
    _jspx_th_t_page_0.doTag();
    return false;
  }

  private class selecionarRemedioDispensa_jspHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public selecionarRemedioDispensa_jspHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("        <div class=\"main w-100\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"panel panel-default col-sm\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h2 align=\"center\">Dispensar Medicamentos</h2>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <div class=\"col-sm-12\">\n");
      out.write("                        <form class=\"card border-light\">\n");
      out.write("                            <div class=\"card-body p-3\">\n");
      out.write("                                <div class=\"form-row\" id=\"line1\">\n");
      out.write("                                    <div class=\"col-md-6 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Medicamento\" >Medicamento:</label>\n");
      out.write("                                        <select id=\"cbRemedios\" class=\"form-control\">\n");
      out.write("                                            <option></option>\n");
      out.write("                                            <option>remedio1</option>\n");
      out.write("                                            <option>remedio2</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Quantidade\" >Quantidade:</label>\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("                                        <script>\n");
      out.write("                                            $(document).ready(function(){\n");
      out.write("                                                $(\"#add1\").click(function(){\n");
      out.write("                                                    $(\"#line2\").show();\n");
      out.write("                                                });\n");
      out.write("                                            });\n");
      out.write("                                            </script>\n");
      out.write("                                            <button id=\"add1\">+</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div><br>\n");
      out.write("                                \n");
      out.write("                                <div class=\"form-row\" id=\"line2\" style=\"display:none\">\n");
      out.write("                                    <div class=\"col-md-6 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Medicamento\" >Medicamento:</label>\n");
      out.write("                                        <select id=\"cbRemedios\" class=\"form-control\">\n");
      out.write("                                           <option></option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Quantidade\" >Quantidade:</label>\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("                                        <script>\n");
      out.write("                                            $(document).ready(function(){\n");
      out.write("                                                $(\"#add2\").click(function(){\n");
      out.write("                                                    $(\"#line3\").show();\n");
      out.write("                                                });\n");
      out.write("                                            });\n");
      out.write("                                            $(document).ready(function(){\n");
      out.write("                                                $(\"#sub2\").click(function(){\n");
      out.write("                                                    $(\"#line2\").hide();\n");
      out.write("                                                });\n");
      out.write("                                            });\n");
      out.write("                                            </script>\n");
      out.write("                                            <button id=\"add2\">+</button>\n");
      out.write("                                            <button id=\"sub2\">-</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div><br>\n");
      out.write("                                \n");
      out.write("                                <div class=\"form-row\" id=\"line3\" style=\"display:none\">\n");
      out.write("                                    <div class=\"col-md-6 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Medicamento\" >Medicamento:</label>\n");
      out.write("                                        <select id=\"cbRemedios\" class=\"form-control\">\n");
      out.write("                                           <option></option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Quantidade\" >Quantidade:</label>\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("                                        <script>\n");
      out.write("                                            $(document).ready(function(){\n");
      out.write("                                                $(\"#add3\").click(function(){\n");
      out.write("                                                    $(\"#line4\").show();\n");
      out.write("                                                });\n");
      out.write("                                            });$(document).ready(function(){\n");
      out.write("                                                $(\"#sub3\").click(function(){\n");
      out.write("                                                    $(\"#line3\").hide();\n");
      out.write("                                                });\n");
      out.write("                                            });\n");
      out.write("                                            </script>\n");
      out.write("                                            <button id=\"add3\">+</button>\n");
      out.write("                                            <button id=\"sub3\">-</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div><br>\n");
      out.write("                                \n");
      out.write("                                <div class=\"form-row\" id=\"line4\" style=\"display:none\">\n");
      out.write("                                    <div class=\"col-md-6 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Medicamento\" >Medicamento:</label>\n");
      out.write("                                        <select id=\"cbRemedios\" class=\"form-control\">\n");
      out.write("                                           <option></option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Quantidade\" >Quantidade:</label>\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("                                        <script>\n");
      out.write("                                            $(document).ready(function(){\n");
      out.write("                                                $(\"#add4\").click(function(){\n");
      out.write("                                                    $(\"#line5\").show();\n");
      out.write("                                                });\n");
      out.write("                                            });$(document).ready(function(){\n");
      out.write("                                                $(\"#sub4\").click(function(){\n");
      out.write("                                                    $(\"#line4\").hide();\n");
      out.write("                                                });\n");
      out.write("                                            });\n");
      out.write("                                            </script>\n");
      out.write("                                            <button id=\"add4\">+</button>\n");
      out.write("                                            <button id=\"sub4\">-</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div><br>\n");
      out.write("                                \n");
      out.write("                                <div class=\"form-row\" id=\"line5\" style=\"display:none\">\n");
      out.write("                                    <div class=\"col-md-6 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Medicamento\" >Medicamento:</label>\n");
      out.write("                                        <select id=\"cbRemedios\" class=\"form-control\">\n");
      out.write("                                           <option></option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Quantidade\" >Quantidade:</label>\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("                                        <script>\n");
      out.write("                                            $(document).ready(function(){\n");
      out.write("                                                $(\"#add5\").click(function(){\n");
      out.write("                                                    $(\"#line6\").show();\n");
      out.write("                                                });\n");
      out.write("                                            });$(document).ready(function(){\n");
      out.write("                                                $(\"#sub5\").click(function(){\n");
      out.write("                                                    $(\"#line5\").hide();\n");
      out.write("                                                });\n");
      out.write("                                            });\n");
      out.write("                                            </script>\n");
      out.write("                                            <button id=\"add5\">+</button>\n");
      out.write("                                            <button id=\"sub5\">-</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div><br>\n");
      out.write("                                \n");
      out.write("                                <div class=\"form-row\" id=\"line6\" style=\"display:none\">\n");
      out.write("                                    <div class=\"col-md-6 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Medicamento\" >Medicamento:</label>\n");
      out.write("                                        <select id=\"cbRemedios\" class=\"form-control\">\n");
      out.write("                                           <option></option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <label for=\"Quantidade\" >Quantidade:</label>\n");
      out.write("                                        <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-2 offset-1 form-group\">\n");
      out.write("                                        <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("                                        <script>\n");
      out.write("                                            $(document).ready(function(){\n");
      out.write("                                                $(\"#add6\").click(function(){\n");
      out.write("                                                    $(\"#line7\").show();\n");
      out.write("                                                });\n");
      out.write("                                            });$(document).ready(function(){\n");
      out.write("                                                $(\"#sub6\").click(function(){\n");
      out.write("                                                    $(\"#line6\").hide();\n");
      out.write("                                                });\n");
      out.write("                                            });\n");
      out.write("                                            </script>\n");
      out.write("<!--                                            <button id=\"add6\">+</button>-->\n");
      out.write("                                            <button id=\"sub6\">-</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div><br>\n");
      out.write("                                \n");
      out.write("                                <div class=\"form-row\">\n");
      out.write("                                    <div class=\"form-group col-md-3 offset-1\">\n");
      out.write("                                        <label for=\"dtnasc\" class=\"text-dark\">Data de nascimento:</label>\n");
      out.write("                                        <input type=\"date\" class=\"form-control\" id=\"dtnascpaciente\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-3 offset-3\">\n");
      out.write("                                        <label for=\"dtnasc\" class=\"text-dark\">CRM:</label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"dtnascpaciente\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <a href=\"pesquisaPacienteDispensa.jsp\">\n");
      out.write("                                    <button type=\"submit\" class=\"btn offset-1 btn-primary\">Avançar</button>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
