package com.leetcode;

/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
 */
public class LongestCommonSubsequence_1143 {

	//DP 
	public static void main(String[] args) {
		
System.out.println(longestCommonSubsequence("abcde", "ace"));

String s = "abcde";
StringBuilder sb = new StringBuilder(s);
sb.reverse().toString();
	}
	
	 public static int longestCommonSubsequence(String text1, String text2) {
         
	     // return findLCSRecursive(text1,text2,text1.length(),text2.length());TLE
	      
	      int row = text1.length();
	      int col = text2.length();
	      int [][] dp = new int[row+1][col+1];
	      
	      
	      for(int i=0;i<=row;i++){
	        for(int j=0;j<=col;j++){
	          if(i==0 || j==0){
	            dp[i][j] = 0;
	            
	          } else{
	            if(text1.charAt(i-1) == text2.charAt(j-1)){
	              dp[i][j] = 1+ dp[i-1][j-1];
	            }else{
	               dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
	            }
	          } 
	        }
	        
	      }
	      
	      return dp[row][col];
	      
	    }

}
