<%-- 
    Document   : cadastrarUsuario
    Created on : 25/08/2018, 16:54:37
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
                    <div class="panel-heading text-center">
                        <h2>Cadastro de Usuários</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <div class="col-sm-12">
                            <form action="UsuarioController?action=cadastrarUsuario" method="POST" class="card border-info">
                                <div class="card-body p-5">
                                    <div class="form-row" id="successAlert">
                                        <div class="alert alert-success colalert-dismissible col">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            Usuário cadastrado com sucesso!
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col">
                                            <label for="nome" class="text-dark">Nome:</label>
                                            <input type="text" class="form-control" id="nomeusuario" required name="nome">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4" >
                                            <label for="usuario" class="text-dark">Login</label>
                                            <input type="text" class="form-control" id="loginUsuario" required name="login">
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="dtnasc" class="text-dark">Data de nascimento:</label>
                                            <input type="date" class="form-control" id="dtnascUsuario" required name="dataNascimento">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-8">
                                            <label for="email" class="text-dark">E-mail:</label>
                                            <input type="email" class="form-control" id="emailUsuario" name="email">
                                        </div>
                                    </div>                                    
                                    <div class="form-row">
                                        <div class="form-group col-md-5">
                                            <label for="perfil" class="text-dark">Perfil:</label>
                                            <select id="cbPerfil" class="form-control" required name="perfilUsuario">
                                                <option></option>
                                                <option>Administrador</option>
                                                <option>Usuário padrão</option>                                                        
                                            </select>
                                        </div>
                                    </div>                                    
                                    <div class="form-row">
                                        <div class="col-md-1 offset-md-11" >
                                            <button type="submit" class="btn btn-primary">Salvar</button
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         <script>
              $(document).ready(function () {
              var successAlert = JSON.parse(${successAlert});
        if(successAlert == true)
            $("#successAlert").show();
        else
            $("#successAlert").hide();  
    });
        </script>
    </jsp:body>
</t:page>
