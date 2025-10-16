package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 */
public class NetWork_Delay_time_743 {
    public static void main(String[] args) {
       int [][] times = {{2,1,1},
                         {2,3,1},
                         {3,4,1}};
       int n = 4;
       int k = 2;

        System.out.println("MinTime to reach all n nodes="+ networkDelayTime(times,n,k));
    }

    public static int networkDelayTime(int[][] times, int V, int src) {

        int dis[] = new int[V+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;

        List<List<Edge>> graph = constructGraph(times,V);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,src});

        while(!pq.isEmpty()){

            int [] cur = pq.poll();
            int u = cur[1];

            for(Edge e: graph.get(u)){
                int v = e.to;
                int dest_time = e.time;

                if(dis[v] > dis[u] + dest_time){
                    dis[v] = dis[u] + dest_time;
                    pq.offer(new int[]{dis[v],v});
                }
            }

        }
        int i =1;
        int ans = -1;
        while(i <= V){
            if(dis[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,dis[i]);
            i++;
        }
return ans;
    }

    public static List<List<Edge>> constructGraph(int[][] times, int V) {
        List<List<Edge>> graph = new ArrayList<>();

        for(int i=0;i<=V;i++){
            graph.add(new ArrayList<>());
        }

      for(int[] time : times){
            graph.get(time[0]).add(new Edge(time[1],time[2]));
        }
return graph;
    }

    static class Edge {
        int to;
        int time;
        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }

    }
}
