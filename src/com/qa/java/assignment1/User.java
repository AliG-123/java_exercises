package com.qa.java.assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	String username;
	String password;
	String emailId;
	ArrayList<Book> newBooks = new ArrayList<Book>();
	ArrayList<Book> favouriteBooks = new ArrayList<Book>();;
	ArrayList<Book> completedBooks = new ArrayList<Book>();;

	User(){
	}
	
	public User(String username, String password, String emailId, ArrayList<Book> newBooks, ArrayList<Book> favouriteBooks, ArrayList<Book> completedBooks) {
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.newBooks = newBooks;
		this.favouriteBooks = favouriteBooks;
		this.completedBooks = completedBooks;
	}

	Scanner inp = new Scanner(System.in);

	void createUser() {
		System.out.println("Enter a username: ");
		this.username = inp.nextLine();
		System.out.println("Enter a password: ");
		this.password = inp.nextLine();
		System.out.println("Enter your email: ");
		this.emailId = inp.nextLine();
		newBooks.add(new Book("This is the Default Book","","",0));
		completedBooks.add(new Book("This is the Default Book","","",0));
		favouriteBooks.add(new Book("This is the Default Book","","",0));
	}
	boolean userLogin() {
		boolean flag = true;
		while (flag) {
			System.out.println("Please enter the username: ");
			String enteredUsername = inp.nextLine().toLowerCase();
			System.out.println("Please enter the password: ");
			String enteredPassword = inp.nextLine();
			if (enteredUsername.equals(this.username) && enteredPassword.equals(this.password)) {
				System.out.println("Successfully Logged In");
				flag = false;
			} else {
				System.out.println("Invalid Username or Password, try again");
			}
		}
		return true;

	}

	void viewBooks(ArrayList<User> users, int inpUsername) {
		System.out.println("Which books would you like to view: ");
		System.out.println("1: New Books");
		System.out.println("2: Favourite Books");
		System.out.println("3: Completed Books");
		int bookType = inp.nextInt();
		boolean flag = true;
		while (flag) {
			switch (bookType) {
			case 1:
				for (Book book : users.get(inpUsername - 1).newBooks) {
					System.out.println(book.bookName);
				}
				flag = false;
				break;
			case 2:
				for (Book book : users.get(inpUsername - 1).favouriteBooks) {
					System.out.println(book.bookName);
				}
				flag = false;
				break;
			case 3:
				for (Book book : users.get(inpUsername - 1).completedBooks) {
					System.out.println(book.bookName);
				}
				flag = false;
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}
		}
	}
}
