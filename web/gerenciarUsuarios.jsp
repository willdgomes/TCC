<%-- 
    Document   : gerenciarRetirantes
    Created on : 25/04/2018, 17:26:33
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-heading">
                        <h2 align="center">Gerenciamento de usuários</h2>
                        <div class="col-sm-12 m-3">
                        <a class="nav-link" href="UsuarioController?action=carregarCadastro"><i class="material-icons">group_add</i> <span class="align-top">Cadastrar usuário</span></a>
                        </div>
                    </div>
                    <div class="panel-body m-3">
                        <div class="col-sm-12">
                            <form action="UsuarioController?action=pesquisarUsuario" method="POST" class="card border-info">
                                <div class="card-body p-5">
                                    <div class="form-row" id="successAlert">
                                        <div class="alert alert-success alert-dismissible col">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            Usuário alterado com sucesso!
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="col-sm-10" placeholder="Pesquisar" required name="pesquisa">    
                                        <button type="submit" class="btn col-sm-1" data-toggle="tooltip" data-placement="bottom" title="Pesquisar retirante"><i class="material-icons">search</i></button>
                                    </div>     
                                </div>
                            </form>
                        </div>
                        <div class="col-sm-12">
                            <div class="card border-info">
                                <div class="card-body p-5">
                                    <table class="table table-hover table-responsive-sm">
                                        <thead>
                                            <tr>                                                    
                                                <th scope="col">Nome</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Perfil</th>
                                                <th scope="col">Ação</th>
                                            </tr>
                                        </thead>
                                        <tbody> 
                                        <td colspan="5" id="errorAlert"><div class="form-row">
                                                <div class="alert alert-danger alert-dismissible col">
                                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                                    Usuário não cadastrado no sistema!
                                                </div>
                                            </div>
                                        </td>
                                        <c:forEach items="${usuarios}" var="usuario">
                                            <form action="UsuarioController?action=editar" method="POST">
                                                <tr>
                                                    <td scope="col">${usuario.nome}</td>
                                                    <td scope="col">${usuario.email}</td>
                                                    <td scope="col">${usuario.perfil}</td>
                                                    <td scope="col"><button type="submit" name="editar" class="btn btn-sm btn-link"><i class="material-icons">edit</i></button> </td>
                                                <input type="hidden" value="${usuario.idUsuario}" name="idUsuario">
                                                </tr>
                                            </form>
                                        </c:forEach>
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
        </div>
        <script>
            $(document).ready(function () {
                var successAlert = JSON.parse(${successAlert});
                var errorAlert = JSON.parse(${errorAlert});
                if (successAlert == true)
                    $("#successAlert").show();
                else
                    $("#successAlert").hide();
                if (errorAlert == true)
                    $("#errorAlert").show();
                else
                    $("#errorAlert").hide();
            });
        </script>
    </jsp:body>
</t:page>



