package com.soft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DBTest {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Id::");
			int id = sc.nextInt();
			System.out.println("Name::");
			String name = sc.next();
			System.out.println("email::");
			String email = sc.next();

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("update user_details.user set username=?,useremail=? where userid=?");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, id);
			
			int k = ps.executeUpdate();
			if(k>0) {
				System.out.println("done");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
