package com.leetcode;

/*
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
 */
public class MinCostToClaimbStairs_746 {

	
	public static void main(String[] args) {
		/*
		 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
		 */
		
		int cost[] = {10,15,20};//{1,100,1,1,1,100,1,1,100,1};
		System.out.println(minCostClimbingStairs(cost));

	}
	
	 public static int minCostClimbingStairs(int[] cost) {
	        int [] mincost = new int [cost.length+1];
	         mincost[0] = 0;
	         mincost[1] = 0;
	        
	        //10 ,15 ,20
	        for(int i=2;i<mincost.length;i++){
	        	int a = (mincost[i-1]+cost[i-1]);
	        	int b =(mincost[i-2]+cost[i-2]);
	            mincost[i] = Math.min((mincost[i-1]+cost[i-1]),(mincost[i-2]+cost[i-2]));
	        }
	        
	        return mincost[mincost.length -1];	
	    }

}
