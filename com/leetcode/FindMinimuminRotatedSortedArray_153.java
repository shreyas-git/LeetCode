package com.leetcode;

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 */
public class FindMinimuminRotatedSortedArray_153 {

	public static void main(String[] args) {
		
		int nums[] =  {4,5,6,7,0,1,2};
		System.out.println(findMin(nums));
	}
	
	
	 public static int findMin(int[] nums) {
	        
	        // base case
	        if(nums.length == 1){
	            return nums[0];
	            
	        }
	        
	        //check if the array is rotated
	        
	    if(nums[0] <nums[nums.length-1]){
	        return nums[0];
	    }
	        
	        // declare pointers
	        int L=0, R = nums.length-1;
	        
	        while(L<=R){
	            int mid = (L+R)/2;
	            
	            // check for the actual conditon
	            
	             if(nums[mid]> nums[mid+1] ){
	                return nums[mid+1];
	            }
	            
	            if( nums[mid-1] > nums[mid] ){
	                return nums[mid]; // one position before mid
	            }
	            
	           
	            
	            
	            if(nums[L] < nums[mid]){
	                // left half is sorted
	                L = mid+1;
	            }else{
	                R= mid-1;
	            }
	            
	        }
	        return -1;
	    }

}
