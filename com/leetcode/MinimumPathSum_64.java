package com.leetcode;
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 */
public class MinimumPathSum_64 {

	//https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns
	public static void main(String[] args) {
		int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));

	}
	
	public static  int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
      // fill first row
      for(int i=1;i<n;i++){ 
        grid[0][i] = grid[0][i-1]+grid[0][i];
      }
      
      //fill first column
      for(int j=1;j<m;j++){
        grid[j][0] = grid[j][0]+ grid[j-1][0];
      }
      
      //fill in Bottom-Up 
      for(int i=1;i<m;i++){
        for(int j=1;j<n;j++){
          grid[i][j] = Math.min(grid[i][j-1],grid[i-1][j])+grid[i][j];
        }
      }
      
      return grid[m-1][n-1];
    }

}
