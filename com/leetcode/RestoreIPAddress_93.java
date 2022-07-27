package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class RestoreIPAddress_93 {

	public static void main(String[] args) {
		
		System.out.println(restoreIpAddresses("25525511135"));

	}
	
	
	  public  static List<String> restoreIpAddresses(String s) {
	        List<String> res = new ArrayList<>();
	      
	        helper(s,new StringBuilder(),3,res,0);
	      
	        return res;
	    }
	  
	  private static  void helper(String s,StringBuilder sb , int dotLeft,List<String> res,int index){
	    
	    // base case 
	    if(dotLeft == 0){
	      
	    	if(isValid(s.substring(index))) {
	    		sb.append("."+s.substring(index));
	    		res.add(sb.toString());
	    	}
	    	
	      return ;
	    }
	    
	   for(int right =index;right<s.length();right++) {
		   if(isValid(s.substring(index, right+1))) {
			   int length = sb.length();
			   if(dotLeft ==3) {
				   sb.append(s.substring(index,right+1));
				   helper(s, sb, dotLeft-1, res, right+1);
				   sb.setLength(length);
			   }else {
				   sb.append("."+s.substring(index,right+1));
				   helper(s, sb, dotLeft-1, res, right+1);
				   sb.setLength(length);
			   }
		   }
		  
		   
	   }
	    
	    
	  }


	private static boolean isValid(String s) {
		if(s.length() > 3) return false;
		if(s.length() < 1) return false;
		if(s.charAt(0)=='0' && s.length() > 1) return false;
		if(Integer.valueOf(s) > 255) return false;
		
		return true;
	}

}
