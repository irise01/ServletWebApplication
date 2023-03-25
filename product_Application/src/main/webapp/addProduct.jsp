<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add New Product</h1>

<form action="addProdcut" method="post">

<label>ProductId</label>
<input type="number" name="pid"> <br><br>

<label>prodcutName</label>
<input type="text" name="pname"> <br><br>

<label>productQty</label>
<input type="number" name="pqty"> <br><br>

<label>productPrice</label>
<input type="text" name="pprice"> <br><br>


<input type="submit" value="Submit">

</form>
</body>
</html>