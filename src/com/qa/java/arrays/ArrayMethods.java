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
}
