<%-- 
    Document   : gerenciarPacientes
    Created on : 25/04/2018, 02:02:28
    Author     : Isabelle 
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
                    <h2 align="center">Gerenciamento de pacientes</h2>
                </div>
                <div class="panel-body m-3">
                    <div class="col-sm-12">
                        <form class="card border-info">
                            <div class="card-body p-5">
                            <div class="form-group">
                                <input type="text" class="col-sm-10" placeholder="Pesquisar">    
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
                                    <th scope="col">#</th>
                                    <th scope="col">First</th>
                                    <th scope="col">Last</th>
                                    <th scope="col">Handle</th>
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
