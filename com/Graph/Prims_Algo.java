package com.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_Algo {

    public static void main(String[] args) {
        int graph[][] = new int[][] {{0,1,5},
                {1,2,3},
                {0,2,1}};

        System.out.println(spanningTree(3,3,graph));



    }

    /*
    V - vertices
    E - Edges
     */
    private static int spanningTree(int V, int E, int[][] graph) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<graph.length;i++){
            int u =  graph[i][0];
            int v = graph[i][1];
            int wt = graph[i][2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.offer(new Pair(0,0));

        int vis[] = new int[V];

        int ans = 0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();

            int v =  p.v;
            int wt = p.wt;

            if(vis[v]==1)continue;

            ans = ans+ wt;
            vis[v]=1;

            for(Pair pair:adj.get(v)){
                if(vis[pair.v]==0){
                    pq.offer(new Pair(pair.v,pair.wt));
                }
            }

        }
        return ans;
    }

    static class Pair implements Comparable<Pair>
    {
        int v;
        int wt;
        Pair(int v,int wt)
        {
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(Pair that)
        {
            return this.wt-that.wt;
        }
    }

}
