package com.leetcode;
/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
 */
public class MinimumFallingPathSum_931 {

	public static void main(String[] args) {
		int [][]matrix = {{2,1,3},{6,5,4},{7,8,9}};
		System.out.println(minFallingPathSum(matrix));
		//https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns

	}
	
	 public static int minFallingPathSum(int[][] matrix) {
	        int m = matrix.length;
	      int n = matrix[0].length;
	      
	      for(int i = 1;i<m ;i++){
	        for(int j=0;j<n;j++){
	            if(j==0){
	               matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j+1]);
	            }
	          else if(j== n-1){
	            matrix[i][j] += Math.min(matrix[i-1][j-1],matrix[i-1][j]);
	          }
	          else{
	              matrix[i][j] += minOfThree(matrix[i-1][j-1], // top left diagonal
	                                    matrix[i-1][j], //  exact top 
	                                    matrix[i-1][j+1]);// top right diagonal
	          }

	        }
	      }
	      
	      // now we have last row filled with min sum 
	      // find min in last row
	      
	      int res = Integer.MAX_VALUE;
	      
	      for(int col=0;col<n;col++){
	        res = Math.min(res, matrix[m-1][col]);
	      }
	      
	      return res;
	    }
	  
	  
	  public static int minOfThree(int a,int b,int c){
	    return Math.min(a,Math.min(c,b));
	  }

}
