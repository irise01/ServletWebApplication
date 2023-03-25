<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.soft.dao.ProductDAO"%>
<%@page import="com.soft.beans.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String name =null; %>

<%String username = (String) request.getAttribute("UserName"); 
name = username;
%>

<h1>Welcome::<%= name%></h1>


<div style="display: block;width: 50%; margin: auto;">
<a href="addProduct.jsp"><button>Add New Product</button></a>

<table style="border: 1px solid black;">
<thead>
<tr>
<th>ProductId</th>
<th>ProductName</th>
<th>ProducQty</th>
<th>ProductPrice</th>
<th>Actions</th>
</tr>
</thead>
<tbody>

<%
	ProductDAO productdao = new ProductDAO();
	List<Product> productlist = productdao.findAllproduct();
%>
<%
	for(Product produ:productlist){ %>
	
	<tr>
	<td><%=produ.getPid()%></td>
	<td><%=produ.getpName()%></td>
	<td><%=produ.getpQty()%></td>
	<td><%=produ.getPrice()%></td>
	
	<td>
	<a href="editProduct.jsp?pid=<%=produ.getPid()%>"><button>Edit</button></a>
	<a href="deleteProduct?pid=<%=produ.getPid()%>" onclick="return confirm('Are you sure want to delete this record');"><button>Delete</button></a>
	</td>
	</tr>
	
<%
	}

%>


</tbody>
</table>
</div>
</body>
</html>