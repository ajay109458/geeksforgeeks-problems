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
	}
}	
