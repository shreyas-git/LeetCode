package com.leetcode;

public class Spiral_Matrix {

	public static void main(String[] args) {
		
		System.out.println(generateMatrix(3));

	}
	
	public static  int[][] generateMatrix(int n) {
		 int [][] res = new int [n][n];
		 
		 //// total possible layer = (n+1)/2
	        int count=1;
	     
	        for(int layer=0;layer < (n+1)/2;layer++) {
	        	
	        	//left to right
	        	for(int ptr=0;ptr < n-layer;ptr++)
	        		res[layer][ptr]= count++;
	        	
	        	//top tp bottom
	        	for(int ptr=layer+1; ptr < n-layer;ptr++)
	        		res[ptr][n-layer-1]= count++;
	        	
	        	//right to left
	        	for(int ptr=layer+1; ptr < n-layer;ptr++)
	        		res[n-layer-1][n-ptr-1] = count++;
	        	
	        	// bottom to top
	        	for(int ptr= layer+1 ;ptr< n-layer-1;ptr++)
	        		res[n-ptr-1][layer]= count++;
	        }
		 
		 
		 return res;
    }

}
