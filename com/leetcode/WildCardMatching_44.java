package com.leetcode;
/*
 * 
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 */
public class WildCardMatching_44 {

	public static void main(String[] args) {
	 System.out.println(isMatch("adcbdk", "*a*b?k"));
	}
	
	 public static boolean isMatch(String s, String p) {
		 int m=s.length(), n=p.length();
	        boolean[][] dp = new boolean[m+1][n+1];
	        dp[0][0] = true;
	        // update first column
	        for (int i=1; i<=m; i++) {
	            dp[i][0] = false;
	        }
	        // update first row
	        for(int j=1; j<=n; j++) {
	            if(p.charAt(j-1)=='*'){
	                dp[0][j] = true;
	            } else {
	                break;
	            }
	        }

	        for(int i=1; i<=m; i++) {
	            for(int j=1; j<=n; j++) {
	                if (p.charAt(j-1) =='*') {
	                    dp[i][j] = dp[i-1][j] || dp[i][j-1];  //  dp[i-1][j] || dp[i][j-1] means either add or delete to s and p respectively  
	                } else {
	                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?');
	                }             // dp[i-1][j-1] means till previous value mathces eg : - s= adcbdk  and p = *a*b?d
	            }
	        }
	        
	        return dp[m][n];
	 }

}
