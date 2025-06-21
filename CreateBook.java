package com.besant.libmgt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateBook {

	public static void addBook(String url, String userName, String password) {

		String query = "insert into Book (bookid,bookname,quantity,price,isavilable) values (?,?,?,?,?)";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);

			PreparedStatement pr = con.prepareStatement(query);
			while (true) {
				System.out.println("Enter id");
			String squery = "select * from Book where bookid=?";
			
			PreparedStatement pr1 = con.prepareStatement(squery);
				int id = sc.nextInt();
				pr1.setInt(1, id);
				ResultSet result = pr1.executeQuery();

				if (result.next()) {
					System.out.println("Entered Id: "+id+"is alreday exits");}
				else {
					pr.setInt(1, id);
					
					System.out.println("enter book name:");
					String name=sc.next();
					pr.setString(2, name);
					
					System.out.println("enter book quantity:");
					int quantity = sc.nextInt();
					pr.setInt(3, quantity);
					
					System.out.println("enter book price:");
					int price=sc.nextInt();
					pr.setInt(4, price);
					
					System.out.println("enter true if book is avilable or enter false");
					boolean isavilable=sc.nextBoolean();
					pr.setBoolean(5, isavilable);

					int result1 = pr.executeUpdate();

					if (result1 > 0) {
						System.out.println("Record inserted sucessfully ");
						
						while (result1 > 0) {
						System.out.println("Do want to continue edit \nenter yes or no");
						String value=sc.next();
						
						if(value.equals("yes")|| value.equals("Yes")  || value.equals("YES")) {
							return;
						}
						else if (value.equals("No") || value.equals("no") || value.equals("NO")) {
							System.exit(0);
						}
						else System.out.println("you enterd invalid input");
						
						}
					
						}
						
					else
						System.out.println("not inserted");
				} 
					
			}

			

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
