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
</script>
<script>
	function validateUsername(){
		var xhttp = new XMLHttpRequest();
		xhttp.open("POST", "Validate", true);
		xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhttp.onreadystatechange = function() {
			document.getElementById("usernameMsg").innerHTML = this.responseText;
		}
		xhttp.send("field=username&username=" + document.myform.username.value);
		function validatePassword() {
			var xhttp = new XMLHttpRequest();
			xhttp.open("GET", "Validate?field=password&password=" + document.myform.pass.value, true);
			xhttp.onreadystatechange = function() {
				document.getElementById("passwordMsg").innerHTML = this.responseText;
			}
			xhttp.send();
		}
	}
</script>

<meta charset="UTF-8">

<!-- title -->
<title>WeatherMeister</title>


<!-- linking CSS -->
<link rel="stylesheet" type="text/css" href="login.css" />
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
	<!-- Login form -->
	<div class="login">
		<img src="Images/download.jpeg" alt="Avator" class="avator">
			<form action="login" method="POST">
			  <div class="box">
			    <label for="uname"><b>Username</b></label>
			    <input type="text" placeholder="Enter Username" name="uname" required>
			    <label for="psw"><b>Password</b></label>
			    <input type="password" placeholder="Enter Password" name="psw" required>
			    <button type="submit">Login</button>
			  </div>
			</form>
	</div>
</body>
</html>
