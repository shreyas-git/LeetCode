package com.leetcode;

/*
Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.

A subarray of an array is a consecutive sequence of zero or more values taken out of that array.

Return the maximum length of a subarray with positive product.

 

Example 1:

Input: nums = [1,-2,-3,4]
Output: 4
Explanation: The array nums already has a positive product of 24.
Example 2:

Input: nums = [0,1,-2,-3,-4]
Output: 3
Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.
Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.
Example 3:

Input: nums = [-1,-2,-3,0,1]
Output: 2
Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].
 */
public class MaximumLengthofSubarrayWithPositiveProduct_1567 {

	public static void main(String[] args) {
		
		int nums [] = {1,-2,-3,4};
		System.out.println(getMaxLen(nums));

	}
	
	 public  static int getMaxLen(int[] nums) {
	        
	      int max =0;
	      
	      for(int i=0;i<nums.length;i++){
	        if(nums[i] != 0){
	          int negative = nums[i] > 0 ? 0: 1;
	          
	          max = Math.max(max, negative);
	          
	          for(int j=i+1;j<nums.length;j++) {
	        	  
	        	  if(nums[j] < 0) {
	        		  negative++;
	        	  }else if(nums[j] ==0) {
	        		  break;
	        	  }
	        	  if(negative % 2 ==0) {
	        		  max = Math.max(max, j-i+1);
	        	  }
	          }
	        }
	      }
	      
	      return max;
	    }

}
