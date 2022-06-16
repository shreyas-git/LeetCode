package com.leetcode;

public class LongestPalidromicSubstring_5 {

	public static void main(String[] args) {
		String str= "abba";
		System.out.println(longestPalindrome(str));

	}
	
	public static String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);// to handle first pos
	        int len2 = expandAroundCenter(s, i, i + 1); // to handle last pos
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;  //"racecar"  we need to check the starting index 
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    /*
	     * "racecar";
	     * when they are not same then return the value;
	     */
	 
	    return R - L - 1;
	}

}
