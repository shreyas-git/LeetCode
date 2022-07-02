package com.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

 

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 */
public class LongestSubstringWithAtMost_K_DistinctCharacters_340 {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("LOVELEETCODE", 4));
		//output = LOVELEE = 7
	}
	
	
	 public static int lengthOfLongestSubstringKDistinct(String s, int k) {
	        if(s.length() == 0 || k ==0){
	            return 0;
	        }
	        
	        int left =0;
	        int right = 0;
	        
	        Map<Character,Integer> map = new HashMap();
	        
	        int max_len_substring=1;
	        while(right < s.length()){
	          
	                map.put(s.charAt(right),right);
	                //increament the right pointer
	                right++;
	            //LOVELEETCODE
	            if(map.size() == k+1){
	                int left_index_to_remove = Collections.min(map.values());
	                // here got index of [L:4,O:1(to be deleted ),V:2,E:6,T:7]
	                map.remove(s.charAt(left_index_to_remove));
	                left = left_index_to_remove+1;
	                
	            }
	            
	            max_len_substring = Math.max(max_len_substring, right-left);
	            
	        }
	        
	        return max_len_substring;
	    }

}
