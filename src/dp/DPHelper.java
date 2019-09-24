package dp;

public class DPHelper {

	/**
	 * Recursive function for Fibonacci series is below
	 */
	public static int fibRecursion(int n) {
		if (n <= 1)
			return n;
		return fibRecursion(n - 1) + fibRecursion(n - 2);
	}

	public static int fib(int n) {

		int[] fibArr = new int[n + 2];
		fibArr[0] = 0;
		fibArr[1] = 1;

		for (int i = 2; i <= n; i++) {
			fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
		}

		return fibArr[n];
	}

	public static int catalan(int n) {
		if (n <= 1)
			return 1;
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

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[j] < arr[i]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}

			result = Math.max(result, lis[i]);
		}

		return result;

	}

	/**
	 * If last two characters match - Increment LCS length by 1 & process first[m-1]
	 * and L[n-1]
	 * 
	 * Else - Max (LCS(m-1, n), LCS(n-1, m))
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
			return 1 + LCS(first, second, m - 1, n - 1);
		} else {
			return Math.max(LCS(first, second, m - 1, n), LCS(first, second, m, n - 1));
		}
	}

	public static int LCSDP(String first, String second) {
		int M = first.length();
		int N = second.length();

		int[][] dp = new int[M + 1][N + 1];

		for (int i = 0; i < M; i++) {
			dp[i][0] = 0;
		}

		for (int j = 0; j < N; j++) {
			dp[0][j] = 0;
		}

		System.out.println("--------DP table-----------");
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if (first.charAt(i - 1) == second.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
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
		return editDistance(first, second, first.length() - 1, second.length() - 1);
	}

	private static int editDistance(String first, String second, int m, int n) {

		if (m < 0 || n < 0) {
			return 0;
		}

		if (first.charAt(m) == second.charAt(n)) {
			return editDistance(first, second, m - 1, n - 1);
		} else {
			return Math.min(Math.min(editDistance(first, second, m - 1, n), editDistance(first, second, m, n - 1)),
					editDistance(first, second, m - 1, n - 1)) + 1;
		}

	}

	public static int editDistanceDP(String first, String second) {
		int M = first.length();
		int N = second.length();

		int[][] dp = new int[M + 1][N + 1];

		// rows
		for (int i = 0; i < M; i++) {
			dp[i][0] = i;
		}

		// cols
		for (int j = 0; j < N; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {

				if (first.charAt(i - 1) == second.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
				}

			}
		}

		return dp[M][N];
	}

	public static int bionomialCoff(int n, int k) {

		if (k == 0 || k == n)
			return 1;

		return bionomialCoff(n - 1, k - 1) + bionomialCoff(n - 1, k);

	}

	public static int binonomialCoffDP(int n, int k) {

		int[][] dp = new int[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {

				if (j == 0 || j == i) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				}

			}
		}

		return dp[n][k];
	}

	public static int knapsack(int W, int[] wts, int[] val, int n) {

		if (W == 0 || n == 0)
			return 0;

		if (wts[n - 1] > W)
			return knapsack(W, wts, val, n - 1);

		return Math.max(knapsack(W, wts, val, n - 1), val[n - 1] + knapsack(W - wts[n - 1], wts, val, n - 1));
	}
	
	public static int knapsackDP(int W, int[] wts, int[] vals, int n) {
		
		int[][] dp = new int[n+1][W+1];
		
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				
				if (i == 0 || w == 0) {
					dp[i][w] = 0;
				} else if (wts[i-1] > w) {
					dp[i][w] = dp[i-1][w];
				} else {
					dp[i][w] = Math.max(dp[i-1][w], vals[i-1] +  dp[i-1][w - wts[i-1]]);
				}
				
			}
		}
		
		return dp[n][W];
		
	}
	
	public static int longestPalindromeSeq(String input) {
		return longestPalindromeSeq(input, 0, input.length() - 1);
	}
	
	public static int longestPalindromeSeq(String input, int left, int right) {
		
		if (right < left)
			return 0;
		
		if (left == right)
			return 1;
		
		if (input.charAt(left) == input.charAt(right)) {
			return longestPalindromeSeq(input, left + 1, right -1) + 2;
		} else {
			return Math.max(longestPalindromeSeq(input, left + 1, right), longestPalindromeSeq(input, left, right - 1));
		}
		
	}
}
