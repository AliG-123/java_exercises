package com.qa.java.arrays;

public class Product {
	int id;
	String name;
	double price;
	String category;
	double rating;
	int discountPercentage;
	boolean isAvailable;

	final static String SHOP_NAME = "Asda";
	final static String SHOP_CONTACT_NO = "07329343437";
	final static String SHOP_EMAIL = "Seller@asda.com";

	// No arg constructer

	Product() {
		System.out.println("No details given. Default Apple product info displayed.");
		id = 1;
		name = "Apple";
		price = 3.25;
		category = "Fruits";
		rating = 3;
		discountPercentage = 10;
		isAvailable = true;

	}

	// arg constructer

	public Product(int id, String name, double price, String category, double rating, int discountPercentage,
			boolean isAvailable) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.rating = rating;
		this.discountPercentage = discountPercentage;
		this.isAvailable = isAvailable;

	}

	// method to calculate rounded discounted price
	double discountedPrice() {
		return (Math.round((price - (price * discountPercentage / 100)) * 100.00) / 100.00);
	}
	// method display product info

	void productInfo() {
		System.out.println("Product Id: " + id);
		System.out.println("Product Name: " + name);
		System.out.println("Product Catergory: " + category);
		System.out.println("Product Rating: " + rating + "/5.0");
		System.out.println("Product in stock: " + isAvailable);
		System.out.println(discountPercentage + "% discount available");
		System.out.println("Originial Product Price: £" + price);
		System.out.println("Discounted Product Price: £" + discountedPrice());
		System.out.println();
	}

	// method to display shop info
	static void sellerContactDetails() {
		System.out.println("Shop name is: " + SHOP_NAME);
		System.out.println("Shop phone number is: " + SHOP_CONTACT_NO);
		System.out.println("Shop email is: " + SHOP_EMAIL);
	}
	
}
