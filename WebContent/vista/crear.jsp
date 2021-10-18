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
	<h1>Crear Empleado</h1>
	
	<form action ="Controller?opcion=crear" method="post">
		<input type="hidden" name="opcion" value="crear">
			<table border="1">
				<tr>
					<td>Nombre</td>
					<td><input type="text" name="nombre" "></td>
				</tr>
				<tr>
					<td>DNI</td>
					<td><input type="text" name="dni" ></td>
				</tr>
				<tr>
				<tr>
					<td>Sexo</td>
					<td><input type="text" name="sexo" ></td>
				</tr>
				<tr>
					<td>Categoria</td>
					<td><input type="text" name="categoria" ></td>
				</tr>
				<tr>
					<td>Antiguedad</td>
					<td><input type="text" name="antiguedad" ></td>
				</tr>
			</table>	
			<br>
			<input type="submit" value="Guardar">
			
	</form>
	<br>
	<button onclick="window.location.href='javascript:history.back()'">Volver</button>
</body>
</html>