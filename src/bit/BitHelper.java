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
		int set1 = (x >> p1) & ((1 << n) - 1);

		// get n bits for p2
		int set2 = (x >> p2) & ((1 << n) - 1);

		// clear set bits from p1 and p2
		for (int i = 0; i < n; i++) {
			x = x & ~(1 << (p1 + i));
			x = x & ~(1 << (p2 + i));
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

		while (a > 0 && b > 0 && c > 0) {
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
		for (i = 0; i < Integer.BYTES * 8; i++) {

			int currBit = n & (1 << i);

			if (currBit != 0)
				count1Bits++;

			if (prevBit != 0 && currBit == 0) {
				break;
			}

			// unset if a bit is being set.
			n = n & ~(1 << i);

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

		for (int i = 0; i < Integer.BYTES * 8; i++) {
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

	public static int unsetRightMostBit(int n) {

		if (n == 0)
			return 0;

		return n & (n - 1);
	}

	public static int leftRotate(int n, int k) {
		return (n << k) | (n >> (Integer.BYTES * 8 - k));
	}

	public static int rightRotate(int n, int k) {
		return (n >> k) | (n << (Integer.BYTES * 8 - k));
	}

	public static int findNumberWithOddOccurance(int[] arr) {
		int result = 0;

		for (int ele : arr) {
			result ^= ele;
		}

		return result;
	}

	public static boolean isAddResultOverflow(int a, int b) {

		if (b > Integer.MAX_VALUE - a) {
			return true;
		}

		return false;

	}

	public static int countSetBits1(int n) {

		int count = 0;

		while (n != 0) {
			count++;
			n = n & (n - 1);
		}

		return count;
	}

	public static int countSetBits2(int n) {

		int count = 0;

		while (n != 0) {

			if ((n & 1) != 0) {
				count++;
			}

			n >>= 1;
		}

		return count;
	}

	public static int numberOfBitsToFlip(int a, int b) {
		int xorNum = a ^ b;
		return countSetBit(xorNum);
	}

	public static int multiply7(int n) {
		return (n << 2) + (n << 1) + n;
	}

	public static boolean isPowerOf2(int n) {
		return (n != 0 && ((n & (n - 1)) == 0)) ? true : false;
	}

	public static int indexOfRightMostBit(int n) {

		int index = -1;

		while (n != 0) {

			index++;

			if ((n & 1) != 0) {
				break;
			}

			n >>= 1;
		}

		return index;
	}

	public static String getBinary(int n) {

		String result = "";

		while (n != 0) {
			result = (n % 2) + result;
			n /= 2;
		}

		return result;
	}

	public static String addBitString(String a, String b) {

		int len1 = a.length();
		int len2 = b.length();

		int diff = len1 - len2;

		// Make both string as equal
		if (len1 > 0) {
			for (int i = 0; i < diff; i++) {
				b = '0' + b;
			}
		} else {
			diff = Math.abs(diff);
			for (int i = 0; i < diff; i++) {
				a = '0' + a;
			}
		}

		String result = "";

		int carry = 0;
		for (int i = a.length() - 1; i >= 0; i--) {
			int numA = a.charAt(i) - '0';
			int numB = b.charAt(i) - '0';

			int sum = numA ^ numB ^ carry;

			result = ((char) (sum + '0')) + result;

			carry = (numA & numB) | (numA & carry) | (numB & carry);
		}

		if (carry == 1) {
			result = '1' + result;
		}

		return result;

	}

	public static int xor1ToN(int n) {
		int xor = 0;

		for (int i = 1; i <= n; i++) {
			xor ^= i;
		}

		return xor;
	}

	public static int xor1ToNEfficient(int n) {

		int mod = n % 4;

		switch (mod) {
			case 0:
				return n;
			case 1:
				return 1;
			case 2:
				return n + 1;
			case 3:
				return 0;
		}
		
		return 0;

	}
	
	public static boolean isAltBitPattern(int n) {
		
		boolean result = true;
		int prevBit = n & 1;
		n >>= 1;
		
		while (n != 0) {
			int currBit = n & 1;
			if ((prevBit ^ currBit) == 0) {
				return false;
			}
			
			prevBit = currBit;
			n >>= 1;
		}
		
		return result;
	}
}
