package com.leetcode;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
 */
public class MoveZeros_283 {

	public static void main(String[] args) {
		
		int nums[] = {0,1,0,3,12};
		
		moveZeroes(nums);
		
		for(int i :nums) {
			System.out.print(i+" ,");
		}

	}
	
	 public  static void moveZeroes(int[] nums) {
	        
		 int insert_index=0;
		 //[0,1,0,3,12]
		 for(int i =0;i<nums.length;i++) {
			 if(nums[i]!=0) {
				 nums[insert_index]  = nums[i];
				 insert_index++;
			 }
		 }
		 
		 // by the end of above loop array will be 
		 // [1,3,12,3,12] and insert_index= 3 , from index 3 we have to make it 0 
		 
		 while(insert_index< nums.length) {
			 nums[insert_index] = 0;
			 insert_index++;
		 }
	    }

}
