<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claboradores</title>

<style>
	tr:first-child{
		font-weight:bold;
		background-color:#C6C9C4;
	}
</style>

</head>
<body>
<h2>Colaboradores</h2>
	<table>
		<tr>
			<td>NAME</td>
			<td>Joining Date</td>
			<td>Salary</td>
			<td>SSN</td>
		</tr>
		<c:forEach items="${colaboradores}" var="colaborador">
			<tr>
				<td>${colaborador.name }</td>
				<td>${colaborador.joiningDate }</td>
				<td>${colaborador.salary }</td>
				<td><a href="<c:url value='/edit-${colaborador.ssn}-colaborador' />">${colaborador.ssn}</a></td>
				<td><a href="<c:url value='/delete-${colaborador.ssn}-colaborador' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<c:url value='/new' />">Add new Colaborador</a>
</body>
</html>