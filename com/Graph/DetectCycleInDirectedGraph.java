package com.Graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        int V= 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        Graph g = new Graph(V, adj);

        g.addDirected(0,1);
      //  g.addDirected(2,1);
        g.addDirected(2,3);
        g.addDirected(3,4);
        g.addDirected(4,5);
       // g.addDirected(5,3);

        System.out.println("is cycle :{}" +detectCycle(g, V));
    }

    private static boolean detectCycle(Graph g, int v) {
        boolean[] visited = new boolean[v];
        boolean[] recursionStack = new boolean[v];


        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfsCycleUtil_1(g, visited, recursionStack, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfsCycleUtil_1(Graph g, boolean[] visited, boolean[] recursionStack, int start) {

        if( visited[start]) { return false; }
        if( recursionStack[start]) { return true; }
        visited[start] = true;
        recursionStack[start] = true;



        for (int neighbor : g.getAdj(start)) {
            if (!visited[neighbor] && dfsCycleUtil_1(g, visited, recursionStack, neighbor)) {
                return true;
            } else if (recursionStack[neighbor]) {
                return true;
            }
        }

        recursionStack[start] = false;
        return false;
    }
}
