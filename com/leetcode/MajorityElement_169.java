package com.leetcode;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement_169 {

	public static void main(String[] args) {
		
		int nums [] = {2,2,1,1,1,2,2};
		System.out.println(majorityElement(nums));

	}
	
	 public  static int majorityElement(int[] nums) {
		// 2 2 1 1 1 2 2  n = 7
//		       ^  
		// 1 2 1 0  ......
		        //this is kind of voting system 
		        int vote =0;
		        Integer candidate = null;
		        
		        for(int num:nums){
		            if(vote ==0 ){
		                candidate = num;
		            }
		            
		            if(candidate == num){
		                vote++;
		            }else{
		                vote--;
		            }
		        }
		        
		        return candidate;
		    }

}
