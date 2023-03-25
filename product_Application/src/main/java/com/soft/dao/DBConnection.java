package com.soft.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private Connection con;
	
	public Connection createConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_details","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
