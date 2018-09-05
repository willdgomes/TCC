<%-- 
    Document   : inserirMedicamento
    Created on : 04/09/2018, 22:12:17
    Author     : Eu
--%>


<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
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
                        <form class="card border-info">
                            <div class="card-body p-5">
                                
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="medicamento" class="text-dark" >Medicamento:</label>
                                            <select id="cbMedicamento" class="form-control">
                                                <option>Med1</option>
                                                <option>Med2</option>
                                                <option>med3</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2 offset-1 form-group">
                                            <label for="Quantidade"class="text-dark" >Quantidade:(Caixa)</label>
                                            <input type="number" class="form-control" id="cpfpaciente" placeholder="">
                                        </div>
                                    </div>
                                <div class="row col-sm-1 offset-10">
                                <a href="pesquisaPacienteDispensa.jsp">
                                    <button type="submit" class="btn offset-1 btn-primary">Salvar</button>
                                </a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page>