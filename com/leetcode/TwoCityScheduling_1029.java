package com.leetcode;

import java.util.Arrays;

/*
A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

 

Example 1:

Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
Example 2:

Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
Output: 1859
Example 3:

Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
Output: 3086
 */
public class TwoCityScheduling_1029 {

	public static void main(String[] args) {
		
		int [][]costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
		System.out.println(twoCitySchedCost(costs));

		
	}
	
	 public static  int twoCitySchedCost(int[][] costs) {
	        //step 1: sort the price A- price B in asecnding order
	        // then first n/2 assign to city A the n/2 to city B
	      // [[10,20],[30,200],[400,50],[30,20]]
	// diff =   -10.    -170.     350     10 
	//.      [30,200]  [10,20] [30,20]  [400,50] after sort
	// city A = 30 + 10 = 40
	// city B = 20 + 50 = 70   total cost = 40 + 70 = 110
	      
	      Arrays.sort(costs, (cost1, cost2) -> ((cost1[0] - cost1[1]) - (cost2[0] - cost2[1])));
	      int total = 0;
	      for (int i=0;i<costs.length;i++){
	        if(i < costs.length/2) 
	            total += costs[i][0];
	          else
	            total += costs[i][1];
	        
	      }
	     return total;
	      
	    }

}
