package com.leetcode;

import java.util.Stack;

public class MinStack_155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 Stack <Integer> stack ;
	    Stack <Integer> minStack;

	    public MinStack_155() {
	        stack = new Stack();
	         minStack = new Stack();
	    }
	    
	    public void push(int val) {
	        stack.push(val);
	        
	        if(minStack.isEmpty() || val <=minStack.peek() ){
	            minStack.push(val);
	        }
	        
	    }
	    
	    public void pop() {
	       int x=  stack.pop();
	        if(minStack.peek() == x){
	            minStack.pop();
	        }
	        
	        
	        
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int getMin() {
	        return minStack.peek();
	    }

}

