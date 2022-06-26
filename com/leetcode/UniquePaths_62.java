package com.leetcode;

import java.util.Arrays;

/*
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 */
public class UniquePaths_62 {

	/*
	 * Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
	 */
	public static void main(String[] args) {
		
		

	}
	
	 public int uniquePaths(int m, int n) {
	        int dp [][] = new int [m][n];
	        
	        for(int [] d:dp){
	            Arrays.fill(d,1);
	        }
	        
	        for(int i=1;i<m;i++){
	            for(int j=1;j<n;j++){
	                dp[i][j] = dp[i][j-1]+dp[i-1][j];
	            }
	        }
	        
	        return dp[m-1][n-1];
	    }

}
