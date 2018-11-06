<%-- 
    Document   : cadastrarRetirante
    Created on : 29/04/2018, 00:56:33
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
                        <h2>Cadastro de retirantes</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <div class="col-sm-12">
                            <form class="card border-info" action="CadastroRetiranteController" method="POST">
                                <div class="card-body p-5">
                                    <div class="form-row">
                                        <div class="form-group col">
                                            <label for="nome" class="text-dark">Nome:</label>
<<<<<<< HEAD
                                            <input type="text" class="form-control" id="nomeretirante" required name="nomeRetirante">
=======
<<<<<<< HEAD
                                            <input type="text" class="form-control" id="nomepaciente" required name="nomeRetirante">
=======
                                            <input type="text" class="form-control" id="nomeretirante" required name="nomeRetirante">
>>>>>>> 912b5d2b6abc8795533343894bd08a0ba9b7e3dd
>>>>>>> fafe12c7c6202553635e8936351f0aaa13542a45
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4" >
                                            <label for="cpf" class="text-dark">CPF:</label>
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> fafe12c7c6202553635e8936351f0aaa13542a45
                                            <input type="number" class="form-control" id="cpfpaciente" required name="cpfRetirante">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="dtnasc" class="text-dark">Data de nascimento:</label>
                                            <input type="date" class="form-control" id="dtnascpaciente" required name="dtNascimento">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="dtnasc" class="text-dark">Telefone:</label>
                                            <input type="number" class="form-control" id="dtnascpaciente" name="telefone">
<<<<<<< HEAD
=======
=======
                                            <input type="number" class="form-control" id="cpfretirante" required name="cpfRetirante">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="dtnasc" class="text-dark">Data de nascimento:</label>
                                            <input type="date" class="form-control" id="dtnascretirante" required name="dtNascimento">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="dtnasc" class="text-dark">Telefone:</label>
                                            <input type="number" class="form-control" id="telefoneretirante" name="telefone">
>>>>>>> 912b5d2b6abc8795533343894bd08a0ba9b7e3dd
>>>>>>> fafe12c7c6202553635e8936351f0aaa13542a45
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="email" class="text-dark">E-mail:</label>
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> fafe12c7c6202553635e8936351f0aaa13542a45
                                            <input type="text" class="form-control" id="emailpaciente" name="emailRetirante">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
<<<<<<< HEAD
                                            <label for="parentesco" class="text-dark ">Paciente</label>
                                            <div class="col-md-12 row">
                                                <div class="dropdown">
                                                    <select id="cbPaciente" class="form-control" name="paciente">
                                                        <option></option>
                                                        <option>Fulano da silva santos sauro</option>
                                                        <option>eu fro aaa</option>
                                                        <option>Lilian renata de spuza campos ferreira</option>
                                                    </select>
                                                </div>                    
                                            </div>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="parentesco" class="text-dark ">Parentesco:</label>
                                            <div class="col-md-5 row">
                                                <div class="dropdown">
                                                    <select id="cbRemedios" class="form-control" name="parentesco">
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
                                            <input type="number" class="form-control" id="ceppaciente" required name="cepRetirante">
                                        </div>
                                        <div class="col-md-1">
                                            <button type="button" class="btn btn-sm mt-3" onclick="$(document).ready(function ()"><i class="material-icons">search</i></button>
=======
                                                <label for="parentesco" class="text-dark ">Paciente</label>
                                                <div class="col-md-12 row">
                                                    <div class="dropdown">
                                                        <select id="cbPaciente" class="form-control" name="paciente">
                                                            <option></option>
                                                            <option>Fulano da silva santos sauro</option>
                                                            <option>eu fro aaa</option>
                                                            <option>Lilian renata de spuza campos ferreira</option>
                                                        </select>
                                                    </div>                    
                                                </div>
                                        </div>
                                        <div class="form-group col-md-6">
                                                <label for="parentesco" class="text-dark ">Parentesco:</label>
                                                <div class="col-md-5 row">
                                                    <div class="dropdown">
                                                        <select id="cbRemedios" class="form-control" name="parentesco">
                                                            <option></option>
                                                            <option>Pai</option>
                                                            <option>Mãe</option>
                                                            <option>Outro</option>
                                                        </select>
                                                    </div>                    
                                                </div>
                                           </div>
                                        </div>
=======
                                            <input type="text" class="form-control" id="emailretirante" name="emailRetirante">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">                                
                                            <div class="form-group col-md-6">
                                                <label for="parentesco" class="text-dark ">Paciente</label>
                                                <div class="col-md-12 row">
                                                    <div class="dropdown">
                                                        <select id="cbRemedios" class="form-control" name="parentesco">
                                                            <option></option>
                                                            <option>Pai</option>
                                                            <option>Mãe</option>
                                                            <option>Outro</option>
                                                        </select>
                                                    </div>                    
                                                </div>
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label for="parentesco" class="text-dark ">Parentesco:</label>
                                                <div class="col-md-12 row">
                                                    <div class="dropdown">
                                                        <select id="cbRemedios" class="form-control" name="parentesco">
                                                            <option></option>
                                                            <option>Pai</option>
                                                            <option>Mãe</option>
                                                            <option>Outro</option>
                                                        </select>
                                                    </div>                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
