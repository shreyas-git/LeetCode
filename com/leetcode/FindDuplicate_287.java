package com.leetcode;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 */
public class FindDuplicate_287 {

	public static void main(String[] args) {
		
		int [] nums = {1,3,4,2,1};
		System.out.println(findDuplicate(nums));

	}
	/*
	 *  public int findDuplicate(int[] nums) {
       
      int slow = nums[0];
      int fast = nums[0];
      
      do{
        slow = nums[slow];
        fast = nums[nums[fast]];
      }while(slow!=fast);
      
      slow = nums[0];
      
      while(slow!=fast){
        slow = nums[slow];
        fast = nums[fast];
      }
      
      return fast;
    }
	 */
	 public static  int findDuplicate(int[] nums) {
	        int duplicate = -1;
	        for (int i = 0; i < nums.length; i++) {
	            int cur = Math.abs(nums[i]);
	            if (nums[cur] < 0) {
	                duplicate = cur;
	                break;
	            }
	            nums[cur] *= -1;
	        }
	        
	        // Restore numbers
	        for (int i = 0; i < nums.length; i++)
	            nums[i] = Math.abs(nums[i]);

	        return duplicate;
	    }

}
