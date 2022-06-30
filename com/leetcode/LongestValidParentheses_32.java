package com.leetcode;

import java.util.Stack;

/*
 * 
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0

 */
public class LongestValidParentheses_32 {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()"));

	}
	
	public  static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max_len =0 ;
        stack.push(-1); // this is the main thing , bcz if we encounter () then length should be 2 
        // () these are at index (0,1)  so (1 - (0)) will leads to 1 , so we have to push -1 int stack first 
        // so it will be (1 - (-1)) = 2;
        
        for(int i =0;i< s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max_len = Math.max(max_len, i-stack.peek());
                }
                
            }
        }
        
        return max_len;
    }

}
