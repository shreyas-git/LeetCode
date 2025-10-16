package com.Graph;


import java.util.LinkedList;
import java.util.Stack;

/*
210. Course Schedule 2
 */
class TopologicalSortCycle_DFS {

    public static void main(String[] args) {
        int v = 4;
//        int[][] edges = {{2, 3}, {3, 1}, {4, 0},
//                {4, 1}, {5, 0}, {5, 2}};

        int[][] edges = {{1,0}, {2,0}, {3,1},
                {3,2}};

        int[] ans = findOrder(v, edges);

        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        return topologicalSort(numCourses, prerequisites);
    }

    public static int[] topologicalSort(int v, int[][] edges) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        boolean[] onPath = new boolean[v]; // to detect cycles

        LinkedList<Integer>[] adj = constructAdj(v, edges);

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (hasCycleDFS(i, visited, onPath, stack, adj)) {
                    return new int[0]; // return empty array if cycle detected
                }
            }
        }

        int[] ans = new int[v];
        int index = 0;
        while (!stack.isEmpty()) {
            ans[index++] = stack.pop();
        }
        return ans;
    }

    // DFS with cycle detection
    public static boolean hasCycleDFS(int node, boolean[] visited, boolean[] onPath,
                                      Stack<Integer> stack, LinkedList<Integer>[] adj) {
        visited[node] = true;
        onPath[node] = true;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if (hasCycleDFS(neighbor, visited, onPath, stack, adj)) {
                    return true; // cycle detected
                }
            } else if (onPath[neighbor]) {
                return true; // back edge -> cycle
            }
        }

        onPath[node] = false;
        stack.push(node); // post-order
        return false;
    }

    // Correct edge direction: b → a for [a, b]
    private static LinkedList<Integer>[] constructAdj(int v, int[][] edges) {
        LinkedList<Integer>[] adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            adj[edge[1]].add(edge[0]); // b → a
        }
        return adj;
    }
}
