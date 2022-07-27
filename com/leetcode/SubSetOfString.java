package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubSetOfString {

	public static void main(String[] args) {
		
		subset("abc");
		int nums [] = {1,2,3};
		subsets(nums);

	}
	
	public static void subset(String s) {
		
		List<List<String>> res = new ArrayList<>();
		
		
		helper(s,new ArrayList<>(),res,0);
		
		System.out.println(res);
		
	}

	private static void helper(String s, List<String> temp, List<List<String>> res, int index) {
		
		if(index == s.length()) {
			res.add(new ArrayList<String>(temp) );
			return ;
		}
		
		for(int i=index;i<s.length();i++) {
			
			temp.add(Character.toString(s.charAt(i)));
			
			helper(s, temp, res, i+1);
			temp.remove(temp.size()-1);
			helper(s, temp, res, i+1);
			
		}
		
	}
	
	
	 public static List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        if (nums.length < 1) return res;
	        helper(res, new ArrayList<>(), nums, 0);
	        System.out.println(res);
	        return res;
	    }
	    
	    private static void helper(List<List<Integer>> res, 
	        List<Integer> cur, int[] nums, int index) {
	        if (index == nums.length) {
	            res.add(new ArrayList(cur));
	            return;
	        }
	        
	        cur.add(nums[index]);
	        helper(res, cur, nums, index + 1);
	        cur.remove(cur.size() - 1);
	        helper(res, cur, nums, index + 1);
	    }

}
