<%-- 
    Document   : inserirMedicamento
    Created on : 04/09/2018, 22:12:17
    Author     : Eu
--%>


<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/menuAdmin" %>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-heading text-center">
                        <h2>Inserir Medicamentos</h2>
                    </div>
                    <div class="panel-body m-3">
                        <div class="col-sm-12">
                            <form action="MedicamentoController?action=insereMedicamentoLote" method="POST" class="card border-info">
                                <div class="card-body p-5">
                                    <div class="form-row" id="successAlert">
                                        <div class="alert alert-success alert-dismissible col">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            Medicamento adicionado com sucesso!
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="medicamento" class="text-dark" >Medicamento:</label>
                                            <select id="cbRemedios" class="form-control" required name="nomeMed">
                                                <option></option>
                                                <c:forEach items="${applicationScope.medicamentos}" var="medicamento">
                                                    <option>${medicamento.nome}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                     <div class="form-row">
                                         <div class="col-md-2 form-group">
                                            <label for="Quantidade"class="text-dark" >Quantidade:(Caixa)</label>
                                            <input type="number" class="form-control" id="cpfpaciente" placeholder="" required name="qtdeCaixa">
                                        </div>
                                        <div class="col-md-2 offset-1 form-group">
                                            <label for="Lote"class="text-dark" >Lote:</label>
                                            <input type="number" class="form-control" id="loteMedicamento" placeholder="" required name="numeroLote">
                                        </div>
                                           <div class="col-md-2 offset-1 form-group">
                                            <label for="Lote"class="text-dark" >Data vencimento:</label>
                                            <input type="date" class="form-control" id="vencimentoLote" placeholder="" required name="vencimentoLote">
                                        </div>
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
            <script>
            $(document).ready(function () {
                var successAlert = JSON.parse(${successAlert});
                if (successAlert == true)
                    $("#successAlert").show();
                else
                    $("#successAlert").hide();
            });
        </script>
        </jsp:body>
    </t:page>