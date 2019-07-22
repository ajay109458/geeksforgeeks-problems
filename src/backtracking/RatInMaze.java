package backtracking;

import java.util.Arrays;

public class RatInMaze {

	
	// assumption - square matrix maze
	public static boolean solveMaze(int[][] maze) {
		
		int n = maze.length;
		
		int[][] sol = new int[n][n];
		
		if (!solveMazeUtils(maze, 0, 0, sol)) {
			System.out.println("No solution exists");
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
	
	private static boolean isSafe(int[][] maze, int x, int y) {
		return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1);
	}
	
	private static boolean solveMazeUtils(int[][] maze, int x, int y, int[][] sol) {
		
		if ( x == maze.length - 1 && y == maze[0].length - 1) {
			sol[x][y] = 1;
			return true;
		}
		
		if (isSafe(maze, x, y)) {
			
			sol[x][y] = 1;
			
			if (solveMazeUtils(maze, x + 1, y, sol))
				return true;
			
			if (solveMazeUtils(maze, x, y + 1, sol))
				return true;
			
			sol[x][y] = 0;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] maze = {
				{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
		};
		
		solveMaze(maze);
	}
}
