package string;

public class StringMain {

	public static void main(String[] args) {
		
		System.out.print("Digit Num : ");
		StringHelper.printDigitNum(5);
		
		/**
		 * Minimum sum of squares of character counts in a given string after removing k characters
		 */
		System.out.println("Min Square value " + StringHelper.minStringValue("abccc", 1));
		
	}
	
}
