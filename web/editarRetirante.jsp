<%-- 
    Document   : cadastrarRetirante
    Created on : 29/04/2018, 00:56:33
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>

        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/jquery.mask.min.js"></script>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-heading text-center">
                        <h2>Editar retirantes</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <div class="col-sm-12">
                            <form class="card border-info" action="RetiranteController?action=editarRetirante" method="POST">
                                <input type="hidden" value="${retirante.idRetirante}" required name="idRetirante">
                                <div class="card-body p-5">
                                    <div class="form-row">
                                        <div class="form-group col">
                                            <label for="nome" class="text-dark">Nome:</label>
                                            <input type="text" class="form-control" id="nomeretirante" value="${retirante.nomeRetirante}" required name="nomeRetirante">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4" >
                                            <label for="cpf" class="text-dark">CPF:</label>
                                            <input type="text" class="form-control" id="cpfretirante" value="${retirante.cpfRetirante}" required name="cpfRetirante">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="dtnasc" class="text-dark">Data de nascimento:</label>
                                            <input type="date" class="form-control" id="dtnascpaciente" value="${retirante.dnRetirante}" required name="dtNascimento">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="dtnasc" class="text-dark">Telefone:</label>
                                            <input type="text" class="form-control" id="telefone" value="${retirante.telefone}" name="telefone">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="email" class="text-dark">E-mail:</label>
                                            <input type="email" class="form-control" id="emailpaciente" value="${retirante.email}" name="emailRetirante">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="parentesco" class="text-dark ">Paciente</label>
                                            <div class="col-md-12 row">
                                                <div class="dropdown">
                                                     <select id="cdRetirante" class="form-control" required name="paciente">
                                                        <option></option>
                                                         <c:forEach items="${applicationScope.pacientes}" var="paciente">
                                                                <option value="${paciente.id}">${paciente.nome}</option>
                                                          </c:forEach>
                                                    </select>
                                                </div>                    
                                            </div>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="parentesco" class="text-dark ">Parentesco:</label>
                                            <div class="col-md-5 row">
                                                <div class="dropdown">
                                                    <select id="cbParentesco" class="form-control" name="parentesco">
                                                        <option></option>
                                                        <option>Pai</option>
                                                        <option>Mãe</option>
                                                        <option>Outro</option>
                                                    </select>
                                                </div>                    
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="cep" class="text-dark">CEP:</label>
                                            <input type="number" class="form-control" id="ceppaciente" required name="cepRetirante" value="${retirante.cep}">
                                        </div>
                                        <div class="col-md-1">
                                            <button type="button" class="btn btn-sm mt-3" onclick="$(document).ready(function ()"><i class="material-icons">search</i></button>
                                        </div>
                                    </div>
                                    <div class="form-row">                                   
                                        <div class="form-group col-md-4">
                                            <label for="cidade" class="text-dark">Cidade:</label>
                                            <input type="text" class="form-control" id="cidadepaciente" required name="cidadeRetirante" value="${retirante.cidade}">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="estado" class="text-dark">Estado:</label>
                                            <input type="text" class="form-control" id="estadoretirante" required name="estadoRetirante" value="${retirante.estado}">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="bairro" class="text-dark">Bairro:</label>
                                            <input type="text" class="form-control" id="bairroretirante" required name="bairroRetirante" value="${retirante.bairro}">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="endereco" class="text-dark">Endereço:</label>
                                            <input type="text" class="form-control" id="enderecoretirante" required name="enderecoRetirante" value="${retirante.endereco}">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="numero" class="text-dark">Número:</label>
                                            <input type="number" class="form-control" id="numeroretirante" required name="numeroEnderecoRetirante" value="${retirante.numEndereco}">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="numero" class="text-dark">Complemento:</label>
                                            <input type="text" class="form-control" id="complemento" name="complementoRetirante" value="${retirante.complemento}">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-1 offset-md-11" >
                                            <button type="submit" class="btn btn-primary">Salvar</button
                                        </div>
                                    </div>
                                </div>
                            </form>
                          
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" >

        $(document).ready(function () {
        $("#cpfretirante").mask('999.999.999-99');  
        $("#telefone").mask('(99)0 0000-0000');    
            function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#enderecoretirante").val("");
                $("#bairroretirante").val("");
                $("#cidaderetirante").val("");
                $("#estadoretirante").val("");
            }

            //Quando o campo cep perde o foco.
            $("#cepretirante").blur(function () {

                //Nova variável "cep" somente com dígitos.
                var cep = $(this).val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if (validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        $("#enderecoretirante").val("...");
                        $("#bairroretirante").val("...");
                        $("#cidaderetirante").val("...");
                        $("#estadoretirante").val("...");

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                $("#enderecoretirante").val(dados.logradouro);
                                $("#bairroretirante").val(dados.bairro);
                                $("#cidaderetirante").val(dados.localidade);
                                $("#estadoretirante").val(dados.uf);
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
