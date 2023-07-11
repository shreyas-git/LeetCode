package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 */
public class DecodeWays_91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "12";
		
		//System.out.println(decode(s,0,new int[s.length()]));
		
		System.out.println(decode_new(s,0,new int[s.length()]));

	}
	
	private static int  decode_new(String s, int index, int[] cache) {
		
		if(index == s.length()) {
			

			return 1;
		}
		
		if(s.charAt(index) =='0') return 0;
		
		if(cache[index]!=0) return cache[index];
		int  res = decode_new(s, index+1,cache);
		 
		
		if(index < s.length() -1) {
			
			if(s.charAt(index)=='1' || s.charAt(index)=='2' && s.charAt(index+1) < '7') {
				res += decode_new(s, index+2,cache);
			}
		}

		cache[index] = res;
		
		return res;
		
		
		
	}

	public int numDecodings(String s) {
        return decode(s,0,new int[s.length()]);
    }
  
    public  static int decode(String s, int start, int [] cache){
      if(s.length() == start){
        return 1;
      }
      // special case 
      if(s.charAt(start) == '0'){
        return 0;
      }
      
      if(cache[start] != 0) return cache[start];
      int res = decode(s,start+1,cache); // check for individual character
      
      if(start < s.length() -1){
        if(s.charAt(start) == '1' || s.charAt(start)=='2' && s.charAt(start+1) < '7'){ //s.charAt(start+1) < '7' bcz only 26 characters are allowed
          res = res + decode(s,start+2, cache);// check for 2 char with range 10 to 26 , Then sum up the res.
          
        }
      }
      cache[start] = res;
      return res;
      
      
    }

    /*
     * below solution won't give proper solution
     */
	private static void decode_Backtracking(String s) {
		Set<Integer> set = new HashSet<>();
		for(int i=1;i<=26;i++) {
			set.add(i);
		}
		List<String> res  = new ArrayList<>();
		int count=0;
		
		helper(s,new StringBuilder(),res,0);
		
		System.out.println(res);
		for(String str:res) {
			if(set.contains(Integer.valueOf(str))) {
				count++;
				set.remove(Integer.valueOf(str));
			}
		}
		
		System.out.println("count = "+ count);
		
	}

	private static void helper(String s, StringBuilder sb, List<String> res, int index) {
		if(sb.length() >1 ) {
			res.add(sb.toString());
			
		}else if(sb.length() ==2 ) {
			res.add(sb.toString());
			//return;
		}
		
		for(int i=index;i<s.length();i++) {
			sb.append(s.charAt(i));
			helper(s, sb, res, index+1);
			sb.deleteCharAt(sb.length()-1);
		}
		
	}
	

	

}
