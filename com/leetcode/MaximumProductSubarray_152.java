package com.leetcode;

/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray_152 {

	public static void main(String[] args) {
		
		int [] nums = {-4,-3,-2};
		
		System.out.println(maxProduct(nums));

	}

	
	public static int maxProduct(int[] nums) {
        
	      int max_so_far = nums[0];
	      int min_so_far = nums[0];
	      
	      int result = max_so_far;
	      
	      for(int i =1;i<nums.length;i++){
	        int cur = nums[i];
	        
	         int temp  = Math.max(cur,Math.max(cur*max_so_far ,cur*min_so_far));
	        
	        min_so_far = Math.min(cur,Math.min(cur*max_so_far ,cur*min_so_far));
	         
	        max_so_far = temp;
	        result = Math.max(max_so_far,result);
	      }
	     return result;
	    }
}
