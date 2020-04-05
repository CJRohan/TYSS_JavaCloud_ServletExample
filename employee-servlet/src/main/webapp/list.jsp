<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeList</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/employeeAssignment?action=WELCOME" method = "POST"">HOME</a>
	|
	<a href="${pageContext.request.contextPath}/employeeAssignment?action=LOGOUT" method = "POST"">LOGOUT</a>
	<br> ${messagel}
	<div align="center">
		<a
			href="${pageContext.request.contextPath}/employeeAssignment?action=ADD">ADD
			a new user</a><br> <br>
		<table border="2" cellpadding="3" cellspacing="2">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Sex</th>
				<th>Country</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.name}</td>
					<td>${employee.mailid}</td>
					<td>${employee.sex}</td>
					<td>${employee.country}</td>
					<td><a
						href="${pageContext.request.contextPath}/employeeAssignment?action=EDIT&id=${employee.empid}&name=${employee.name}&password=${employee.password}&mail=${employee.mailid}&sex=${employee.sex}&country=${employee.country}" method = "POST">Edit</a>
						| 
						<a
						href="${pageContext.request.contextPath}/employeeAssignment?action=DELETE&id=${employee.empid}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>