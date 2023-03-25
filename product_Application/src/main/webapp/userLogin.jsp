<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User Login</h1>

<form action="userLogin" method="get">

<label>userEmail</label>
<input type="text" name="uemail"> <br><br>
<label>Password</label>
<input type="password" name="upassword"> <br><br>

<input type="submit" value="Submit"><br><br>

<a href="userRegister.jsp">SignUp</a>
</form>
</body>
</html>