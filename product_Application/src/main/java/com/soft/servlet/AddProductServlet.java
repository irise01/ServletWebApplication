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

import com.soft.dao.DBConnection;

@WebServlet("/addProdcut")
public class AddProductServlet extends HttpServlet{

	private Connection con;
	public void init() {
		
		DBConnection dbcon = new DBConnection();
		con = dbcon.createConnection();
	}
	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		 PrintWriter pw = res.getWriter();
		 res.setContentType("text/html");
		 
		 try {
			 
			 int pid = Integer.parseInt(req.getParameter("pid"));
			 String pname = req.getParameter("pname");
			 int pqty = Integer.parseInt(req.getParameter("pqty"));
			 double price = Double.parseDouble(req.getParameter("pprice"));
			 
			 PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?)");
			 
			 ps.setInt(1, pid);
			 ps.setString(2, pname);
			 ps.setInt(3, pqty);
			 ps.setDouble(4, price);
			 int k = ps.executeUpdate();
			 if(k>0) {
				 RequestDispatcher rd = req.getRequestDispatcher("productDashboard.jsp");
				 rd.forward(req, res);
			 }else {
				 RequestDispatcher rd = req.getRequestDispatcher("productError.jsp");
				 rd.forward(req, res);
				
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	 
	 }
}
