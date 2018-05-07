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
                        <form class="card border-info">
                            <div class="card-body p-5">
                                <div class="form-row">
                                    <div class="form-group col">
                                        <label for="nome" class="text-dark">Nome:</label>
                                        <input type="text" class="form-control" id="nomepaciente" required>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-4" >
                                        <label for="cpf" class="text-dark">CPF:</label>
                                        <input type="number" class="form-control" id="cpfpaciente" required>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="dtnasc" class="text-dark">Data de nascimento:</label>
                                        <input type="date" class="form-control" id="dtnascpaciente" required>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="dtnasc" class="text-dark">Telefone:</label>
                                        <input type="number" class="form-control" id="dtnascpaciente" required>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col">
                                        <label for="parentesco" class="text-dark ">Parentesco:</label>
                                        <div class="col-sm-12 row">
                                        <div class="dropdown">
                                        <button class="btn dropdown-toggle " type="button" data-toggle="dropdown">Selecione</button>
                                            <ul class="dropdown-menu">
                                            <li><a href="#">Mãe</a></li>
                                            <li><a href="#">Pai</a></li>
                                            <li><a href="#">Amigo</a></li>
                                            </ul>
                                        </div>                    
                                        <button type="submit" class="btn btn-primary offset-9">Salvar</button> 
                                        </div>
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
