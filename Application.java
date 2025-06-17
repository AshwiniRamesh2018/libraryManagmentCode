package com.besant.libmgt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Application {
	

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/librarymanagment";
		String userName= "root";
		String password="2018";
		String con = null;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("Enter your choice");
		System.out.print("0.exit\s\s");
		System.out.print("1.insert\s\s");
		System.out.print("2.Delete\s\s");
		System.out.print("3.Update\s\s");
		System.out.print("4.view all\s\s");
		System.out.print("5.view by id");
		System.out.println();
		
		
	int choice=	sc.nextInt();
		
		switch(choice) {
		case 0: System.out.println("exiting from application");
		sc.close();
		return ;
		case 1: System.out.println("Insert Details");
		CreateBook.addBook(url,userName,password);
		break;
		case 2: System.out.println("Delete book");
		DeleteBook.removeBook(url,userName,password);
		break;
		case 3: System.out.println("Update book");
		UpdateBook.updateBook(url,userName,password);
		break;
		case 4: System.out.println("All book details");
		ViewAllBook.viewAllBook(url,userName,password);
		break;
		case 5: System.out.println("enter bookid for details");
		ViewBookById.viewBookid(url,userName,password);
		break;
		
		
		default: System.out.println("you entered wrong choice");
		
		
		
		}
		}
		

	}

}
