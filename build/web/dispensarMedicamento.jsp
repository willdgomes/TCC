<%-- 
    Document   : cadastrarPacientes
    Created on : 25/04/2018, 14:37:58
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/jquery.mask.min.js"></script>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-heading">
                        <h2 align="center">Dispensar Medicamentos</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <form action="DispensaController?action=dispensarMedicamento" method="POST">
                            <div class="col-sm-12 card border-info">
                                <div class="card-body p-5">
                                     <div class="form-row" id="successAlert">
                                                <div class="alert alert-success colalert-dismissible col">
                                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                                    Dispensa realizada com sucesso!
                                                </div>
                                            </div>
                                    <div class="col form-row">
                                        <div class="form-group col-md-6">
                                            <label for="retirante" class="text-dark" >Paciente</label>
                                            <select id="cbPaciente" class="form-control" required name="idPaci">
                                                <option></option>
                                                <c:forEach items="${applicationScope.pacientes}" var="paciente">
                                                    <option value="${paciente.id}">${paciente.nome}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col form-row">
                                        <div class="form-group col-md-6">
                                            <label for="cpf" class="text-dark">CPF Retirante:</label>
                                            <input type="text" class="form-control" id="cpfRetirante" required name="cpfRetirante">
                                        </div>
                                    </div>  
                                    <div colspan="5" id="errorAlert"><div class="form-row">
                                                <div class="alert alert-danger alert-dismissible col">
                                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                                    ${textoMensagem}
                                                </div>
                                            </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card border-info p-5">
                                <div class="form-row" id="line1">
                                    <div class="col-md-6 form-group">
                                        <label class="text-dark" for="Medicamento" >Medicamento:</label> 
                                        <select id="cbRemedios" class="form-control" required name="nomeMedicamentoReceita">
                                            <option></option>
                                            <c:forEach items="${applicationScope.medicamentos}" var="medicamento">
                                                <option id="${medicamento.id}">${medicamento.nome}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-md-2 offset-1 form-group">
                                        <label for="Quantidade"class="text-dark" >Quantidade:(Caixa)</label>
                                        <input type="number" class="form-control" id="quantidade" placeholder="" name="quantidadeMedicamento">
                                    </div>
                                    <div class="col-md-1 offset-md-1 form-group">
                                        <script src="js/jquery-3.2.1.slim.min.js"></script>
                                        <button type="button" class="btn btn-sm btn-info mt-2" id="add1" onclick="addRow()"><i class="material-icons">add</i></button>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <table class="table table-hover table-responsive-sm" id="tabelaReceita">
                                        <thead>
                                            <tr>                                                    
                                                <th scope="col">Medicamento</th>
                                                <th scope="col">Quantidade</th>
                                                <th scope="col">Ação</th>
                                            </tr>
                                        </thead>
                                        <tbody> 
                                        <td colspan="2">${mensagem}</td>
                                        <form method="POST" name="tabela">
                                            <tr>
                                                <td scope="col"></td>
                                                <td scope="col"></td>
                                                <td scope="col"></td>
                                            </tr>
                                        </form>
                                        </tbody>
                                    </table>                
                                </div>
                                <div class="row col-sm-1 offset-10">
                                    <button type="submit" class="btn offset-1 btn-primary">Salvar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" >
            $(document).ready(function () {
               var successAlert = JSON.parse(${successAlert});
                    var errorAlert = JSON.parse(${errorAlert});
                    if (errorAlert == true)
                        $("#errorAlert").show();
                    else
                        $("#errorAlert").hide();
                });
                
                if (successAlert == true)
                    $("#successAlert").show();
                else
                    $("#successAlert").hide();

            function addRow() {
                var table = document.getElementById("tabelaReceita");
                var medicamento = document.getElementById("cbRemedios");
                var quantidade = document.getElementById("quantidade");
                var idLinha = medicamento.options[medicamento.selectedIndex].id;
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);
                row.id = idLinha;
                var cell1 = row.insertCell(0);
                var element1 = document.createElement("input");
                element1.type = "text";
                element1.name = "nome";
                element1.id = idLinha;
                element1.value = medicamento.options[medicamento.selectedIndex].text;
                cell1.appendChild(element1);

                var cell2 = row.insertCell(1);
                var element2 = document.createElement("input");
                element2.type = "number";
                element2.name = "quantidade";
                element2.value = quantidade.value;
                element2.id = idLinha;
                cell2.appendChild(element2);

                var cell3 = row.insertCell(2);
                var element3 = document.createElement("button");
                element3.type = "delete";
                element3.name = "excluir";
                element3.setAttribute("class", "btn btn-sm btn-link");
                element3.setAttribute("onClick", "deleteRow(" + idLinha + ")");
                var i = document.createElement("i");
                var texto = document.createTextNode("delete");
                i.appendChild(texto);
                i.setAttribute("class", "material-icons");
                element3.appendChild(i);
                element3.id = idLinha;
                cell3.appendChild(element3);


            }

            function deleteRow(linha) {
                try {
                    var table = document.getElementById("tabelaReceita");
                    var rowCount = table.rows.length;

                    for (var i = 0; i < rowCount; i++) {
                        var row = table.rows[i];
                        if (row.id == linha) {
                            table.deleteRow(i);
                            rowCount--;
                            i--;
                            break;
                        }


                    }
                } catch (e) {
                    alert(e);
                }
            }

        </script>
    </jsp:body>
</t:page>
