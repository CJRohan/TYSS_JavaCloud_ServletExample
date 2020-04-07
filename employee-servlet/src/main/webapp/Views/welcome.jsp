<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
if (!("loggedin").equals(session.getAttribute("admins")))
	response.sendRedirect("");
%>
	<a
		href="${pageContext.request.contextPath}/employeeAssignment?action=LOGOUT"
		method="POST"">LOGOUT</a>
		<br>
	<br>
	<h1 align="center">JSP CRUD Example</h1>
	<br><br>
	<br>
	<div align="center">
		<a
			href="${pageContext.request.contextPath}/employeeAssignment?action=ADD">Add
			User</a> <br> <br> <a
			href="${pageContext.request.contextPath}/employeeAssignment?action=LIST">View
			Users</a>
	</div>
</body>
</html>