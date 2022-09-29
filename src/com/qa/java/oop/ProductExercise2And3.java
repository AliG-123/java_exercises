package com.qa.java.oop;

public class ProductExercise2And3 {
	public static void main(String[] args) {

		// No-arg constructor - Default is Apples
		Product product1 = new Product();
		product1.productInfo();

		// arg constructor for Chicken Fillets and Banana
		Product product2 = new Product(2, "Chicken Fillets", 7.25, "Fruits", 5, 8, true);
		product2.productInfo();

		Product product3 = new Product(3, "Banana", 1.25, "Fruits", 4, 10, true);
		product3.productInfo();
	}
}
