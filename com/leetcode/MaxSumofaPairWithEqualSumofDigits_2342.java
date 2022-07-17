package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

 

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
Example 2:

Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 */
public class MaxSumofaPairWithEqualSumofDigits_2342 {

	public static void main(String[] args) {
		int nums[] = {368,369,307,304,384,138,90,279,35,396,114,328,251,364,300,191,438,467,183};

		System.out.println(maximumSum(nums));
	}
	
	public static  int maximumSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        // [18,43,36,13,7]
        //  9 , 7 ,9 , 4 ,7 
      int max = -1;
      for(int i=0;i<nums.length;i++){
        
        int sum = sumDigits(nums[i]);
        
        if(map.containsKey(sum)){
          if(map.get(sum) !=i){
            max = Math.max(max,nums[map.get(sum)]+nums[i]);
            int cur_max = nums[map.get(sum)]>nums[i]?map.get(sum):i;
        
            map.put(sum,cur_max);
          }
        }else{
          map.put(sum,i);
        }
      }
    return max;
    }
  
  public static  int sumDigits(int num){
    int sum = 0;
    while(num >0){
      sum = sum + num%10;
      num = num/10;
    }
    return sum;
  }

}
