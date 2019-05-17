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
	
	public static int add(int x, int y) {
		
		while (y != 0) {
			
			int carry = x & y;
			
			x = x ^ y;
			
			y = carry << 1;
		}
		
		return x;
	}
	

	public static int smallest(int a, int b, int c) {
		int count = 0;
		
		while ( a > 0  && b > 0 && c > 0) {
			a--;
			b--;
			c--;
			count++;
		}
		
		return count;
	}
	
	
	public static int getNextHigherElementWithSameBits(int n) {
		
		int prevBit = 0;
		
		int count1Bits = 0;
		int i = 0;
	
		
		// Identify bit with 01 pattern.
	    for(i = 0; i < Integer.BYTES * 8; i++) {
	    
	    	int currBit = n & (1 << i);
	    	
	    	if (currBit != 0)
	    		count1Bits++;
	    	
	    	if (prevBit != 0 && currBit == 0) {
	    		break;
	    	}
	    	
	    	// unset if a bit is being set.
	    	n = n & ~(1<<i);
	    	
	    	prevBit = currBit;
	    }
		
	    n = n | (1 << i);
	    count1Bits--;
	    
	    for (int j = 0; j < count1Bits; j++) {
	    	n = n | (1 << j);
	    }
	    
	    return n;
	}
	
	public static int add1ToNumber(int n) {
		
		for (int i = 0; i < Integer.BYTES * 8 ; i++) {
			int currBit = n & (1 << i);
			
			if (currBit == 0) {
				n |= (1 << i);
				break;
			} else {
				n &= ~(1 << i);
			}
		}
		
		return n;
		
	}
	
	public static int multiply3_5(int n) {
		return (n >> 1) + n + (n << 1);
	}
}
