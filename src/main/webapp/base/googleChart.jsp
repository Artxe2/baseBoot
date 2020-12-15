<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>GoogleChart Sample</title>
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
				url: '/base/geoChart',
				success: (data) => {
					new google.visualization.GeoChart(document.querySelector('#geoChart')).draw(
							new google.visualization.DataTable(data)
							,{
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
				url: '/base/scatterChart',
				success: (data) => {
					new google.visualization.ScatterChart(document.querySelector('#scatterChart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'ScatterChart',
								hAxis: {title: 'rows', minValue: 0, maxValue: 15},
								vAxis: {title: 'columns', minValue: 0, maxValue: 150},
								legend: 'none'
							}
					);
				}
			});
			ajax({
				url: '/base/coreChart',
				success: (data) => {
					new google.visualization.ColumnChart(document.querySelector('#columnChart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'ColumnChart'
							}
					);
				}
			});
			
			
			ajax({
				url: '/base/coreChart',
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
				url: '/base/coreChart',
				success: (data) => {
					new google.visualization.BarChart(document.querySelector('#barChart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'BarChart'
							}
					);
				}
			});
			ajax({
				url: '/base/coreChart',
				success: (data) => {
					new google.visualization.ComboChart(document.querySelector('#comboChart')).draw(
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
				url: '/base/coreChart',
				success: (data) => {
					new google.visualization.AreaChart(document.querySelector('#areaChart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'AreaChart'
							}
					);
				}
			});
			ajax({
				url: '/base/coreChart',
				success: (data) => {
					new google.visualization.SteppedAreaChart(document.querySelector('#stepped_areaChart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'SteppedAreaChart'
							}
					);
				}
			});
			ajax({
				url: '/base/coreChart',
				success: (data) => {
					new google.visualization.LineChart(document.querySelector('#lineChart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'LineChart',
								curveType: 'function'
							}
					);
				}
			});
			
			
			ajax({
				url: '/base/coreChart',
				success: (data) => {
					new google.visualization.PieChart(document.querySelector('#pieChart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'PieChart'
							}
					);
				}
			});
			ajax({
				url: '/base/coreChart2',
				success: (data) => {
					new google.visualization.BubbleChart(document.querySelector('#bubbleChart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'BubbleChart',
								hAxis: {title: 'column1'},
								vAxis: {title: 'column2'},
								bubble: {textStyle: {fontSize: 11}}
							}
					);
				}
			});
			ajax({
				url: '/base/coreChart',
				success: (data) => {
					new google.visualization.PieChart(document.querySelector('#donutChart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'DonutChart',
								pieHole: 0.4
							}
					);
				}
			});
			ajax({
				url: '/base/coreChart2',
				success: (data) => {
					new google.visualization.CandlestickChart(document.querySelector('#candlestickChart')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'CandlestickChart',
								legend:'none'
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
				url: '/base/orgChart',
				success: (data) => {
					new google.visualization.OrgChart(document.querySelector('#orgChart')).draw(
							new google.visualization.DataTable(data)
							,{
								'allowHtml': true
							}
					);
				}
			});
		}
<%-- org chart

tree map --%>
		google.charts.load('current', {
			'packages':['treemap']
		});
		google.charts.setOnLoadCallback(drawTree);
		function drawTree() {
			ajax({
				url: '/base/tree_map',
				success: (data) => {
					new google.visualization.TreeMap(document.querySelector('#tree_map')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'TreeMap',
								minColor: '#f00',
								midColor: '#ddd',
								maxColor: '#0d0',
								headerHeight: 15,
								fontColor: 'black',
								showScale: true
							}
					);
				}
			});
		}
<%-- tree map

table --%>
		google.charts.load('current', {
			'packages':['table']
		});
		google.charts.setOnLoadCallback(drawTable);
		function drawTable() {
			ajax({
				url: '/base/table',
				success: (data) => {
					new google.visualization.Table(document.querySelector('#table')).draw(
							new google.visualization.DataTable(data)
							,{
								showRowNumber: true
							}
					);
				}
			});
		}
<%-- table

timeline --%>
		google.charts.load('current', {
			'packages':['timeline']
		});
		google.charts.setOnLoadCallback(drawTime);
		function drawTime() {
			ajax({
				url: '/base/timeline',
				success: (data) => {
					data = JSON.parse(data);
					for (i in data.rows) {
						data.rows[i].c[1].v = new Date(data.rows[i].c[1].v);
						data.rows[i].c[2].v = new Date(data.rows[i].c[2].v);
					}
					new google.visualization.Timeline(document.querySelector('#timeline')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'Timeline'
							}
					);
				}
			});
		}
<%-- timeline

gauge --%>
		google.charts.load('current', {
			'packages':['gauge']
		});
		google.charts.setOnLoadCallback(drawGauge);
		function drawGauge() {
			ajax({
				url: '/base/coreChart',
				success: (data) => {
					new google.visualization.Gauge(document.querySelector('#gauge')).draw(
							new google.visualization.DataTable(data)
							,{
								title: 'Gauge',
								redFrom: 90, redTo: 100,
						        yellowFrom: 75, yellowTo: 90,
						        minorTicks: 5
							}
					);
				}
			});
		}
<%-- gauge

--%>
	</script>
</head>
<body>	
    <div id="geoChart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="scatterChart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="columnChart" style="width: 600px; height: 400px; float: left;"></div>

    <div id="histogram" style="width: 600px; height: 400px; float: left;"></div>
    <div id="barChart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="comboChart" style="width: 600px; height: 400px; float: left;"></div>
    
    <div id="areaChart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="stepped_areaChart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="lineChart" style="width: 600px; height: 400px; float: left;"></div>

    <div id="pieChart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="bubbleChart" style="width: 600px; height: 400px; float: left;"></div>
    <div id="donutChart" style="width: 600px; height: 400px; float: left;"></div>

    <div id="orgChart" style="width: 900px; height: 400px; float: left;"></div>
    <div id="tree_map" style="width: 600px; height: 400px; float: left;"></div>
    <div id="table" style="width: 300px; height: 400px; float: left;"></div>
    
    <div id="timeline" style="width: 600px; height: 400px; float: left;"></div>
    <div id="gauge" style="width: 600px; height: 400px; float: left;"></div>
    <div id="candlestickChart" style="width: 600px; height: 400px; float: left;"></div>
</body>
</html>