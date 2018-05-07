<%-- 
    Document   : gerenciarRetirantes
    Created on : 25/04/2018, 17:26:33
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
                    <h2 align="center">Gerenciamento de retirantes</h2>
                </div>
                <div class="panel-body m-3">
                    <div class="col-sm-12">
                        <div class="card border-info">
                            <div class="card-body p-5">
                                <table class="table table-hover table-responsive-sm">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">First</th>
                                    <th scope="col">Last</th>
                                    <th scope="col">Handle</th>
                                    <th scope="col">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                    <td><button type="button"  class="btn btn-sm btn-link"><i class="material-icons">edit</i></button> </td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                    <td><button type="button"  class="btn btn-sm btn-link"><i class="material-icons">edit</i></button> </td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td colspan="2">Larry the Bird</td>
                                    <td>@twitter</td>
                                    <td><button type="button"  class="btn btn-sm btn-link"><i class="material-icons">edit</i></button> </td>
                                </tr>
                                </tbody>
                                </table>
                                <div class="col-sm-1 offset-10 row">
                                     <button type="button" class="btn btn-primary">Adicionar</button>
                                </div>
                            </div>
                        </div>
                    </div>                  
                </div>
            </div>
        </div>
    </jsp:body>
</t:page>



