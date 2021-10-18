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
	<h1>Lista de empleados</h1>
	
	<br>
	<table border="1" >
		<tr>
		<td>DNI</td>
		<td>NOMBRE</td>
		<td>CATEGORIA</td>
		<td>ANTIGUEDAD</td>
		<td>SEXO</td>
		<td></td>
		<td></td>
		</tr>
		<c:forEach var="empleado" items="${listaEmpleado}">
		<tr>
		<td><c:out value="${empleado.dni}"></c:out></td>
		<td><c:out value="${empleado.nombre}"></c:out></td>
		<td><c:out value="${empleado.categoria}"></c:out></td>
		<td><c:out value="${empleado.anyos}"></c:out></td>
		<td><c:out value="${empleado.sexo}"></c:out></td>
		<td><a href="Controller?opcion=editar&dni=<c:out value="${empleado.dni}"></c:out>">Editar</a></td>
		<td><a href="Controller?opcion=eliminar&dni=<c:out value="${empleado.dni}"></c:out>">Eliminar</a></td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<button onclick="window.location.href='javascript:history.back()'">Volver</button>
	<button onclick="window.location.href='Controller?opcion=buscaEmpleado'">Buscar Empleados</button>
</body>
</html>