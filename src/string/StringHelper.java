package string;

public class StringHelper {
	
	/**
	 * @param n
	 * Find the smallest number such that the sum of its digits is N and it is divisible by 10^N.
	 */
	public static void printDigitNum(int n) {
		
		if (n == 0)
			System.out.println("0");
		
		if ( n % 9 > 0) {
			System.out.print(n%9);
		}
		
		for (int i = 0; i < n/9; i++) {
			System.out.print(9);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(0);
		}
		
		System.out.println();
		
	}

}
