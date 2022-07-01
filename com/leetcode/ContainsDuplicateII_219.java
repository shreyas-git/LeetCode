package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class ContainsDuplicateII_219 {

	public static void main(String[] args) {
		int nums [] = {1,2,3,1,2,3}; int k=2;
		System.out.println(containsNearbyDuplicate(nums, k));

	}
	 public static  boolean containsNearbyDuplicate(int[] nums, int k) {
	        if(nums.length == 0 || k==0){
	            return false;
	        }
	        int removeIndex = 0;
	        Set<Integer> set = new HashSet();
	        
	        for(int i =0 ;i< nums.length;i++){
	            if(set.contains(nums[i])){
	                return true;
	            }
	            set.add(nums[i]);
	            
	            if(set.size() > k){ // keep window of k as we have to find the duplicates in K window
	                    set.remove(nums[removeIndex++]);            
	            }
	                
	            
	        }
	        
	        return false;
	     }
}
