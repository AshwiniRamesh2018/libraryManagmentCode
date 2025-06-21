package com.besant.libmgt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateBook {

	public static void updateBook(String url, String userName, String password) {
		// TODO Auto-generated method stub
		String query = "update book set bookname=?  where bookid=?";
		String qquery = "update book set quantity=?  where bookid=?";
		String pquery = "update book set price=?  where bookid=?";
		String aquery = "update book set isavilable=?  where bookid=?";
		String squery = "select * from Book where bookid=?";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection can = DriverManager.getConnection(url, userName, password);
			PreparedStatement pr = can.prepareStatement(query);
			PreparedStatement pr1 = can.prepareStatement(squery);
			PreparedStatement pr2 = can.prepareStatement(qquery);
			PreparedStatement pr3 = can.prepareStatement(pquery);
			PreparedStatement pr4 = can.prepareStatement(aquery);
			System.out.println("Enter bookid");
			int id = sc.nextInt();
			pr1.setInt(1, id);
			ResultSet result = pr1.executeQuery();
			if (result.next()) {
				System.out.println("Select  0.exit\s 1.Update name\s 2.Update Quantity\s 3.price\s 4.isavilable ");
				int upDateInput = sc.nextInt();
			while(true) {
				switch (upDateInput) {
				case 0: System.out.println("for exit from update");
				return;
				case 1:
					System.out.println("Enter book Name");

					String id1 = sc.next();
					pr.setString(1, id1);
					pr.setInt(2, id);

					int result1 = pr.executeUpdate();

					if (result1 > 0) {
						System.out.println("Record Update sucessfully");
					} else
						System.out.println("not Update");
					return;
					

				case 2:
					System.out.println("Enter book Quantity");

					int id2 = sc.nextInt();
					pr2.setInt(1, id2);
					pr2.setInt(2, id);
					int result2 = pr2.executeUpdate();

					if (result2 > 0) {
						System.out.println("Record Update sucessfully");
					} else
						System.out.println("not Update");
					return;
				case 3:
					System.out.println("Enter book price");

					int id3 = sc.nextInt();
					pr3.setInt(1, id3);
					pr3.setInt(2, id);
					int result3 = pr3.executeUpdate();

					if (result3 > 0) {
						System.out.println("Record Update sucessfully");
					} else
						System.out.println("not Update");
					return;
					
				case 4:
					System.out.println("Enter true if book isavilable or enter false");

					boolean id4 = sc.nextBoolean();
					pr4.setBoolean(1, id4);
					pr4.setInt(2, id);
					int result4 = pr4.executeUpdate();

					if (result4 > 0) {
						System.out.println("Record Update sucessfully");
					} else
						System.out.println("not Update");
					return;
					
					default: System.out.println("entered wrong input Please select from 1 to 4");
				}
				
			}
		}
			else {
				System.out.println("Entered Id: " + id + "is not exits");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
