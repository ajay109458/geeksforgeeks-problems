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
		
		System.out.println("Character count");
		StringHelper.printCharacterCount("#GeeKs01fOr@gEEks07");
		
		System.out.println("Longest subsequence where every character appears at-least k times : ");
		StringHelper.printLongestSubSeq("geeksforgeek", 2);
		
		
		System.out.println("Check if first string is subsequence of string 2 : " + StringHelper.isSubSeqRec("AXY", "ADXCPY"));
		System.out.println("Check if first string is subsequence of string 2 : " + StringHelper.isSubStringItr("AXY", "ADXCPY"));
		
		System.out.println("Word count in the string : " + StringHelper.wordCount("One two     three\n four\tfive"));

		String[] words = { "welcome", "to", "geeks", "portal"};
		String inputStr = "geeksforgeeks is a computer science portal for geeks";
		
		System.out.println("Words present in the string : " + StringHelper.countWordsPresentInString(inputStr, words));
		
		
		StringHelper.printMaxMinLenWords("This is a test string");
		
		System.out.println("Count of substrings with equal begin and end : " + StringHelper.countSubstringWithSameBeginAndEnd("abcab"));
		
		System.out.println("Count of the non-empty substrings : " + StringHelper.countOfNonEmptySubStrings("abcd"));
		
		
		String[] inputArr = {"abcd", "acbd", "adcb", "cdba", 
                "bcda", "badc"};
		
		System.out.println("Count distinct strings : " + StringHelper.countDistinctSubstringsWithEvenOdd(inputArr));
		
		System.out.println("Longest length of the string : " + StringHelper.longestStringOf0("100001", 3));
		
		System.out.println("Count non overlapping string : " + StringHelper.countNonOverlapping101or010("10101010101"));
		
		System.out.println("Check if a string can be converted : " + StringHelper.checkIfS1canBeConvertedToS2("00100", "111"));
		
		System.out.println("Odd parity max length : " + StringHelper.getMaxLenOddParityStringLen("1001110"));
		
		System.out.println("Min operations for transformation  : " + StringHelper.minOperationForTransform("1001011001", 3, 6));
		
		System.out.println("Score of the string : " +  StringHelper.calculateScoreOfString("11011"));
		
		System.out.println("Is equidistant one : " + StringHelper.is1Equidistant("00111000"));
		
		System.out.println("Is Panagram : " + StringHelper.isPanagram("The quick brown fox jumps over the lazy dog"));
		
		System.out.println("Missing character from  Panagram : " + StringHelper.getMissingCharactersFromPanagram("welcome to geeksforgeeks"));
		
		System.out.println("Is string panagramic lipogram : " + StringHelper.isPanagramicLipogram("The quick brown fox jumped over the lazy dog"));
		
		
		/******************************************************************
		 *             ANAGRAM QUESTIONS                                  *
		 ******************************************************************/
		
		System.out.println("Is anagram : " + StringHelper.isAnagram("test", "ttew"));
		
		
		String[] words1 = {"cat", "dog", "tac", "god", "act"}; 
		StringHelper.printAnagramsTogther(words1);
		
		String str1 = "i.like.this.program.very.much";
		
		System.out.println(StringHelper.reverseWords(str1));
		
	}
	
}