>>>>>>> 912b5d2b6abc8795533343894bd08a0ba9b7e3dd

                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="cep" class="text-dark">CEP:</label>
<<<<<<< HEAD
                                            <input type="number" class="form-control" id="ceppaciente" required name="cepRetirante">
                                        </div>
                                        <div class="col-md-1">
                                            <button type="button" class="btn btn-sm mt-3"><i class="material-icons">search</i></button>
=======
                                            <input type="number" class="form-control" id="cepretirante" required name="cepRetirante">
                                        </div>
                                        <div class="col-md-1">
                                            <button type="button" class="btn btn-sm mt-3" onclick="$(document).ready(function ()"><i class="material-icons">search</i></button>
>>>>>>> 912b5d2b6abc8795533343894bd08a0ba9b7e3dd
>>>>>>> fafe12c7c6202553635e8936351f0aaa13542a45
                                        </div>
                                    </div>
                                    <div class="form-row">                                   
                                        <div class="form-group col-md-4">
                                            <label for="cidade" class="text-dark">Cidade:</label>
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> fafe12c7c6202553635e8936351f0aaa13542a45
                                            <input type="text" class="form-control" id="cidadepaciente" required name="cidadeRetirante">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="estado" class="text-dark">Estado:</label>
<<<<<<< HEAD
=======
                                            <input type="text" class="form-control" id="estadopaciente" required name="estadoRetirante">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="bairro" class="text-dark">Bairro:</label>
                                            <input type="text" class="form-control" id="ceppaciente" required name="bairroRetirante">
=======
                                            <input type="text" class="form-control" id="cidaderetirante" required name="cidadeRetirante">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="estado" class="text-dark">Estado:</label>
>>>>>>> fafe12c7c6202553635e8936351f0aaa13542a45
                                            <input type="text" class="form-control" id="estadoretirante" required name="estadoRetirante">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="bairro" class="text-dark">Bairro:</label>
                                            <input type="text" class="form-control" id="bairroretirante" required name="bairroRetirante">
<<<<<<< HEAD
=======
>>>>>>> 912b5d2b6abc8795533343894bd08a0ba9b7e3dd
>>>>>>> fafe12c7c6202553635e8936351f0aaa13542a45
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="endereco" class="text-dark">Endereço:</label>
<<<<<<< HEAD
                                            <input type="text" class="form-control" id="enderecoretirante" required name="enderecoRetirante">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="numero" class="text-dark">Número:</label>
                                            <input type="number" class="form-control" id="numeroretirante" required name="numeroEnderecoRetirante">
=======
<<<<<<< HEAD
                                            <input type="text" class="form-control" id="enderecopaciente" required name="enderecoRetirante">
=======
                                            <input type="text" class="form-control" id="enderecoretirante" required name="enderecoRetirante">
>>>>>>> 912b5d2b6abc8795533343894bd08a0ba9b7e3dd
                                        </div>

                                        <div class="form-group col-md-4">
                                            <label for="numero" class="text-dark">Número:</label>
<<<<<<< HEAD
                                            <input type="number" class="form-control" id="numeropaciente" required name="numeroEnderecoRetirante">
=======
                                            <input type="number" class="form-control" id="numeroretirante" required name="numeroEnderecoRetirante">
>>>>>>> 912b5d2b6abc8795533343894bd08a0ba9b7e3dd
>>>>>>> fafe12c7c6202553635e8936351f0aaa13542a45
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="numero" class="text-dark">Complemento:</label>
                                            <input type="text" class="form-control" id="complemento" name="complementoRetirante">
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
<<<<<<< HEAD
    </div>
    <script type="text/javascript" >

        $(document).ready(function () {

            function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#enderecoretirante").val("");
                $("#bairroretirante").val("");
                $("#cidaderetirante").val("");
                $("#estadoretirante").val
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
=======
<<<<<<< HEAD
=======
        <script type="text/javascript" >

            $(document).ready(function () {

                function limpa_formulário_cep() {
                    // Limpa valores do formulário de cep.
                    $("#enderecoretirante").val("");
                    $("#bairroretirante").val("");
                    $("#cidaderetirante").val("");
                    $("#estadoretirante").val
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
>>>>>>> 912b5d2b6abc8795533343894bd08a0ba9b7e3dd
    </jsp:body>
>>>>>>> fafe12c7c6202553635e8936351f0aaa13542a45
</t:page>
