package com.leetcode;

/*
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0
 */
public class AirthmaticSlices_413 {

	public static void main(String[] args) {
		
		int nums[]= {1,2,3,4};
		System.out.println(numberOfArithmeticSlices(nums));
	}
	
	static int   res=0;
    public static int numberOfArithmeticSlices(int[] nums) {
       // slices(nums,nums.length-1);
      
      int dp[] = new int[nums.length];
      for(int i=2;i<nums.length;i++){
        if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
          dp[i] = 1+ dp[i-1];
          res = res+ dp[i];
        }
      }
      return res;
    }
  
  
  
  
  public static int slices(int[] slices,int index){
    
    if(index < 2){// should have at least 3 elements 
      return 0;
    }
    int count =0;
    if(slices[index] - slices[index-1] == slices[index-1] - slices[index-2]){
       count = 1+slices(slices,index-1); 
      res = res+count;
    }else{
      slices(slices,index-1);
    }
    return count;
  }

}
