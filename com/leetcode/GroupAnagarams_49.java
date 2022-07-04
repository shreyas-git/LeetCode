package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagarams_49 {

	public static void main(String[] args) {
		String [] strs = {"eat","tea","tan","ate","nat","bat"};
		
		System.out.println(groupAnagrams(strs));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		
		Map<String,ArrayList<String>>  map = new HashMap();
		List<List<String>>  res = new ArrayList();
		
		
		
		for(String str : strs) {
			
			char [] c_arr = new char[26];
			
			for(int i=0; i<str.length(); i++){
	           c_arr[str.charAt(i) -'a']++;
	        }
			

			String ns = new String(c_arr);
	       if(map.containsKey(ns)) {
	    	   map.get(ns).add(str);
	       }else {
	    	   List<String> al = new ArrayList();
	    	   al.add(str);
	    	   map.put(ns, (ArrayList<String>) al);
	       }
	 
	      
		}
		res.addAll(map.values());
       return res;

	}

}
