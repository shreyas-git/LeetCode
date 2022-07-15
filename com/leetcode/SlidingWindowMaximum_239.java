package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
public class SlidingWindowMaximum_239 {

	public static void main(String[] args) {
		
		int nums[] = {1,3,-1,-3,5,3,6,7};
		int k=3;
		System.out.println(maxSlidingWindow(nums, k));

	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
        
	      List<Integer> res = new ArrayList();
	      
	      int ws = 0;// window Start
	      
	      LinkedList<Integer> queue = new LinkedList<>();
	      for(int i=0;i<nums.length;i++){
	        
	        // step 1: Is Window crossed
	        // first check if we are out of window , Then remove the first element from the window is Window Start index
	        
	        if(i-ws >=k){
	          if(ws == queue.getFirst()){
	            queue.removeFirst();
	          }
	          ws++;
	        }
	        
	        // step2 : We Need to keep max element in the Queue, So if we are insertinf any max element then it should be always in first position , is the next element is smaller then simply append in the queue
	        while(!queue.isEmpty() && nums[i] > nums[queue.getLast()]){
	          queue.removeLast();
	        }
	        queue.offer(i);
	        
	        // step 3: is we reached the window size then add the first elemnet from the queue
	        if(i-ws == k-1){
	          res.add(queue.getFirst());
	        }
	        
	        
	        
	      }
	      int []maxElements = new int [res.size()];
	      int i=0;
	      for(int r:res){
	        maxElements[i++]= nums[r];
	        System.out.print(nums[r]+" ");
	      }
	      
	      return maxElements;
	    }

}
