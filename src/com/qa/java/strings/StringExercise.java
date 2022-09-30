package com.qa.java.strings;

public class StringExercise {

	public static void main(String[] args) {
	
		String test = "Hello how are you";
		int numberOfWords = StringMethods.countWords(test);
		System.out.println(numberOfWords);
		

	
		String[] emails = {"abc_gmail.com", "abcd*()@gmail.com", "abcd@gmail.com", "test_123@gmail.com", "1234@#$@gmail.com"};
		
		//Calling method that return number of invalid emails
		int invalidEmails = StringMethods.invalidEmail(emails);
		System.out.println("The number of invalid emails is: " + invalidEmails);
		System.out.println();
		//Calling method that return number of valid emails
		int validEmails = StringMethods.validEmail(emails);
		System.out.println("The number of invalid emails is: " + validEmails);
		System.out.println();
		//Calling method that prints the valid emails
		StringMethods.validEmailsReturn(emails);
		System.out.println();

		//Calling method that prints the invalid emails
		StringMethods.invalidEmailsReturn(emails);
		System.out.println();

	}

}
