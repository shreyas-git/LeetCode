package com.leetcode;

/*
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray_189 {

	public static void main(String[] args) {
		int [] nums = {1,2,3,4,5,6,7}; int k = 3;
		rotate(nums, k);
		for(int i:nums) {
			System.out.print(i+",");
		}
		
		/*
		 * Original List                   : 1 2 3 4 5 6 7
			After reversing all numbers     : 7 6 5 4 3 2 1
			After reversing first k numbers : 5 6 7 4 3 2 1
			After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
		 */

	}

	public static void rotate(int[] nums, int k) {
		k= k%nums.length;
		reverse(nums,0,nums.length-1);// reverese whole array 
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);
		
		
	}
	
	public static void reverse(int []nums, int start, int end) {
		while(start<end) {
			int temp = nums[end];
			nums[end]= nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
		
	}

}
