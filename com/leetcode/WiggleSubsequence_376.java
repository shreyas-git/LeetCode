package com.leetcode;

/*
A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.

For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first two differences are positive, and the second is not because its last difference is zero.
A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.

Given an integer array nums, return the length of the longest wiggle subsequence of nums.

 

Example 1:

Input: nums = [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).
Example 2:

Input: nums = [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length.
One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).
Example 3:

Input: nums = [1,2,3,4,5,6,7,8,9]
Output: 2
 */
public class WiggleSubsequence_376 {

	public static void main(String[] args) {
		int nums[]= {1,7,4,9,2,5};
		
		System.out.println(wiggleMaxLength_GREEDY(nums));
		

	}
	
	
	public static int wiggleMaxLength_GREEDY(int []nums) {
		
		int count =0;
		int DIRECTION_UP =1;
		int DIRECTION_DOWN =-1;
		int DIRECTION_UNKNOWN =0;
		int prev_direction = DIRECTION_UNKNOWN;
		
		if(nums.length < 2) return nums.length;
		
		
		for(int i=1;i<nums.length;i++) {
			
			if(nums[i] > nums[i-1]) {
				
				if(prev_direction == DIRECTION_DOWN) {
					count++;
				}
				prev_direction = DIRECTION_UP;
			}else if(nums[i] < nums[i-1]) {
				if(prev_direction == DIRECTION_UP) {
					count++;
				}
				prev_direction = DIRECTION_DOWN;
			}
		}
		
		return count==0? 0:count+2; // +2 bcz we need to consider first and last sequence
	}

	
	 public int wiggleMaxLength(int[] nums) {
	        
	      if(nums.length< 2) return nums.length;
	      
	      return 1 + Math.max(calculate(nums,0,true),calculate(nums,0,false));
	    }
	  
	  public int calculate(int nums[],int index,boolean isUp){
	    int max=0;
	    for(int i=index+1 ;i< nums.length;i++){
	      if((isUp && nums[i] > nums[index]) || (!isUp && nums[i] < nums[index])){
	        max = Math.max(max ,1+ calculate(nums,i,!isUp));
	      }
	    }
	    return max;
	  }
}
