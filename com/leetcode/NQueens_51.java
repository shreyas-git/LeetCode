package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */

/*
 * Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */
public class NQueens_51 {

	public static void main(String[] args) {

		System.out.println(solveNQueens(4));

	}

	public static List<List<String>> solveNQueens(int n) {

		char board[][] = new char[n][n];
		List<List<String>> res = new ArrayList<>();

		// fill all the board with '.'
		for (char[] c : board) {
			Arrays.fill(c, '.');
		}

		// here we need to find the placement of Queen in each row , with every possible
		// combination
		// row =0 [0,0,0,0] and col ++
		// we can't place Queen in [row,col,diagonal,anti-diagonal], so will maintain
		// HashSet to keep track

		backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), res, n, board);

		return res;

	}

	public static void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols,
			List<List<String>> res, int n, char[][] board) {

		if (row == n) {
			res.add(createResult(board));
			return;
		}

		for (int col = 0; col < n; col++) {
			int diagonal = row - col;     
			int anti_diagonal = row + col;

			if (cols.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(anti_diagonal)) {
				continue;
			}

			cols.add(col);
			diagonals.add(diagonal);
			antiDiagonals.add(anti_diagonal);

			board[row][col] = 'Q';
			backtrack(row + 1, diagonals, antiDiagonals, cols, res, n, board);

			cols.remove(col);
			diagonals.remove(diagonal);
			antiDiagonals.remove(anti_diagonal);
			board[row][col] = '.';

		}
	}

	private static List<String> createResult(char[][] state) {
		List<String> board = new ArrayList<String>();
		for (int row = 0; row < state.length; row++) {
			String current_row = new String(state[row]);
			board.add(current_row);
			
		}
		//System.out.println(board.toString());
		return board;
	}

}
