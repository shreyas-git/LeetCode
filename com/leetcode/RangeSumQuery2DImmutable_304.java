package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class RangeSumQuery2DImmutable_304 {

	public static void main(String[] args) {
		
		int matrix [][] = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
		NumMatrix numMatrix = new NumMatrix(matrix);
		numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
		numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
		numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)


	}
	
	 

}


class NumMatrix{
	int matrix [][] ;
	  Map<String,Integer> cache = new HashMap<>();
	    public NumMatrix(int[][] matrix) {
	        this.matrix = matrix;
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	      String key = ""+row1+row2+col1+col2;
	      if(cache.containsKey(key)){
	        return cache.get(key);
	      }
	        int sum =0;
	      for(int i=row1;i<=row2;i++){
	        for(int j = col1;j<=col2;j++){
	          sum += matrix[i][j];
	        }
	      }
	      cache.put(key,sum);
	      return sum;
	    }
}