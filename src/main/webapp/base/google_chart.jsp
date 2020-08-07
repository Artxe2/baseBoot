<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="/js/ajax.js"></script>
	<script src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
<%--

geo chart --%>
		google.charts.load('current', {
			'packages':['geochart'],
			'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY'
		});
		google.charts.setOnLoadCallback(drawGeo);
		function drawGeo() {
			ajax({
				url: '/base_files/geoChartData',
				success: (data) => {
					new google.visualization.GeoChart(document.querySelector('#geo_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'GeoChart'
							}
					);
				}
			});
		}
<%-- geo chart

core charts --%>
		google.charts.load('current', {'packages':['corechart']});
		google.charts.setOnLoadCallback(drawChart);
		function drawChart() {
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.ScatterChart(document.querySelector('#scatter_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'ScatterChart'
							}
					);
				}
			});
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.ColumnChart(document.querySelector('#column_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'ColumnChart'
							}
					);
				}
			});
			
			
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.Histogram(document.querySelector('#histogram')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'Histogram'
							}
					);
				}
			});
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.BarChart(document.querySelector('#bar_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'BarChart'
							}
					);
				}
			});
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.ComboChart(document.querySelector('#combo_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'ComboChart',
								seriesType: 'bars',
								series: {2: {type: 'line'}}
							}
					);
				}
			});
			
			
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.AreaChart(document.querySelector('#area_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'AreaChart'
							}
					);
				}
			});
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.SteppedAreaChart(document.querySelector('#stepped_area_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'SteppedAreaChart'
							}
					);
				}
			});
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.LineChart(document.querySelector('#line_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'LineChart',
								curveType: 'function'
							}
					);
				}
			});
			
			
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.PieChart(document.querySelector('#pie_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'PieChart'
							}
					);
				}
			});
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.BubbleChart(document.querySelector('#bubble_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'BubbleChart',
								hAxis: {title: 'column5'},
								vAxis: {title: 'column4'},
								bubble: {textStyle: {fontSize: 11}}
							}
					);
				}
			});
			ajax({
				url: '/base/core_chart',
				success: (data) => {
					new google.visualization.PieChart(document.querySelector('#donut_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'DonutChart',
								pieHole: 0.4
							}
					);
				}
			});
		}
<%-- core charts

org chart --%>
		google.charts.load('current', {
			'packages':['orgchart']
		});
		google.charts.setOnLoadCallback(drawOrg);
		function drawOrg() {
			ajax({
				url: '/base/org_chart',
				success: (data) => {
					document.querySelector('#test').innerHTML = data;
					new google.visualization.OrgChart(document.querySelector('#org_chart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'OrgChart',
								'allowHtml': true
							}
					);
				}
			});
		}
<%-- org chart

--%>
	</script>
</head>
<body>
	<div><pre id="test"></pre></div>
	
    <div id="geo_chart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="scatter_chart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="column_chart" style="width: 600px; height: 400px; float: left;"></div>

    <div id="histogram" style="width: 600px; height: 400px; float: left;"></div>
    <div id="bar_chart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="combo_chart" style="width: 600px; height: 400px; float: left;"></div>
    
    <div id="area_chart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="stepped_area_chart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="line_chart" style="width: 600px; height: 400px; float: left;"></div>

    <div id="pie_chart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="bubble_chart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="donut_chart" style="width: 600px; height: 400px; float: left;"></div>

    <div id="org_chart" style="width: 600px; height: 400px; float: left;"></div>
</body>
</html>