package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//it contains 4sum answers as well
public class ThreeSum_15 {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		int sum = 3;

		Set<List<Integer>> set = new HashSet<>();
		
		set.add(Arrays.asList(2,2,2,2));
		set.add(Arrays.asList(2,2,2,2));
		set.add(Arrays.asList(2,2,2,2));
		set.add(Arrays.asList(2,2,2,2));
		for (List<Integer> ans : set) {
			System.out.println(ans.toString());
		}
		
		 //findCombination(nums, sum);

		List<List<Integer>> res = find3SumWithoutDuplicates(nums);

	}

	private static List<List<Integer>> find3SumWithoutDuplicates(int[] nums) {
		System.out.println("dfdfdfd");
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);
		// {-4,-1,-1,0,1,2}

		for (int i = 0; i < nums.length - 2; i++) { // nums.length-2 bcz we need to skip last two elemets

			if (i==0 || i > 0 && nums[i] != nums[i - 1]) {
				int low = i + 1;
				int high = nums.length - 1;

				while (low < high) {
					if (nums[i] + nums[low] + nums[high] == 0) {
						res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low<high && nums[low] == nums[low+1]) low++; //
                        //this to remove duplicates eg : [-2,0,0,2,2] if not there then o/p = [[-2,0,2],[-2,0,2]] expected = [[-2,0,2]] 
                        while(low<high && nums[high] == nums[high-1]) high--;
						low++;
						high--;

					} else if (nums[i] + nums[low] + nums[high] > 0) {
						high--;
					} else {
						low++;
					}
				}
			}
		}

		for (List<Integer> ans : res) {
			System.out.println(ans.toString());
		}
		return res;

	}

	public static List<List<Integer>> findCombination(int[] nums, int sum) {

		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();

		List<Integer> temp = new ArrayList<>();

		findCombinations(nums, res, temp, sum, 0);

		for (List<Integer> ans : res) {
			System.out.println(ans.toString());
		}
		return res;

	}

	private static void findCombinations(int[] nums, List<List<Integer>> res, List<Integer> temp, int sum, int start) {

		if (temp.size() == sum) {
			if (isSum_0(temp)) {
				res.add(new ArrayList<>(temp));
			}
		}

		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			findCombinations(nums, res, temp, sum, i + 1);
			temp.remove(temp.size() - 1);
		}

	}

	private static boolean isSum_0(List<Integer> temp) {

		int sum = temp.stream().mapToInt(Integer::intValue).sum();
		return sum == 0 ? true : false;
	}

}
