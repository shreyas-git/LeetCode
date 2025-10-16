package com.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
khan based algo
207.Course Schedule
 */
 class TopologicalSorting_BFS{

    public static void main(String[] args) {
        int N = 4;
        int [][]prerequisites = new int[3][2];
        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;

        prerequisites[1][0] = 2;
        prerequisites[1][1] = 1;

        prerequisites[2][0] = 3;
        prerequisites[2][1] = 2;


        boolean ans = isPossible(N, prerequisites);
        if (ans)
            System.out.println("YES");
        else
            System.out.println("NO");
    }




    public static boolean isPossible(int V, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
 

         int []indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        List<Integer> topologicalSort = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topologicalSort.add(node);

            for(int i : adj.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0)
                    q.offer(i);
            }
        }
        if (topologicalSort.size() == V)  return true;
        return false;
    }
}


