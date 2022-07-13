package com.leetcode;

import java.util.Arrays;

/*
A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

 

Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.
Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 */
public class MinimumDeletionstoMakeCharacterFrequenciesUnique_1647 {

	// there can be unique freq allowed 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDeletions("aaabbbcc"));
	}
	
	 public static  int minDeletions(String s) {
	        int []freq = new int[26];
	      
	      int maxFreq =s.length();
	      
	      for(int i=0;i<s.length();i++){
	        freq[s.charAt(i) - 'a']++;
	      }
	      
	      int delete= 0;
	      
	      Arrays.sort(freq); // sort in acending order
	      
	      for(int i= 25 ;i>=0;i--){ // traverse from backwards
	        if(freq[i] > maxFreq){
	          delete = delete + freq[i] - maxFreq;
	          freq[i] = maxFreq;
	        }
	        maxFreq = Math.max(0,freq[i]-1);
	      }
	      
	      
	      return delete;
	    }

}
