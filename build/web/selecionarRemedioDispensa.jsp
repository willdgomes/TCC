<%-- 
    Document   : cadastrarPacientes
    Created on : 25/04/2018, 14:37:58
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
                        <h2 align="center">Dispensar Medicamentos</h2>
                    </div>
                    <div class="panel-body pt-3">
                        <div class="col-sm-12">
                            <form class="card border-info">
                                <div class="card-body p-5">
                                    <div class="form-row" id="line1">
                                        <div class="col-md-6 form-group">
                                            <label class="text-dark" for="Medicamento" >Medicamento:</label> 
                                            <c:forEach items="${medicamentos}" var="medicamento">
                                                <select id="cbRemedios" class="form-control">
                                                    <option>${medicamentos.nome}</option>
                                                </select>
                                            </c:forEach>
                                        </div>
                                        <div class="col-md-2 offset-1 form-group">
                                            <label for="Quantidade"class="text-dark" >Quantidade:(Caixa)</label>
                                            <input type="number" class="form-control" id="cpfpaciente" placeholder="">
                                        </div>
                                        <div class="col-md-1 offset-md-1 form-group">
                                            <script src="js/jquery-3.2.1.slim.min.js"></script>
                                            <script>
                                                $(document).ready(function () {
                                                    $("#add1").click(function () {
                                                        $("#line2").show();
                                                    });
                                                });
                                            </script>
                                            <button class="btn btn-sm btn-info mt-2" id="add1"><i class="material-icons">add</i></button>
                                        </div>
                                    </div>

                                    <div class="form-row" id="line2" style="display:none">
                                        <div class="col-md-6 form-group">
                                            <label for="Medicamento" class="text-dark">Medicamento:</label>
                                            <select id="cbRemedios" class="form-control">
                                                <option></option>
                                            </select>
                                        </div>
                                        <div class="col-md-2 offset-1 form-group">
                                            <label for="Quantidade" class="text-dark">Quantidade: (Caixa)</label>
                                            <input type="number" class="form-control" id="cpfpaciente" placeholder="">
                                        </div>
                                        <div class="col-md-1 offset-md-1 form-group">
                                            <script src="js/jquery-3.2.1.slim.min.js"></script>
                                            <script>
                                                $(document).ready(function () {
                                                    $("#add2").click(function () {
                                                        $("#line3").show();
                                                    });
                                                });
                                                $(document).ready(function () {
                                                    $("#sub2").click(function () {
                                                        $("#line2").hide();
                                                    });
                                                });
                                            </script>
                                            <button class="btn btn-sm btn-info mt-2"  id="add2"><i class="material-icons">add</i></button>
                                            <button class="btn btn-sm btn-info mt-2"  id="sub2"><i class="material-icons">-</i></button>
                                        </div>
                                    </div>

                                    <div class="form-row" id="line3" style="display:none">
                                        <div class="col-md-6 form-group">
                                            <label for="Medicamento" class="text-dark" >Medicamento:</label>
                                            <select id="cbRemedios" class="form-control">
                                                <option></option>
                                            </select>
                                        </div>
                                        <div class="col-md-2 offset-1 form-group">
                                            <label for="Quantidade" class="text-dark">Quantidade: (Caixa)</label>
                                            <input type="number" class="form-control" id="cpfpaciente" placeholder="">
                                        </div>
                                        <div class="col-md-1 offset-1 form-group">
                                            <script src="js/jquery-3.2.1.slim.min.js"></script>
                                            <script>
                                                $(document).ready(function () {
                                                    $("#add3").click(function () {
                                                        $("#line4").show();
                                                    });
                                                });
                                                $(document).ready(function () {
                                                    $("#sub3").click(function () {
                                                        $("#line3").hide();
                                                    });
                                                });
                                            </script>
                                            <button class="btn btn-sm btn-info mt-2" id="add3"><i class="material-icons">add</i></button>
                                            <button class="btn btn-sm btn-info mt-2" id="sub3">-</button>
                                        </div>
                                    </div>

                                    <div class="form-row" id="line4" style="display:none">
                                        <div class="col-md-6 form-group">
                                            <label for="Medicamento" class="text-dark">Medicamento:</label>
                                            <select id="cbRemedios" class="form-control">
                                                <option></option>
                                            </select>
                                        </div>
                                        <div class="col-md-2 offset-1 form-group">
                                            <label for="Quantidade" class="text-dark">Quantidade: (Caixa)</label>
                                            <input type="number" class="form-control" id="cpfpaciente" placeholder="">
                                        </div>
                                        <div class="col-md-1 offset-1 form-group">
                                            <script src="js/jquery-3.2.1.slim.min.js"></script>
                                            <script>
                                                $(document).ready(function () {
                                                    $("#add4").click(function () {
                                                        $("#line5").show();
                                                    });
                                                });
                                                $(document).ready(function () {
                                                    $("#sub4").click(function () {
                                                        $("#line4").hide();
                                                    });
                                                });
                                            </script>
                                            <button class="btn btn-sm btn-info mt-2" id="add4"><i class="material-icons">add</i></button>
                                            <button class="btn btn-sm btn-info mt-2" id="sub4">-</button>
                                        </div>
                                    </div>

                                    <div class="form-row" id="line5" style="display:none">
                                        <div class="col-md-6 form-group">
                                            <label for="Medicamento" class="text-dark">Medicamento:</label>
                                            <select id="cbRemedios" class="form-control">
                                                <option></option>
                                            </select>
                                        </div>
                                        <div class="col-md-2 offset-1 form-group">
                                            <label for="Quantidade" class="text-dark">Quantidade: (Caixa)</label>
                                            <input type="number" class="form-control" id="cpfpaciente" placeholder="">
                                        </div>
                                        <div class="col-md-1 offset-1 form-group">
                                            <script src="js/jquery-3.2.1.slim.min.js"></script>
                                            <script>
                                                $(document).ready(function () {
                                                    $("#add5").click(function () {
                                                        $("#line6").show();
                                                    });
                                                });
                                                $(document).ready(function () {
                                                    $("#sub5").click(function () {
                                                        $("#line5").hide();
                                                    });
                                                });
                                            </script>
                                            <button class="btn btn-sm btn-info mt-2" id="add5">+</button>
                                            <button class="btn btn-sm btn-info mt-2" id="sub5">-</button>
                                        </div>
                                    </div>

                                    <div class="form-row" id="line6" style="display:none">
                                        <div class="col-md-6 form-group">
                                            <label for="Medicamento" class="text-dark">Medicamento:</label>
                                            <select id="cbRemedios" class="form-control">
                                                <option></option>
                                            </select>
                                        </div>
                                        <div class="col-md-2 offset-1 form-group">
                                            <label for="Quantidade" class="text-dark">Quantidade:(Caixa)</label>
                                            <input type="number" class="form-control" id="cpfpaciente">
                                        </div>
                                        <div class="col-md-1 offset-1 form-group">
                                            <script src="js/jquery-3.2.1.slim.min.js"></script>
                                            <script>
                                                $(document).ready(function () {
                                                    $("#add6").click(function () {
                                                        $("#line7").show();
                                                    });
                                                });
                                                $(document).ready(function () {
                                                    $("#sub6").click(function () {
                                                        $("#line6").hide();
                                                    });
                                                });
                                            </script>
                                            <!--                                            <button id="add6">+</button>-->
                                            <button class="btn btn-sm btn-info mt-2" id="sub6">-</button>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="crm" class="text-dark row" >CRM:</label>
                                            <input type="number" class="form-control" id="crmMedico" name="crm">
                                        </div>
                                        <div class="form-group col-md-8">
                                            <label for="crm" class="text-dark row" >Nome do médico:</label>
                                            <input type="nomeMedico" class="form-control" id="nomeMedico" name="crm">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="dtReceita" class="text-dark">Data da receita:</label>
                                            <input type="date" class="form-control" id="dtReceita" required>
                                        </div>
                                    </div>
                                    <div class="row col-sm-1 offset-10">
                                        <a href="pesquisaPacienteDispensa.jsp">
                                            <button type="submit" class="btn offset-1 btn-primary">Avançar</button>
                                        </a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page>
