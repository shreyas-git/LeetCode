package com.leetcode;

public class RotateImage_48 {

	public static void main(String[] args) {
		
		int matrix [][] = { {1,2,3},
							{4,5,6},
							{7,8,9}  };
		
		System.out.println("before ");
		Print(matrix);
		
		transpose(matrix);
		reverteimage(matrix);
		
		System.out.println("after ");
		Print(matrix);
	}
	
	
	private static void Print(int[][] matrix) {
		int N = matrix.length;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}


	public static void transpose(int[][] matrix) {
	      int N = matrix.length;
	        
	        
	        //transpose the matix
	        for(int i=0;i<N;i++){
	            for(int j=i;j<N;j++){  //this is the main step
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = temp;
	            }
	        }
	    }
	
	public static void reverteimage(int[][] matrix) {
	      int N = matrix.length;
	        
	        
	        //transpose the matix
	        for(int i=0;i<N;i++){
	            for(int j=0;j<(N/2);j++){  //this is the main step
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[i][N-1-j];
	                matrix[i][N-1-j] = temp;
	            }
	        }
	    }

}
