package com.soft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test")
public class TestAttributeServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		
		
		String username  = (String) req.getAttribute("username");
		String useremail = (String) req.getAttribute("useremail");
		
		pw.println("UserName::"+username);
		pw.println("UserEmail::"+useremail);
	}

}
