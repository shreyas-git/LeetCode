package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args)
    {
        int V = 5;
        int[][] edges = {
                {0, 1}, {0, 2}, {0, 3}, {1, 2}, {3, 4}
        };

        if (isCycle(V, edges)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    private static boolean isCycle(int v, int[][] edges) {
        List<Integer>[] adj =constructadj(v, edges);

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                if(dfsUtil(i,adj,visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsUtil(int v, List<Integer>[] adj, boolean[] visited, int parent) {
        visited[v] = true;

        for (int i : adj[v]) {
            if (!visited[i]) {
                   if(dfsUtil(i,adj,visited,v))
                    return true;
            }
            else if( v != parent){
                return true;
            }
        }

        return false;
    }

    static  List<Integer>[] constructadj(int V, int [][] edges){

        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        return adj;
    }
}
