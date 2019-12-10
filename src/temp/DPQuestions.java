package temp;

public class DPQuestions {

	public static int LIS(int[] arr) {

		int n = arr.length;

		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}

			}
		}

		return dp[n - 1];
	}

	public static int LCS(String a, String b) {
		return LCS(a, b, a.length(), b.length());
	}

	private static int LCS(String a, String b, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		}

		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			return 1 + LCS(a, b, m - 1, n - 1);
		} else {
			return Math.max(LCS(a, b, m - 1, n), LCS(a, b, m, n - 1));
		}

	}

	public static int LCSDP(String a, String b) {

		int m = a.length();
		int n = b.length();

		if (m == 0 || n == 0) {
			return 0;
		}

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < m; i++) {
			dp[i][0] = 0;
		}

		for (int j = 0; j < n; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {

				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}

			}
		}

		return dp[m-1][n-1];
	}

}
