<%-- 
    Document   : gerenciarPacientes
    Created on : 25/04/2018, 02:02:28
    Author     : Isabelle 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            <form action="PacienteController?action=pesquisaParam" method="POST" class="card border-info">
                                <div class="card-body p-5">
                                    <div class="form-group">
                                        <input type="text" class="col-sm-10" placeholder="Pesquisar" required name="pesquisa">    
                                        <button type="submit" class="btn col-sm-1" data-toggle="tooltip" data-placement="bottom" title="Pesquisar paciente"><i class="material-icons">search</i></button>
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
                                                <th scope="col">Nome</th>
                                                <th scope="col">CPF</th>
                                                <th scope="col">Data Nascimento</th>
                                                <th scope="col">Ação</th>
                                            </tr>
                                        </thead>
                                        <tbody> 
                                        <td colspan="2">${mensagem}</td>
                                        <c:forEach items="${pacientes}" var="paciente">
                                            <form action="PacienteController?action=editar" method="POST">
                                                <tr>
                                                    <td scope="col">${paciente.nome}</td>
                                                    <td scope="col">${paciente.cpf}</td>
                                                    <td scope="col">${paciente.dataNascimento}</td>
                                                    <td scope="col"><button type="submit" name="editar" class="btn btn-sm btn-link"><i class="material-icons">edit</i></button> </td>
                                                <input type="hidden" value="${paciente.id}" required name="idPaciente">
                                                </tr>
                                            </form>
                                        </c:forEach>
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
