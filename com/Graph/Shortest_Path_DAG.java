package com.Graph;

import java.util.*;

/*
     (0)
    /   \
 5/     \3
 /       \
(1)---2-->(2)
 |        |\
6|        | \2
 |        |  \
(3)<--7---   (5)
  |         /
 -1        /
  |       /4
 (4)<-----
     \
     -2
      \
     (5)

 */
public class Shortest_Path_DAG {

    static final int INF=Integer.MAX_VALUE;

    class AdjListNode
    {
        private int v;
        private int weight;
        AdjListNode(int _v, int _w) { v = _v;  weight = _w; }
        int getV() { return v; }
        int getWeight()  { return weight; }
    }

    public static void main(String[] args) {
        Shortest_Path_DAG t = new Shortest_Path_DAG();
        Graph g = t.newGraph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.println("Following are shortest distances "+
                "from source " + s );
        g.shortestPath(s);
    }

    Graph newGraph(int number)
    {
        return new Graph(number);
    }

    class Graph {
        private LinkedList<AdjListNode> adj[];
        private int V;

        Graph(int V){
            this.V = V;
            adj=new LinkedList[V];
            for(int i=0;i<V;i++)
                adj[i]=new LinkedList<AdjListNode>();
        }
        void addEdge(int u, int v, int weight){
            AdjListNode node=new AdjListNode(v,weight);
            adj[u].add(node);
        }


        public void shortestPath(int s) {

            // step 1: do the topological sorting
            Stack<Integer> stack=new Stack();

          boolean[] visited=new boolean[V];

          for (int i = 0; i < V; i++) {
              if(!visited[i]) {
                  topological_sort_dfs(i,visited,stack);
              }
          }

          // step 2: create dist array

            int dist[] = new int[V];
            Arrays.fill(dist,INF);

            dist[s] = 0;
          //step 3: process vertices in topological order
          while(!stack.isEmpty()){
           int u =  stack.pop();

           if(dist[u]==INF)continue;

           for (AdjListNode node: adj[u]) {
               int v = node.v;
               int weight = node.weight;

               if (dist[v] > dist[u] + weight) {
                   dist[v] = dist[u] + weight;
               }
           }

          }

            // Print the calculated shortest distances
            for (int i = 0; i < V; i++)
            {
                if (dist[i] == INF)
                    System.out.print( "INF ");
                else
                    System.out.print( dist[i] + " ");
            }

        }

        private void topological_sort_dfs(int v, boolean[] visited, Stack<Integer> stack) {

            visited[v]=true;

            for (AdjListNode node: adj[v]) {
                if(!visited[node.v]) {
                    topological_sort_dfs(node.getV(),visited,stack);
                }
            }


            stack.push(new Integer(v));

        }
    }


}
