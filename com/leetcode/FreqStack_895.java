package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack_895 {

	public static void main(String[] args) {
		
		FreqStack_895 freqStack = new FreqStack_895();
		freqStack.push(5); // The stack is [5]
		freqStack.push(7); // The stack is [5,7]
		freqStack.push(5); // The stack is [5,7,5]
		freqStack.push(7); // The stack is [5,7,5,7]
		freqStack.push(4); // The stack is [5,7,5,7,4]
		freqStack.push(5); // The stack is [5,7,5,7,4,5]
		System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
		System.out.println(freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
		System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
		System.out.println(freqStack.pop());   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].

	}
	
	 Map<Integer,Integer>  valueFreq;
	  Map<Integer,Stack<Integer>> freqStack;
	  int maxFreq=0;
	    public FreqStack_895() {
	        valueFreq= new HashMap<>();
	        freqStack = new HashMap<>();
	    }
	    
	    public void push(int val) {
	        int newFreq = valueFreq.getOrDefault(val,0)+1;
	      if(newFreq>maxFreq){
	        maxFreq = newFreq;
	      }
	      valueFreq.put(val,newFreq);
	       Stack<Integer> stack;
	      if(freqStack.containsKey(newFreq)){
	        stack = freqStack.get(newFreq);
	        stack.push(val);
	      }else{
	        stack = new Stack<>();
	        stack.push(val);
	        freqStack.put(newFreq,stack);
	      }
	      
	    }
	    
	    public int pop() {
	        Stack<Integer> stack = freqStack.get(maxFreq);
	        int valRemoved = stack.pop();
	      valueFreq.put(valRemoved,valueFreq.get(valRemoved)-1);
	      if(stack.isEmpty()){
	        maxFreq--;
	      }
	      return valRemoved;
	      
	    }

}
