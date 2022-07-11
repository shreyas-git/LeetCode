package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathtoGetFood_1730 {

	public static void main(String[] args) {
		
		char [][] grid = {{'X','X','X','X','X','X'}
						 ,{'X','*','O','O','O','X'},
						  {'X','O','O','#','O','X'},
						  {'X','X','X','X','X','X'}};
		
		System.out.println(getFood(grid));

	}

static int[][] dirs = new int[][] {{0,1}, {0, -1}, {1,0}, {-1, 0}};
    
    public static int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int step = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(grid[i][j]=='*'){
                   q.offer(new int[]{i,j});
                   break;
               }
           } 
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                int[] info=q.poll();
                int r = info[0];
                int c = info[1];
                
                if(grid[r][c]=='#'){
                    return step;
                }
                
              for(int[] dir:dirs)  {
                  int nextR = r + dir[0];
                  int nextC = c + dir[1];
                  
                  if(nextR>=0 && nextR<m && nextC>=0 && nextC<n && grid[nextR][nextC]!='X' &&!visited[nextR][nextC]){
                      visited[nextR][nextC] = true;
                      q.offer(new int[]{nextR,nextC});
                  }
              }
            }
            
            step++;
        }
        
        return -1;
    }
	  
}



