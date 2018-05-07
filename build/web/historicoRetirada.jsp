<%-- 
    Document   : historicoRetirada
    Created on : 30/04/2018, 02:52:48
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
                <div class="panel-heading">
                    <h2 align="center">Histórico de retiradas</h2>
                </div>
                <div class="panel-body m-3">
                    <div class="col-sm-12">
                        <div class="card border-info">
                            <div class="card-body p-5">
                                <table class="table table-hover table-responsive-sm">
                                <thead>
                                <tr>
                                    <th scope="col">Data</th>
                                    <th scope="col">Nome remédio</th>
                                    <th scope="col">Quantidade</th>
                                    <th scope="col">Retirante</th>                                    
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td colspan="2">Larry the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                </tbody>
                                </table>                                
                            </div>
                        </div>
                    </div>                  
                </div>
            </div>
        </div>
    </jsp:body>
</t:page>

