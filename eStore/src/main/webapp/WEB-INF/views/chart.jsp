
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script type="text/javascript">
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawBasic);


function getContextPath(){
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}



function drawBasic() {

    var jsonData = $.ajax({
        url: getContextPath()+"/chartFromRecordToRest",
        dataType: "json",
        async: false,
        }).responseText;
    
    var array  = JSON.parse(jsonData);
        
    // Create our data table out of JSON data loaded from server.
    var data = new google.visualization.DataTable(array);
    


      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

      chart.draw(data, options);
    }
    
</script>


<div class="container-wrapper">
	<div class="container">
		<h2>Chart</h2>
		<p class="lead">Chart</p>
		<div id="chart_div"></div>

<!-- 		<table class="table table-striped"> -->
<!-- 			<thead> -->
<!-- 				<tr class="bg-success"> -->
<!-- 					<th>Photo Thumb</th> -->
<!-- 					<th>Product Name</th> -->
<!-- 				</tr> -->
<!-- 			</thead> -->
<!-- 			<tbody> -->
<%-- 				<c:forEach var="result" items="${results}"> --%>
<!-- 					<tr> -->
<%-- 						<td>${result.count}</td> --%>
<%-- 						<td>${result.date}</td> --%>
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<!-- 			</tbody> -->
<!-- 		</table> -->

	</div>
</div>

