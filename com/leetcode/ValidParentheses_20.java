package com.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses_20 {

	public static void main(String[] args) {
		
		System.out.println("is valid="+isValid("(]"));

	}
	
	 public static  boolean isValid(String s) {
		 
		 HashMap<Character,Character> map=new HashMap<Character,Character>();
	        map.put(')','(');
	        map.put(']','[');
	        map.put('}','{');
	        Stack<Character> stack = new Stack<>();
	        
	        for(int i=0;i<s.length();i++) {
	        	char c = s.charAt(i);
	        	if(map.containsKey(c)) {
	        		if(stack.isEmpty() || map.get(c) != stack.pop()) {
	        			return false;
	        		}
	        	}else {
	        		stack.push(c);
	        	}
	        }
		return true;
	        
	    }

}
