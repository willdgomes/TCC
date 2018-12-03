<%-- 
    Document   : log
    Created on : 25/04/2018, 17:26:33
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/pagination.js"></script>
        <script src="js/pagination.min.js"></script>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-heading">
                        <h2 align="center">Relatório de atividades dos usuários no sistema</h2>
                    </div>
                    <div class="panel-body m-3">
                        <div class="col-sm-12">
                            <form action="RelatorioController?action=pesquisarLogPeriodo" method="POST" class="card border-info">
                                <div class="card-body p-5">
                                    <div class="form-row">
                                        <div class="row col-sm-12">
                                            <label for="dtperiodo" class="text-dark">Selecione o período:</label>  
                                        </div>
                                        <div class="form-group col-sm-5">
                                            <label for="dtInicio" >Início:</label>  
                                            <input type="date" class="form-control" id="dtInicio" required name="dataInicio">
                                        </div>
                                        <div class="form-group col-sm-5">
                                            <label for="dtFim" >Fim</label>  
                                            <input type="date" class="form-control" id="dtFim" required name="dataFim">
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn"><i class="material-icons">search</i></button>    
                                        </div>

                                    </div>
                                    <div class="form-row" id="errorDate">
                                        <div class="alert alert-danger alert-dismissible col">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            A data final não pode ser menor que a data inicial!
                                        </div>
                                    </div>
                                </div>     
                        </div>
                        </form>
                    </div>
                    <div class="col-sm-12">
                        <div class="card border-info">
                            <div class="card-body p-5">
                                <table class="table table-hover table-responsive-sm" id="tabelaLog">
                                    <thead>
                                        <tr>                                                    
                                            <th scope="col">Usuário</th>
                                            <th scope="col">Mensagem</th>
                                            <th scope="col">Data</th>
                                        </tr>
                                    </thead>
                                    <tbody> 
                                    <td colspan="5" id="errorAlert">
                                        <div class="form-row">
                                            <div class="alert alert-danger alert-dismissible col">
                                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                                Não foram encontradas atividades no periodo selecionado!
                                            </div>
                                        </div>
                                    </td>
                                    <c:forEach items="${logs}" var="log">
                                        <tr>
                                            <td scope="col">${log.nomeUsuario}</td>
                                            <td scope="col">${log.mensagem}</td>
                                            <td scope="col">${log.data}</td>
                                        <input type="hidden" value="${log.id}" name="idMedicamento">
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>                  
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                var errorAlert = JSON.parse(${errorAlert});
                if (errorAlert == true)
                    $("#errorAlert").show();
                else
                    $("#errorAlert").hide();
                $("#errorDate").hide();
   
            });
        </script>                                     
    </jsp:body>
</t:page>



