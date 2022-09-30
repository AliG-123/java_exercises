package com.qa.java.arrays;

public class ArrayMethods {
	
	//method to return sum of all the array elements
	
	static int sumAllElements(int[] nums){
		int sum = 0;
		for (int num: nums) {
			sum = sum + num;	
		}
		return sum;
	}
	
	//Method to return the smallest number of the array elements
	
	static int smallestOfArray(int[] nums){
		int smallest = nums[0];
		for (int i = 0; i<nums.length; i++){
			if (nums[i] < smallest) {
				smallest = nums[i];
			};	
		}
		return smallest;
	}
	
	//Method to return the highest number of the array elements
	
	static int highestOfArray(int[] nums){
		int highest = nums[0];
		for (int i = 0; i<nums.length; i++){
			if (nums[i] > highest) {
				highest = nums[i];
			};	
		}
		return highest;
	}
	
	// Method to return the product with least price
		static Product cheapestProduct(Product[] products) {
			double cheapestPrice = products[0].discountedPrice();
			Product Product = products[0];
			for (Product product : products) {
				if (product.discountedPrice() < cheapestPrice) {
					cheapestPrice = product.discountedPrice();
					Product = product;
				}
			}
			return Product;
		}

		// Method to return the product with highest price
		static Product mostExpensiveProduct(Product[] products) {
			double highestPrice = products[0].discountedPrice();
			Product Products = products[0];
			for (Product product : products) {
				if (product.discountedPrice() > highestPrice) {
					highestPrice = product.discountedPrice();
					Products = product;
				}
			}
			return Products;
		}

		// Method to return the product with highest rating
		static Product highestRated(Product[] products) {
			double highestRating = products[0].rating;
			Product Products = products[0];
			for (Product product : products) {
				if (product.rating > highestRating) {
					highestRating = product.rating;
					Products = product;
				}
			}
			return Products;
		}
	
	
}
