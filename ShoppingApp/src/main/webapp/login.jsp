<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:purple">Login Form</h1>
	
	<form action="Login">
		User Id : <input type="text" name="uid" />
		<br/>
		Password :<input type="password" name="pwd"/>
		<br/>
		<input type="submit" value="LOGIN" /><br/>
		<br/>
		New user? <a href="Register.jsp">click here to register</a>
		
	</form>
	<br/>
	${cookie.loginerror.value }
</body>
</html>