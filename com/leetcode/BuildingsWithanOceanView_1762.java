package com.leetcode;

import java.util.Stack;

/*
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.

Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 */
public class BuildingsWithanOceanView_1762 {

	public static void main(String[] args) {
		
		/*
		 * Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
		 */
		int []heights = {4,2,3,1};
		
System.out.println(findBuildings(heights));
	}
	
	public static  int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length-1;
       
        for(int i=n;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                if(heights[stack.peek()] < heights[i]){
                     stack.push(i);
                }
            }
            
        }
        int res[] = new int[stack.size()];
        int size = stack.size();
        for (int j = 0; j < size; j++) {
        	res[j] = stack.pop();
        	System.out.print(res[j]+",");
        }
             
        
        return res;
    }

}
