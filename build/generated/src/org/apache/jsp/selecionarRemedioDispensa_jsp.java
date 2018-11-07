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

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_t_page_0(_jspx_page_context))
        return;
      out.write('\r');
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

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) _jspx_parent));
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.medicamentos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("medicamento");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\r\n");
          out.write("                                                    <option>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${medicamento.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\r\n");
          out.write("\r\n");
          out.write("                                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        throw new SkipPageException();
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
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
      out.write("\r\n");
      out.write("        <div class=\"main w-100\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"panel panel-default col-sm pt-4\">\r\n");
      out.write("                    <div class=\"panel-heading\">\r\n");
      out.write("                        <h2 align=\"center\">Dispensar Medicamentos</h2>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"panel-body pt-3\">\r\n");
      out.write("                        <div class=\"col-sm-12\">\r\n");
      out.write("                            <form class=\"card border-info\" action=\"DispensaController?action=selecionaMedicamento\" method=\"POST\">\r\n");
      out.write("                                <div class=\"card-body p-5\">\r\n");
      out.write("                                    <div class=\"form-row\" id=\"line1\">\r\n");
      out.write("                                        <div class=\"col-md-6 form-group\">\r\n");
      out.write("                                            <label class=\"text-dark\" for=\"Medicamento\" >Medicamento:</label> \r\n");
      out.write("                                            <select id=\"cbRemedios\" class=\"form-control\" required name=\"nomeMedicamento\">\r\n");
      out.write("                                                ");
      if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-2 offset-1 form-group\">\r\n");
      out.write("                                            <label for=\"Quantidade\"class=\"text-dark\" >Quantidade:(Caixa)</label>\r\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\" required name=\"quantidadeMedicamento\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-1 offset-md-1 form-group\">\r\n");
      out.write("                                            <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\r\n");
      out.write("                                            <script>\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#add1\").click(function () {\r\n");
      out.write("                                                        $(\"#line2\").show();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                            </script>\r\n");
      out.write("                                            <button class=\"btn btn-sm btn-info mt-2\" id=\"add1\"><i class=\"material-icons\">add</i></button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"form-row\" id=\"line2\" style=\"display:none\">\r\n");
      out.write("                                        <div class=\"col-md-6 form-group\">\r\n");
      out.write("                                            <label for=\"Medicamento\" class=\"text-dark\">Medicamento:</label>\r\n");
      out.write("                                            <select id=\"cbRemedios\" class=\"form-control\">\r\n");
      out.write("                                                <option></option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-2 offset-1 form-group\">\r\n");
      out.write("                                            <label for=\"Quantidade\" class=\"text-dark\">Quantidade: (Caixa)</label>\r\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-1 offset-md-1 form-group\">\r\n");
      out.write("                                            <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\r\n");
      out.write("                                            <script>\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#add2\").click(function () {\r\n");
      out.write("                                                        $(\"#line3\").show();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#sub2\").click(function () {\r\n");
      out.write("                                                        $(\"#line2\").hide();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                            </script>\r\n");
      out.write("                                            <button class=\"btn btn-sm btn-info mt-2\"  id=\"add2\"><i class=\"material-icons\">add</i></button>\r\n");
      out.write("                                            <button class=\"btn btn-sm btn-info mt-2\"  id=\"sub2\"><i class=\"material-icons\">-</i></button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"form-row\" id=\"line3\" style=\"display:none\">\r\n");
      out.write("                                        <div class=\"col-md-6 form-group\">\r\n");
      out.write("                                            <label for=\"Medicamento\" class=\"text-dark\" >Medicamento:</label>\r\n");
      out.write("                                            <select id=\"cbRemedios\" class=\"form-control\">\r\n");
      out.write("                                                <option></option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-2 offset-1 form-group\">\r\n");
      out.write("                                            <label for=\"Quantidade\" class=\"text-dark\">Quantidade: (Caixa)</label>\r\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-1 offset-1 form-group\">\r\n");
      out.write("                                            <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\r\n");
      out.write("                                            <script>\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#add3\").click(function () {\r\n");
      out.write("                                                        $(\"#line4\").show();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#sub3\").click(function () {\r\n");
      out.write("                                                        $(\"#line3\").hide();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                            </script>\r\n");
      out.write("                                            <button class=\"btn btn-sm btn-info mt-2\" id=\"add3\"><i class=\"material-icons\">add</i></button>\r\n");
      out.write("                                            <button class=\"btn btn-sm btn-info mt-2\" id=\"sub3\">-</button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"form-row\" id=\"line4\" style=\"display:none\">\r\n");
      out.write("                                        <div class=\"col-md-6 form-group\">\r\n");
      out.write("                                            <label for=\"Medicamento\" class=\"text-dark\">Medicamento:</label>\r\n");
      out.write("                                            <select id=\"cbRemedios\" class=\"form-control\">\r\n");
      out.write("                                                <option></option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-2 offset-1 form-group\">\r\n");
      out.write("                                            <label for=\"Quantidade\" class=\"text-dark\">Quantidade: (Caixa)</label>\r\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-1 offset-1 form-group\">\r\n");
      out.write("                                            <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\r\n");
      out.write("                                            <script>\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#add4\").click(function () {\r\n");
      out.write("                                                        $(\"#line5\").show();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#sub4\").click(function () {\r\n");
      out.write("                                                        $(\"#line4\").hide();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                            </script>\r\n");
      out.write("                                            <button class=\"btn btn-sm btn-info mt-2\" id=\"add4\"><i class=\"material-icons\">add</i></button>\r\n");
      out.write("                                            <button class=\"btn btn-sm btn-info mt-2\" id=\"sub4\">-</button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"form-row\" id=\"line5\" style=\"display:none\">\r\n");
      out.write("                                        <div class=\"col-md-6 form-group\">\r\n");
      out.write("                                            <label for=\"Medicamento\" class=\"text-dark\">Medicamento:</label>\r\n");
      out.write("                                            <select id=\"cbRemedios\" class=\"form-control\">\r\n");
      out.write("                                                <option></option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-2 offset-1 form-group\">\r\n");
      out.write("                                            <label for=\"Quantidade\" class=\"text-dark\">Quantidade: (Caixa)</label>\r\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" placeholder=\"\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-1 offset-1 form-group\">\r\n");
      out.write("                                            <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\r\n");
      out.write("                                            <script>\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#add5\").click(function () {\r\n");
      out.write("                                                        $(\"#line6\").show();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#sub5\").click(function () {\r\n");
      out.write("                                                        $(\"#line5\").hide();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                            </script>\r\n");
      out.write("                                            <button class=\"btn btn-sm btn-info mt-2\" id=\"add5\">+</button>\r\n");
      out.write("                                            <button class=\"btn btn-sm btn-info mt-2\" id=\"sub5\">-</button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"form-row\" id=\"line6\" style=\"display:none\">\r\n");
      out.write("                                        <div class=\"col-md-6 form-group\">\r\n");
      out.write("                                            <label for=\"Medicamento\" class=\"text-dark\">Medicamento:</label>\r\n");
      out.write("                                            <select id=\"cbRemedios\" class=\"form-control\">\r\n");
      out.write("                                                <option></option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-2 offset-1 form-group\">\r\n");
      out.write("                                            <label for=\"Quantidade\" class=\"text-dark\">Quantidade:(Caixa)</label>\r\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-1 offset-1 form-group\">\r\n");
      out.write("                                            <script src=\"js/jquery-3.2.1.slim.min.js\"></script>\r\n");
      out.write("                                            <script>\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#add6\").click(function () {\r\n");
      out.write("                                                        $(\"#line7\").show();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                                $(document).ready(function () {\r\n");
      out.write("                                                    $(\"#sub6\").click(function () {\r\n");
      out.write("                                                        $(\"#line6\").hide();\r\n");
      out.write("                                                    });\r\n");
      out.write("                                                });\r\n");
      out.write("                                            </script>\r\n");
      out.write("                                            <!--                                            <button id=\"add6\">+</button>-->\r\n");
      out.write("                                            <button class=\"btn btn-sm btn-info mt-2\" id=\"sub6\">-</button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"form-row\">\r\n");
      out.write("                                        <div class=\"form-group col-md-4\">\r\n");
      out.write("                                            <label for=\"crm\" class=\"text-dark row\" >CRM:</label>\r\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"crmMedico\" required name=\"medicoCrm\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group col-md-8\">\r\n");
      out.write("                                            <label for=\"crm\" class=\"text-dark row\" >Nome do médico:</label>\r\n");
      out.write("                                            <input type=\"nomeMedico\" class=\"form-control\" id=\"nomeMedico\" required name=\"medicoNome\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"form-row\">\r\n");
      out.write("                                        <div class=\"form-group col-md-4\">\r\n");
      out.write("                                            <label for=\"dtReceita\" class=\"text-dark\">Data da receita:</label>\r\n");
      out.write("                                            <input type=\"date\" class=\"form-control\" id=\"dtReceita\" required name=\"dataReceita\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"row col-sm-1 offset-10\">\r\n");
      out.write("                                            <button type=\"submit\" class=\"btn offset-1 btn-primary\">Avançar</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
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
