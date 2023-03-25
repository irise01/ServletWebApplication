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

@WebServlet("/updateProduct")
public class EditProductServlet extends HttpServlet{


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
			 
			 PreparedStatement ps = con.prepareStatement("update product set pname=?, pqty=?,price=? where pid=?");
			 ps.setString(1, pname);
			 ps.setInt(2, pqty);
			 ps.setDouble(3, price);
			 ps.setInt(4, pid);
			 
			 int k = ps.executeUpdate();
			 
			 if(k>0) {
				 pw.print("Prodcut updated sucessfully...!");
				 RequestDispatcher rd = req.getRequestDispatcher("productDashboard.jsp");
				 rd.include(req, res);
			 }else {
				 pw.print("Prodcut not updated sucessfully...!");
				 RequestDispatcher rd = req.getRequestDispatcher("editProduct.jsp");
				 rd.include(req, res);
				
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
	 }
		 
}
