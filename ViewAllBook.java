package com.besant.libmgt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ViewAllBook {

	public static void viewAllBook(String url, String userName, String password) {
		String qur="select * from Book";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, userName, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qur);
			while (rs.next()) {
				int bId = rs.getInt("bookid");
				System.out.print("bookid:\s" + bId + "\t");
				String name = rs.getString("bookname");
				System.out.print("bookname:\s"+name + "\t");
				int quan = rs.getInt("quantity");
				System.out.print("quantity:\s" +quan + "\t");
				int cost = rs.getInt("price");
				System.out.print("price:\s"+cost + "\t");
				boolean avl = rs.getBoolean("isavilable");
				System.out.print("isavilable:\s" +avl + "\t");
				System.out.println();

			}
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

