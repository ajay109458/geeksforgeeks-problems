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
	
	public static int swapBits(int x, int p1, int p2, int n) {
		
		// Get n bits for p1 
		int set1 = (x >> p1) & ((1 << n) -1);
		
		// get n bits for p2
		int set2 = (x >> p2) & ((1 << n) -1);
		
		// clear set bits from p1 and p2 
		for (int i = 0; i < n; i++ ) {
			x = x & ~(1<<(p1+i));
			x = x & ~ (1<<(p2+i));
		}
		
		return (x | (set1 << p2) | (set2 << p1)); 
	}
	

}
