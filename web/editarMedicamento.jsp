<%-- 
    Document   : cadastrarRemédio
    Created on : 14/08/2018, 19:13:07
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-heading text-center">
                        <h2>Editar medicamento</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <div class="col-sm-12">
                            <c:forEach items="${medicamento}" var="medicamento">
                            <form action="MedicamentoController?action=editarMedicamento" method="POST" class="card border-info">
                                <div class="card-body p-5">
                                    <input type="hidden" value="${medicamento.id}" required name="idMedicamento">
                                    <div class="form-row">
                                        <div class="form-group col">
                                            <label for="nome" class="text-dark">Nome:</label>
                                            <input type="text" class="form-control" id="nomemedicamento" required value="${medicamento.nome}" name="nome">
                                        </div>
                                         <div class="form-group col" >
                                            <label for="fabricante" class="text-dark">Fabricante:</label>
                                            <input type="text" class="form-control" id="nomeFabricante" value="${medicamento.nomeFabricante}" required name="nomeFabricante">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="composicao" class="text-dark">Composição:</label>
                                            <input type="text" class="form-control" id="composicao" value="${medicamento.composicao}" required name="composicao">
                                        </div>
                                         <div class="form-group col-md-2" >
                                            <label for="dosagem" class="text-dark">Dosagem:</label>
                                            <input type="number" class="form-control" id="dosagem" value="${medicamento.dosagem}" required name="dosagem">
                                        </div>
                                        <div class="form-group col-md-4" >
                                            <label for="medida" class="text-dark">Un. Medida:</label>
                                             <div class="dropdown">
                                                <select id="cbRemedios" class="form-control" name="medida">
                                                    <option></option>
                                                    <option>Miligramas (mg)</option>
                                                    <option>Mililitros (ml)</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col">
                                            <label for="descricao" class="text-dark">Descrição:</label>
                                            <input type="text" class="form-control" id="descricao" value="${medicamento.descricao}" required name="descricao">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-1 offset-md-11" >
                                            <button type="submit" class="btn btn-primary">Salvar</button
                                        </div>
                                    </div>
                                </div>
                            </form>
                            </foreach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page>

