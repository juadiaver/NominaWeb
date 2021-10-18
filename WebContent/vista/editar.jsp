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
	<h1>Modificar Empleado</h1>
	
	<form action ="Controller?opcion=editar" method="post">
	<c:set var="empleado" value="${empleado}"></c:set>
		<input type="hidden" name="opcion" value="editar">
		<input type="hidden" name="dni" value="${empleado.dni}">
			<table border="1">
				<tr>
					<td>Nombre</td>
					<td><input type="text" name="nombre" value="${empleado.nombre}"></td>
				</tr>
				<tr>
					<td>Sexo</td>
					<td><input type="text" name="sexo" value="${empleado.sexo}"></td>
				</tr>
				<tr>
					<td>Categoria</td>
					<td><input type="text" name="categoria" value="${empleado.categoria}"></td>
				</tr>
				<tr>
					<td>Antiguedad</td>
					<td><input type="text" name="antiguedad" value="${empleado.anyos}"></td>
				</tr>
			</table>	
			<br>
			<input type="submit" value="Guardar">
			
	</form>
	<br>
	<button onclick="window.location.href='javascript:history.back()'">Volver</button>
	
</body>
</html>