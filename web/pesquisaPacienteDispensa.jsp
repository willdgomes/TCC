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
                                <div class="form-group">
                                    <input type="text" class="col-sm-10" placeholder="Pesquisar">    
                                    <button type="submit" class="btn col-sm-1"><i class="material-icons">search</i></button>
                                </div>
                                <div class="card-body p-3">
                                    nome do paciente da silva<br>
                                    123.456.678-10<br>
                                    19/06/2018<br>
                                </div>
                                <div class="col-md-4 form-group">
                                    <label for="retirante" >Retirante</label>
                                    <select id="cbRemedios" class="form-control">
                                        <option>Paciente</option>
                                        <option>retirante1</option>
                                        <option>retirante2</option>
                                    </select>
                                </div>
                                <a href="dispensarMedicamentos.jsp">
                                    <button type="submit" class="btn offset-1 btn-primary">Avançar</button>
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page>