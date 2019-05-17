package bit;

public class BitHelper {

	public static boolean isOppSign(int a, int b) {
		return ((a ^ b) < 0) ? true : false;
	}

	public static int countSetBit(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}
	
	public static int countSetBitsInAllNumbersUntilN(int n) {
		int count = 0;
		
		for (int i = 1; i <= n; i++) {
			count += countSetBit(i);
		}
		
		return count;
	}
	

}
