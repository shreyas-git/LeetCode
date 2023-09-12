package com.recursion;

import java.util.Stack;

public class SortStackUsingRecursion {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(5);
		stack.push(2);
		
		System.out.println(stack.toString());
		
		sort(stack,stack.size());
	
		System.out.println(stack.toString());
	}

	private static void sort(Stack stack, int size) {
		
		if(size<=1) {
			return;
		}
		 int last = (int) stack.pop();
		 sort(stack, stack.size());
		 
		 insert(stack,last);
	}

	private static void insert(Stack stack, int last) {
		
		if(stack.size()==0 || (int)stack.peek() <= last) {
			stack.push(last);
			return;
		}
		int temp = (int) stack.pop();
		
		insert(stack, last);
		stack.push(temp);
		
	}

}
