package backtracking;

import java.util.Arrays;

public class HamCycleProblem {
	
	public static boolean hamCycle(int[][] graph) {
		
		int[] path = new int[graph.length];
		
		path[0] = 0;
		
		if (!hamCycleUtils(graph, path, 1)) {
			System.out.println("No solution found");
			return false;
		}
		
		System.out.println(Arrays.toString(path));
		return true;
	}
	
	private static boolean isSafe(int[][] graph, int[] path, int vIndex, int v) {
		
		if (graph[path[vIndex-1]][v] == 1)
			return false;
		
		for (int i = 0; i < vIndex; i++) {
			if (path[i] == v) {
				return false;
			}
		}
		
		return true;
		
	}
	
	private static boolean hamCycleUtils(int[][] graph, int[] path, int vIndex) {
		
		if (vIndex == graph.length) {
			return (graph[path[vIndex - 1]][path[0]] == 1);
		}

		for (int i = 1; i < graph.length; i++) {
			if (isSafe(graph, path, vIndex, i)) {
				
				path[vIndex] = i;
				
				if (hamCycleUtils(graph, path, vIndex + 1))
					return true;
				
				path[vIndex] = -1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		 int graph1[][] = {{0, 1, 0, 1, 0}, 
		            {1, 0, 1, 1, 1}, 
		            {0, 1, 0, 0, 1}, 
		            {1, 1, 0, 0, 1}, 
		            {0, 1, 1, 1, 0}, 
		        }; 
		  
		        // Print the solution 
		        hamCycle(graph1); 
	}
	
}
