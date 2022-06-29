package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
public class Subset_78 {

	public static void main(String[] args) {
		int nums[] = { 4,4,4,1,4 };
		System.out.println(subsets(nums));

	}

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList();
		Arrays.sort(nums);
		findSubset(nums, temp, res, 0);
		return res;
	}

	


	public  static  void findSubset(int[] nums, List<Integer> temp,List<List<Integer>> res,int startIndex){
	        
	        if(!res.contains(temp)) {
	        	res.add(new ArrayList<>(temp));
	        }
	        
	        for(int i = startIndex;i<nums.length;i++){
	            temp.add(nums[i]);
	             findSubset(nums,temp,res,i+1);
	            temp.remove(temp.size() -1);
	        }
	        
	    }

}
