<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<%
if (!("loggedin").equals(session.getAttribute("admins")))
	response.sendRedirect("");
%>
	<a href="${pageContext.request.contextPath}/employeeAssignment?action=WELCOME" method = "POST">HOME</a>
	|
	<a href="${pageContext.request.contextPath}/employeeAssignment?action=LOGOUT" method = "POST"">LOGOUT</a>
	<br>
	<br>
	<a
		href="${pageContext.request.contextPath}/employeeAssignment?action=LIST">LIST
		the Employees</a>
	<br>
	<br>
	<h4>${message}</h4>
	<form action="${pageContext.request.contextPath}/employeeAssignment">
		<input type="hidden" name="action" value="ADDEmployee"> 
		<input type="hidden" name="id" value="${id}"> 
		Enter Fullname: <input type="text" name="name" value = "${name}"><br> Enter
		Enter Password: <input type="text" name="password" value = "${password}"><br> 
		Enter  EmailID: <input type="text" name="mail" value = "${mail}"><br> 
		Sex:<br> MALE<input
			type="radio" name="sex" value="MALE" checked="checked"> FEMALE<input
			type="radio" name="sex" value="FEMALE" ><br> 
			Country : <select
			name="country" value = "${country}">
			<option value="${country}">${country}</option>
			<option value="India">India</option>
			<option value="Bhutan">Bhutan</option>
			<option value="Nepal">Nepal</option>
			<option value="China">China</option>
			<option value="Russia">Russia</option>
			<option value="Mexico">Mexico</option>
			<option value="USA">USA</option>
			<option value="UK">UK</option>
			<option value="Ireland">Ireland</option> 
		</select><br>
		<input type="submit" value="ADD">
	</form>
</body>
</html>