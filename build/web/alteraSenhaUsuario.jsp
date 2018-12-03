<%-- 
    Document   : alteraSenhaUsuario
    Created on : 03/12/2018, 15:44:46
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
                        <h2>Alterar Senha</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <div class="col-sm-12">
                            <c:forEach items="${usuario}" var="usuario">
                                <form action="UsuarioController?action=alterarSenha" method="POST" class="card border-info">
                                    <input type="hidden" value="${usuario.idUsuario}" required name="idUsuario">
                                    <div class="card-body p-5">
                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label for="novaSenha" class="text-dark">Nova senha:</label>
                                                <input type="password" class="form-control" id="nomeusuario" required name="novaSenha">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-4">
                                                <label for="confirmaNovaSenha" class="text-dark">Confirmar senha:</label>
                                                <input type="password" class="form-control" id="nomeusuario" required name="confirmaNovaSenha">
                                            </div>
                                        </div><div class="form-row">
                                            <div class="col-md-1 offset-md-11" >
                                                <button type="submit" class="btn btn-primary">Alterar</button
                                            </div>
                                        </div>
                                    </div>
                                </form>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page>
