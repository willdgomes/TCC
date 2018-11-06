<%-- 
    Document   : pesquisaPacienteDispensa
    Created on : 01/05/2018, 21:24:00
    Author     : gomes
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
                    <h2>Dispensar Medicamentos</h2>
                </div>
                <div class="panel-body m-3">
                    <div class="col-sm-12">
                        <form class="card border-info">
                            <div class="card-body p-5">
                                <div class="card-body p-3 ">
                                    <div class="col form-row">
                                        <div class="form-group col">
                                            <label for="retirante" class="text-dark" >Paciente</label>
                                            <select id="cbRemedios" class="form-control" required name="nomePaci">
                                                <option>Fulano</option>
                                                <option>Ciclano</option>
                                                <option>Beltrano</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col form-row">
                                        <div class="form-group col-md-4">
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
                                    </div>                                    
                                    <div class="col-sm-1 offset-10 row">
                                        <a href="dispensarMedicamentos.jsp">
                                            <button type="submit" class="btn offset-1 btn-primary">Avançar</button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page>