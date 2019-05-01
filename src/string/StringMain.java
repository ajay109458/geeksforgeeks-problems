package string;

public class StringMain {

	public static void main(String[] args) {
		
		System.out.print("Digit Num : ");
		StringHelper.printDigitNum(5);
		
		/**
		 * Minimum sum of squares of character counts in a given string after removing k characters
		 */
		System.out.println("Min Square value " + StringHelper.minStringValue("abccc", 1));
		
		
		/**
		 * Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find sum of these two numbers.
		 */
		System.out.println("Sum of 3333311111111111 and 44422222221111 : " + StringHelper.findSum("3333311111111111", "44422222221111"));
		
		
		/**
		 * Given a string containing alphanumeric characters, calculate sum of all numbers present in the string.
		 */
		System.out.println("Sum of numbers in string '1abc2x30yz67' : " + StringHelper.sumOfNumbersInString("1abc2x30yz67"));
		System.out.println("Sum of numbers in string '1abc2x30yz67' : " + StringHelper.sumOfNumbersInStringRegex("1abc2x30yz67"));
		
		
		System.out.println("Extract maximum number in string '100klh564abc365bg' : " + StringHelper.extractMaxNumRegex("100klh564abc365bg"));
		
		System.out.println("Maximum result with operators for string '01231' : " + StringHelper.getMaxValueWithOperator("01231"));
		
		System.out.println("Max seg value for string '8754' : " + StringHelper.getMaxSegmentValue("8754", 2));
		
		
		System.out.println("Difference of '11443333311111111100' and '1144422222221111' : " + StringHelper.subtract("11443333311111111100", "1144422222221111"));
	}
	
}
