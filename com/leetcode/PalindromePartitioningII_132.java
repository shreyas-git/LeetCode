package com.leetcode;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 */
public class PalindromePartitioningII_132 {

	public static void main(String[] args) {
		System.err.println(minCut("aab"));
		
	}
	
	public static int minCut(String s) {
        if(ispalindrome(s,0,s.length()-1)){
          return 0;
        }else{
          return fidCuts(s,0,s.length()-1,s.length());
        }
    }
  
  
  public static int fidCuts(String s, int start,int end,int minCuts){
    
    if(start == end  || ispalindrome(s,start,end)){
      return 0;
    }
    
    for(int i = start; i<=end ;i++){
      if(ispalindrome(s,start,i)){
        minCuts = Math.min(minCuts,1+fidCuts(s,i+1,end,minCuts));
      }
    }
    return minCuts;
  }
  
   public static  boolean ispalindrome(String s ,int start,int end){
    while(start<end){
      if(s.charAt(start) == s.charAt(end)){
        start++;
      end--;
      }else{
        return false;
      }
      
    }
    return true;
  }

}
