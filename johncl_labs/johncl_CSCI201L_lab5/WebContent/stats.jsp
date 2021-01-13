<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%
		for ( int i =0; i < timeSize ; i++)
		{
		out.println(resource[i]);
		out.println(itimespend[i]);
		out.println(icostspend[i]);
		totalcost += itimespend[i] * icostspend[i];     
		%>
		
		<tr>
		<td> <%=resource[i]%></td>
		<td><%=itimespend[i]%> </td>
		<td> <%=icostspend[i]%></td>
		</tr>
		
		<%       
		}
		%>
	</table>
</body>
</html>