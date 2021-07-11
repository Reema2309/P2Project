<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Logout</title>
<style>
body{
	background-image: url('background4.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100% ;
	
}
</style>
</head>
<body>
	<%
		session.invalidate();
	%>
	<label style="color: white ; font-family: verdana">Your Session has terminated.</label>
	<br>
	<a href="index.html">Login again</a>
</body>
</html>