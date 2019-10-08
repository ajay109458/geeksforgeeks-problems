package temp;

public class DPQuestions {

 	public static int LIS(int[] arr) {
 		
 		int n = arr.length;
 		
 		if (n == 0)
 			return 0;
 		
 		int[] dp = new int[n];
 		
 		for (int i = 0; i < n; i++) {
 			dp[i] = 1;
 		}
 		
 		int max = Integer.MIN_VALUE;
 		
 		for (int i = 1; i < n; i++) {
 			for (int j = 0; j < i; j++) {
 				if (arr[i] > arr[j])
 					dp[i] = Math.max(dp[i], dp[j] + 1);
 			}
 			
 			max = Math.max(max, dp[i]);
 		}
 		
 		return max;
 		
 	}
 	
 	public static int lcs(String a, String b) {
 		return lcs(a, b, a.length(), b.length());
 	} 
 	
 	private static int lcs(String a, String b, int m, int n) {
 		
 		if ( m == 0 || n == 0)
 			return 0;
 		
 		if (a.charAt(m-1) == b.charAt(n-1)) {
 			return 1 + lcs(a, b, m-1, n-1);
 		} else {
 			return Math.max(lcs(a, b, m-1, n), lcs(a, b, m, n-1));
 		}
 		
 	}
 	
 	public static int lcsDP(String a, String b) {
 		
 		int m = a.length();
 		int n = b.length();
 		
 		int[][] dp= new int[m+1][n+1];
 		
 		for (int i = 0; i <= m; i ++) {
 			for (int j = 0; j <= n; j++) {
 				if (i == 0 || j == 0) {
 					dp[i][j] = 0;
 				} else if (a.charAt(i-1) == b.charAt(j-1)) {
 					dp[i][j] = 1 + dp[i-1][j-1];
 				} else {
 					dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
 				}
 			}
 		}
 		
 		return dp[m][n];
 	}
 	
 	
	
}
