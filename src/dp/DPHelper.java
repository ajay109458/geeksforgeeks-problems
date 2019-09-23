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
	
	public static int LCSDP(String first, String second) {
		int M = first.length(); 
		int N = second.length();
		
		int[][] dp = new int[M+1][N+1];
		
		for (int i = 0; i < M; i++) {
			dp[i][0] = 0;
		}
		
		for (int j = 0; j < N; j++) {
			dp[0][j] = 0;
		}
		
		System.out.println("--------DP table-----------");
		for(int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if (first.charAt(i-1) == second.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
		
		return dp[M][N];
	}
	
	/**
	 * Recursive edit distance problem
	 */
	public static int editDistance(String first, String second) {
		return editDistance(first, second, first.length() -1 , second.length() -1);
	}
	
	
	private static int editDistance(String first, String second, int m, int n) {
		
		if (m  < 0 || n  < 0) {
			return 0;
		}
		
		if (first.charAt(m) == second.charAt(n)) {
			return editDistance(first, second, m -1, n -1);
		} else {
			return Math.min(
						Math.min(editDistance(first, second, m - 1, n), editDistance(first, second, m, n -1)),
						editDistance(first, second, m -1, n -1 )
					) + 1;
		}
		
	}
	
	public static int editDistanceDP(String first, String second) {
		int M = first.length();
		int N = second.length();
		
		int[][] dp = new int[M + 1][N + 1];
		
		// rows
		for(int i = 0; i < M; i++) {
			dp[i][0] = i;
		}
		
		// cols
		for (int j = 0; j < N; j++) {
			dp[0][j] = j;
		}
		
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				
				if (first.charAt(i-1) == second.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = Math.min(
								Math.min(dp[i][j-1], dp[i-1][j]),
								dp[i-1][j-1]
							) + 1;
				}
				
			}
		}
		
		return dp[M][N];
	}
}
