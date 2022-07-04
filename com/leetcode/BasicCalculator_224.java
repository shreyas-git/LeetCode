package com.leetcode;

import java.util.Stack;
/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 */
public class BasicCalculator_224 {

	public static void main(String[] args) {
		
		 System.out.println(calculate("12-2-(3-78)"));// o/p = 85

	}
	
	
	 public static  int calculate(String s) {
	        int cur_num =0; // hold cur num if String is "12" then it will convert it as 12
	        int sign = 1;  // hold sign 
	        int res = 0;
	        Stack<Integer> stack = new Stack();
	      // "12-2-(3-78)"
	        for(int i=0;i< s.length();i++){
	          char ch= s.charAt(i);
	          
	          if(Character.isDigit(ch)){
	            cur_num = cur_num * 10 + ch - '0'; // 12
	            
	            // whenever encounter  + or - , 
	            //calculate the res and update the cur_num =0 and sign    
	          }else if(ch =='+'){
	            res = res + sign * cur_num;
	            sign = 1;
	            cur_num =0;
	            
	          }else if(ch == '-'){
	            res = res + sign * cur_num;
	             sign = -1;
	            cur_num =0;
	            
	          }else if(ch == '('){
	          // hold the previous answer in to the stack   
	            stack.push(res);
	            stack.push(sign);
	         
	            // update the res and sign to default as we have these values in stack
	            res = 0;
	            sign =1;
	            
	          }else if(ch == ')'){
	            
	        	  
	        	 //update the current result 
	            res = res + sign * cur_num;
	            
	            // here stack contains [10 , -1]
	            // update the sign first 
	            res = res * stack.pop();
	            
	            // update the result with current result
	            res = res + stack.pop();
	            
	            // set the cur number to default
	            cur_num = 0; 
	      
	          }
	          
	          
	          
	          
	        }
	      
	        // check if there is any sign and cur_num left;
	      return res + (sign * cur_num);
	      
	    }

}
