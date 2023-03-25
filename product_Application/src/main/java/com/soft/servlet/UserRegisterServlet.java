package com.soft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.beans.User;
import com.soft.dao.DBConnection;
@WebServlet("/userregister")
public class UserRegisterServlet extends  HttpServlet{
	private Connection con;
	public void init() {
		
		DBConnection dbcon = new DBConnection();
		con = dbcon.createConnection();
	}
	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		 
		 PrintWriter pw = res.getWriter();
		 res.setContentType("text/html");
		 
		 try {
			
			 int userId = Integer.parseInt(req.getParameter("uid"));
			 String userName  = req.getParameter("uname");
			 String userEmail = req.getParameter("uemail");
			 String userAddress = req.getParameter("uaddrs");
			 String password = req.getParameter("upassword");
			 long userContact = Long.parseLong(req.getParameter("ucontact"));
			 
			 PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			 
			 User user = new User();
			 user.setUserId(userId);
			 user.setUserName(userName);
			 user.setUserEmail(userEmail);
			 user.setUserAddress(userAddress);
			 user.setContactNo(userContact);
			 user.setPassword(password);
			 
			 //ps.setObject(userId, user);
			 
			 ps.setInt(1, userId);
			 ps.setString(2, userName);
			 ps.setString(3, userEmail);
			 ps.setString(4	, password);
			 ps.setLong(5, userContact);
			 ps.setString(6, userAddress);
			 
			 
			 int k = ps.executeUpdate();
			 if(k>0) {
				 RequestDispatcher rd = req.getRequestDispatcher("userLogin.jsp");
				 rd.forward(req, res);
			 }else {
				 
				 RequestDispatcher rd = req.getRequestDispatcher("userRegister.jsp");
				 rd.forward(req, res);
				 pw.print("User not registered sucessfully....");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	

}
