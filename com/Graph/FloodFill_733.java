package com.Graph;

public class FloodFill_733 {
    private static void printResult(int[][] ans) {
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] ans = floodFill(image, 1, 1, 2);
        printResult(ans);
    }



    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){

        // get initial color
        int initialColor = image[sr][sc];
        int [][] ans = image; //clone the image
        // possible direction
        int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        dfs_FloodFill(sr,sc,image,newColor,dir,initialColor,ans);
        return ans;
    }

    private static void dfs_FloodFill(int row, int col, int[][] image, int newColor, int[][] dir, int initialColor, int[][] ans) {
        ans[row][col] = newColor;
        int row_bound = image.length;
        int col_bound = image[0].length;

        for (int[] possible_dir : dir) {
            int x = possible_dir[0] + row;
            int y = possible_dir[1] + col;

        if(x>=0 && x<row_bound && y>=0 && y<col_bound // boundary check
                && image[x][y] == initialColor  // if original image not visited yet and match original colour
                && ans[x][y] != newColor)//this is kind of visited condition
         {
            dfs_FloodFill(x,y,image,newColor,dir,initialColor,ans);
          }
        }
    }
}
