package com.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_in_Binary_Matrix_1091 {
    public static void main(String[] args) {

    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};

        int rows = grid.length;
        int cols = grid[0].length;


        // base case
        if(grid[0][0] != 0) return -1;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {0,0,0});

        while(!q.isEmpty()){
            int [] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // stop condition

            if(x == rows -1 && y == cols -1) return dist +1;

            for(int i=0;i<8;i++){
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                // boundary
                if(nx < 0 || nx >=rows ||
                        ny < 0 || ny >= cols ||
                        grid[nx][ny] !=0 ) continue;

                grid[nx][ny] = -1 ;
                q.offer(new int []{nx, ny, dist+1});

            }


        }
        return -1;
    }
}
