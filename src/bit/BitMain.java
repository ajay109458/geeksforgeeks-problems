package bit;

public class BitMain {
	public static void main(String[] args) {
		System.out.println("Is opposite sign : " + BitHelper.isOppSign(5, -3));
		
		System.out.println("Number of set bits in number 5 : " + BitHelper.countSetBit(5));
		
		System.out.println("Number of set bits in all numbers until 5: " + BitHelper.countSetBitsInAllNumbersUntilN(5));
		
		System.out.println("Swap bits of number 28 is " + BitHelper.swapBits(28, 0, 3, 2));
		
		System.out.println("Binary addition of 3 and 5 : " + BitHelper.add(5, 3));
		
		System.out.println("Smallest of three number : " + BitHelper.smallest(4, 3, 5));
		
		System.out.println("Next higher number with same bits : " + BitHelper.getNextHigherElementWithSameBits(156));
		
 		System.out.println("Add 1 to a number : " + BitHelper.add1ToNumber(5));
 		 
 		System.out.println("Multiply number with 3.5 : " + BitHelper.multiply3_5(2));
 		
 		System.out.println("Unset right most set bit : " + BitHelper.unsetRightMostBit(5));
 		
 		System.out.println("Left rotate : " + BitHelper.leftRotate(16, 2));
 		System.out.println("Left rotate : " + BitHelper.rightRotate(16, 2));
 		
 		int[] arr = {1, 2, 3, 2, 3, 1, 3};
 		System.out.println("Element occuring odd number of times : " + BitHelper.findNumberWithOddOccurance(arr));
 		
 		System.out.println("Is add results into integer overflow : "  + BitHelper.isAddResultOverflow(2147483640, 10));
 		
 		System.out.println("Count set bits  #1 : " + BitHelper.countSetBits1(5));
 		System.out.println("Count set bits  #2 : " + BitHelper.countSetBits2(5));
 		
 		System.out.println("Number of bits to flip: " + BitHelper.numberOfBitsToFlip(10, 20));
 		
 		System.out.println("Multiply number with 7 : " + BitHelper.multiply7(5));
 		
 		System.out.println("Is power of 2 : " + BitHelper.isPowerOf2(8));
 		
 		System.out.println("Index of rightmost set bit : " + BitHelper.indexOfRightMostBit(12));
 		
 		System.out.println("Get binary of the number : " + BitHelper.getBinary(6));
 		
 		
 		System.out.println("Add binary string : " + BitHelper.addBitString("1100011", "10"));
 		
 		System.out.println("Xor from 1 to n : " + BitHelper.xor1ToN(6));
 		System.out.println("Xor from 1 to n efficient: " + BitHelper.xor1ToNEfficient(6));
 		
 		System.out.println("Is alternate bit pattern : " + BitHelper.isAltBitPattern(5));
	}
}	
