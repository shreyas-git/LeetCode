//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//
//
//        Example 1:
//
//
//Input: board = [["A","B","C","E"],
//                ["S","F","C","S"],
//                ["A","D","E","E"]], word = "ABCCED"
//Output: true

class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board,i,j,word,0,new boolean [row][col])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board,int row, int col, String word, int index,  boolean[][] visited){

        if(index == word.length()) return true;

        if(row<0 || col <0 || row >=board.length ||  col >=board[0].length) return false;

        if(visited[row][col]) return false;

        if (board[row][col] != word.charAt(index)) return false;


        visited[row][col]= true;
        if(helper(board,row+1,col,word,index+1,visited) ||
                helper(board,row-1,col,word,index+1,visited)||
                helper(board,row,col+1,word,index+1,visited) ||
                helper(board,row,col-1,word,index+1,visited))return true;
        // backtrack set to previuos
        visited[row][col]= false;
        return false;
    }


}