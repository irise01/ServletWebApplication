package com.soft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.soft.dao.DBConnection;

public class LoginServlet extends GenericServlet {

	Connection con = null;

	public void init() {
		DBConnection dbcon = new DBConnection();
		con = dbcon.createConnection();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {

			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			String email = req.getParameter("userEmail");
			String pass = req.getParameter("password");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user_details.user where useremail=? AND password=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			

			if(rs.next()) {
				pw.println("User login sucessfully..");
				pw.println("Welcome::"+rs.getString(2));
				
				req.setAttribute("username", rs.getString(2));
				req.setAttribute("useremail", rs.getString(3));
				
				RequestDispatcher rd = req.getRequestDispatcher("/test");
				rd.forward(req, res);   // without loginservlet response
				
				rd.include(req, res);  // with loginservlet response
				
				
			}else {
				pw.println("User not login sucessfully..");
				RequestDispatcher rd = req.getRequestDispatcher("register.html");
				rd.forward(req, res);
			}
			
		} catch (Exception e) {

		}

	}

	public void destroy() {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
