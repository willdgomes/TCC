package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class relatorioEstoque_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js\"></script>\n");
      if (_jspx_meth_t_page_0(_jspx_page_context))
        return;
      out.write('\n');
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
    _jspx_th_t_page_0.setJspBody(new relatorioEstoque_jspHelper( 0, _jspx_page_context, _jspx_th_t_page_0, null));
    _jspx_th_t_page_0.doTag();
    return false;
  }

  private class relatorioEstoque_jspHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public relatorioEstoque_jspHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      out.write("        \n");
      out.write("        <div class=\"col\">\n");
      out.write("            <canvas id=\"myChart\" onloadstart=\"addData(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.nomeMed}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(',');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.qntd}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")\"></canvas>\n");
      out.write("        </div>\n");
      out.write("<script>\n");
      out.write("    \n");
      out.write("function addData(medicamentos,qntd) {\n");
      out.write("var ctx = document.getElementById(\"myChart\").getContext('2d');\n");
      out.write("var myChart = new Chart(ctx, {\n");
      out.write("    type: 'bar',\n");
      out.write("    data: {\n");
      out.write("        labels: va,\n");
      out.write("        datasets: [{\n");
      out.write("            label: medicamentos,\n");
      out.write("            data: qntd,\n");
      out.write("            backgroundColor: [\n");
      out.write("                'rgba(255, 99, 132, 0.2)',\n");
      out.write("                'rgba(54, 162, 235, 0.2)',\n");
      out.write("                'rgba(255, 206, 86, 0.2)',\n");
      out.write("                'rgba(75, 192, 192, 0.2)',\n");
      out.write("                'rgba(153, 102, 255, 0.2)',\n");
      out.write("                'rgba(255, 159, 64, 0.2)'\n");
      out.write("            ],\n");
      out.write("            borderColor: [\n");
      out.write("                'rgba(255,99,132,1)',\n");
      out.write("                'rgba(54, 162, 235, 1)',\n");
      out.write("                'rgba(255, 206, 86, 1)',\n");
      out.write("                'rgba(75, 192, 192, 1)',\n");
      out.write("                'rgba(153, 102, 255, 1)',\n");
      out.write("                'rgba(255, 159, 64, 1)'\n");
      out.write("            ],\n");
      out.write("            borderWidth: 1\n");
      out.write("        }]\n");
      out.write("    },\n");
      out.write("    options: {\n");
      out.write("        scales: {\n");
      out.write("            yAxes: [{\n");
      out.write("                ticks: {\n");
      out.write("                    beginAtZero:true\n");
      out.write("                }\n");
      out.write("            }]\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("});\n");
      out.write("}\n");
      out.write("</script>\n");
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
