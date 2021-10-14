<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Indique el Dni del empleado para conocer su salario</h1>
	
	<form action="Controller?opcion=salario" method="post" >
 DNI: <input type = "text" name = "dniB" /> <br/>
	<br>
<input type="submit" value="confirmar">

</form>
</body>
</html>