<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="register">
	<h4 style="color:red">Registration Form</h4>
	<br/>
		<table>
			<tr>
				<td>User ID : </td>
				<td><input type="text" name="uid"/></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="password" name="pwd"/></td>
			</tr>
			<tr>
				<td>First Name : </td>
				<td><input type="text" name="fname"/></td>
			</tr>
			<tr>
				<td>Middle Name : </td>
				<td><input type="text" name="mname"/></td>
			</tr>
			<tr>
				<td>Last Name : </td>
				<td><input type="text" name="lname"/></td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><input type="email" name="email"/></td>
			</tr>
			<tr>
				<td>Contact : </td>
				<td><input type="number" name="contact"/></td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="REGISTER"/>
	</form>
</body>
</html>