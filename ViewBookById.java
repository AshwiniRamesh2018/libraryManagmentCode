package com.besant.libmgt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewBookById {

	public static void viewBookid(String url, String userName, String password) {
		String query = "select * from Book where bookid=?";

		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement pr = con.prepareStatement(query);

			pr.setInt(1, id);

			ResultSet rs1 = pr.executeQuery();
			
			if (rs1.next()) {
				PreparedStatement pr1 = con.prepareStatement("select * from Book");
				ResultSet rs = pr.executeQuery();
				
			if (rs.next()) {
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
			else System.out.println(" book not avilable");
			System.out.println();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
