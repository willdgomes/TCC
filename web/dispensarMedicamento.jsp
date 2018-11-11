<%-- 
    Document   : cadastrarPacientes
    Created on : 25/04/2018, 14:37:58
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-heading">
                        <h2 align="center">Dispensar Medicamentos</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <div class="col-sm-12">
                            <form class="card border-info">
                                <div class="card-body p-5">
                                    <div class="col form-row">
                                        <div class="form-group col-md-6">
                                            <label for="retirante" class="text-dark" >Paciente</label>
                                            <select id="cbRemedios" class="form-control" required name="nomePaci">
                                                <option>Fulano</option>
                                                <option>Ciclano</option>
                                                <option>Beltrano</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-4  offset-md-1">
                                            <label for="cpf" class="text-dark row" >CPF:</label>
                                            <label for="infoCpf" class="row text-left" required name="cpfPaciente">097.579.629-10</label>
                                        </div>
                                    </div>
                                    <div class="col form-row">
                                        <div class="form-group col-md-6">
                                            <label for="retirante" class="text-dark" >Retirante</label>
                                            <select id="cbRemedios" class="form-control" required name="nomeRetirante">
                                                <option>Paciente</option>
                                                <option>retirante1</option>
                                                <option>retirante2</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-4  offset-md-1">
                                            <label for="cpf" class="text-dark row" >CPF:</label>
                                            <label for="infoCpf" class="row text-left" required name="cpfPaciente">097.579.629-10</label>
                                        </div>
                                    </div>  
                                </div>
                            </form>
                        </div>
                        <div class="col-sm-12">
                            <form class="card border-info" action="DispensaController?action=selecionaMedicamento" method="POST">
                                <div class="card-body p-5">
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
                                            <script>
                                                $(document).ready(function () {
                                                    $("#add1").click(function () {
                                                        $("#line2").show();
                                                    });
                                                });
                                            </script>
                                            <button class="btn btn-sm btn-info mt-2" id="add1"><i class="material-icons">add</i></button>
                                        </div>
                                    </div>
                                    <div class="form-row mt-3">
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
                                        <button type="submit" class="btn offset-1 btn-primary">Avançar</button>
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
