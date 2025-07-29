package com.recursion;

import java.util.Stack;

public class DeleteMiddleElementInStack {

	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack.toString());
		
		solve(stack,stack.size());
	
		System.out.println(stack.toString());

	}

	private static Stack<Integer> solve(Stack<Integer> stack, int size) {
		
		if(stack.size()==0)return stack ;
		int mid = stack.size()/2 +1;
		
		deleteKthElement(stack,mid);
		
		return stack;
		
	}

	private static void deleteKthElement(Stack<Integer> stack, int mid) {
		
		if(1 == mid) {
			stack.pop();return;
		}
		int top = stack.pop();
		
		deleteKthElement(stack, mid-1);
		
		stack.push(top);
		
	}

}
