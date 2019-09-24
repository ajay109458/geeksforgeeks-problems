package dp;

public class DPMain {

	public static void main(String[] args) {
		System.out.println(DPHelper.fib(5));
		
		DPHelper.printParanthesis(3);
		
		// Longest increasing subsequence
		int[] arr1 = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println("LIS " + DPHelper.LIS(arr1));
		
		String first = "abcdefg";
		String second = "abxdfg";
		
		System.out.println("LCS recursive : " + DPHelper.LCS(first, second));
		System.out.println("LCS DP : " + DPHelper.LCSDP(first, second));
		
		first = "cat";
		second = "cut";
		
		System.out.println("Edit distance recursive : " + DPHelper.editDistance(first, second));
		System.out.println("Edit distance DP : " + DPHelper.editDistanceDP(first, second));
		
		System.out.println("Bionomial coff recursive : " + DPHelper.bionomialCoff(5, 3));
		System.out.println("Bionomial coff DP : " + DPHelper.binonomialCoffDP(5, 3));
		
		int[] values = {60, 100, 120};
		int[] weights = {10, 20, 30};
		
		System.out.println("Knapsack recursive - max weight : " + DPHelper.knapsack(50, weights, values, values.length));
		System.out.println("Knapsack DP - max weight : " + DPHelper.knapsackDP(50, weights, values, values.length));
		
		System.out.println("Longest palindrome seq : " + DPHelper.longestPalindromeSeq("dadbabcbab"));
	}
	
}
