package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 */
public class WordBreak_139 {

	public static void main(String[] args) {
		
		String s = "catsandog";
		
				System.out.println(s.substring(0,3));
				
	List<String> list = new ArrayList<>();
	
	list.add("cat");
	list.add("cats");
	list.add("and");
	list.add("sand");
	list.add("dog");
//	System.out.println(wordBreakBackTrack(s, list));
	System.out.println(wordBreak(s, list));
	}
	
	
	public static  boolean wordBreak(String s, List<String> wordDict) {
		
		Set<String> dictionary = new HashSet<>(wordDict);
		boolean dp[] = new boolean[s.length()+1];
		dp[0] = true;// "" string can be formed , Base case;
		
		for(int i=1;i<=s.length();i++) {
			for(int j=0;j<i;j++) {
			System.out.println( s.substring(j,i));
				
				if(dp[j] && dictionary.contains(s.substring(j,i))) {
					dp[i]=true;
					break;
				}
			}
		}
		
		
		
		
		return dp[s.length()];
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * this solution works but leads to TLE
	 */
public static  boolean wordBreakBackTrack(String s, List<String> wordDict) {
	List<String>   res= new ArrayList<>();
	helper(s,"",res,wordDict,0);
	System.out.println(res);
	return res.size() > 0;
        
    }

private static void helper(String s, String temp, List<String> res, List<String> wordDict, int start) {
	if(temp.length()>s.length()) {
		return;
	}
	if(temp.equals(s)) {
		res.add(new String(temp)) ;
	}
	
	for(int i=start;i<wordDict.size();i++) {
		String original = temp;
		temp=temp+wordDict.get(i);
		helper(s, temp,res, wordDict, start);
		temp = original;
	}
	
	
}

}
