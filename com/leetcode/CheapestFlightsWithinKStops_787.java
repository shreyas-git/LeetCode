package com.leetcode;

import java.util.Arrays;

/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
 */
public class CheapestFlightsWithinKStops_787 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  n = 4;
		int [][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
		int src = 0, dst = 3, k = 1;
		System.out.println(findCheapestPrice(n, flights, src, dst, k));
	}

	/*
	 * Bellmamford Algorithm  (n -1) iteration 
	 But in this algo we have to dp k+1 iteration
	 * time = O(v .k)
	 * 
	 */
	 public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		 int [] cost = new int [n];
		 
		 Arrays.fill(cost, Integer.MAX_VALUE);
		 cost[src] = 0;
		 
		 for(int i=0;i<k+1;i++) {
			 int temp [] = Arrays.copyOf(cost, n);
			 for(int []f:flights) {
				 int source = f[0],dest=f[1],price=f[2];
				 
				 if(cost[source] == Integer.MAX_VALUE) continue;
				 
				 temp[dest] = Math.min(temp[dest], price+cost[source]);
				 
				 
			 }
			 cost = temp;
		 }
		 
		 return cost[dst] == Integer.MAX_VALUE?-1:cost[dst];
	 }
}
