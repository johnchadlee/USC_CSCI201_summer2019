<%@page import="java.util.Comparator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>	
<%@ page import="parsing.City"%>	
<%@ page import="parsing.JSONParser"%>	
<%@ page import="parsing.NotEnoughException"%>
<%@ page import="parsing.FormatException"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import = "java.util.Collections"%>
<%@page import ="java.util.Comparator"%>
<%@page import ="java.util.List"%>

<!DOCTYPE html>
<html>

<!-- head -->
<head>

<script type="text/javascript">

// displays and hides both types of search bars
function myFunction() {
	
	// show City search bar
	if (document.getElementById("City").checked == true) {
		document.getElementById("showCitySearch").style.display = "block";
		document.getElementById("showLocationSearch").style.display = "none";
	} 
	
	// show Location search bar
	else {
		document.getElementById("showCitySearch").style.display = "none";
		document.getElementById("showLocationSearch").style.display = "block";
	}
	
}
</script>

<meta charset="UTF-8">

<!-- title -->
<title>WeatherMeister</title>

<!-- linking CSS -->
<link rel="stylesheet" type="text/css" href="all.css" />
</head>

<!-- body -->
<body>

	<!-- topbar -->
	<div class="topbar">
		<h1>
			<a href="index.jsp" style="text-decoration: none; color: white;">WeatherMeister</a>
		</h1>
	</div>

	<!-- background image -->
	<div class="background-img"></div>

	<!-- City search -->
	<div class="nav">
		<div class="search-container">
			<form action="MyServlet" method="GET">
				<div class="showCitySearch" id="showCitySearch">
					<input type="text" placeholder="Search..." name="citySearch">
					<button type="submit"></button>
				</div>
	
				<div class="showLocationSearch" id="showLocationSearch">
					<input type="text" id="LatitudeSearch" placeholder="Latitude"
						name="latSearch"> <input type="text" id="LongitudeSearch"
						placeholder="Longitude" name="longSearch">
					<button type="submit"></button>
				</div>
				<div class="radio-button-div">
					<input type="radio" name="option" id="City" value="City"
						checked="checked" onclick="myFunction()">City <input
						type="radio" name="option" id="Location" value="Location"
						onclick="myFunction()">Location (Lat./Long.)
				</div>
			</form>

		</div>
	</div>
	
	<h2>Search Results</h2>

	<table id="infoTable">
		<tr>
			<th>City Name</th>
			<th>Temp. Low</th>
			<th>Temp. High</th>
		</tr>
		
		<% 
		City search = (City)request.getAttribute("searchedCity");
		/* request.setAttribute("redirect", search); */
		for (int i = 0; i < JSONParser.getCities().size(); i++) {
			
			if (search.getName().trim().equalsIgnoreCase(JSONParser.getCities().get(i).getName())) {
		%>
		
		<tr>
			
			<td><a href = "Redirect?city=<%= JSONParser.getCities().get(i).getName() %>" style="text-decoration: none; color: white;"><%= JSONParser.getCities().get(i).getName() %></a></td>
			
			<td><%= JSONParser.getCities().get(i).getDayLow() %></td>
			<td><%= JSONParser.getCities().get(i).getDayHigh() %></td>
		</tr>

		<% } }
		for (int j = 0; j < 6; j++) {
			%>
			<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
			
			<%
		}
		%> 
	</table>
</body>
</html>