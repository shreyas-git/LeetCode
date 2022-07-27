package com.leetcode;

/*
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
 */
public class MaximumSumCircularSubarray_918 {

	public static void main(String[] args) {
	
			int nums []= {-3,-2,-3};
			System.out.println(maxSubarraySumCircular(nums));

	}
	
	public static  int maxSubarraySumCircular(int[] nums) {
        
	      int maxTillHere = nums[0];
	      int max_so_far = nums[0];
	      
	      int minTillHere = nums[0];
	      int min_so_far = nums[0];
	      
	      int sum = nums[0];
	      
	      for(int i=1;i<nums.length;i++){
	         sum +=nums[i];
	        
	        maxTillHere = Math.max(maxTillHere+nums[i],nums[i]);
	        max_so_far = Math.max(maxTillHere,max_so_far);
	        
	        if(maxTillHere <0) maxTillHere =0;
	        
	        minTillHere = Math.min(minTillHere+nums[i],nums[i]);
	        min_so_far = Math.min(min_so_far,minTillHere);
	        
	        if(minTillHere > 0) minTillHere=0;
	        

	      }
	      
	     if(sum - min_so_far == 0) return max_so_far;
	        
	    return sum -min_so_far > max_so_far ?sum -min_so_far: max_so_far;
	      
	    }

}
