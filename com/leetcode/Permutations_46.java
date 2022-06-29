package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 */
public class Permutations_46 {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };

		System.out.println(permute(nums));
	}

	public static List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<>();
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
	    for (int num : nums)
	      temp.add(num);
		
		permutation(res,temp,0,nums.length);
		
		return res;

	}

	

	private static void permutation( List<List<Integer>> res, ArrayList<Integer> temp, int index,
			int length) {
		
		if(index == length) {
			res.add(new ArrayList<>(temp));
			
		}
		
			for(int i = index;i<length;i++) {
				Collections.swap(temp, index, i);
				permutation(res, temp, index+1, length);
				Collections.swap(temp, index, i);
			}
		
	}

}
