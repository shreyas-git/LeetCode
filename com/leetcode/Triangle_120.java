package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 */
public class Triangle_120 {

	public static void main(String[] args) {
		
		int [][] triangle =  {{2},{3,4},{6,5,7},{4,1,8,3}};
		
		 List< List<Integer> > nestedLists =
	                Arrays.
	                //Convert the 2d array into a stream.
	                stream(triangle).
	                //Map each 1d array (internalArray) in 2d array to a List.
	                map(
	                        //Stream all the elements of each 1d array and put them into a list of Integer.
	                        internalArray -> Arrays.stream(internalArray).boxed().collect(Collectors.toList()
	                    )
	        //Put all the lists from the previous step into one big list.
	        ).collect(Collectors.toList());
		
		System.out.println(minimumTotal(nestedLists));

	}

	
	public static  int minimumTotal(List<List<Integer>> triangle) {
	       int n = triangle.size() ;
	        
	    // start from last but one row 
	        
	        for(int row = n-2;row>=0;row--){
	            for(int col=0;col<triangle.get(row).size() ;col++){
	                int min_sum_below_row = Math.min(
	                                        triangle.get(row+1).get(col),
	                                        triangle.get(row+1).get(col+1)
	                                         );
	                
	                triangle.get(row).set(col,min_sum_below_row + triangle.get(row).get(col));
	            }
	        }
	        
	        return triangle.get(0).get(0);
	    }
}
