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
	<jsp:include page="BuscaSalario.jsp" />
	<h1>Salario</h1>
	
	<br>
	<table border="1" >
		<tr>
		<td>DNI</td>
		<td>SUELDO</td>

		</tr>
		<c:forEach var="salario" items="${mapa}">
		<tr>
		<td><c:out value="${salario.getKey()}"></c:out></td>
		<td><c:out value="${salario.getValue()}"></c:out></td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<button onclick="window.location.href='index.jsp'">Volver al menu principal</button>
	<button onclick="window.location.href='vista/BuscaDni.jsp'">Volver a buscar salario</button>
</body>
</html>