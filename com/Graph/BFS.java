package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));
        
        
        ArrayList<Integer> ans = bfs(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int s = 0;
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true; // visited of source node to true

        q.offer(s);
        while (!q.isEmpty()) {
            s = q.poll();
            ans.add(s);
            for (int i : adj.get(s)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return ans;
    }

    ArrayList<Integer> bfsDisconnected(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        // create an array to store the traversal
        ArrayList<Integer> res= new ArrayList<>();

        // Initially mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // perform BFS for each node
        for (int i = 0; i < adj.size(); ++i) {
            if (!visited[i]) {
                bfs(adj, i, visited, res);
            }
        }

        return res;
    }

    private void bfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, ArrayList<Integer> res) {
    }
}
