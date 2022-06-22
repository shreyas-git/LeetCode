package com.leetcode;

public class NumberOfIslands {

	public static void main(String[] args) {
	char[][]	grid = {
		        {'1','1','1','1','0'},
		        {'1','1','0','1','0'},
		        {'1','1','0','0','0'},
		        {'0','0','0','0','0'}
		      };

	System.out.println(numIslands(grid));
	}
	
	public static  int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }
        
        int numIslands= 0;
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    
                    dfs(grid,i,j,vis);
                    numIslands ++;
                }
            }
        }
        
        return numIslands;
    }
    
    public static void dfs(char[][] grid , int i ,int j,boolean [][] vis){
        if(i<0 || i>= grid.length || j<0 || j >= grid[0].length || vis[i][j] || grid[i][j] == '0'){
            return ;
        }
        vis[i][j] = true;
        
        dfs(grid,i+1,j,vis);
        dfs(grid,i-1,j,vis);
        dfs(grid,i,j+1,vis);
        dfs(grid,i,j-1,vis);
        
        
        
        
        
    }

}
