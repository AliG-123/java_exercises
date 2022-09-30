package com.qa.java.arrays;

public class ArrayOfObjectsExercise {

	public static void main(String[] args) {
		Product[] products;
		products = new Product[5];
		products[0] = new Product(1, "Apples", 3.25, "Fruits", 3.4, 10, true);
		products[1] = new Product(2, "Chicken Fillets", 7.25, "Food", 4.5, 8, true);
		products[2] = new Product(3, "Banana", 1.25, "Fruits", 4.0, 15, true);
		products[3] = new Product(4, "Oreos", 2.00, "Sweets", 4.6, 6, true);
		products[4] = new Product(5, "Galaxy Chocolate", 1.25, "Sweets", 4.1, 20, true);
	
		
		String theCheapestItem = Product.cheapestProduct(products);
		System.out.println("The cheapest discounted item is: " + theCheapestItem);
		
		String mostExpensiveItem = Product.mostExpensiveProduct(products);
		System.out.println("The most expensive discounted item is: " + mostExpensiveItem);

		String highestRatedItem = Product.highestRated(products);
		System.out.println("The highest rated item is: " + highestRatedItem);
	}
}