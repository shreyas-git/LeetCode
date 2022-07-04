package com.leetcode;

import java.util.Stack;

/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
 */
public class LargestRectangleinHistogram_84 {

	public static void main(String[] args) {
		int []heights = {6,2,5,4,1,5,6};
		System.out.println(largestRectangleArea(heights));

	}
	
	 public static  int largestRectangleArea(int[] heights) {
		 
		 Stack<Integer> stack = new Stack<>();
		 int res=0;
		 int n = heights.length;
		 for(int cur=0;cur<n;cur++) {
			 while(!stack.isEmpty() && heights[stack.peek()] > heights[cur]) {
				 int top = stack.pop();
				 int dis = stack.isEmpty()?cur:cur-stack.peek() -1;
				 int b_h = dis * heights[top];
				 res = Math.max(res, b_h);
			 }
			 stack.push(cur);
		 }
		 
		 // stack will be don't have next smaller element
		 // by this line stack will have 1,5,6
		 
		 while(!stack.isEmpty()) {
			 int top = stack.pop();
			 int dis = stack.isEmpty()? n:n - stack.peek() -1;
			 int b_h = dis * heights[top];
			 res = Math.max(res, b_h);
		 }
		 return res;
	 }
	
	/*
	 * O(n^2)
	 */
	 public static  int largestRectangleArea_TLE(int[] heights) {
	        int n = heights.length;
	      
	      int res= 0;
	      for(int i=0;i<n;i++){
	        int cur = heights[i];
	        
	        for(int j=i-1;j>=0;j--){
	          
	        if(heights[j] >= heights[i])
	            cur = cur+ heights[i];
	          else
	            break;
	            
	        }
	        
	        for(int j=i+1;j<n;j++){
	          if(heights[j] >= heights[i])
	            cur = cur+ heights[i];
	          else
	            break;
	        }
	        
	        res = Math.max(res,cur);
	      }
	      
	      return res;
	    }

}
