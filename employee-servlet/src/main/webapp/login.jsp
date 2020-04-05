<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<h3>${message}</h3>
<br><br><br><br>
<div align = "center">
<form action="${pageContext.request.contextPath}/employeeAssignment" method="POST">
<input type="hidden" name="action" value="LOGIN">
Admin Name: <input type="text" name="admin"><br>
-Password-: <input type="text" name="pass"><br>
<input type="submit" value="LOGIN">
</form>
</div>

</body>
</html>