<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="parsing.NotEnoughException"%>
<%@ page import="parsing.FormatException"%>
<!DOCTYPE html>
<html>

<!-- head -->
<head>
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
			<a href="home.jsp" style="text-decoration: none; color: white;">WeatherMeister</a>
		</h1>
		<div class = "login-stat" >
			<h2> 
				<a href="profile.jsp" style="text-decoration: none; color: white;">Profile</a>
			</h2>
			<h2> 
				<a href="signout.jsp" style="text-decoration: none; color: white;">Sign out</a>
			</h2>
		</div> 
	</div>
	<h1>Username's Search History</h1>
	<!-- background image -->
	<div class="background-img"></div>


</body>
</html>