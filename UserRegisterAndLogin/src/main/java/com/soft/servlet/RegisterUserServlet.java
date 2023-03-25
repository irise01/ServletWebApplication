package com.soft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.soft.dao.DBConnection;

public class RegisterUserServlet extends GenericServlet {

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
			int userId = Integer.parseInt(req.getParameter("userId"));
			String userName = req.getParameter("userName");

			String userEmail = req.getParameter("userEmail");
			String userPass = req.getParameter("userPassword");
			
			PreparedStatement ps = con.prepareStatement("insert into user_details.user values(?,?,?,?)");
			ps.setInt(1, userId);
			ps.setString(2, userName);
			ps.setString(3, userEmail);
			ps.setString(4, userPass);
			
			int k = ps.executeUpdate();
			
			
			
			if(k>0) {
				pw.println("User register sucessfully..");
				
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.forward(req, res);
			}else {
				pw.println("User not register sucessfully..");
				RequestDispatcher rd = req.getRequestDispatcher("register.html");
				rd.forward(req, res);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
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
