package com.leetcode;

import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		int [] height = {7,1,4,0,2,8,6,3,5};
		System.out.println(trap(height));

	}
	
	
public static  int trap(int[] height) {

    
    //stack based solution 
    
    Stack<Integer> stack = new Stack();
    
    int cur =0;
    int res=0;
    int n = height.length;
    while(cur < n){
        
        while(!stack.isEmpty() && height[cur] > height[stack.peek()]){
            int top = stack.peek();
            //  here find max water can store in previous hieght ,bcz now we got height greater than previous height(there should be cup like structure to hold water in it)
            stack.pop();
            
            if(stack.isEmpty()) break;
            
            int dis = cur - stack.peek() -1;
            
            int b_h = Math.min(height[cur],height[stack.peek()]) - height[top];
            
            res = res + dis*b_h;
            
        }
        stack.push(cur);
        cur++;
    }
    
    return res;
}

}
