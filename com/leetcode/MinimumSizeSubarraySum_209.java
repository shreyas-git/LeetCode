package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */
public class MinimumSizeSubarraySum_209 {
	/*
	 * of which the sum is greater than  or equal to target
	 * 
	 * This poin to be noted
	 */
	public static void main(String[] args) {
		
		int target = 7;
		int []nums = {2,3,1,2,4,3};
		
    findSubArrayWithGivenSum(target, nums);
    System.out.println(minSubArrayLen(target, nums));

	}
	
	
	 public static  int minSubArrayLen(int target, int[] nums) {
		 int n = nums.length;
		    int ans = Integer.MAX_VALUE;
		    int left = 0;
		    int sum = 0;
		    for (int i = 0; i < n; i++) {
		        sum += nums[i];
		        while (sum >= target) {
		            ans = Math.min(ans, i + 1 - left);
		            sum -= nums[left++];
		        }
		    }
		    return (ans != Integer.MAX_VALUE) ? ans : 0;
		        
	 }
	
	
	 public static  void findSubArrayWithGivenSum (int target, int[] nums) {
	        int min_len= Integer.MAX_VALUE;
	        
	        Map<Integer,Integer> map = new HashMap<>();
	        
	        int sum=0;
	        //[2,3,1,2,4,3]
	        for(int i=0;i<nums.length;i++){
	            sum = sum + nums[i];
	            if(map.containsKey(sum-target)){
	               min_len = Math.min(min_len , i - map.get(sum-target));
	               System.out.println("SubArray from "+(map.get(sum-target)+1) + "to :"+ i);
	            }
	                map.put(sum,i);
	            
	        }
	        
	        
	        
	        
	       
	        
	    }

}
