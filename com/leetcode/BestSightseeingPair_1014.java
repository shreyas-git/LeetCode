package com.leetcode;

/*
You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

 

Example 1:

Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
Example 2:

Input: values = [1,2]
Output: 2
 */
public class BestSightseeingPair_1014 {

	public static void main(String[] args) {
		
		System.out.println(maxScoreSightseeingPair(new int[] {8,1,5,2,6}));

	}
	
	 /*
	  Approach : equation = values[i]+values[j]+i-j where j>i
	The above equation can also be written as values[i]+i+values[j]-j

	we observe that we just need to store values[i]+i and since we have to get the max value so we will be storing max value of value[i]+i as maxLeft since we have j > i.
	  */
	  public static int maxScoreSightseeingPair(int[] values) {
	       
	      int max =0;
	      int max_left=0;
	      for(int i=0;i<values.length;i++){
	        
	        max =Math.max(max, max_left+values[i]-i);
	        max_left  = Math.max(max_left,values[i]+i);
	          
	        
	      }
	      
	      return max;
	    }

}
