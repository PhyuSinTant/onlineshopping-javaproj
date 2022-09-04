<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/login" method="POST">
		<label>Username:</label>
		<input type="text" name="username">
		<label>Password:</label>
		<input type="password" name="password">
		<input type="submit" value="Login">
	</form>
	
</body>
</html>