package com.leetcode;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */
public class MinimunWindowSustring_76 {

	public static void main(String[] args) {
		
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}
	
	
	 public static String minWindow(String s, String t) {
	        // define table 
	        int [] arr = new int [128];
	        
	        char [] s_arr = s.toCharArray();
	        char [] t_arr = t.toCharArray();
	        // increment each character in t by one 
	      
	        for(char cur:t_arr){
	            arr[cur]++;
	        }
	        
	        // define pointers 
	        int L=0,R=0;
	        
	        // define min Len 
	        int minLen = Integer.MAX_VALUE; int counter=0;
	        
	        // define ans 
	        String ans = "";
	        
	        // find the window 
	        
	        while(R< s_arr.length){
	            // expand the widow
	            char curChar = s_arr[R];
	            
	            // decrement the counter
	            if(--arr[curChar] >=0){
	                counter++;
	            }
	            
	           
	            // Shrink the window 
	            while(counter == t_arr.length){
	                int curWindow = R-L+1;
	                
	                if(curWindow < minLen){
	                    minLen = curWindow;
	                    ans = s.substring(L, R+1);
	                   
	                }
	                char leftChar = s_arr[L]; 
	              
	                if(++arr[leftChar] > 0){
	                    counter--;
	                }
	                L++;
	            }
	            R++;
	        }
	        
	        
	        return ans;
	        
	    }

}
