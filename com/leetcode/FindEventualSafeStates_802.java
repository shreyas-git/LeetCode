package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 

Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
 */
public class FindEventualSafeStates_802 {

	public static void main(String[] args) {
		int [][]graph = {{1,2},{2,3},{5},{0},{5},{},{}};
		System.out.println(eventualSafeNodes(graph));
		

	}
	
	  private static  Integer WHITE = 0; // not visited so far
      private static Integer  GREY = 1; // visited ,but found cylce
      private  static Integer BLACK = 2; // terminal node
      
      /*
       * DFS Soluton
       */
    public static  List<Integer> eventualSafeNodes(int[][] graph) {
        
   
      
      // step 1: mark all nodes as White 
      Map<Integer,Integer> nodeState = new HashMap();
      
      for(int i=0;i<graph.length;i++){
        nodeState.put(i,WHITE);
      }
      
      // step 2 dfs
      List<Integer> res = new ArrayList<>();
     for(int i=0;i<graph.length;i++){
        if(dfs(graph,i,nodeState)){
          res.add(i);
          
        }
       
      }
      
      return res;
    }
  
  public static boolean dfs(int [][]graph,int node,Map<Integer,Integer> nodeState){
    
    if(nodeState.get(node) == GREY) return false;
    if(nodeState.get(node) == BLACK) return true;
    
    nodeState.put(node , GREY);
    for(int nei:graph[node]){// nei = neighbour
      if(nodeState.get(nei) == WHITE){
        boolean isLoopExists = dfs(graph,nei,nodeState);
        if(isLoopExists == false){
          return false;
        }
      }else if(nodeState.get(nei) == GREY){
        return false;
    }
  }
    nodeState.put(node,BLACK);
    return true;
}

}
