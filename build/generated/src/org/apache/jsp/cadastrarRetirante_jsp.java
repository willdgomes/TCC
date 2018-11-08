package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastrarRetirante_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_th_t_page_0.setJspBody(new cadastrarRetirante_jspHelper( 0, _jspx_page_context, _jspx_th_t_page_0, null));
    _jspx_th_t_page_0.doTag();
    return false;
  }

  private class cadastrarRetirante_jspHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public cadastrarRetirante_jspHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <div class=\"main w-100\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"panel panel-default col-sm pt-4\">\n");
      out.write("                    <div class=\"panel-heading text-center\">\n");
      out.write("                        <h2>Cadastro de retirantes</h2>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body pt-3\">\n");
      out.write("                        <div class=\"col-sm-12\">\n");
      out.write("                            <form class=\"card border-info\" action=\"CadastroRetiranteController\" method=\"POST\">\n");
      out.write("                                <div class=\"card-body p-5\">\n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col\">\n");
      out.write("                                            <label for=\"nome\" class=\"text-dark\">Nome:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"nomeretirante\" required name=\"nomeRetirante\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col-md-4\" >\n");
      out.write("                                            <label for=\"cpf\" class=\"text-dark\">CPF:</label>\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"cpfpaciente\" required name=\"cpfRetirante\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-4\">\n");
      out.write("                                            <label for=\"dtnasc\" class=\"text-dark\">Data de nascimento:</label>\n");
      out.write("                                            <input type=\"date\" class=\"form-control\" id=\"dtnascpaciente\" required name=\"dtNascimento\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-4\">\n");
      out.write("                                            <label for=\"dtnasc\" class=\"text-dark\">Telefone:</label>\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"dtnascpaciente\" name=\"telefone\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col-md-8\">\n");
      out.write("                                            <label for=\"email\" class=\"text-dark\">E-mail:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"emailpaciente\" name=\"emailRetirante\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col-md-6\">\n");
      out.write("                                            <label for=\"parentesco\" class=\"text-dark \">Paciente</label>\n");
      out.write("                                            <div class=\"col-md-12 row\">\n");
      out.write("                                                <div class=\"dropdown\">\n");
      out.write("                                                    <select id=\"cbPaciente\" class=\"form-control\" name=\"paciente\">\n");
      out.write("                                                        <option></option>\n");
      out.write("                                                        <option>Fulano da silva santos sauro</option>\n");
      out.write("                                                        <option>eu fro aaa</option>\n");
      out.write("                                                        <option>Lilian renata de spuza campos ferreira</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>                    \n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-6\">\n");
      out.write("                                            <label for=\"parentesco\" class=\"text-dark \">Parentesco:</label>\n");
      out.write("                                            <div class=\"col-md-5 row\">\n");
      out.write("                                                <div class=\"dropdown\">\n");
      out.write("                                                    <select id=\"cbRemedios\" class=\"form-control\" name=\"parentesco\">\n");
      out.write("                                                        <option></option>\n");
      out.write("                                                        <option>Pai</option>\n");
      out.write("                                                        <option>Mãe</option>\n");
      out.write("                                                        <option>Outro</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>                    \n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col-md-4\">\n");
      out.write("                                            <label for=\"cep\" class=\"text-dark\">CEP:</label>\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"ceppaciente\" required name=\"cepRetirante\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-1\">\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-sm mt-3\" onclick=\"$(document).ready(function ()\"><i class=\"material-icons\">search</i></button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-row\">                                   \n");
      out.write("                                        <div class=\"form-group col-md-4\">\n");
      out.write("                                            <label for=\"cidade\" class=\"text-dark\">Cidade:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"cidadepaciente\" required name=\"cidadeRetirante\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-4\">\n");
      out.write("                                            <label for=\"estado\" class=\"text-dark\">Estado:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"estadoretirante\" required name=\"estadoRetirante\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-4\">\n");
      out.write("                                            <label for=\"bairro\" class=\"text-dark\">Bairro:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"bairroretirante\" required name=\"bairroRetirante\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col-md-8\">\n");
      out.write("                                            <label for=\"endereco\" class=\"text-dark\">Endereço:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"enderecoretirante\" required name=\"enderecoRetirante\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-4\">\n");
      out.write("                                            <label for=\"numero\" class=\"text-dark\">Número:</label>\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" id=\"numeroretirante\" required name=\"numeroEnderecoRetirante\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-row\">\n");
      out.write("                                        <div class=\"form-group col-md-8\">\n");
      out.write("                                            <label for=\"numero\" class=\"text-dark\">Complemento:</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"complemento\" name=\"complementoRetirante\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
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
      out.write("    </div>\n");
      out.write("    <script type=\"text/javascript\" >\n");
      out.write("\n");
      out.write("        $(document).ready(function () {\n");
      out.write("\n");
      out.write("            function limpa_formulário_cep() {\n");
      out.write("                // Limpa valores do formulário de cep.\n");
      out.write("                $(\"#enderecoretirante\").val(\"\");\n");
      out.write("                $(\"#bairroretirante\").val(\"\");\n");
      out.write("                $(\"#cidaderetirante\").val(\"\");\n");
      out.write("                $(\"#estadoretirante\").val(\"\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            //Quando o campo cep perde o foco.\n");
      out.write("            $(\"#cepretirante\").blur(function () {\n");
      out.write("\n");
      out.write("                //Nova variável \"cep\" somente com dígitos.\n");
      out.write("                var cep = $(this).val().replace(/\\D/g, '');\n");
      out.write("\n");
      out.write("                //Verifica se campo cep possui valor informado.\n");
      out.write("                if (cep != \"\") {\n");
      out.write("\n");
      out.write("                    //Expressão regular para validar o CEP.\n");
      out.write("                    var validacep = /^[0-9]{8}$/;\n");
      out.write("\n");
      out.write("                    //Valida o formato do CEP.\n");
      out.write("                    if (validacep.test(cep)) {\n");
      out.write("\n");
      out.write("                        //Preenche os campos com \"...\" enquanto consulta webservice.\n");
      out.write("                        $(\"#enderecoretirante\").val(\"...\");\n");
      out.write("                        $(\"#bairroretirante\").val(\"...\");\n");
      out.write("                        $(\"#cidaderetirante\").val(\"...\");\n");
      out.write("                        $(\"#estadoretirante\").val(\"...\");\n");
      out.write("\n");
      out.write("                        //Consulta o webservice viacep.com.br/\n");
      out.write("                        $.getJSON(\"https://viacep.com.br/ws/\" + cep + \"/json/?callback=?\", function (dados) {\n");
      out.write("\n");
      out.write("                            if (!(\"erro\" in dados)) {\n");
      out.write("                                //Atualiza os campos com os valores da consulta.\n");
      out.write("                                $(\"#enderecoretirante\").val(dados.logradouro);\n");
      out.write("                                $(\"#bairroretirante\").val(dados.bairro);\n");
      out.write("                                $(\"#cidaderetirante\").val(dados.localidade);\n");
      out.write("                                $(\"#estadoretirante\").val(dados.uf);\n");
      out.write("                            } //end if.\n");
      out.write("                            else {\n");
      out.write("                                //CEP pesquisado não foi encontrado.\n");
      out.write("                                limpa_formulário_cep();\n");
      out.write("                                alert(\"CEP não encontrado.\");\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                    } //end if.\n");
      out.write("                    else {\n");
      out.write("                        //cep é inválido.\n");
      out.write("                        limpa_formulário_cep();\n");
      out.write("                        alert(\"Formato de CEP inválido.\");\n");
      out.write("                    }\n");
      out.write("                } //end if.\n");
      out.write("                else {\n");
      out.write("                    //cep sem valor, limpa formulário.\n");
      out.write("                    limpa_formulário_cep();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    </script>\n");
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
