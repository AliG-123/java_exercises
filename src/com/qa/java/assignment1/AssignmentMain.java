package com.qa.java.assignment1;

import java.util.Scanner;
import java.util.ArrayList;

public class AssignmentMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("Diary of a wimpy kid", "Jeff Kinney", "Comedy, young adult fiction", 1));
		books.add(new Book("Horrid Henry", "Francesca Simon", "Fantasy Fiction", 2));
		books.add(new Book("Atomic Habits", "James Clear", "Self-help book", 3));

		ArrayList<User> users = new ArrayList<User>();

		users.add(new User("ali", "Password123", "ali@hotmail.com", books, books, books));
		users.add(new User("jabril", "Password123", "jabril@hotmail.com", books, books, books));
		users.add(new User("david", "Password123", "david@hotmail.com", books, books, books));

		int bookSize = books.size();
		int userSize = users.size();
		boolean ExitProgram = false;
		while (ExitProgram == false) {
			System.out.println("Main menu");
			System.out.println("1: Create User");
			System.out.println("2: Login to account");
			System.out.println("3: Add book to library");
			System.out.println("4: View book by bookID");
			System.out.println("5: View all books in library");
			System.out.println("6: Exit Program");
			System.out.println("Please select the number from the following options above: ");
			while (scan.hasNextInt() == false) {
				System.out.println("Invalid option try again");
				scan.nextInt();
			}
			int option = scan.nextInt();
			switch (option) {
			case 1:
				System.out.println("Creating User");
				users.add(new User());
				users.get(userSize).createUser();
				userSize++;
				break;
			case 2:
				System.out.println("Which account would you like to access: ");
				int i = 1;
				for (User user : users) {
					System.out.println(user.username + ": " + (i));
					i++;
				}
				System.out.println("Enter number of account you want to access");
				int inpUsername = scan.nextInt();
				if (users.get(inpUsername - 1).userLogin()) {
					System.out.println("You are now viewing account information");
					users.get(inpUsername - 1).viewBooks(users, inpUsername);
				}
				break;
			case 3:
				books.add(new Book());
				books.get(bookSize).createBook(books);
				break;
			case 4:
				System.out.println("Enter Book ID");
				int inpBookId = scan.nextInt();
				Book.searchBook(books, inpBookId);
				break;
			case 5:
				System.out.println("These are all the books in the Library: ");
				for (Book book : books) {
					System.out.println(book.bookName);
				}
				break;
			case 6:
				System.out.println("Exiting Program");
				ExitProgram = true;
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			System.out.println("Do you want to return to main menu: (y/n)");
			String mainMenuOption = scan.next();
			if (mainMenuOption.equals("y")) {
				continue;
			} else {
				System.out.println("Program ended");
				ExitProgram = true;
			}

		}
		scan.close();
	}

}
