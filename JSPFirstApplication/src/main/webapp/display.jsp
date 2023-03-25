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

<%@ include file="Header.jsp" %>


<h1>User Data</h1>

<!-- Declarative tag -->

<%! int a= 50;  %>        

<%! public int m1(){       

	return a;
}
%>

  	
  <!-- Expression tag -->
<%= a=90 %>    

 <!-- Scriptlet tag -->
<%                         

	String name = request.getParameter("fname");
	String email = request.getParameter("email");
	int phno = Integer.parseInt(request.getParameter("phno"));
	
	out.println(name);
	out.println(email);
	out.println(phno);
	
	String str = "abcd";
	str= "satish";
	
	out.println(str);
	out.print(m1());
	
	
%>


<%@ include file="footer.jsp" %>



</body>
</html>