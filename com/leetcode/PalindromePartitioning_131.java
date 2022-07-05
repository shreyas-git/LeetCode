package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 */
public class PalindromePartitioning_131 {

	public static void main(String[] args) {
		
		 System.out.println(partition("aab"));

	}

	public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(s,temp,res,0);
      return res;
    }
  
  
  public static void helper(String s, List<String> temp, List<List<String>> res, int startIndex){
    if(startIndex >= s.length()){
      res.add(new ArrayList<String>(temp));
      return ;
    }
    
    
    //aab -> a,a , b , aa, ab,......
    for(int end =startIndex;end<s.length();end++){
      if(ispalindrome(s,startIndex,end)){
        temp.add(s.substring(startIndex,end+1));
        helper(s,temp,res,end+1);
        temp.remove(temp.size() -1);
      }
    }
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
