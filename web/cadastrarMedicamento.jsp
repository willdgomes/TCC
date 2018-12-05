<%-- 
    Document   : cadastrarRemédio
    Created on : 14/08/2018, 19:13:07
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-heading text-center">
                        <h2>Cadastro de medicamento</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <div class="col-sm-12">
                            <form action="MedicamentoController?action=cadastrarMedicamento" method="POST" class="card border-info">
                                <div class="card-body p-5">
                                    <div class="form-row" id="successAlert">
                                        <div class="alert alert-success colalert-dismissible col">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            Medicamento cadastrado com sucesso!
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col">
                                            <label for="nome" class="text-dark">Nome:</label>
                                            <input type="text" class="form-control" id="nomemedicamento" required name="nome">
                                        </div>
                                         <div class="form-group col" >
                                            <label for="fabricante" class="text-dark">Fabricante:</label>
                                            <input type="text" class="form-control" id="fabricante" required name="fabricante">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="composicao" class="text-dark">Composição:</label>
                                            <input type="text" class="form-control" id="composicao" required name="composicao">
                                        </div>
                                         <div class="form-group col-md-2" >
                                            <label for="dosagem" class="text-dark">Dosagem:</label>
                                            <input type="number" class="form-control" id="dosagem" required name="dosagem">
                                        </div>
                                        <div class="form-group col-md-4" >
                                            <label for="medida" class="text-dark">Un. Medida:</label>
                                             <div class="dropdown">
                                                <select id="cbRemedios" class="form-control" name="medida">
                                                    <option></option>
                                                    <option>Miligramas (mg)</option>
                                                    <option>Mililitros (ml)</option>
                                                     <option>Comprimidos</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col">
                                            <label for="descricao" class="text-dark">Descrição:</label>
                                            <input type="text" class="form-control" id="descricao" required name="descricao">
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

