package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.

 

Example 1:

Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
Example 2:

Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring. 
Example 3:

Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and does not exist in the array.
 */
public class CheckIfaStringContainsAllBinaryCodesofSizeK_1461 {

	public static void main(String[] args) {
		
		System.out.println(hasAllCodes("00110010", 2));

	}
	
	/*
	 * this methos helps to convert Binary to decimal
	 */
	public static int getDecimal(int binary){  
	    int decimal = 0;  
	    int n = 0;  
	    while(true){  
	      if(binary == 0){  
	        break;  
	      } else {  
	          int temp = binary%10;  
	          decimal += temp*Math.pow(2, n);  
	          binary = binary/10;  
	          n++;  
	       }  
	    }  
	    return decimal;  
	}  

	
	 public static boolean hasAllCodes(String s, int k) {
	        Set<String> set = new HashSet<>();
	      int p1 = 0;
	      int p2 = k-1;
	      
	      double possibleCombination = Math.pow(2,k);
	      
	      
	      while(p2 < s.length()){
	        String subString = s.substring(p1,p2+1);
	        if(!set.contains(subString)){
	          possibleCombination--;
	        }
	        if(possibleCombination ==0) return true;
	        
	        set.add(subString);
	        p1++;p2++;
	      }
	      
	      return false;
	    }
}
