package com.Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph{
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

    public void addDirected(int u, int v) {
        //Bi -directional
        this.adj.get(u).add(v);
      //  this.adj.get(v).add(u);
    }



    public int getV() {
        return v;
    }



    public void setV(int v) {
        this.v = v;
    }



    public ArrayList<Integer> getAdj(int start) {
        return adj.get(start);
    }

    public ArrayList<ArrayList<Integer>> getAdj() {
        return adj;
    }



    public void setAdj(ArrayList<ArrayList<Integer>> adj) {
        this.adj = adj;
    }

    public List<Integer> getAdjs(int v) {
        return adj.get(v);
    }

}