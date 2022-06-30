package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */
public class LongestConsecutiveSequence_128 {

	public static void main(String[] args) {
		
		int [] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(nums));

	}
	
	
	
	 public static int longestConsecutive(int[] nums) {
	        Set<Integer> num_set = new HashSet<Integer>();
	        for (int num : nums) {
	            num_set.add(num);
	        }

	        int longestStreak = 0;

	        for (int num : num_set) {
	        	/*
	        	 * !num_set.contains(num-1)
	        	 * have a closer look to this  , This means {100,4,200,1,3,2,99}  
	        	 * if you are checking for 100 then no need to calculate , bcz you will calculate for  
	        	 * the number 99
	        	 */
	            if (!num_set.contains(num-1)) {
	                int currentNum = num;
	                int currentStreak = 1;

	                while (num_set.contains(currentNum+1)) {
	                    currentNum += 1;
	                    currentStreak += 1;
	                }

	                longestStreak = Math.max(longestStreak, currentStreak);
	            }
	        }

	        return longestStreak;
	    }

}
