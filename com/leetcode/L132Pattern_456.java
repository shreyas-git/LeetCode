package com.leetcode;

import java.util.Stack;

/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class L132Pattern_456 {

	public static void main(String[] args) {
		
		int nums[] = {3,1,4,2};
		System.out.println(find132pattern(nums));

	}
	
	public static boolean find132pattern(int[] nums) {
	      //        [3,1,4,2]
	      // condition  1: condition  i<j<k
	      // condition 2 : nums[i] < nums[k] < nums[j]
	      // we have to find first largest (nums[j]) , second largest(nums[k]) , third largest(nums[i])
	      Stack<Integer> stack = new Stack(); // to store FL 
	      // SL  = will keep a variable
	      //and Tl will find on the go that will be i'th value
	      
	      int SL = Integer.MIN_VALUE;
	      
	      // traverse from right to left so i<j<k condition satisfy 
	      
	      for(int i = nums.length-1;i>=0;i--){
	        
	        // check if TL is less than SL 
	        if(SL > nums[i]){  //nums[i] represents TL i =1 1<2 yes 
	          return true;  // FL = stack.peek() 4, SL = 2, TL = 1   1< 2 < 4
	        }
	        // update the SL 
	        while(!stack.isEmpty() && stack.peek() < nums[i]){  //i =2, 2 < 4
	          SL = Math.max(SL,stack.pop()); // i =2 SL =2,
	        }  
	        
	        stack.push(nums[i]); // i=3 push(2), i=2 push(4)
	      }
	      
	      
	      
	      
	      return false;
	    }

}
