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
                                        <input type="text" class="form-control" id="nomepaciente" required name="nomeRetirante">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-4" >
                                        <label for="cpf" class="text-dark">CPF:</label>
                                        <input type="number" class="form-control" id="cpfpaciente" required name="cpfRetirante">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="dtnasc" class="text-dark">Data de nascimento:</label>
                                        <input type="date" class="form-control" id="dtnascpaciente" required name="dtNascimento">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="dtnasc" class="text-dark">Telefone:</label>
                                        <input type="number" class="form-control" id="dtnascpaciente" name="telefone">
                                    </div>
                                </div>
                                <div class="form-row">
                                     <div class="form-group col-md-8">
                                        <label for="email" class="text-dark">E-mail:</label>
                                        <input type="text" class="form-control" id="emailpaciente" name="emailRetirante">
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
                                
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="cep" class="text-dark">CEP:</label>
                                        <input type="number" class="form-control" id="ceppaciente" required name="cepRetirante">
                                    </div>
                                    <div class="col-md-1">
                                        <button type="button" class="btn btn-sm mt-3"><i class="material-icons">search</i></button>
                                    </div>
                                </div>
                                <div class="form-row">                                   
                                    <div class="form-group col-md-4">
                                        <label for="cidade" class="text-dark">Cidade:</label>
                                        <input type="text" class="form-control" id="cidadepaciente" required name="cidadeRetirante">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="estado" class="text-dark">Estado:</label>
                                        <input type="text" class="form-control" id="estadopaciente" required name="estadoRetirante">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="bairro" class="text-dark">Bairro:</label>
                                        <input type="text" class="form-control" id="ceppaciente" required name="bairroRetirante">
                                    </div>
                                </div>
                                <div class="form-row">
                                     <div class="form-group col-md-8">
                                        <label for="endereco" class="text-dark">Endereço:</label>
                                        <input type="text" class="form-control" id="enderecopaciente" required name="enderecoRetirante">
                                    </div>
                                    
                                    <div class="form-group col-md-4">
                                        <label for="numero" class="text-dark">Número:</label>
                                        <input type="number" class="form-control" id="numeropaciente" required name="numeroEnderecoRetirante">
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
    </jsp:body>
</t:page>
