package dp;

import java.util.Arrays;
import java.util.Comparator;

import utils.Box;
import utils.Pair;

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
	
	public static int longestPalSeqDP(String input) {
		
		int n = input.length();
		
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		
		for (int len = 2; len <= n; len++) {
			
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				
				if (input.charAt(i) == input.charAt(j) && len == 2) {
					dp[i][j] = 2;
				} else if (input.charAt(i) == input.charAt(j)) {
					dp[i][j] =  dp[i+1][j-1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
				
				
			}
			
		}
		
		return dp[0][input.length()-1];
	}
	
	public static int longestBiotonicSubseq(int[] arr) {
		
		int n = arr.length;
		
		// compute LIS
		int[] lis = new int[n];
		
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					lis[i] = Math.max(lis[i], 1 + lis[j]);
				}
			}
		}
		
		// Compute LDS
		int[] lds = new int[n];
		
		for (int i = n -1; i >=0; i--) {
			for (int j  = n -1; j > i; j--) {
				if (arr[i] > arr[j]) {
					lds[i] = Math.max(lds[i], 1 + lds[j]);
				}
			}
		}
		
		int result = 1;
		for(int i = 0; i < n; i++) {
			result = Math.max(result, lis[i] + lis[i] - 1);
		}
		
		return result;
	}
	
	public static int longestChainOfPairDP(Pair[] pairs) {
		
		int n = pairs.length;
		
		int[] dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		
		for (int i = 1; i < pairs.length; i++) {
			for (int j = 0; j < i; j++) {
				if (pairs[i].x > pairs[j].y) {
					dp[i] = Math.max(dp[i], dp[j]  + 1);
				}
			}
		}
		
		return dp[n-1];
	}
	
	public static int maxHeightOfBoxStacks(Box[] boxes) {
		
		int n = boxes.length;
		
		Box[] rotatedBoxes = new Box[3 * n];
		
		int index = 0;
		for(int i = 0; i < n; i++) {
			Box cBox = boxes[i];
			rotatedBoxes[index++] = cBox;
			
			// Make length as height
			Box box = new Box(cBox.l, Math.max(cBox.h, cBox.w), Math.min(cBox.h, cBox.w));
			rotatedBoxes[index++] = box;
			
			box = new Box(cBox.w, Math.max(cBox.h, cBox.l), Math.min(cBox.h, cBox.l));
			rotatedBoxes[index++] = box;
		}
		
		Arrays.sort(rotatedBoxes, new Comparator<Box>() {

			@Override
			public int compare(Box o1, Box o2) {
				if (o1.w * o1.l > o2.w * o2.l) {
					return 1;
				} else if (o1.w * o1.l < o2.w * o2.l) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		int m = rotatedBoxes.length;
		
		int[] dp = new int[m];
		
		for (int i = 0; i < m; i++) {
			dp[i] = rotatedBoxes[i].h;
		}
		
		for (int i = 1; i < m; i++) {		
			for (int j = 0; j < i; j++) {
				if (rotatedBoxes[i].w < rotatedBoxes[j].w && rotatedBoxes[i].l < rotatedBoxes[j].l) {
					dp[i] = Math.max(dp[i], dp[j] + rotatedBoxes[j].h);
				}
			}
		}
		
		int maxResult = 0;
		
		for (int i= 0; i < m; i++) {
			maxResult = Math.max(maxResult, dp[i]);
		}
		
		return maxResult;
	}
	
	public static int largestSumContigiousSubarray(int[] arr) {
		
		int sumSoFar = 0;
		
		int maxSumSoFar = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sumSoFar += arr[i];
			
			maxSumSoFar = Math.max(sumSoFar, maxSumSoFar);
			
			if (sumSoFar < 0) {
				sumSoFar = 0;
			}
 		}
		
		return maxSumSoFar;
	}
	
	public static int numberOfCoins(int V, int[] coins) {
		if (V == 0 ) {
			return 0;
		}
		
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i < coins.length; i++) {
			
			if (V >=  coins[i]) {
				int subResult = numberOfCoins(V - coins[i], coins);
				
				if (subResult != Integer.MAX_VALUE && subResult + 1 < result) {
					result = 1 + subResult;
				}
			}
		}
		
		return result;
	}
	
	public static int numberOfCoinsDP(int[] coins, int V) {
		
		int[] dp = new int[V+1];
		
		dp[0] = 0;
		
		for (int i = 1; i <= V; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for (int v = 1; v <= V; v++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= v) {
					
					int subResult = dp[v - coins[j]];
					
					if (subResult != Integer.MAX_VALUE && subResult + 1 < dp[v]) {
						dp[v] = 1 + subResult;
					}
					
				}
			}
		}
		
		return dp[V];
		
	}
	
	public static int tilingProblem(int n) {
		
		if (n == 1 || n == 2) {
			return 1;
		}
		
		return tilingProblem(n - 1) + tilingProblem(n - 2);
		
	}
	
	public static int tilingProblemDP(int n) {
		
		int[] dp = new int[n+1];
		
		dp[0] = 0;
		
		if (n == 1 || n == 2) {
			return 1;
		}
 		
		dp[1] = 1;
		dp[2] = 1;
		
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
}
