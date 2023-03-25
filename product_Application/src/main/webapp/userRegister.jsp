<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User Registration</h1>

<form action="userregister" method="post">
<label>userId</label>
<input type="number" name="uid"> <br><br>

<label>userName</label>
<input type="text" name="uname"> <br><br>

<label>userEmail</label>
<input type="text" name="uemail"> <br><br>

<label>userAddress</label>
<input type="text" name="uaddrs"> <br><br>

<label>userContactNo</label>
<input type="text" name="ucontact"> <br><br>

<label>Password</label>
<input type="password" name="upassword"> <br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>