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
	<jsp:include page="BuscaSalario.jsp" />
	<h1>Salario</h1>

	<br>
	<c:if test="${empty salario}">
    var1 is empty or null.
</c:if>
	<c:if test="${not empty salario}">
    var1 is NOT empty or null.
</c:if>
	<c:if test="${empty salario}">
    	La busqueda no tiene resultados
	</c:if>
	<c:if test="${not empty salario}">
		<table border="1">
			<tr>
				<td>DNI</td>
				<td>SUELDO</td>

			</tr>
			<c:forEach var="salario" items="${mapa}">
				<tr>
					<c:out value="${salario.getKey()}"></c:out>
					<c:choose>
						<c:when test="${salario.getKey() == null}">
            Salary is very low to survive.
        </c:when>
					</c:choose>
					<td><c:out value="${salario.getKey()}"
							default="default value of c:out"></c:out></td>
					<td><c:out value="${salario.getValue()}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<br>
	<button onclick="window.location.href='index.jsp'">Volver al
		menu principal</button>
	<button onclick="window.location.href='vista/BuscaDni.jsp'">Volver
		a buscar salario</button>
</body>
</html>