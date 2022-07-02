package com.leetcode;

public class LongestSubstringWithoutRepeatingChars_3 {

	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		//Sliding window approach , below are two pointers
		int left=0 ; int right =0;
		
		int len = s.length();
		int res=0;
		int []chars = new int[128];
		while(right < len) {
			char c = s.charAt(right);
			chars[c]++;
			
			while(chars[c] >1) {
				//if it is greater than1 means that charater is repeated 
				char repeated = s.charAt(left);
				chars[repeated]--;
				left++;
			}
			res = Math.max(res, right-left+1);
			right++;
		}
		
		return res;
	}
}
