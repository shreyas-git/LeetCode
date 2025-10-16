package com.Graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting_DFS {
    public static void main(String[] args) {
        int v = 4;
//        int[][] edges = {{2, 3}, {3, 1}, {4, 0},
//                {4, 1}, {5, 0}, {5, 2}};

        int[][] edges = {{1,0}, {2,0}, {3,1},
                {3,2}};

        int[] ans = topologicalSort(v, edges);

        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    private static int[] topologicalSort(int v, int[][] edges) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];

        LinkedList<Integer>[] adj = constructAdj(v,edges);
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topological_DFS(i,visited,stack,adj);
            }
        }
        int[] ans = new int[v];
        int index = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            ans[index++] = node;
        }
        return ans;
    }

    private static void topological_DFS(int v, boolean[] visited, Stack<Integer> stack, LinkedList<Integer>[] adj) {

        visited[v] = true;

        for(int i:adj[v]){
            if(!visited[i]){
                topological_DFS(i,visited,stack,adj);
            }
        }

        stack.push(v);
    }

    private static LinkedList<Integer>[] constructAdj(int v, int[][] edges) {
        LinkedList<Integer>[] adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

      for(int[] edge:edges){
          adj[edge[1]].add(edge[0]);// directed
      }
      return adj;
    }
}
