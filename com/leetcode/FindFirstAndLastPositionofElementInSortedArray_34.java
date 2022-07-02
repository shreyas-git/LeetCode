package com.leetcode;
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */
public class FindFirstAndLastPositionofElementInSortedArray_34 {

	public static void main(String[] args) {
		int nums[] = {5,7,7,8,8,10};
		System.out.println(searchRange(nums, 8));

	}
	
	 public static int[] searchRange(int[] nums, int target) {
	        int left  = findTheOccurance(nums,target,true);
	        int right = findTheOccurance(nums,target,false);
	        System.out.println("["+left +" ,"+right+"]");
	      return new int[]{left,right};
	    }
	  
	  
	  public static int findTheOccurance(int nums[] , int target, boolean isleft){
	    
	    int low =0;
	    int high = nums.length -1 ;
	    
	    while(low<=high){
	      
	      int mid = (low+high)/2;
	      
	      if(target > nums[mid]){
	        low = mid+1;
	      }else if (target < nums[mid]){
	        high = mid-1;
	      }else{
	        if(isleft){
	                  if(mid ==0 || nums[mid-1]!=nums[mid]){
	                    return mid;
	                  }else{
	                    high = mid -1;
	                  }
	          
	        }else{
	          if(mid==nums.length-1 ||nums[mid]!=nums[mid+1]){
	            return mid;
	          }else{
	            low = mid+1;
	          }
	          
	          
	        }
	      }
	    }
	    
	    return -1;
	  }

}
