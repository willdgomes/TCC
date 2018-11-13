<%-- 
    Document   : cadastrarReceita
    Created on : 11/11/2018, 14:37:58
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>

        <script src="js/jquery-3.2.1.min.js"></script>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-heading text-center">
                        <h2>Cadastro de receita</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <div class="col-sm-12">
                            <div class="col-sm-12">
                                <form  action="ReceitasController?action=cadastrarReceita" method="POST">
                                    <div class="card border-info p-5">
                                        <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="paciente" class="text-dark ">Paciente:</label>
                                            <div class="row">
                                                <div class="dropdown col-md-12  ">
                                                    <select id="cbPaciente" class="form-control" name="paciente">
                                                        <option></option>
                                                        <option>Fulano da silva santos sauro</option>
                                                        <option>eu fro aaa</option>
                                                        <option>Ana claudia de souza campos ferreira banah silva</option>
                                                    </select>
                                                </div>                    
                                            </div>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="cpfPaciente" class="text-dark ">CPF:</label>
                                            <div class="col-md-5 row">
                                                <div class="dropdown">
                                                    <label for="cpdPaciente" class="text-dark row" >09757962910</label>
                                                </div>                    
                                            </div>
                                        </div>
                                    </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-8">
                                                <label for="nomeMedico" class="text-dark row" >Nome do médico:</label>
                                                <input type="nomeMedico" class="form-control" id="nomeMedico" name="medicoNome">
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label for="crm" class="text-dark row" >CRM:</label>
                                                <input type="number" class="form-control" id="crmMedico" name="medicoCrm">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label for="dtReceita" class="text-dark">Data da receita:</label>
                                                <input type="date" class="form-control" id="dtReceita" name="dataReceita">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card border-info p-5">
                                        <div class="form-row" id="line1">
                                            <div class="col-md-6 form-group">
                                                <label class="text-dark" for="Medicamento" >Medicamento:</label> 
                                                <select id="cbRemedios" class="form-control" required name="nomeMedicamento">
                                                    <c:forEach items="${applicationScope.medicamentos}" var="medicamento">
                                                        <option>${medicamento.nome}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col-md-2 offset-1 form-group">
                                                <label for="Quantidade"class="text-dark" >Quantidade:(Caixa)</label>
                                                <input type="number" class="form-control" id="cpfpaciente" placeholder="" required name="quantidadeMedicamento">
                                            </div>
                                            <div class="col-md-1 offset-md-1 form-group">
                                                <script src="js/jquery-3.2.1.slim.min.js"></script>
                                                <button class="btn btn-sm btn-info mt-2" id="add1"><i class="material-icons">add</i></button>
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <table class="table table-hover table-responsive-sm">
                                                <thead>
                                                    <tr>                                                    
                                                        <th scope="col">Medicamento</th>
                                                        <th scope="col">Dosagem</th>
                                                        <th scope="col">Quantidade</th>
                                                        <th scope="col">Ação</th>
                                                    </tr>
                                                </thead>
                                                <tbody> 
                                                <td colspan="2">${mensagem}</td>
                                                <c:forEach items="${medicamentoList}" var="paciente">
                                                    <form action="cadastrarPaciente" method="POST">
                                                        <tr>
                                                            <td scope="col">${medicamento.nome}</td>
                                                            <td scope="col">${medicamento.dosagem}</td>
                                                            <td scope="col">${medicamento.quantidade}</td>
                                                            <td scope="col"><button type="delete" name="excluir" class="btn btn-sm btn-link"><i class="material-icons">delete</i></button> </td>
                                                        <input type="hidden" value="${medicamento.id}">
                                                        </tr>
                                                    </form>
                                                </c:forEach>
                                                </tbody>
                                            </table>                
                                        </div>
                                        <div class="row col-sm-1 offset-10">
                                            <button type="submit" class="btn offset-1 btn-primary">Salvar</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript" >

                $(document).ready(function () {

                    function limpa_formulário_cep() {
                        // Limpa valores do formulário de cep.
                        $("#enderecopaciente").val("");
                        $("#bairropaciente").val("");
                        $("#cidadepaciente").val("");
                        $("#estadopaciente").val
                    }

                    //Quando o campo cep perde o foco.
                    $("#ceppaciente").blur(function () {

                        //Nova variável "cep" somente com dígitos.
                        var cep = $(this).val().replace(/\D/g, '');

                        //Verifica se campo cep possui valor informado.
                        if (cep != "") {

                            //Expressão regular para validar o CEP.
                            var validacep = /^[0-9]{8}$/;

                            //Valida o formato do CEP.
                            if (validacep.test(cep)) {

                                //Preenche os campos com "..." enquanto consulta webservice.
                                $("#enderecopaciente").val("...");
                                $("#bairropaciente").val("...");
                                $("#cidadepaciente").val("...");
                                $("#estadopaciente").val("...");

                                //Consulta o webservice viacep.com.br/
                                $.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

                                    if (!("erro" in dados)) {
                                        //Atualiza os campos com os valores da consulta.
                                        $("#enderecopaciente").val(dados.logradouro);
                                        $("#bairropaciente").val(dados.bairro);
                                        $("#cidadepaciente").val(dados.localidade);
                                        $("#estadopaciente").val(dados.uf);
                                    } //end if.
                                    else {
                                        //CEP pesquisado não foi encontrado.
                                        limpa_formulário_cep();
                                        alert("CEP não encontrado.");
                                    }
                                });
                            } //end if.
                            else {
                                //cep é inválido.
                                limpa_formulário_cep();
                                alert("Formato de CEP inválido.");
                            }
                        } //end if.
                        else {
                            //cep sem valor, limpa formulário.
                            limpa_formulário_cep();
                        }
                    });
                });

            </script>
        </jsp:body>
    </t:page>
