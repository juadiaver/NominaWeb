<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Indique el Dni del empleado para conocer su salario</h1>

	<form action="Controller?opcion=salario" method="post">
		DNI: <input type="text" name="dniB" /> <br /> <br> <input
			type="submit" value="Buscar">
	</form>
	<br>
	<c:if test="${empty salario}">
    	La busqueda no tiene resultados
	</c:if>
	<c:if test="${not empty salario}">
	<table border="1" >
		<tr>
		<td>DNI</td>
		<td>SUELDO</td>

		</tr>
		<c:forEach var="salario" items="${salario}">
		<tr>
		<td><c:out value="${salario.getKey()}" ></c:out></td>
		<td><c:out value="${salario.getValue()}" ></c:out></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	<br>
	<br>
	<button onclick="window.location.href='index.jsp'">Volver al menu principal</button>

</body>
</html>