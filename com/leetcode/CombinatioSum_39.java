package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinatioSum_39 {

	public static void main(String[] args) {
		int []nums= {2,3,6,7};
		int target = 7;
		
System.out.println(findCombination(nums,target));
	}
	
	
	public static List<List<Integer>> findCombination(int[] nums, int target) {

		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();

		List<Integer> temp = new ArrayList<>();

		findCombinations(nums, res, temp, target, 0);

//		for (List<Integer> ans : res) {
//			System.out.println(ans.toString());
//		}
		return res;

	}

	private static void findCombinations(int[] nums, List<List<Integer>> res, List<Integer> temp, int target, int start) {

		if(target ==0) {
			
			res.add(new ArrayList<>(temp));
			return;
		}else if(target < 0) {
			return;
		}

//		if (isTarget(temp)==target) {
//			res.add(new ArrayList<>(temp));
//			return ;
//		}
	

		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			findCombinations(nums, res, temp, target-nums[i], i);
			temp.remove(temp.size() - 1);
		}

	}

	private static int isTarget(List<Integer> temp) {

		int sum = temp.stream().mapToInt(Integer::intValue).sum();
		return sum;
	}


}
