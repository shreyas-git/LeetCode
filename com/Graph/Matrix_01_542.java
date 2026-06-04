package com.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix_01_542 {

    public static void main(String[] args) {
        int mat [][] = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };


        Arrays.stream(updateMatrix(mat)).forEach(row -> {
            Arrays.stream(row).forEach(element ->
                    System.out.print(element + " ")
            );
            System.out.println(); // new line after each row
        });

    }

    private static int[][] updateMatrix(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        int dist[][] = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!visited[i][j] && mat[i][j] == 0){
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int x=cur[0];
            int y=cur[1];

            int [][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

            for (int i = 0; i < direction.length; i++){

                int newX = x + direction[i][0];
                int newY = y + direction[i][1];

                if( newX< 0 || newX>= row || newY<0 || newY>=col || visited[newX][newY]) {
                    continue;
                }else{
                    visited[newX][newY] = true;
                    dist[newX][newY] = dist[x][y] + 1;
                    queue.offer(new int[]{newX,newY});
                }
            }

        }

        return dist;
    }

}
