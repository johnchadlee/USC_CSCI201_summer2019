<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CAT.JSP</title>
</head>
<body>
     <p>
     	<img src= "image/cat.jpg" name = "cat_image" width = "300" height = "300" /><br />
     </p>
     <form name = "link" action = "dog.jsp" method = "GET" onsubmit= true>
     <input type="submit" name="petclass" value="DOG">
     </form>
</body>
</html>