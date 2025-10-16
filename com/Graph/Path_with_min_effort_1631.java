package com.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Path_with_min_effort_1631 {
    public static void main(String[] args) {
        int [][] heights = {{1,2,2},{3,8,2},{5,3,5}};

        int minPath = minimumEffortPath(heights);
        System.out.println("Minimum effort path is " + minPath);
    }

    private static int minimumEffortPath(int[][] heights) {
        int rows =  heights.length;
        int cols =  heights[0].length;

        // 1. applying Dijkstra
        // distance array
        int dist[][] = new int[rows][cols];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = 0;

        // take PQ with min distance
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));

        // start with source
        pq.offer(new Edge(0,new int[]{0,0}));

        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!pq.isEmpty()) {
            Edge u = pq.poll();

            int distance = u.distance;
            int x = u.cell[0];
            int y = u.cell[1];

            // check if the destination is reached
             if(x == rows - 1 && y == cols - 1)  return distance;

             for (int i = 0; i < 4; i++) {
                 int nx  = x + dir[i][0];
                 int ny  = y + dir[i][1];

                 if(nx >=0 && nx < rows && ny >=0 && ny < cols){
                   int newDist = Math.max( Math.abs(heights[x][y] - heights[nx][ny])
                                         , distance);

                   if(newDist < dist[nx][ny]){
                       dist[nx][ny] = newDist;
                       pq.offer(new Edge(newDist,new int[]{nx,ny}));
                   }
                 }
             }


        }

        return -1 ;
    }

    static class Edge {
        int distance;
        int cell[];

        public Edge(int distance, int[] cell) {
            this.distance = distance;
            this.cell = cell;
        }
    }
}
