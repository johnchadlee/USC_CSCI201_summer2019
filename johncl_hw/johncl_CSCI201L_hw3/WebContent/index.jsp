<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="parsing.JSONParser"%>
<%@ page import="parsing.NotEnoughException"%>
<%@ page import="parsing.FormatException"%>
<%
%>
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
<link rel="stylesheet" type="text/css" href="HomePage.css" />
</head>

<!-- body -->
<body>
	<!-- topbar -->
	<div class="topbar">
		<h1>
			<a href="index.jsp" style="text-decoration: none; color: white;">WeatherMeister</a>
		</h1>
		<div class = "login-stat" >
			<h2> 
				<a href="login.jsp" style="text-decoration: none; color: white;">login</a>
			</h2>
			<h2> 
				<a href="signup.jsp" style="text-decoration: none; color: white;">Sign up</a>
			</h2>
		</div> 
	</div>

	<!-- logo -->
	<div class="logo"></div>

	<!-- background image -->
	<div class="background-img"></div>

	<!-- City search -->
	<div class="nav">
		<div class="search-container">
			<form action="MyServlet" method="GET">
				<div class="showCitySearch" id="showCitySearch">
					<input type="text" placeholder="Search..." name="citySearch">
					<button type="submit" name="citySearch"></button>
				</div>
				<div class="showLocationSearch" id="showLocationSearch">
					<input type="text" id="LatitudeSearch" placeholder="Latitude"
						name="latSearch"> <input type="text" id="LongitudeSearch"
						placeholder="Longitude" name="longSearch">
					<button type="submit" name="locationSearch"></button>
				</div>

				<div class="radio-button-div">
					<input type="radio" name="option" id="City" value="City"
						checked="checked" onclick="myFunction()">City
					<input type="radio" name="option" id="Location" value="Location"
						onclick="myFunction()">Location (Lat./Long.)
				</div>
			</form>
		</div>
	</div>

</body>
</html>
