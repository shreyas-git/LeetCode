package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

	public static void main(String[] args) {
		
		String s = "applepenapple";
		
//				String test = "leet";
//				System.out.println(test.substring(0,4));
				
	List<String> list = new ArrayList<>();
	
	list.add("apple");
	list.add("pen");
//	System.out.println(wordBreakBackTrack(s, list));
	System.out.println(wordBreak(s, list));
	}
	
	
	public static  boolean wordBreak(String s, List<String> wordDict) {
		
		Set<String> dictionary = new HashSet<>(wordDict);
		boolean dp[] = new boolean[s.length()+1];
		dp[0] = true;// "" string can be formed , Base case;
		
		for(int i=1;i<=s.length();i++) {
			for(int j=0;j<i;j++) {
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
