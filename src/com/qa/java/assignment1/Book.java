package com.qa.java.assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {

	String bookName;
	String authorName;
	String description;
	int bookId;

	Book() {
	}

	public Book(String bookname, String authorName, String description, int bookId) {
		this.bookName = bookname;
		this.authorName = authorName;
		this.description = description;
		this.bookId = bookId;

	}

	Scanner inp = new Scanner(System.in);

	static void searchBook(ArrayList<Book> books, int id) {
		for (Book book : books) {
			if (id == book.bookId) {
				System.out.println("The matching book to that Book ID is:  " + book.bookName + " by " + book.authorName);
			}
		}
	}

	void createBook(ArrayList<Book> books) {
		System.out.println("Enter book name");
		this.bookName = inp.nextLine();
		System.out.println("Enter book author");
		this.authorName = inp.nextLine();
		System.out.println("Enter book genre");
		this.description = inp.nextLine();
		this.bookId = books.size();
		System.out.println("We have added " + this.bookName + " by " + this.authorName + " to the library");
	}
}
