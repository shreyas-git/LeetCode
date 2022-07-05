package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 */
public class WordBreak2_140 {

	public static void main(String[] args) {
		String s = "catsanddog";
		String [] wordDict = {"cat","cats","and","sand","dog"};
		
		//backtracking
		System.out.println(wordBreak(s, Arrays.asList(wordDict)));
				

	}
	
	 public static List<String> wordBreak(String s, List<String> wordDict) {
		 
		 List<String> res = new ArrayList<>();
		 List<String> temp = new ArrayList<>();
		 
		 helper(s,wordDict,temp,res,0);
		 
		 
		return res;
		 
	 }

	private static void helper(String s, List<String> wordDict, List<String> temp, List<String> res, int startIndex) {
		//s = "catsanddog";
		//{"cat","cats","and","sand","dog"};
		
		//base condition 
		if(startIndex == s.length()) {
			
			StringBuilder sb = new StringBuilder();
			
			for(String str : temp) {
				sb.append(str).append(" ");
			}
			res.add(sb.toString().trim());
			
			return ;
		}
		
		String sub = s.substring(startIndex);
		for(String word:wordDict) {
			if(sub.startsWith(word)) {
				// initially startIndex will be '0'
				temp.add(word);
				helper(s, wordDict, temp, res, startIndex+word.length());
				temp.remove(temp.size() -1);
			}
			
		}
		
	}

}
