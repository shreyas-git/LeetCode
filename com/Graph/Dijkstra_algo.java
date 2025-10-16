package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Dijkstra_algo {
    public static void main(String[] args) {

      int   src = 0;
      int V = 5;
       int edges[][] = {{0, 1, 4},
                        {0, 2, 8},
                        {1, 4, 6},
                        {2, 3, 2},
                        {3, 4, 10}};

       Arrays.stream(dijkstra_sol(src, V, edges))
                .forEach(e -> System.out.println("Shortest path = " + e));


    }

    private static int[] dijkstra_sol(int src, int V, int[][] edges) {
        int dist[] = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        List<List<Edge>> adj =   constructGraph(V, edges);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(distance -> distance[0])
        );

        pq.offer(new int[]{0, src});


        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            // int d = curr[0];
             int u = curr[1];

             for (Edge e : adj.get(u)) {
                int v = e.to ;
                int weight = e.weight;

                 if(dist[v] > dist[u] + weight) {
                     dist[v] = dist[u] + weight;
                     pq.offer(new int[]{dist[v], v});
                 }
             }

        }

return dist;

    }

    private static List<List<Edge>> constructGraph(int v, int[][] edges) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];
            adj.get(from).add(new Edge(to, weight));
        }
        return adj;
    }

    static class Edge {
        int to;
       int weight;
       public Edge(int to, int weight) {
           this.to = to;
           this.weight = weight;
       }

    }
}
