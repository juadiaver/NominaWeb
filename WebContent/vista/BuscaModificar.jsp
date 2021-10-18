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
	<h1>Opciones de busqueda</h1>
<table>
	<tr>
	<form action="Controller?opcion=busquedaDni" method="post">
	
		<td>DNI:</td>
		<td><input type="text" name="dniB" /></td>  
		<td><input type="submit" value="Buscar"></td>
	</form>
	</tr>
	<tr>
	<form action="Controller?opcion=busquedaNombre" method="post">
		<td>Nombre:</td>
		<td><input type="text" name="nombreB" /> </td>
		<td><input type="submit" value="Buscar"></td>
	</form>
	</tr>
	<tr>
	<form action="Controller?opcion=busquedaCategoria" method="post">
		<td>Categoria:</td>
		<td><input type="text" name="categoriaB" /></td>  
		<td><input type="submit" value="Buscar"></td>
	</form>
	</tr>
	<tr>
	<form action="Controller?opcion=busquedaAntiguedad" method="post">
		<td>Antiguedad:</td>
		<td><input type="text" name="antiguedadB" /></td>  
		<td><input type="submit" value="Buscar"></td>
	</form>
	</tr>
	<tr>
	<form action="Controller?opcion=busquedaSexo" method="post">
		<td>Sexo:</td>
		<td><input type="text" name="sexoB" /></td>  
		<td><input type="submit" value="Buscar"></td>
	</form>
	</tr>
	</table>
	<br>
	<button onclick="window.location.href='javascript:history.back()'">Volver</button>
</body>
</html>