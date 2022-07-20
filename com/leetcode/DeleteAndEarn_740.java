package com.leetcode;

/*
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

 

Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.

Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
 */
public class DeleteAndEarn_740 {

	public static void main(String[] args) {
		
		int [] nums = {3,4,2};
		System.out.println(deleteAndEarn(nums));

	}
	
	public static int deleteAndEarn(int[] nums) {
        int ex= 0;
        int in =0;
        int arr[] = new int[100001];
        int max = 0;
      for(int i=0;i<nums.length;i++){
        arr[nums[i]]++;
        max = Math.max(max,nums[i]);
      }
      
      for(int i=1;i<=max;i++){
        int temp = in;
        in   = ex + arr[i] *i;
        ex = Math.max(ex,temp);
        
        
        
      }
      
      return Math.max(in,ex);
    }

}
