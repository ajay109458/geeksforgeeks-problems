package dp;

import java.util.Arrays;

public class DPHelper {

	public static int fibRecursion(int n) {
		if(n <= 1)
			return n;
		return fibRecursion(n-1) + fibRecursion(n-2);
	}
	
	/**
	 * Nth fibonacii series number
	 * 
	 * @param n
	 * @return
	 */
	public static int fib(int n) {
		
		int[] fibArr = new int[n+2];
		fibArr[0] = 0;
		fibArr[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			fibArr[i] = fibArr[i-1] + fibArr[i-2];
		}
		
		return fibArr[n];
	}
	
	public static int catalan(int n) { 
		if(n <= 1) return 1;
		return -1;
	}
	
	public static void printParanthesis(int n) {
		printParanthesis(n, "", 0, 0);
	}
	
	private static void printParanthesis(int n, String res, int s, int e) {
		if (s == n && e == n) {
			System.out.println(res);
		}
		
		if (s < n) {
			printParanthesis(n, res + "(", s + 1, e);
		}
		
		if (e < s && e < n) {
			printParanthesis(n, res + ")", s, e + 1);
		}
	}
}
