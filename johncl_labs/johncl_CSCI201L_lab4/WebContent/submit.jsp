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
	String pname = request.getParameter("pname");
	String oname = request.getParameter("oname");
	String emessage = request.getParameter("emessage");
	%>
	<h1>Submitted Data</h1>
	First Name:<strong><%= pname %></strong><br />
	Last Name:<strong><%= oname %></strong><br />
	Email:<strong><%= emessage %></strong><br />
	</body>
</html>