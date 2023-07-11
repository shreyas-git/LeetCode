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
		int nums[] = { 1,2,3};
		System.out.println(subsets(nums));

	}

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList();
		Arrays.sort(nums);
		findSubset(nums, temp, res, 0);
		return res;
	}

	
	public static  void findSubset(int[] nums, List<Integer> temp,List<List<Integer>> res,int startIndex){
	       
	      if(startIndex == nums.length){
	        res.add(new ArrayList<Integer>(temp));
	        System.out.println(temp);
	        return;
	      }
	      
	      temp.add(nums[startIndex]);
	      // System.out.println(temp);
	      findSubset(nums,temp,res,startIndex+1);
	      temp.remove(temp.size()-1);
	      findSubset(nums,temp,res,startIndex+1);
	    }
	


	public  static  void findSubset1(int[] nums, List<Integer> temp,List<List<Integer>> res,int startIndex){
	        
	        if(!res.contains(temp)) {
	        	res.add(new ArrayList<>(temp));
	        }
	        
	        for(int i = startIndex;i<nums.length;i++){
	            temp.add(nums[i]);
	            findSubset1(nums,temp,res,i+1);
	            temp.remove(temp.size() -1);
	        }
	        
	    }

}
