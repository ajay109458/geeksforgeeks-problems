package backtracking;

import java.util.Arrays;

public class MColoringProblem {

	public static boolean mColoring(int[][] graph, int m) {
		int V = graph.length;
		
		int[] color = new int[V];
		
		if (!mColoringUtils(graph, m, color, 0)) {
			System.out.println("Solution doesn't exist");
			return false;
		}
		
		System.out.println(Arrays.toString(color));
		return true;
	}
	
	public static boolean isSafe(int[][] graph, int[] color, int vIndex, int c) {
		
		for (int i = 0; i < graph.length; i++) {
			if (graph[vIndex][i] == 1 && color[i] == c)
				return false;
		}
		
		return true;
	}
	
	public static boolean mColoringUtils(int[][] graph, int m, int[] color, int vIndex) {
		
		if (vIndex == graph.length)
			return true;
		
		for(int c = 1; c <= m; c++) {
			
			if (isSafe(graph, color, vIndex, c)) {
				
				color[vIndex] = c;
				
				if (mColoringUtils(graph, m, color, vIndex + 1))
					return true;
				
				color[vIndex] = 0;
 				
			}
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] graph = {{0, 1, 1, 1}, 
		        {1, 0, 1, 0}, 
		        {1, 1, 0, 1}, 
		        {1, 0, 1, 0}, 
		    }; 
		    int m = 3; // Number of colors 
		    mColoring(graph, m); 
	}
}
