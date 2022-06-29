package com.leetcode;

import java.util.Stack;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
 */
public class EvaluateReversePolishNotation_151 {

	public static void main(String[] args) {
		
		String []tokens = {"4","3","-"};
		System.out.println(evalRPN(tokens));
	}
	
	 public static  int evalRPN(String[] tokens) {
	        
	        Stack<Integer> stack = new Stack<>();
	        
	        String operators = "+-*/";
	        
	       
	        for(String t:tokens){
	            if(!operators.contains(t)){
	                stack.push(Integer.valueOf(t));
	            }else{
	                int a = stack.pop();
	                int b = stack.pop();
	                
	                switch(t){
	                        case "+":
	                       
	                            stack.push(b+a);
	                                break;
	                        case "-":
	                            stack.push(b-a);
	                                break;
	                        case "*":
	                            stack.push(b*a);
	                              break;
	                        case "/":
	                            stack.push(b/a);
	                        break;
	                }
	            }
	            
	           
	            
	        }
	      return stack.pop();  
	    } 

}
