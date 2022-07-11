package com.leetcode;

public class DesignTic_Tac_Toe_348 {

	public static void main(String[] args) {
		/*
		 * 
		 * {"TicTacToe","move","move","move","move","move","move","move"}
{{3},{0,0,1},{0,2,2},{2,2,1},{1,1,2},{2,0,1},{1,0,2},{2,1,1}}


["TicTacToe","move","move","move"]
[[2],[0,0,2],[1,1,1],[0,1,2]]
//		 */
		TicTacToe ticTacToe = new TicTacToe(3);
		
		System.out.println(ticTacToe.move(0, 0, 1)); // return 0 (no one wins)
		System.out.println(ticTacToe.move(0, 2, 2)); // return 0 (no one wins)
		System.out.println(ticTacToe.move(2, 2, 1)); // return 0 (no one wins)
		System.out.println(ticTacToe.move(1, 1, 2)); // return 0 (no one wins)
		System.out.println(ticTacToe.move(2, 0, 1)); // return 0 (no one wins)
		System.out.println(ticTacToe.move(1, 0, 2)); // return 0 (no one wins)
		System.out.println(ticTacToe.move(2, 1, 1)); // return 1 (player 1 wins)

	
//TicTacToe ticTacToe = new TicTacToe(2);
//		//["TicTacToe","move","move","move"]
//
//		System.out.println(ticTacToe.move(0, 1, 1)); // return 0 (no one wins)
//		System.out.println(ticTacToe.move(1, 1, 2)); // return 0 (no one wins)
//		System.out.println(ticTacToe.move(1, 0, 1)); // return 0 (no one wins)
	
	}

}
class TicTacToe {

    int[][] grid ;
    int n;
    public TicTacToe(int n) {
        grid = new int[n][n];
      this.n = n;
    }
    
    public int move(int row, int col, int player) {
        grid[row][col] = player;
      if(checkRow(row,player) || checkCol(col,player)||
        ( row == col && checkDiagonal(player)) ||
         (col == n - row -1 && checkAntiDiagonal(player))){
        return player;
      }
      return 0;
      
    }
  public boolean checkDiagonal(int player){
    for(int row =0; row<n;row++){
      if(grid[row][row]!=player){
        return false;
      }
    }
    return true;
  }
  
  public boolean checkAntiDiagonal(int player){
    for(int row =0; row<n;row++){
      if(grid[row][n-row -1]!=player){
        return false;
      }
    }
    return true;
  }
  
 
  
  public boolean checkRow(int row, int player){
    for(int col=0;col<n;col++){
       if(grid[row][col]!=player){
        return false;
      }
    }
    return true;
  }
  
  public boolean checkCol(int col, int player){
    for(int row=0;row<n;row++){
       if(grid[row][col]!=player){
        return false;
      }
    }
    return true;
  }
}

class TicTacToe_backTrack {

    int[][] grid ;
    public TicTacToe_backTrack(int n) {
        grid = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        grid[row][col] = player;
     if(isWin(row,col,1,player)){
       return player;
     }
      return 0;
    }
   int [][] directions = {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
  
    public boolean isWin(int row,int col, int n, int player){
      
      if(n == grid.length){
        return true;
      }
      
  

        
        for(int [] dir:directions){
          int x = dir[0]+row;
          int y = dir[1]+col;
          
          if(x<0 || x>=grid.length || y< 0 || y>= grid[0].length || grid[x][y]!=player){
            continue;
          }else{
            if(grid[x][y] == player){
              n++;
              if(n==grid.length) {
            	  return true;
              }
            
            }
          }
        }
      
      return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */