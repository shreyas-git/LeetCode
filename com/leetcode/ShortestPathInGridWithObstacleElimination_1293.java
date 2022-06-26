package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/*
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 
 */
public class ShortestPathInGridWithObstacleElimination_1293 {

	public static void main(String[] args) {
		/*
		 * Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6.
 Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
		 */

		int [][]grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
		int  k = 1;
		System.out.println(shortestPath(grid, k));
		
	}
	
	
	 public static int shortestPath(int[][] grid, int k) {
		 // this is BFS based solution and it's easy 
		 int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		 Queue<StepState> queue = new LinkedList<>();
		 Set<StepState> vis = new HashSet();
		 int m = grid.length;
		 int n = grid[0].length;
		 
		 StepState start =  new StepState(0, 0, 0, k);
		 queue.offer(start);
		 vis.add(start);
		 
		 while(!queue.isEmpty()) {
			 StepState cur = queue.poll();
			 
			 // base case , this is when we reached target position 
			 if(cur.row==m-1 && cur.col==n-1) {
				 return cur.steps;
			 }
			 
			 
			 for(int [] nextDir :dir) {
				 // here we are getting all possible dir  left,right,up,down
				 int  x= nextDir[0];
				 int  y= nextDir[1];
				 
				 int nextX= cur.row+x;
				 int nextY = cur.col+y;
				 
				 
				 
				 // check the corner case , if directions move out of matrix then simply ignore
				 // as we need to proceed with next one
				 
				 if( 0 > nextX || nextX == m  || 0 > nextY  || nextY ==n) {
					 continue;
				 }
				 int remaining_obstacle = cur.k - grid[nextX][nextY];
				 StepState next_move =  new StepState(cur.steps+1, nextX, nextY, remaining_obstacle);
				 
				 if(remaining_obstacle >=0 && !vis.contains(next_move)) {
					 queue.offer(next_move);
					 vis.add(next_move);
				 }
				 
			 }
			 
		 }
		 
		 return -1;
	        
	    }

}

class StepState {
    /**
     * data object to keep the state info for each step:
     * <steps, row, col, remaining_eliminations>
     */
    public int steps, row, col, k;

    public StepState(int steps, int row, int col, int k) {
        this.steps = steps;
        this.row = row;
        this.col = col;
        this.k = k;
    }


	
    
    

    @Override
    public int hashCode() {
        // needed when we put objects into any container class
        return (this.row + 1) * (this.col + 1) * this.k;
    }

    @Override
    public boolean equals(Object other) {
        /**
         * only (row, col, k) matters as the state info
         */
        if (!(other instanceof StepState)) {
            return false;
        }
        StepState newState = (StepState) other;
        return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", this.row, this.col, this.k);
    }
}
