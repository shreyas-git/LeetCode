package com.leetcode;
/*
An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.

Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.

 

Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Example 3:

Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
Output: false
 */
public class RectangleOverlap_836 {

	public static void main(String[] args) {
		
		int [] rec1= {0,0,2,2};int  []rec2 = {1,1,3,3};
		System.out.println(isRectangleOverlap(rec1, rec2));

	}
	
	 public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
	        
	      // not overlapping use case
	      
	      // 1. rec 2 is on the right of rec 1
	      if(rec1[2] <= rec2[0]) return false;
	      
	      // 2. rec 2 is left side of rec 1
	      if(rec1[0] >= rec2[2])  return false;
	        
	      // 3. rec 2 is at the top of rec1
	        
	      if(rec1[3] <= rec2[1]) return false;
	      
	      // 4. rec2 is at the bottom of rec 1
	      if(rec1[1] >= rec2[3]) return false;
	      
	      
	      return true;
	      
	    }

}
