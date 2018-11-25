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
    
    var qntdMedTotal = JSON.parse('${totalMedJson}');
    var labels = JSON.parse('${periodoJson}');
    var quantidade = JSON.parse('${quantidadeJson}');
    var med = JSON.parse('${nomeMedJson}');
    var i=0;
    var myData = []; 
    for(var i = 0; i < med.length; i++) {
    if(med[i].length > 0) {
        var cor = getRandomColor();
        myData.push({type: "line", data: quantidade[i],label:med[i], backgroundColor: cor, borderColor: cor, yAxisID: "y-axis-1",fill: false});
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

        	window.onload = function() {
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
        </script>
    </jsp:body>
</t:page>

