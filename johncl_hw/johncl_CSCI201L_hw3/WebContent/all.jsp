<%@page import="java.util.Comparator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>	
<%@ page import="parsing.City"%>	
<%@ page import="parsing.NotEnoughException"%>
<%@ page import="parsing.FormatException"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import = "java.util.Collections"%>
<%@page import ="java.util.Comparator"%>
<%@page import ="java.util.List"%>

<%
	// verify once
	boolean checked = false;
	if (!checked) {
		try {
			FileIO fio = new FileIO(getServletContext().getRealPath("/weather.txt"));
			checked = true;
		} catch (NotEnoughException nee) {
			
		}
			catch(FormatException fe) {
			
		} catch (Exception e) {
		
		}
	}
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

function sort(x) {
	var table = document.getElementById("infoTable");
	
	// A to Z
	if (document.getElementById("selectID").value == "0") {
		<% City.ComparatorAZ caz = new City.ComparatorAZ();
		FileIO.getCities().sort(caz); 
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			%> 
			document.getElementById("infoTable").deleteRow(1);
			<% } 
		for (int i = 0; i < FileIO.getCities().size(); i++) {
		%>
			var row = table.insertRow(<%=i+1%>);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			cell1.innerHTML = "<a href = 'Redirect?city=<%= FileIO.getCities().get(i).getName() %>' style='text-decoration: none; color: white;'><%= FileIO.getCities().get(i).getName() %></a>";
			cell2.innerHTML = "<%= FileIO.getCities().get(i).getDayLow() %>";
			cell3.innerHTML = "<%= FileIO.getCities().get(i).getDayHigh() %>";
		<% 
		} 
		%>

	}
	
	// Z to A
	else if (document.getElementById("selectID").value == "1") {
		<% City.ComparatorZA cza = new City.ComparatorZA();
		FileIO.getCities().sort(cza); 
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			%> 
			document.getElementById("infoTable").deleteRow(1);
			<% 
			}
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			%>
				var row = table.insertRow(<%=i+1%>);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				cell1.innerHTML = "<a href = 'Redirect?city=<%= FileIO.getCities().get(i).getName() %>' style='text-decoration: none; color: white;'><%= FileIO.getCities().get(i).getName() %></a>";
				cell2.innerHTML = "<%= FileIO.getCities().get(i).getDayLow() %>";
				cell3.innerHTML = "<%= FileIO.getCities().get(i).getDayHigh() %>";
			<% 
			}
			%>

	}
	
	// Temp. Low Ascending
	else if (document.getElementById("selectID").value == "2") {
		<% City.ComparatorLowASC cla = new City.ComparatorLowASC();
		FileIO.getCities().sort(cla);
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			%> 
			document.getElementById("infoTable").deleteRow(1);
			<% } 
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			%>
				var row = table.insertRow(<%=i+1%>);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				cell1.innerHTML = "<a href = 'Redirect?city=<%= FileIO.getCities().get(i).getName() %>' style='text-decoration: none; color: white;'><%= FileIO.getCities().get(i).getName() %></a>";
				cell2.innerHTML = "<%= FileIO.getCities().get(i).getDayLow() %>";
				cell3.innerHTML = "<%= FileIO.getCities().get(i).getDayHigh() %>";
			<% 
			}
			%>
	
	}
	
	// Temp. Low Descending
	else if (document.getElementById("selectID").value == "3") {
		<% City.ComparatorLowDESC cld = new City.ComparatorLowDESC();
		FileIO.getCities().sort(cld);
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			%> 
			document.getElementById("infoTable").deleteRow(1);
			<% 
			}
		for (int i = 0; i < FileIO.getCities().size(); i++) {
		%>
			var row = table.insertRow(<%=i+1%>);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			cell1.innerHTML = "<a href = 'Redirect?city=<%= FileIO.getCities().get(i).getName() %>' style='text-decoration: none; color: white;'><%= FileIO.getCities().get(i).getName() %></a>";
			cell2.innerHTML = "<%= FileIO.getCities().get(i).getDayLow() %>";
			cell3.innerHTML = "<%= FileIO.getCities().get(i).getDayHigh() %>";
		<% 
		}
		%>
		 
	
	}
	
	// Temp. High Ascending
	else if (document.getElementById("selectID").value == "4") {
		<% City.ComparatorHighASC cha = new City.ComparatorHighASC();
		FileIO.getCities().sort(cha);
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			%> 
			document.getElementById("infoTable").deleteRow(1);
			<% 
			}
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			%>
				var row = table.insertRow(<%=i+1%>);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				cell1.innerHTML = "<a href = 'Redirect?city=<%= FileIO.getCities().get(i).getName() %>' style='text-decoration: none; color: white;'><%= FileIO.getCities().get(i).getName() %></a>";
				cell2.innerHTML = "<%= FileIO.getCities().get(i).getDayLow() %>";
				cell3.innerHTML = "<%= FileIO.getCities().get(i).getDayHigh() %>";
			<% 
			}
			%>
		
	
	}
	
	// Temp. High Descending
	else if (document.getElementById("selectID").value == "5") {
		<% City.ComparatorHighDESC chd = new City.ComparatorHighDESC();
		FileIO.getCities().sort(chd);
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			%> 
			document.getElementById("infoTable").deleteRow(1);
			<% 
			}
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			%>
				var row = table.insertRow(<%=i+1%>);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				cell1.innerHTML = "<a href = 'Redirect?city=<%= FileIO.getCities().get(i).getName() %>' style='text-decoration: none; color: white;'><%= FileIO.getCities().get(i).getName() %></a>";
				cell2.innerHTML = "<%= FileIO.getCities().get(i).getDayLow() %>";
				cell3.innerHTML = "<%= FileIO.getCities().get(i).getDayHigh() %>";
			<% 
			}
			%>
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

	<h2>All Cities</h2>
	<div class = "sortBy">Sort by:</div>
	<table id="infoTable">
		<tr>
			<th>City Name</th>
			<th>Temp. Low</th>
			<th>Temp. High</th>
		</tr>
		
		<% 

		City.ComparatorAZ caz1 = new City.ComparatorAZ();
		FileIO.getCities().sort(caz1);
		
		for (int i = 0; i < FileIO.getCities().size(); i++) {
			
		%>
		
		<tr>
			<td><a href = "Redirect?city=<%= FileIO.getCities().get(i).getName() %>" style="text-decoration: none; color: white;"><%= FileIO.getCities().get(i).getName() %></a></td>
			<td><%= FileIO.getCities().get(i).getDayLow() %></td>
			<td><%= FileIO.getCities().get(i).getDayHigh() %></td>
		</tr>
	
		<% }
		for (int i = 0; i < 7-FileIO.getCities().size(); i++) {
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

	<div id="custom-select">
		<select id = "selectID" onchange = "sort(this.value);">
			<option value="0" >City Name A-Z</option>
			<option value="1" >City Name Z-A</option>
			<option value="2" >Temp. Low ASC</option>
			<option value="3" >Temp. Low DESC</option>
			<option value="4"  >Temp. High ASC</option>
			<option value="5" >Temp. High DESC</option>
		</select>
	</div>
</body>
</html>