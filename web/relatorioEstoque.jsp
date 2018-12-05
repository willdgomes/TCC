<%-- 
    Document   : relatorioEstoque
    Created on : 17/11/2018, 22:43:39
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
                            <div class="col-11">
                                <canvas id="myChart"></canvas>
                            </div>
                        </div>
                        <div class="card-body pt-2">
                            <div class="col-11">
                                <canvas id="maiorSaida"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>

                var qntdMedTotal = JSON.parse('${totalMedJson}');
                var labels = JSON.parse('${periodoJson}');
                var quantidade = JSON.parse('${quantidadeJson}');
                var med = JSON.parse('${nomeMedJson}');
                var i = 0;
                var myData = [];
                for (var i = 0; i < med.length; i++) {
                    if (med[i].length > 0) {
                        var cor = getRandomColor();
                        myData.push({type: "line", data: quantidade[i], label: med[i], backgroundColor: cor, borderColor: cor, yAxisID: "y-axis-1", fill: false});
                    }
                }
                function getRandomColor() {
                    var letters = '0123456789ABCDEF';
                    var color = '#';
                    for (var i = 0; i < 6; i++) {
                        color += letters[Math.floor(Math.random() * 16)];
                    }
                    return color;
                }
                var lineChartData = {
                    labels: labels,
                    datasets: myData
                };

                window.onload = function () {
                    var ctx = document.getElementById('myChart').getContext('2d');
                    window.myLine = Chart.Line(ctx, {
                        data: lineChartData,
                        options: {
                            responsive: true,
                            hoverMode: 'index',
                            stacked: false,
                            title: {
                                display: true,
                                text: 'Saída de Medicamentos por mês'
                            },
                            scales: {
                                yAxes: [{
                                        type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                                        display: true,
                                        position: 'left',
                                        id: 'y-axis-1',
                                    }],
                            }
                        }
                    });
                };              
                
            var totalSaidaJson = JSON.parse('${totalSaidaJson}');
            var ctx = document.getElementById("maiorSaida").getContext('2d');
            var maiorSaida = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: med,
                    datasets: [{
                            data: totalSaidaJson,
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
                        text: 'Medicamentos que mais sairam'
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

