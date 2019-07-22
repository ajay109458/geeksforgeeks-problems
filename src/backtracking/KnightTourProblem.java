package backtracking;

import java.util.Arrays;

public class KnightTourProblem {

	private static int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {
		solveKT(8);
	}
	
	public static boolean solveKT(int n) {

		int[][] sol = new int[n][n];

		sol[0][0] = 1;

		if (!solveKTUtils(sol, 0, 0, 1 + 1, n)) {
			System.out.println("No solution exist");
			return false;
		}

		display(sol);

		return true;
	}

	private static void display(int[][] sol) {

		for (int[] row : sol) {
			System.out.println(Arrays.toString(row));
		}

	}
	
	private static boolean isSafe(int[][] sol, int x, int y, int n) {
		return (x >= 0 && x < n && y >= 0 && y < n && sol[x][y] == 0);
		
	}

	private static boolean solveKTUtils(int[][] sol, int x, int y, int count, int n) {

		if (count > n*n) {
			return true;
		}
		
		for(int i = 0; i < xMoves.length; i++) {
			
			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];
			
			if (isSafe(sol, nextX, nextY, n)) {
				
				sol[nextX][nextY] = count;
				
				if (solveKTUtils(sol, nextX, nextY, count+1, n)) {
					return true;
				}
				
				sol[nextX][nextY] = 0;
			}
		}
		
		return false;
		
	}

}
