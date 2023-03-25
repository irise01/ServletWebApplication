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

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet{

	private Connection con;
	public void init() {
		
		DBConnection dbcon = new DBConnection();
		con = dbcon.createConnection();
	}
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		 PrintWriter pw = res.getWriter();
		 res.setContentType("text/html");
		 try {
			 
			 int pid = Integer.parseInt(req.getParameter("pid"));
			 
			PreparedStatement ps = con.prepareStatement("delete from product where pid=?");
			ps.setInt(1, pid);
			
			int k = ps.executeUpdate();
			if(k>0) {
				pw.print("Record deleted..");
				 RequestDispatcher rd = req.getRequestDispatcher("productDashboard.jsp");
				 rd.include(req, res);
			}else {
				pw.print("Record not deleted..");
				 RequestDispatcher rd = req.getRequestDispatcher("productDashboard.jsp");
				 rd.include(req, res);
			}
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}
