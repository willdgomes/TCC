<%-- 
    Document   : cadastrarPacientes
    Created on : 25/04/2018, 14:37:58
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
                        <h2>Editar paciente</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <div class="col-sm-12">
                            <c:forEach items="${paciente}" var="paciente">
                            <form action="PacienteController?action=editarPaciente" method="POST" class="card border-info">
                                <div class="card-body p-5">
                                    <input type="hidden" value="${paciente.id}" required name="idPaciente">
                                    <div class="form-row">
                                        <div class="form-group col">
                                            <label for="nome" class="text-dark">Nome:</label>
                                            <input type="text" class="form-control" id="nomepaciente" value="${paciente.nome}" required name="nome">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4" >
                                            <label for="cpf" class="text-dark">CPF:</label>
                                            <input type="number" class="form-control" id="cpfpaciente" value="${paciente.cpf}" required name="cpf">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="dtnasc" class="text-dark">Data de nascimento:</label>
                                            <input type="date" class="form-control" id="dtnascpaciente" value="${paciente.dataNascimento}"  required name="dataNascimento">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="telefone" class="text-dark">Telefone:</label>
                                            <input type="number" class="form-control" id="dtnascpaciente" value="${paciente.telefone}" name="telefone">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="email" class="text-dark">E-mail:</label>
                                            <input type="text" class="form-control" id="emailpaciente" value="${paciente.email}" name="email">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="cep" class="text-dark">CEP:</label>
                                            <input type="number" class="form-control" id="ceppaciente" value="${paciente.cep}" required name="cep">
                                        </div>
                                        <div class="col-md-1">
                                            <button type="button" class="btn btn-sm mt-3"><i class="material-icons" onclick="$(document).ready(function ()">search</i></button>
                                        </div>
                                    </div>
                                    <div class="form-row">                                   
                                        <div class="form-group col-md-4">
                                            <label for="cidade" class="text-dark">Cidade:</label>
                                            <input type="text" class="form-control" id="cidadepaciente" value="${paciente.cidade}" required name="cidade">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="estado" class="text-dark">Estado:</label>
                                            <input type="text" class="form-control" id="estadopaciente" value="${paciente.estado}" required name="estado">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="bairro" class="text-dark">Bairro:</label>
                                            <input type="text" class="form-control" id="bairropaciente" value="${paciente.bairro}" required name="bairro">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="endereco" class="text-dark">Endereço:</label>
                                            <input type="text" class="form-control" id="enderecopaciente" value="${paciente.endereco}" required name="endereco">
                                        </div>

                                        <div class="form-group col-md-4">
                                            <label for="numero" class="text-dark">Número:</label>
                                            <input type="number" class="form-control" id="numeropaciente" value="${paciente.numEndereco}" required name="numeroEndereco">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="complemento" class="text-dark">Complemento:</label>
                                            <input type="text" class="form-control" id="complemento" value="${paciente.complemento}" name="complemento">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-1 offset-md-11" >
                                            <button type="submit" class="btn btn-primary">Salvar</button
                                        </div>
                                    </div>
                                </div>
                            </form>
                            </c:forEach>
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
