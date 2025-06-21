package com.besant.libmgt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook extends DataBase {

	public static void removeBook(String url, String userName, String password) {
		// TODO Auto-generated method stub
		String query = "delete from Book where bookid=?";

		System.out.println("enter bookid for delete");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement pr = con.prepareStatement(query);
			String squery = "select * from Book where bookid=?";

			PreparedStatement pr1 = con.prepareStatement(squery);
			pr1.setInt(1, id);
			ResultSet result1 = pr1.executeQuery();

			if (result1.next()) {
			

			pr.setInt(1, id);

			int result = pr.executeUpdate();

			if (result > 0) {
				System.out.println("Record deleted sucessfully");
			} else
				System.out.println("Record not deleted");
		}
		
			else System.out.println(id+"\tid number not avilable please view all and check what you want to delete ");
		}catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
