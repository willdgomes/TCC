<%-- 
    Document   : gerenciarPacientes
    Created on : 25/04/2018, 02:02:28
    Author     : Isabelle 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-heading">
                        <h2 align="center">Gerenciamento de medicamentos</h2>
                        <a class="nav-link" href="MedicamentoController?action=carregarCadastro"><i class="material-icons">library_add</i> <span class="align-top">Medicamentos</span></a>
                    </div>
                    <div class="panel-body m-3">
                        <div class="col-sm-12">
                            <form action="MedicamentoController?action=pesquisarMedicamento" method="POST" class="card border-info">
                                <div class="card-body p-5">
                                    <div class="form-row" id="successAlert">
                                        <div class="alert alert-success alert-dismissible col">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            Medicamento alterado com sucesso!
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="col-sm-10" placeholder="Pesquisar" required name="pesquisa">    
                                        <button type="submit" class="btn col-sm-1"><i class="material-icons">search</i></button>
                                    </div>     
                                </div>
                            </form>
                        </div>
                        <div class="col">
                            <div class="card border-info">
                                <div class="card-body p-3">
                                    <table class="table table-hover table-responsive-sm">
                                        <thead>
                                            <tr>
                                                <th scope="col">Nome</th>
                                                <th scope="col">Fabricante</th>
                                                <th scope="col">Coposição</th>
                                                <th scope="col">Dosagem</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>               
                                        <td colspan="5" id="errorAlert"><div class="form-row">
                                                <div class="alert alert-danger alert-dismissible col">
                                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                                    Medicamento não cadastrado no sistema!
                                                </div>
                                            </div>
                                        </td>
                                            <c:forEach items="${medicamentos}" var="medicamento">
                                            <form action="MedicamentoController?action=editar" method="POST">
                                                <tr>
                                                    <td colspan="col">${medicamento.nome}</td>
                                                    <td colspan="col">${medicamento.nomeFabricante}</td>
                                                    <td colspan="col">${medicamento.composicao}</td>
                                                    <td colspan="col">${medicamento.dosagem}</td>
                                                    <td><button type="submit" name="editar" class="btn btn-sm btn-link"><i class="material-icons">edit</i></button> </td>
                                                <input type="hidden" value="${medicamento.id}" name="idMedicamento">
                                                </tr>
                                            </form>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                $(document).ready(function () {
                    var successAlert = JSON.parse(${successAlert});
                    var errorAlert = JSON.parse(${errorAlert});
                    if (successAlert == true)
                        $("#successAlert").show();
                    else
                        $("#successAlert").hide();
                    if (errorAlert == true)
                        $("#errorAlert").show();
                    else
                        $("#errorAlert").hide();
                });
            </script>
        </jsp:body>
    </t:page>
