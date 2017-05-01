<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title><tiles:insertAttribute name="title" /></title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/carousel.css"/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>


<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
	google.charts.load('current', {
		packages : [ 'corechart', 'line' ]
	});
	google.charts.setOnLoadCallback(drawBasic);

	function drawBasic() {

		var data = new google.visualization.DataTable();
		data.addColumn('number', 'X');
		data.addColumn('number', 'Dogs');

		data.addRows([ [ 0, 0 ], [ 1, 10 ], [ 2, 23 ], [ 3, 17 ], [ 4, 18 ],
				[ 5, 9 ], [ 6, 11 ], [ 7, 27 ], [ 8, 33 ], [ 9, 40 ],
				[ 10, 32 ], [ 11, 35 ], [ 12, 30 ], [ 13, 40 ], [ 14, 42 ],
				[ 15, 47 ], [ 16, 44 ], [ 17, 48 ], [ 18, 52 ], [ 19, 54 ],
				[ 20, 42 ], [ 21, 55 ], [ 22, 56 ], [ 23, 57 ], [ 24, 60 ],
				[ 25, 50 ], [ 26, 52 ], [ 27, 51 ], [ 28, 49 ], [ 29, 53 ],
				[ 30, 55 ], [ 31, 60 ], [ 32, 61 ], [ 33, 59 ], [ 34, 62 ],
				[ 35, 65 ], [ 36, 62 ], [ 37, 58 ], [ 38, 55 ], [ 39, 61 ],
				[ 40, 64 ], [ 41, 65 ], [ 42, 63 ], [ 43, 66 ], [ 44, 67 ],
				[ 45, 69 ], [ 46, 69 ], [ 47, 70 ], [ 48, 72 ], [ 49, 68 ],
				[ 50, 66 ], [ 51, 65 ], [ 52, 67 ], [ 53, 70 ], [ 54, 71 ],
				[ 55, 72 ], [ 56, 73 ], [ 57, 75 ], [ 58, 70 ], [ 59, 68 ],
				[ 60, 64 ], [ 61, 60 ], [ 62, 65 ], [ 63, 67 ], [ 64, 68 ],
				[ 65, 69 ], [ 66, 70 ], [ 67, 72 ], [ 68, 75 ], [ 69, 80 ] ]);

		var options = {
			hAxis : {
				title : 'Time'
			},
			vAxis : {
				title : 'Popularity'
			}
		};

		var chart = new google.visualization.LineChart(document
				.getElementById('chart_div'));

		chart.draw(data, options);
	}
</script>




</head>
<!-- NAVBAR
================================================== -->
<body>

	<div>
		<tiles:insertAttribute name="header" />
	</div>

	<div>
		<tiles:insertAttribute name="body" />
	</div>

	<div>
		<tiles:insertAttribute name="footer" />
	</div>

</body>
</html>
