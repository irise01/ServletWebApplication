<%@page import="com.soft.beans.Product"%>
<%@page import="com.soft.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	int pid = Integer.parseInt(request.getParameter("pid"));

	ProductDAO productDAO = new ProductDAO();
	Product existProd = productDAO.findBypid(pid);
%>

<h1>Update Product</h1>

<form action="updateProduct" method="post">

<label>ProductId</label>
<input type="number" name="pid" readonly value="<%=existProd.getPid() %>"> <br><br>

<label>prodcutName</label>
<input type="text" name="pname" value="<%=existProd.getpName() %>" id="pnameId"> <br><br>

<label>productQty</label>
<input type="number" name="pqty" value="<%=existProd.getpQty() %>"> <br><br>

<label>productPrice</label>
<input type="text" name="pprice" value="<%=existProd.getPrice() %>"> <br><br>


<input type="submit" value="Update">

</form>
</body>
</html>