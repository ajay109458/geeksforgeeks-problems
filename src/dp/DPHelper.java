package dp;

public class DPHelper {

	/**
	 * Recursive function for Fibonacci series is below
	 */
	public static int fibRecursion(int n) {
		if(n <= 1)
			return n;
		return fibRecursion(n-1) + fibRecursion(n-2);
	}
	
	
	
	
	
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
	
	public static int LIS(int[] arr) {
		
		int[] lis = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
		}
		
		int result = 1;
		
		for (int i  = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				
				if (arr[j] < arr[i]) {
					lis[i] =  Math.max(lis[i], lis[j] + 1);
				}
			}
			
			result = Math.max(result, lis[i]);
		}
		
		return result;
		
	}
	
	/**
	 * If last two characters match
	 * 	- Increment LCS length by 1 & process first[m-1] and L[n-1]
	 * 
	 * Else 
	 * - Max (LCS(m-1, n), LCS(n-1, m))
	 * 
	 * 
	 */
	
	
	/**
	 * Recursive
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	
	public static int LCS(String first, String second) {
		return LCS(first, second, first.length() - 1, second.length() - 1);
	}
	
	private static int LCS(String first, String second, int m, int n) {
		
		if (m < 0 || n < 0)
			return 0;
		
		if (first.charAt(m) == second.charAt(n)) {
			return 1 + LCS(first, second, m-1, n-1);
		} else {
			return Math.max(LCS(first, second, m - 1, n), LCS(first, second, m, n-1));
		}	
	}
}
