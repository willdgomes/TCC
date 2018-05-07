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
        <div class="main w-100">
        <div class="row">
            <div class="panel panel-default col-sm pt-4">
                <div class="panel-heading text-center">
                    <h2>Cadastro de pacientes</h2>
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
