package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

 

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
 */
public class WordSubsets_916 {

	public static void main(String[] args) {
		String [] words1 = {"amazon","apple","facebook","google","leetcode"};
		String [] words2 = {"e","o"};
		System.out.println(wordSubsets(words1, words2));
	}

public static  List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> res = new ArrayList<>();
            
            for(String a : words1){
                int i =0;
                while(i < words2.length){
                    if(a.contains(words2[i])){
                         i++;
                    }else{
                        break;
                    }
                   
                }
                
                if(i == words2.length){
                    res.add(a);
                }
            }
        
        return res;
    }
}
