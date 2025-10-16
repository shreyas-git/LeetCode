package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestflightsWithin_K_Stops {
    public static void main(String[] args) {

       int  n = 4;
       int [][] flights = new int[][]
                               {{0,1,100}
                               ,{1,2,100}
                               ,{2,0,100}
                               ,{1,3,600}
                               ,{2,3,200}};
      int  src = 0 ,dst = 3, k = 1;

      int cost = findCheapestPrice(n,flights,src,dst,k);

        System.out.println(
                "Cost: " + cost
        );


    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        List<List<Edge>> adj =  constructGraph(n, flights);

        PriorityQueue<int []> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );

            pq.offer(new int[]{0,src,0}); // cost, src, stops

            while(!pq.isEmpty()){
                int [] curr = pq.poll();

                int u = curr[1];
                int cost = curr[0];
                int stops = curr[2];

               if(u == dst) return cost;
               if(stops > k) continue;


                for(Edge e: adj.get(u)){
                    int v = e.to;
                    int price = e.weight;


                    if(dist[v] > dist[u] + price){
                        dist[v] = dist[u] + price;
                        pq.offer(new int[]{dist[v],v,stops+1});
                    }
                }

            }
return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    private static List<List<Edge>> constructGraph(int n, int[][] flights) {
        List<List<Edge>> graph = new ArrayList<List<Edge>>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < flights.length; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];
            graph.get(from).add(new Edge(to,cost));

        }
        return graph;
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
