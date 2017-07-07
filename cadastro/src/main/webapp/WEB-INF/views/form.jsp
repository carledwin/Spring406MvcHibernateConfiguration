<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formul�rio</title>

<style>
	.error{
		color:#ff0000;
	}
</style>

</head>
<body>
<h2>Formul�rio</h2>

	<form:form>
		<table>
			<tr>
				<td><label for="name">Name: </label></td>
				<td><form:input path="name" id="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="joiningDate">Joining Date: </label></td>
				<td><form:input path="joiningDate" id="joiningDate" /></td>
				<td><form:errors path="joiningDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="salary">Salary: </label></td>
				<td><form:input path="salary" id="salary" /></td>
				<td><form:errors path="salary" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="ssn"></label>SSN: </td>
				<td><form:input path="ssn" id="ssn" /></td>
				<td><form:errors path="ssn" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
		<br />
		<br />
		Go back to <a href="<c:url value='/list' />">List of All Colaboradores</a>
</body>
</html>