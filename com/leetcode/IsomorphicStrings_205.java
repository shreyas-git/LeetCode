package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another 
character while preserving the order of characters.
 No two characters may map to the same character,
  but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 */
public class IsomorphicStrings_205 {

	public static void main(String[] args) {
		

		
	}
	
	 public boolean isIsomorphic(String s, String t) {
	        Map<Character, Character> map = new HashMap<>();
	        Set<Character> assignedValues = new HashSet<>();
	        for (int i = 0; i < s.length(); i++) {
	            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
	                return false;
	            }
	            if (!map.containsKey(s.charAt(i)) && assignedValues.contains(t.charAt(i))) {
	                return false;
	            }
	            map.put(s.charAt(i), t.charAt(i));
	            assignedValues.add(t.charAt(i));
	        }
	        return true;
	    }

}
