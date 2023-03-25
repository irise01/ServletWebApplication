package com.soft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.soft.dao.DBConnection;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet{
	

	private Connection con;
	public void init() {
		
		DBConnection dbcon = new DBConnection();
		con = dbcon.createConnection();
	
	}
	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		 
		 PrintWriter pw = res.getWriter();
		 res.setContentType("text/html");
		 try {
			 String userEmail = req.getParameter("uemail");
			 String password = req.getParameter("upassword");
			 
			 
			PreparedStatement ps = con.prepareStatement("select * from user where user_email=? AND password=?");
			ps.setString(1, userEmail);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				req.setAttribute("UserName", rs.getString(2));
				RequestDispatcher rd = req.getRequestDispatcher("productDashboard.jsp");
				rd.forward(req, res);
			}else {
		
				RequestDispatcher rd = req.getRequestDispatcher("userLogin.jsp");
				rd.forward(req, res);
				pw.print("User not login sucessfully...!");
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

}
