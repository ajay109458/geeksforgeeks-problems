package backtracking;

import java.util.Arrays;

public class NQueen {

	public static boolean solveNQ(int n) {
		
		int[][] board = new int[n][n];
		
		if (!solveNQUtils(board, 0, n)) {
			System.out.println("solution doesn't exist");
			return false;
		}
		
		display(board);
		return true;
	}
	
	private static boolean isSafe(int[][] board, int row, int col, int n) {
		
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1)
				return false;
		}
		
		for(int i = row, j = col; i >=0 && j>=0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}
		
		for(int i = row, j = col; i < n && j>=0; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
	private static boolean solveNQUtils(int[][] board, int count, int n) {
		
		if (count == n)
			return true;
		
		for (int i = 0; i < n; i++) {
			if (isSafe(board, i, count, n)) {
				board[i][count] = 1;
				
				if (solveNQUtils(board, count + 1, n))
					return true;
				
				board[i][count] = 0;
			}
		}
		
		return false;
	}
	
	private static void display(int[][] sol) {

		for (int[] row : sol) {
			System.out.println(Arrays.toString(row));
		}

	}
	
	public static void main(String[] args) {
		solveNQ(8);
	}
	
}
