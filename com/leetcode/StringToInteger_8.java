package com.leetcode;

public class StringToInteger_8 {

	public static void main(String[] args) {
		System.out.println(myAtoi("+-12"));

	}

	
	 public static  int myAtoi(String s) {
	        int sign =1;
	        int res =0;
	        
	        int i =0;
	        int n = s.length();
	        
	        //spaces
	        while(i<n && s.charAt(i) == ' '){
	          
	            i++;
	        }
	        
	         if(i<n && s.charAt(i) == '+'){
	               sign =1;
	            i++;
	        }else if(i<n && s.charAt(i) == '-'){
	             sign = -1;
	            i++;
	        }
	        
	         while(i<n && Character.isDigit( s.charAt(i)) ){
	             int digit = s.charAt(i) - '0'; //ASCII Value
	             
	             if((res > Integer.MAX_VALUE /10) || (res == Integer.MAX_VALUE/10 && digit >Integer.MAX_VALUE % 10)){
	                 return sign ==1 ?Integer.MAX_VALUE:Integer.MIN_VALUE;
	             }
	             res =res* 10 +digit;
	            i++;
	        }
	        
	        return res*sign;
	        
	    }
}
