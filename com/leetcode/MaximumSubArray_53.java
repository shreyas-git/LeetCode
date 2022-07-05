package com.leetcode;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6. 
 */
public class MaximumSubArray_53 {

	public static void main(String[] args) {
		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		int cur_sum =nums[0];
		int max_so_far = nums[0] ;//Integer.MIN_VALUE;
		
		for(int i=1;i<nums.length;i++) {
			cur_sum += nums[i];
			
			cur_sum = Math.max(cur_sum, nums[i]);
			max_so_far = Math.max(max_so_far, cur_sum);
		}
		
		return max_so_far;
	}

}
