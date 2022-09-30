package com.qa.java.strings;

public class StringMethods {

	// Count the number of words in given String

	static int countWords(String s) {
		return s.split(" ").length;
	}

	static int invalidEmail(String[] Emails) {
		String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		int count = 0;

		for (String Email : Emails) {
			if (!Email.matches(regex))
				count++;
		}
		return count;
	}

	static int validEmail(String[] Emails) {
		String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		int count = 0;

		for (String Email : Emails) {
			if (Email.matches(regex))
				count++;
		}
		return count;
	}

	static void validEmailsReturn(String[] Emails) {
		String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

		System.out.println("The valid emails are: ");
		for (String Email : Emails) {
			if (Email.matches(regex))
				System.out.println(Email);
		}
	}

	static void invalidEmailsReturn(String[] Emails) {
		String regex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

		System.out.println("The invalid emails are: ");
		for (String Email : Emails) {
			if (!Email.matches(regex))
				System.out.println(Email);
		}
	}
}
