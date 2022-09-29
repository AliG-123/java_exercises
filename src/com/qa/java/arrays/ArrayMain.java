package com.qa.java.arrays;

public class ArrayMain {

	public static void main(String[] args) {
		int [] nums = {1,6,2,8,3,9,15,0};
		
		//Find sum of array
		 int Sum = ArrayMethods.sumAllElements(nums);
		 System.out.println(Sum);
		 
		 
		//Find smallest number in array
		 int Smallest = ArrayMethods.smallestOfArray(nums);
		 System.out.println(Smallest);
		 
		//Find highest number in array
		 int highest = ArrayMethods.highestOfArray(nums);
		 System.out.println(highest);
		
	}

}

