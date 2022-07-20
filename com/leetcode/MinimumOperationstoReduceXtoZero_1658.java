package com.leetcode;

/*
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

 

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 */
public class MinimumOperationstoReduceXtoZero_1658 {

	public static void main(String[] args) {
		
		int []nums = {1,1}; int x = 5;
		
		System.out.println(minOperations(nums, x));

	}

	
	 public static  int minOperations(int[] nums, int x) {
	       int left =0, right = nums.length -1;
	      
	      int sum =0,minOperation = 0,res = Integer.MAX_VALUE;
	      
	      // expand the window from left 
	      //nums = [1,1,4,2,3], x = 5
	      while(left < nums.length){
	        sum = sum+nums[left];
	        minOperation ++;
	        if(sum == x){
	          res = minOperation;
	          break;
	        }else if(sum > x){
	          break;
	        }
	        
	        left++;
	      }
	      
	      // sum =2 , left =1 , minOperation =2;
	      
	      // shrink the window
	      
	      while(right >=0 && left <= nums.length-1){
	         if(sum + nums[right] > x){  // sum = 2, 2+3 =5 
	           
	           if(left >= right){
	             break;
	           }
	           sum = sum - nums[left];
	           minOperation--;
	           left--;
	           
	           if(left <0){
	             left = nums.length -1;
	           }
	           continue;
	          
	         }
	        
	        sum = sum + nums[right];
	        minOperation++;  // 1,1 ....3 = 5, minOperation =3
	        
	        if(sum == x){
	          res = Math.min(res,minOperation);
	        }
	         right--;
	      }
	      
	      return res == Integer.MAX_VALUE? -1:res;
	    }
}
