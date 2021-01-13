<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOG.JSP</title>
</head>
<body>
     <p>
     	<img src= "image/dog.jpg" name = "dog_image" width = "300" height = "300" /><br />
     </p>
     <form name = "link" action = "cat.jsp" method = "GET" onsubmit= true>
     <input type="submit" name="petclass" value="CAT">
     </form>
</body>
</html>