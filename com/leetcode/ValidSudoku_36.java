package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
 */
public class ValidSudoku_36 {

	public static void main(String[] args) {
		
      char [][] board = {  {'5','3','.','.','7','.','.','.','.'}
					      ,{'6','.','.','1','9','5','.','.','.'}
					      ,{'.','9','8','.','.','.','.','6','.'}
					      ,{'8','.','.','.','6','.','.','.','3'}
					      ,{'4','.','.','8','.','3','.','.','1'}
					      ,{'7','.','.','.','2','.','.','.','6'}
					      ,{'.','6','.','.','.','.','2','8','.'}
					      ,{'.','.','.','4','1','9','.','.','5'}
					      ,{'.','.','.','.','8','.','.','7','9'}};
      
      
      
      
      System.out.println(isValidSudoku_1(board));
      
      
      helper(board);
      
      System.out.println(isValidSudoku_1(board));
	}
	
	
	
	public static boolean isValidSudoku_1(char[][] board) {
		int N=9;
		Set<String> seen = new HashSet<>();
		
		for(int i=0;i<N;i++){
	          for(int j=0;j<N;j++){
	            char val = board[i][j];
	            
	            if(val != '.') {
	            	if(!seen.add(board[i][j]+ "row" + i) ||
	            	   !seen.add(board[i][j]+ "col"+j) ||
	            	   !seen.add(board[i][j]+ "box"+ ((i/3)*3 +(j/3)))) {
	            		return false;
	            	}
	            }
	          }
		}
		
		
		return true;
	}

	/*
	 * solution by taking 3 Sets 
	 */
	 public static  boolean isValidSudoku(char[][] board) {
	        int N=9;
	      
	        Set<Character> rows[] = new HashSet[N]; // store the val  in every row
	        Set<Character> cols[] = new HashSet[N]; // store the val in every col 
	        Set<Character> boxes[] = new HashSet[N]; // store the val in every box 
	        /*
	         * 
	         * box = (row/3)*3  + col/3;
	         */
	        
	      for(int r=0;r<N;r++){
	        rows[r] = new HashSet<Character>();
	        cols[r] = new HashSet<Character>();
	        boxes[r] = new HashSet<Character>();
	      }
	      
	      
	      
	        for(int i=0;i<N;i++){
	          for(int j=0;j<N;j++){
	            char val = board[i][j];
	            
	            if(val != '.'){
	              if(!rows[i].add(val)){
	                return false;
	              }
	              if(!cols[j].add(val)){
	                return false;
	              }
	              int box = (i/3)*3 + (j/3);
	              if(!boxes[box].add(val)){
	                return false;
	              }
	            }
	          }
	            
	        }
	      return true;
	    }
	 
	 
	 
	 
	 
	 public static  boolean helper(char[][] board){
	        int N=9;
		  
	      for(int i=0;i<9;i++){
	        for(int j=0;j<9;j++){
	          
	          if(board[i][j] == '.'){
	            
	            for(char k='1';k<='9';k++){
	              
	              if(isValid(board,i,j,k)){
	                  board[i][j] = k;
	                  if(helper(board)) return true;
	                  board[i][j] = '.';
	                
	              }
	              
	            }
	              
	             return false; 
	          }
	        }
	      }   
	      return true;
	  }
	  
	  
	  public static  boolean isValid(char[][] board,int row,int col,char val){
	    
	    for(int i=0;i<9;i++){
	      if(board[i][col] == val) return false;
	      if(board[row][i] == val) return false;
	       int r = (row/3)*3 + i/3;
	       int c = (col/3)*3+i%3;
	       System.out.println("row="+r +" col="+c);
	      if(board[(row/3)*3 + i/3][(col/3)*3+i%3] == val ) return false;
	    }
	    
	    return true;
	  }
	  
}
