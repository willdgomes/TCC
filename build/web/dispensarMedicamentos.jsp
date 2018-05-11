<%-- 
    Document   : dispensarMedicamentos
    Created on : 03/05/2018, 18:36:48
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
                    <div class="card border-info">
                        <div class="card-body p-5">
                            <table class="table table-hover table-responsive-sm">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Paciente</th>
                                        <th scope="col">Retirante</th>
                                        <th scope="col">Medicamento</th>
                                        <th scope="col">Quantidade</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Mark Jacob</td>
                                        <td>Otto Thornton</td>
                                        <td>remedio 1</td>
                                        <td>3</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Mark Jacob</td>
                                        <td>Otto Thornton</td>
                                        <td>remedio 2</td>
                                        <td>2</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>Larry the Bird</td>
                                        <td>Larry the Bird</td>
                                        <td>remedio 1</td>
                                        <td>4</td>
                                    </tr>
                                </tbody>
                            </table>
                            <script>
                                $(document).ready(function(){
                                    $("button").on("click", function(){
                                        alert("Dispensa Efetuada com Sucesso!");
                                    });
                                });
                            </script>
                            <div class="col-sm-1 offset-10 row">
                            <a>
                                <button type="submit" class="btn offset-1 btn-primary">Dispensar</button>
                            </a>
                            </div>
                        </div>
                    </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page>