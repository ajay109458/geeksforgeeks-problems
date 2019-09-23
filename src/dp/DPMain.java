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
	}
	
}
