package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 */
public class RottingOranges_994 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int orangesRotting(int[][] grid) {
	        //Step 1 : collect the rotten orange indices
	      
	      int freshCount = 0;
	      
	      Queue<int[]> queue = new LinkedList<>();
	      int row = grid.length;
	      int col = grid[0].length;
	      
	      
	      
	      for(int i = 0;i<row;i++){
	        for(int j=0;j<col;j++){
	          if(grid[i][j] == 2){
	            queue.add(new int[]{i,j});
	          }else if(grid[i][j] == 1){
	            freshCount++;
	          }
	        }
	      }
	      if(freshCount ==0 ){
	        return 0;
	      }
	      
	      
	      // step 2: rot the oranges 
	      int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	      
	      int elaspsedTime =0;
	      
	      while(!queue.isEmpty()){
	        elaspsedTime++; // pre process means already one rotten orange in the queue
	        int qSize = queue.size();
	        
	        for(int i=0;i<qSize;i++){
	          int [] rottenOrangeLocation = queue.remove();
	          //try to rott the orange in top , bottom , left , right
	          for(int [] possible_dir : dir){
	            int x = possible_dir[0] + rottenOrangeLocation[0];
	            int y = possible_dir[1] + rottenOrangeLocation[1];
	            
	            
	          //check for the boundaries 
	            if( x< 0 || x>= row || y<0 || y>=col || grid[x][y] == 2 || grid[x][y] == 0){
	              continue;
	            }else{
	              grid[x][y]= 2;
	              queue.add(new int[]{x,y});
	              freshCount--;
	            }
	          }
	        }
	      }
	      
	      return freshCount >0?-1:elaspsedTime-1;
	    }

}
