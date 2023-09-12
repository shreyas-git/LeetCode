package com.leetcode;

import java.util.ArrayList;

public class DFS {

	public static void main(String[] args) {
		int V= 7;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

		Graph g = new Graph(V, adj);
		
		g.addEdge(0,1); 
    	g.addEdge(0,2); 
    	g.addEdge(2,3); 
    	g.addEdge(1,3); 
    	g.addEdge(1,4);
    	g.addEdge(3,4);
    	
    	DFS(g, 0);
    	
	}

	static void DFS(Graph g, int s) {
		ArrayList<ArrayList<Integer>> adj = g.getAdj();
		int v= g.getV();
		
		boolean[] visited = new boolean[v];
		
		DFSRec(adj,s,visited);
	}
	
	static void DFSRec(ArrayList<ArrayList<Integer>> adj,int s,boolean []visited) {
		
		visited[s]= true;
		System.out.println("Visited node ="+s);
		
		for(int u : adj.get(s)) {
			if(visited[u]==false) {
				DFSRec(adj,u,visited);
			}
		}
	}
}

 class Graph{
	 int v;
	 
	 private ArrayList<ArrayList<Integer>> adj;

	public Graph(int v, ArrayList<ArrayList<Integer>> adj) {
		super();
		this.v = v;
		this.adj = adj;
	}
	 
	 
	
	public void addEdge(int u, int v) {
		//Bi -directional 
		this.adj.get(u).add(v);
		this.adj.get(v).add(u);
	}



	public int getV() {
		return v;
	}



	public void setV(int v) {
		this.v = v;
	}



	public ArrayList<ArrayList<Integer>> getAdj() {
		return adj;
	}



	public void setAdj(ArrayList<ArrayList<Integer>> adj) {
		this.adj = adj;
	}
	 
	
}
