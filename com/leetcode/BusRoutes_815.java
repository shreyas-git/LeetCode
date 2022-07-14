package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.

Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.

 

Example 1:

Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7,
 then take the second bus to the bus stop 6.
Example 2:

Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
Output: -1
 */
public class BusRoutes_815 {

	public static void main(String[] args) {
		// 1 -> 2 -> 7 bus 1
		// 3 -> 6 -> 7 bus 2 
		//move=0
		// 1 -> 2 -> 7(move++) -> 3-> 6(move++)
		
		int [][]routes = {{1,2,7},{3,6,7}};
		int source = 1, target = 6;
		System.out.println(numBusesToDestination(routes, source, target));
	}
	
/*
 * BFS Solution 
 * O(n^2) bcz of adjenecy list
 */
	    public static  int numBusesToDestination(int[][] routes, int source, int target) {
	        if(source == target) return 0;
	      
	        Map<Integer,List<Integer>> routeMap = new HashMap<>();
	      
	        // create an Adjacency list
	      for(int i =0 ;i< routes.length;i++){
	        for(int j=0;j<routes[i].length;j++){
	          
	          if(routeMap.containsKey(routes[i][j])){
	            List<Integer> list = routeMap.get(routes[i][j]);
	            list.add(i);
	            routeMap.put(routes[i][j],list);
	          }else{
	            List<Integer> list = new ArrayList();
	            list.add(i);
	            routeMap.put(routes[i][j],list );
	          }
	        }
	      }
	      
	      Set<Integer> visRoute = new HashSet();
	      Set<Integer> visBus = new HashSet(); // this is to reduce the time complexity 
	      Queue<Integer> q = new LinkedList();
	      
	        q.offer(source);
	        visRoute.add(source);
	      int busToReachTarget = 0;
	      while(!q.isEmpty()){
	        int size = q.size();
	        
	        for(int i=0;i<size;i++){
	          int stop = q.poll();
	          // got first route
	          //routes = [[1,2,7], // route = 0
	          //.         [3,6,7]], route = 1
	          //source = 1, target = 6
	          
	          if(stop == target) return busToReachTarget;
	          for(int route:routeMap.get(stop)){
	              if(visBus.contains(route)) continue;   // if route =0 i.e row 0 is already visited then we will be //adding all the stops by that route so don't need to traverse again
	              visBus.add(route);
	             for(int neighbour:routes[route]){ // 1,2,7
	               if(visRoute.contains(neighbour)) continue;
	                visRoute.add(neighbour);
	                q.offer(neighbour);
	             }
	          }
	        }
	        busToReachTarget++;
	      }
	      
	      return -1;    
	    }
	

}
