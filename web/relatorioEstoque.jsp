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
        <div class="col">
            <canvas id="myChart"></canvas>
        </div>
        <script>
    var labels = JSON.parse('${periodoJson}');
    var quantidade = JSON.parse('${quantidadeJson}');
    var med = JSON.parse('${nomeMedJson}');
    var lineChartData = {
        labels: labels,
        datasets: [{
                label: 'My First dataset',
                borderColor: ['rgba(255,99,132,1)'],
                backgroundColor: ['rgba(255,99,132,1)'],
                fill: false,
                data: quantidade,
                yAxisID: 'y-axis-1',
            }, {
                label: 'My Second dataset',
                borderColor: ['rgba(54, 162, 235, 1)'],
                backgroundColor:['rgba(54, 162, 235, 1)'],
                fill: false,
                data: ['1','2','3'],
                yAxisID: 'y-axis-1'
            }]
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
                    text: 'Chart.js Line Chart - Multi Axis'
                },
                scales: {
                    yAxes: [{
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: true,
                            position: 'left',
                            id: 'y-axis-1',
                        }, {
                            type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                            display: false,
                            position: 'right',
                            id: 'y-axis-2',

                            // grid line settings
                            gridLines: {
                                drawOnChartArea: false, // only want the grid lines for one axis to show up
                            },
                        }],
                }
            }
        });
    };

        </script>
    </jsp:body>
</t:page>

