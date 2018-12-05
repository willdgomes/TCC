<%-- 
    Document   : relatorioReceitas
    Created on : 05/12/2018, 12:41:01
    Author     : Eu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            <div class="panel-body m-3">
                                <div class="col-sm-12">
                                    <p>Total de receitas cadastradas: ${totalReceitas} </p>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-10 offset-1">
                                <canvas id="receitaPorPaciente"></canvas>
                            </div>
                        </div>
                     <!--   <div class="row">
                            <div class="panel-body m-3">
                                <div class="col-sm-12">
                                    <p>Total de pacientes cadastrados:</p>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-10">
                                <canvas id="maisRetirou"></canvas>
                            </div>
                        </div> -->
                    </div>
                </div>
            </div> 
            <script>
                var nomeMaisRetirouJson = JSON.parse('${nomeMaisRetirouJson}');
                var totalMaisRetirouJson = JSON.parse('${totalMaisRetirouJson}');
                
                var nomeReceitaPorPacienteJson = JSON.parse('${nomeReceitaPorPacienteJson}');
                var totalReceitaPorPacienteJson = JSON.parse('${totalReceitaPorPacienteJson}');
            
    
    var receitaPorPaciente = document.getElementById("receitaPorPaciente").getContext('2d');
            var receitaPorPaciente = new Chart(receitaPorPaciente, {
                type: 'bar',
                data: {
                    labels: nomeReceitaPorPacienteJson,
                    datasets: [{
                            data: totalReceitaPorPacienteJson,
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
                        text: 'Pacientes com maiores números de receitas cadastradas'
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
            
            var ctx = document.getElementById("maisRetirou").getContext('2d');
            var maisRetirou = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: nomeMaisRetirouJson,
                    datasets: [{
                            data: totalMaisRetirouJson,
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
                        text: 'Pacientes que mais retiraram medicamentos'
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
            