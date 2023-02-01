<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<form action="update">
	<h4 style="color:red">Update Details</h4>
	<br/>
		<table>
			<tr>
				<td>User ID : </td>
				<td><input type="text"  name="uid" value="${loginuser.uid}" disabled /></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="password" name="pwd" value="${loginuser.pwd}" disabled/></td>
			</tr>
			<tr>
				<td>First Name : </td>
				<td><input type="text" name="fname" value="${loginuser.fname}" disabled/></td>
			</tr>
			<tr>
				<td>Middle Name : </td>
				<td><input type="text" name="mname" value="${loginuser.mname}" disabled/></td>
			</tr>
			<tr>
				<td>Last Name : </td>
				<td><input type="text" name="lname" value="${loginuser.lname}" disabled/></td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><input type="email" name="email" value="${loginuser.email}"/></td>
			</tr>
			<tr>
				<td>Contact : </td>
				<td><input type="number" name="contact" value="${loginuser.contact}"/></td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="UPDATE"/>
	</form>
</body>
</html>