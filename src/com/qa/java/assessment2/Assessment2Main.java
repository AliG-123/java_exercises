//#1 Prompt message- Press 1 to Register, press 2 for Log-in and Press 0 for terminate the program
//if user presses 1, then you should prompt message- "Press 1 to Register as Admin and press 2 to register as Normal User
// Irrespective of what he gives you either 1 or 2, you should takes his/her
// details like username, password, firstName, lastName,
// email, phone and make sure that username is unique in a table as a primary
// key. mIf multiple users give same username while
// registering then you should prompt the message back that "username is already
// taken, please choose another" and ask again to give
// details that means this regsitration process should go into loop until
// registration is successful...and user should sent back to the main
// menu which is "Prompt message- Press 1 to Register, press 2 for Log-in and
// Press 0 for terminate the program"
//#2 if user presses 2, then prompt the message- "you wish to login as Admin the press 1 or 2 for Normal User!!
// if user presses 1, you should ask you press 1 to display all the books
// present or press 2 to create book or 0 to terminate the program
// if presses 1, you should display all the books available in the database
// if presses 2, you should ask all the books information which admin wishes to
// add in the database like bookid, bookname, authorname, description
// after the book is added, you should prompt this message- "press 1 to display
// all the books present or press 2 to create book or 0 to terminate the
// program or 4 to go back to the main menu"

package com.qa.java.assessment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Assessment2Main {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assessment2", "root", "admin123");
		boolean programRunning = true;
	while(programRunning){
		Scanner sc = new Scanner(System.in);

		System.out.println("Press 1 to Register: ");
		System.out.println("Press 2 to Login: ");
		System.out.println("Press 0 to Terminate: ");
		int option = sc.nextInt();
		PreparedStatement pstmt = null;
		switch (option) {
		case 1:
			System.out.println("Press 1 to Register as admin or 2 for user: ");
			int registerOption = sc.nextInt();
			System.out.println("Registering user");
			boolean userTaken = true;
			String username = null;
			while (userTaken) {
				System.out.println("Create a username: ");
				username = sc.next();
				pstmt = conn.prepareStatement("select * from users where username = ?");
				pstmt.setString(1, username);
				ResultSet rs = pstmt.executeQuery();
				if (!rs.next()) {
					userTaken = false;
				} else
					System.out.println("Username is taken, try again");
			}
			System.out.println("Create a password: ");
			String password = sc.next();
			System.out.println("Please enter your first name: ");
			String firstName = sc.next();
			System.out.println("Please enter your email: ");
			String email = sc.next();
			if (registerOption == 1) {
				pstmt = conn.prepareStatement("insert into users values(?,?,?,?,'admin')");
			} else {
				pstmt = conn.prepareStatement("insert into users values(?,?,?,?,'user')");
			}
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, firstName);
			pstmt.setString(4, email);
			pstmt.execute();
			System.out.println("User created");
			break;
		case 2:
			boolean flag = true;
			while (flag) {
				System.out.println("Enter your username: ");
				String enteredUsername = sc.next();
				System.out.println("Enter your password: ");
				String enteredPassword = sc.next();
				pstmt = conn.prepareStatement("select * from users where username = ? AND password = ?");
				pstmt.setString(1, enteredUsername);
				pstmt.setString(2, enteredPassword);
				pstmt.executeQuery();
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					PreparedStatement bpstmt = null;
					System.out.println("Hello " + rs.getString(3) + " you are an " + rs.getString(5));
					System.out.println();
					if (rs.getString(5).equals("admin")) {
						System.out.println("Press 1: View all books in library ");
						int adminOption = sc.nextInt();
						bpstmt = conn.prepareStatement("select * from books");
						ResultSet brs = bpstmt.executeQuery();
						System.out.println("These are the books in the library");
						while (brs.next()) {
							System.out.println("Book ID: " + brs.getString(1) + " - " + brs.getString(2) + " by "
									+ brs.getString(3));
						}
					} else {
						System.out.println("Press 1: Add book to account ");
						System.out.println("Press 2: View books on account");
						int bookOption = sc.nextInt();
						if (bookOption == 1) {
							System.out.println("Please enter the book ID of the book you wish to add: ");
							int idBook = sc.nextInt();
							System.out.println("Please enter the book name: ");
							sc.nextLine();
							String bookname = sc.nextLine();
							System.out.println("Please enter the book author: ");
							String bookauthor = sc.nextLine();
							bpstmt = conn.prepareStatement("insert into books values (?,?,?,?)");
							bpstmt.setInt(1, idBook);
							bpstmt.setString(2, bookname);
							bpstmt.setString(3, bookauthor);
							bpstmt.setString(4, enteredUsername);
							bpstmt.execute();
							System.out.println("Book has been added");
						} else if (bookOption == 2) {
							ResultSet uBrs = null;
							bpstmt = conn.prepareStatement("select * from books where UserID = ?");
							bpstmt.setString(1, enteredUsername);
							uBrs = bpstmt.executeQuery();
							System.out.println("These are the books on your account");
							while (uBrs.next()) {
								System.out.println("Book ID: " + uBrs.getString(1) + " - " + uBrs.getString(2) + " by "
										+ uBrs.getString(3));
							}
						}

					}
					flag = false;
				} else {
				}
			}
			break;
		case 0:
			System.out.println("Terminating program");
			break;
		default:
			System.out.println("Invalid option");
		}
		if (option == 0) {
			System.out.println("Program terminated");
			break;
		}
		System.out.println();
		System.out.println("Do you want to return to main menu");
		System.out.println("Press 1: Yes");
		System.out.println("Press 2: No");
		int mainMenu = sc.nextInt();
		if (mainMenu == 1) {
			continue;
		}else if(mainMenu == 2 ) {
			System.out.println("Program terminated");
			programRunning = false;
		}
		
	}
	}

}
