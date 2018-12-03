<%-- 
    Document   : home
    Created on : 16/05/2018, 19:24:20
    Author     : gomes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<t:page>
    <jsp:attribute name="title">Farmácia APPP</jsp:attribute>
    <jsp:body>
        <div class="main w-100">
            <div class="row">
                <div class="panel panel-default col-sm pt-4">
                    <div class="panel-body">
                        <div class="row">
                            <div class="card border border-info text-secondary bg-light ml-2 col">
                                <div class="card-body pt-2">
                                    <a href="PacienteController?action=carregarCadastro" ><i class="material-icons">person_add</i> <span class="align-top pl-2">Pacientes</span></a>
                                </div>
                            </div>
                            <div class="card border border-info text-secondary bg-light ml-2 col">
                                <div class="card-body pt-2">
                                    <a href="ReceitasController?action=carregarCadastro"><i class="material-icons">receipt</i> <span class="align-top pl-2">Receita Médica</span></a>
                                </div>
                            </div>
                            <div class="card border border-info text-secondary bg-light ml-2 col">
                                <div class="card-body pt-2">
                                    <a href="RetiranteController?action=carregarCadastro"><i class="material-icons">group_add</i> <span class="align-top pl-2">Retirantes</span></a>
                                </div>
                            </div>
                            <c:if test="${perfil}">
                            <div class="card border border-info text-secondary bg-light ml-2 col">
                                <div class="card-body pt-2">
                                    <a href="MedicamentoController?action=carregarCadastro"><i class="material-icons">library_add</i> <span class="align-top pl-2">Medicamentos</span></a>
                                </div>
                            </div>
                            <div class="card border border-info text-secondary bg-light ml-2 col">
                                <div class="card-body pt-2">
                                    <a href="UsuarioController?action=carregarCadastro"><i class="material-icons">library_add</i> <span class="align-top pl-2">Usuário</span></a>
                                </div>                                
                            </div>
                            </c:if>
                        </div>
                        <div class="row">
                            <div class="card border border-danger text-secondary bg-light ml-2 col">
                                <div class="card-body pt-2">
                                    <div class="text-center">
                                    <h5 class="card-title">Próximos medicamentos a vencer</h5>
                                </div>
                                    <table class="table table-responsive-sm">
                                        <thead>
                                            <tr>                                                    
                                                <th scope="col">Medicamento</th>
                                                <th scope="col">Lote</th>
                                                <th scope="col">Data</th>
                                            </tr>
                                        </thead>
                                        <tbody> 
                                            <c:forEach items="${medicamentosVenc}" var="item">
                                            <form action="PacienteController?action=editar" method="POST">
                                                <tr>
                                                    <td scope="col">${item.medicamento.nome} ${item.medicamento.dosagem}</td>
                                                    <td scope="col">${item.id}</td>
                                                    <td scope="col">${item.dataVencimento}</td>
                                                </tr>
                                            </form>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="card border border-info text-secondary bg-light ml-2 col">
                                <div class="card-body pt-2">
                                    <a href="ReceitasController?action=carregarCadastro"><i class="material-icons">receipt</i> <span class="align-top pl-2">Receita Médica</span></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10 offset-1">
                            <canvas id="myChart"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            var labels = JSON.parse('${nomeMedJson}');
            var quantidade = JSON.parse('${quantidadeJson}');
            var ctx = document.getElementById("myChart").getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                            data: quantidade,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255,99,132,1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                },
                options: {
                    legend: {
                        display: false
                    },
                    title: {
                        display: true,
                        text: 'Medicamentos no estoque'
                    },
                    scales: {
                        yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                    }
                }
            });

        </script>
    </jsp:body>
</t:page>
