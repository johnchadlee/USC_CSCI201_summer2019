<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="parsing.City"%>
<%@ page import="parsing.NotEnoughException"%>
<%@ page import="parsing.FormatException"%>

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

// displays and hides icons and details
function iconFunction(x) {
	if (x.getAttribute('id') == "location-img") {
		document.getElementById("location-img").style.display = "none";
		document.getElementById("location-dtls").style.display = "block";
	} if (x.getAttribute('id') == "tempLow-img") {
		document.getElementById("tempLow-img").style.display = "none";
		document.getElementById("tempLow-dtls").style.display = "block";
	} if (x.getAttribute('id') == "tempHigh-img") {
		document.getElementById("tempHigh-img").style.display = "none";
		document.getElementById("tempHigh-dtls").style.display = "block";
	} if (x.getAttribute('id') == "wind-img") {
		document.getElementById("wind-img").style.display = "none";
		document.getElementById("wind-dtls").style.display = "block";
	} if (x.getAttribute('id') == "humidity-img") {
		document.getElementById("humidity-img").style.display = "none";
		document.getElementById("humidity-dtls").style.display = "block";
	} if (x.getAttribute('id') == "coords-img") {
		document.getElementById("coords-img").style.display = "none";
		document.getElementById("coords-dtls").style.display = "block";
	} if (x.getAttribute('id') == "currTemp-img") {
		document.getElementById("currTemp-img").style.display = "none";
		document.getElementById("currTemp-dtls").style.display = "block";
	} if (x.getAttribute('id') == "sun-img") {
		document.getElementById("sun-img").style.display = "none";
		document.getElementById("sun-dtls").style.display = "block";
	} if (x.getAttribute('id') == "location-dtls") {
		document.getElementById("location-dtls").style.display = "none";
		document.getElementById("location-img").style.display = "block";
	} if (x.getAttribute('id') == "tempLow-dtls") {
		document.getElementById("tempLow-dtls").style.display = "none";
		document.getElementById("tempLow-img").style.display = "block";
	} if (x.getAttribute('id') == "tempHigh-dtls") {
		document.getElementById("tempHigh-dtls").style.display = "none";
		document.getElementById("tempHigh-img").style.display = "block";
	} if (x.getAttribute('id') == "wind-dtls") {
		document.getElementById("wind-dtls").style.display = "none";
		document.getElementById("wind-img").style.display = "block";
	} if (x.getAttribute('id') == "humidity-dtls") {
		document.getElementById("humidity-dtls").style.display = "none";
		document.getElementById("humidity-img").style.display = "block";
	} if (x.getAttribute('id') == "coords-dtls") {
		document.getElementById("coords-dtls").style.display = "none";
		document.getElementById("coords-img").style.display = "block";
	} if (x.getAttribute('id') == "currTemp-dtls") {
		document.getElementById("currTemp-dtls").style.display = "none";
		document.getElementById("currTemp-img").style.display = "block";
	} if (x.getAttribute('id') == "sun-dtls") {
		document.getElementById("sun-dtls").style.display = "none";
		document.getElementById("sun-img").style.display = "block";
	} 
}
</script>

<meta charset="UTF-8">

<!-- title -->
<title>WeatherMeister</title>

<!-- linking CSS -->
<link rel="stylesheet" type="text/css" href="city.css" />
</head>

<!-- body -->
<body>
	
	<!-- topbar -->
	<div class="topbar">
		<h1><a href="index.jsp" style = "text-decoration: none; color: white;">WeatherMeister</a></h1>
	</div>
	
	<!-- background image -->
	<div class="background-img"></div>

	<!-- City search -->
	<div class="nav">
		<div class="search-container">
			<form action = "MyServlet" method = "GET">
				<div class="showCitySearch" id="showCitySearch">
					<input type="text" placeholder="Search..." name="citySearch">
					<button type="submit"></button>
				</div>
				
				<div class="showLocationSearch" id="showLocationSearch">
					<input type="text" id = "LatitudeSearch" placeholder="Latitude" name="latSearch">
					<input type="text" id = "LongitudeSearch" placeholder="Longitude" name="longSearch">
					<button type="submit"></button>
				</div>
				<div class="radio-button-div">
					<input type="radio" name="option" id="City" value="City" checked="checked" onclick="myFunction()">City
					<input type="radio" name="option" id="Location" value="Location" onclick="myFunction()">Location (Lat./Long.)
				</div>
			</form>

		</div>
	</div>

	<% City search = (City)request.getAttribute("cityFinal"); %>

	<h2><%= search.getName() %></h2>
	<div id = "location-img" onclick = "iconFunction(this)"></div><div class = "location">Location</div>
	<div id = "location-dtls" onclick = "iconFunction(this)"><%= search.getState() %>,<br><%= search.getCountry() %></div>
	<div id = "tempLow-img" onclick = "iconFunction(this)"></div><div class = "tempLow">Temp Low</div>
	<div id = "tempLow-dtls" onclick = "iconFunction(this)"><%= search.getDayLow() %><br>degrees Fahrenheit</div>
	<div id = "tempHigh-img" onclick = "iconFunction(this)"></div><div class = "tempHigh">Temp High</div>
	<div id = "tempHigh-dtls" onclick = "iconFunction(this)"><%= search.getDayHigh()%><br>degrees Fahrenheit</div>
	<div id = "wind-img" onclick = "iconFunction(this)"></div><div class = "wind">Wind</div>
	<div id = "wind-dtls" onclick = "iconFunction(this)"><%= search.getWindSpeed() %><br>miles/hour</div>
	<div id = "humidity-img" onclick = "iconFunction(this)"></div><div class = "humidity">Humidity</div>
	<div id = "humidity-dtls" onclick = "iconFunction(this)"><%= search.getHumidity() %>%</div>
	<div id = "coords-img" onclick = "iconFunction(this)"></div><div class = "coords">Coordinates</div>
	<div id = "coords-dtls" onclick = "iconFunction(this)"><%= search.getLatitude() %>,<br><%= search.getLongitude() %></div>
	<div id = "currTemp-img" onclick = "iconFunction(this)"></div><div class = "currTemp">Current Temp</div>
	<div id = "currTemp-dtls" onclick = "iconFunction(this)"><%= search.getCurrTemp() %><br>degrees Fahrenheit</div>
	<div id = "sun-img" onclick = "iconFunction(this)"></div><div class = "sun">Sunrise/set</div>
	<div id = "sun-dtls" onclick = "iconFunction(this)"><%= search.getSunrise() %>,<br><%= search.getSunset() %></div>
</body>
</html>