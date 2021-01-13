<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Form Submission</title>
	</head>
	<body>
<%
String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
%>
<h1>Submitted Data</h1>
First Name:<strong><%= fname %></strong><br />
Last Name:<strong><%= lname %></strong> 
	</body>
</html>