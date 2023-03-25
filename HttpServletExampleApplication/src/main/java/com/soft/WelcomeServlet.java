package com.soft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcomehttp")
public class WelcomeServlet extends HttpServlet{
	
	public void init() {
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("Welcome to servlet programming bu using case 2 HTTPServlet..");
		
	}

}
