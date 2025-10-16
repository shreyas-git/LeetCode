package com.Graph;

public class SurroundedRegions_130 {
    public static void main(String[] args) {
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        SurroundedRegions_130 ob = new SurroundedRegions_130();
        char[][] ans = ob.fill(4, 4, mat);
        for(int i = 0;i < 4;i++) {
            for(int j = 0;j < 4;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private char[][] fill(int rows, int cols, char[][] mat) {
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean visited[][] = new boolean[rows][cols];

        // check first row
        int firstRow = 0; int lastRow = rows-1;
        for(int col = 0;col < cols;col++) {
            if(visited[firstRow][col]== false
              && mat[firstRow][col]=='O') {
                dfs(0,col,visited,mat,dir);
            }

            if(visited[lastRow][col]== false
                && mat[lastRow][col]=='O') {
                dfs(lastRow,col,visited,mat,dir);
            }
        }

        int firstCol = 0; int lastCol = cols-1;

        for(int row = 0;row < rows;row++) {
            if(visited[row][firstCol]== false && mat[row][firstCol]=='O') {
                dfs(row,firstCol,visited,mat,dir);
            }
            if(visited[row][lastCol]== false && mat[row][lastCol]=='O') {
                dfs(row,lastCol,visited,mat,dir);
            }
        }

        for(int i = 0;i < rows;i++) {
            for(int j = 0;j < cols;j++) {
                if(visited[i][j]==false && mat[i][j]=='O') {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] mat, int[][] directions) {

        visited[row][col] = true;
        for(int []dir :directions ) {
            int nr = dir[0] + row;
            int nc = dir[1] + col;

            if(nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length &&
                visited[nr][nc] == false && mat[nr][nc]=='O') {
                dfs(nr, nc, visited, mat, directions);
            }
        }
    }
}
