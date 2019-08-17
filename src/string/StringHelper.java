package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {

	public static int OUT = 0;
	public static int IN = 1;

	/**
	 * @param n Find the smallest number such that the sum of its digits is N and it
	 *          is divisible by 10^N.
	 */
	public static void printDigitNum(int n) {

		if (n == 0)
			System.out.println("0");

		if (n % 9 > 0) {
			System.out.print(n % 9);
		}

		for (int i = 0; i < n / 9; i++) {
			System.out.print(9);
		}

		for (int i = 0; i < n; i++) {
			System.out.print(0);
		}

		System.out.println();

	}

	/**
	 * Minimum sum of squares of character counts in a given string after removing k
	 * characters
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static int minStringValue(String input, int k) {

		input = input.toLowerCase();

		int len = input.length();

		if (k >= len)
			return 0;

		// TODO: Change to 256 if string contains special chars
		int[] freq = new int[26];

		for (int i = 0; i < len; i++) {
			freq[input.charAt(i) - 'a']++;
		}

		Comparator<Integer> c = new IntCompare();

		PriorityQueue<Integer> q = new PriorityQueue<>(c);

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0) {
				q.add(freq[i]);
			}
		}

		while (k != 0) {
			int currFreq = q.poll();
			currFreq--;

			if (currFreq > 0) {
				q.add(currFreq);
			}

			k--;
		}

		int result = 0;
		while (!q.isEmpty()) {
			int temp = q.poll();
			result += (temp * temp);
		}

		return result;
	}

	public static boolean isSumSubstring(String input) {
		int len = input.length();

		for (int i = 0; i < len; i++) {
			for (int j = 1; i + j < len; j++) {
				if (isSumSubstringUtils(input, 0, i, j)) {
					return true;
				}
			}
		}

		return false;
	}

	public static String findSum(String input1, String input2) {

		input1 = new StringBuilder(input1).reverse().toString();
		input2 = new StringBuilder(input2).reverse().toString();

		int input1Len = input1.length();
		int input2Len = input2.length();

		int i = 0, j = 0;

		StringBuilder result = new StringBuilder();

		while (i < input1Len && j < input2Len) {

			int num1 = input1.charAt(i) - '0';
			int num2 = input2.charAt(j) - '0';
			result.append(num1 + num2);

			i++;
			j++;
		}

		while (i < input1Len) {
			int num1 = input1.charAt(i) - '0';
			result.append(num1);
			i++;
		}

		while (j < input2Len) {
			int num2 = input2.charAt(i) - '0';
			result.append(num2);
			j++;
		}

		result = result.reverse();

		return result.toString();
	}

	/**
	 * Given a string containing alphanumeric characters, calculate sum of all
	 * numbers present in the string.
	 * 
	 * @param input
	 * @return
	 */
	public static int sumOfNumbersInString(String input) {

		int len = input.length();

		int result = 0;
		int currNum = 0;
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(input.charAt(i))) {
				currNum = currNum * 10 + (input.charAt(i) - '0');
			} else {
				result += currNum;
				currNum = 0;
			}
		}

		result += currNum;

		return result;
	}

	public static int sumOfNumbersInStringRegex(String input) {

		String regex = "\\d+";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(input);

		int sum = 0;
		while (m.find()) {
			Integer num = Integer.parseInt(m.group());
			sum += num;
		}

		return sum;
	}

	public static int extractMaxNumRegex(String input) {

		String regex = "\\d+";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);

		int max = 0;

		while (m.find()) {
			Integer num = Integer.parseInt(m.group());

			if (num > max)
				max = num;
		}

		return max;
	}

	/**
	 * Calculate maximum value using ‘+’ or ‘*’ sign between two numbers in a string
	 * 
	 * @param input
	 * @return
	 */
	public static int getMaxValueWithOperator(String input) {

		if (input == null || input.isEmpty())
			return 0;

		int result = input.charAt(0) - '0';

		for (int i = 1; i < input.length(); i++) {

			int num = input.charAt(i) - '0';

			if (num < 2 || result < 2) {
				result += num;
			} else {
				result *= num;
			}

		}

		return result;
	}

	/**
	 * Maximum segment value after putting k breakpoints in a number
	 * 
	 * One important observation is, the maximum would always be of length
	 * “string-length – k"
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static int getMaxSegmentValue(String input, int k) {
		int segmentSize = input.length() - k;

		int segNum = 0;
		int i = 0;
		for (i = 0; i < segmentSize; i++) {
			int num = input.charAt(i) - '0';

			segNum = segNum * 10 + num;
		}

		int maxSegNum = segNum;

		int divident = 1;
		for (int j = 0; j < segmentSize - 1; j++) {
			divident *= 10;
		}

		for (; i < input.length(); i++) {
			segNum %= divident;
			int num = input.charAt(i) - '0';
			segNum = segNum * 10 + num;

			if (maxSegNum < segNum)
				maxSegNum = segNum;
		}

		return maxSegNum;
	}

	private static boolean isSumSubstringUtils(String input, int beg, int len1, int len2) {

		String s1 = input.substring(beg, len1);
		String s2 = input.substring(beg + len1, len2);

		// TODO : Get S3
		String s3 = "";

		if (s3.length() > input.length() - (beg + len1 + len2))
			return false;

		if (s3.equals(input.substring(beg + len1 + len2, s3.length()))) {

			if (beg + len1 + len2 + s3.length() == input.length())
				return true;

			return isSumSubstringUtils(input, beg + len1, len2, s3.length());
		}

		return false;
	}

	/**
	 * 
	 * Assume input1 is always greater than input2
	 * 
	 * @param input1
	 * @param input2
	 * @return
	 */
	public static String subtract(String input1, String input2) {

		input1 = new StringBuilder(input1).reverse().toString();
		input2 = new StringBuilder(input2).reverse().toString();

		int i = 0, j = 0;
		int carry = 0;

		StringBuilder result = new StringBuilder();

		while (i < input1.length() && j < input2.length()) {

			int num1 = input1.charAt(i) - '0';
			int num2 = input2.charAt(j) - '0';

			if (carry == 1) {
				num1 -= 1;
				carry = 0;
			}

			int diff = num1 - num2;

			if (diff < 0) {
				diff += 10;
				carry = 1;
			}

			result.append(diff);
			i++;
			j++;

		}

		while (i < input1.length()) {
			int num1 = input1.charAt(i) - '0';
			if (carry == 1) {
				num1 -= 1;
				carry = 0;
			}

			result.append(num1);
			i++;
		}

		return result.reverse().toString();
	}

	public static void printCharacterCount(String input) {

		int digitCount = 0;
		int lowerCaseCount = 0;
		int upperCaseCount = 0;
		int specialCharCount = 0;

		for (int i = 0; i < input.length(); i++) {

			Character ch = input.charAt(i);

			if (Character.isDigit(ch)) {
				digitCount++;
			} else if (Character.isAlphabetic(ch)) {
				if (Character.isLowerCase(ch)) {
					lowerCaseCount++;
				} else if (Character.isUpperCase(ch)) {
					upperCaseCount++;
				}
			} else {
				specialCharCount++;
			}

		}

		System.out.println("Digits : " + digitCount);
		System.out.println("Uppercase : " + upperCaseCount);
		System.out.println("Lowercase : " + lowerCaseCount);
		System.out.println("Special char : " + specialCharCount);

	}

	public static String findSmallestWindow(String input, String pattern) {

		int inputLen = input.length();
		int patLen = pattern.length();

		if (inputLen < patLen) {
			System.out.println("No window exists");
			return "";
		}

		return input;
	}

	public static void printLongestSubSeq(String str, int k) {

		int[] freq = new int[26];

		for (int i = 0; i < str.length(); i++) {
			freq[str.charAt(i) - 'a']++;
		}

		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (freq[str.charAt(i) - 'a'] >= k) {
				strBuilder.append(str.charAt(i));
			}
		}

		System.out.println(strBuilder.toString());

	}

	public static boolean isSubStringItr(String a, String b) {
		int i = 0;
		for (int j = 0; j < b.length(); j++) {

			if (a.charAt(i) == b.charAt(j)) {
				i++;
			}

			if (i == a.length())
				return true;

		}

		return false;
	}

	public static boolean isSubSeqRec(String a, String b) {
		return isSubSeqRec(a, b, a.length(), b.length());
	}

	public static int wordCount(String str) {

		int count = 0;
		int state = IN;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '\t' || ch == ' ' || ch == '\n') {
				state = OUT;
			} else if (state == OUT) {
				state = IN;
				count++;
			}
		}

		if (state == IN)
			count++;

		return count;
	}

	public static int countWordsPresentInString(String input, String[] words) {

		Set<String> sWords = getWordsFromString(input);

		int count = 0;

		for (String word : words) {
			if (sWords.contains(word)) {
				count++;
			}
		}

		return count;
	}

	public static void printMaxMinLenWords(String input) {

		Set<String> words = getWordsFromString(input);

		String maxWord = "";
		String minWord = "";

		int minLen = Integer.MAX_VALUE;
		int maxLen = Integer.MIN_VALUE;

		for (String word : words) {

			if (word.length() > maxLen) {
				maxLen = word.length();
				maxWord = word;
			}

			if (word.length() < minLen) {
				minLen = word.length();
				minWord = word;
			}

		}

		System.out.println("Word with min length : " + minWord);
		System.out.println("Word with max length : " + maxWord);

	}

	public static int countSubstringWithSameBeginAndEnd(String input) {

		int count = 0;

		for (int i = 0; i < input.length(); i++) {
			for (int j = i; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					count++;
				}
			}
		}

		return count;
	}

	public static int countDistinctSubstringsWithEvenOdd(String[] arr) {

		int count = 0;

		Set<String> encodedStringSet = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			String encodedString = getEvenOddEncodedString(arr[i]);

			if (!encodedStringSet.contains(encodedString)) {
				encodedStringSet.add(encodedString);
			}
		}

		return encodedStringSet.size();
	}

	private static String getEvenOddEncodedString(String input) {

		int[] evenHash = new int[26];
		int[] oddHash = new int[26];

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if ((i & 1) != 0) {
				oddHash[ch - 'a']++;
			} else {
				evenHash[ch - 'a']++;
			}
		}

		String encodedString = "";

		for (int i = 0; i < evenHash.length; i++) {
			encodedString += evenHash[i];
		}

		encodedString += "-";

		for (int i = 0; i < oddHash.length; i++) {
			encodedString += oddHash[i];
		}

		return encodedString;

	}

	public static Set<String> getWordsFromString(String input) {
		Set<String> set = new HashSet<>();

		int state = IN;

		String word = "";

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (ch == '\t' || ch == ' ' || ch == '\n') {
				state = OUT;
			} else if (state == OUT) {
				state = IN;
				set.add(word);
				word = "";
			}

			if (state == IN) {
				word += ch;
			}
		}

		if (state == IN) {
			set.add(word);
		}

		return set;
	}

	public static int countOfNonEmptySubStrings(String input) {

		if (input == null)
			return 0;

		int n = input.length();

		return n * (n + 1) / 2;
	}

	/**
	 * https://www.geeksforgeeks.org/longest-sub-string-of-0s-in-a-binary-string-which-is-repeated-k-times/
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static int longestStringOf0(String input, int k) {

		input = (k == 1) ? input : (input + input);

		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (ch == '0') {
				count++;
			} else {
				maxCount = Math.max(maxCount, count);
				count = 0;
			}
		}

		if (k == 1) {
			return maxCount;
		} else {
			if (maxCount == input.length() * 2) {
				return k * maxCount;
			} else {
				return maxCount;
			}
		}
	}

	/**
	 * https://www.geeksforgeeks.org/count-of-non-overlapping-sub-strings-101-and-010-in-the-given-binary-string/
	 * 
	 * @param input
	 * @return
	 */
	public static int countNonOverlapping101or010(String input) {

		int n = input.length();
		int count = 0;
		int i = 0;

		while (i < n) {

			if (i + 2 < n) {

				String subStr = input.substring(i, i + 3);
				if ("101".equals(subStr) || "010".equals(subStr)) {
					count++;
					i = i + 3;
				} else {
					i++;
				}

			} else {
				break;
			}

		}

		return count;
	}

	/**
	 * https://www.geeksforgeeks.org/check-whether-str1-can-be-converted-to-str2-with-the-given-operations/
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean checkIfS1canBeConvertedToS2(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();

		if (m < n)
			return false;

		int i = 0;
		int j = 0;

		while (i < m && j < n) {

			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {

				if (i + 1 < m && s1.charAt(i) == '0' && s1.charAt(i + 1) == '0' && s2.charAt(j) == '1') {
					i = i + 2;
					j++;
				} else {
					return false;
				}
			}

		}

		return (i == m && j == n);
	}

	/**
	 * 
	 * 
	 * 
	 * @param input
	 * @return
	 */
	public static int getMaxLenOddParityStringLen(String input) {

		int count = 0;

		int firstIndex = -1;
		int lastIndex = -1;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '1') {

				if (firstIndex == -1) {
					firstIndex = i;
				}

				lastIndex = i;
				count++;
			}
		}

		if (count == 0) {
			return 0;
		} else if (count % 2 != 0) {
			return input.length();
		} else {

			return Math.max(lastIndex, input.length() - firstIndex - 1);

		}

	}

	public static int minOperationForTransform(String input, int a, int b) {

		int count = 0;

		int m = input.length();

		int i = m - 1;

		while (i >= m - b) {

			char ch = input.charAt(i);

			if (i != m - a - 1) {
				if (ch == '1')
					count++;
			} else {
				if (ch == '0')
					count++;
			}

			i--;

		}

		return count;
	}

	public static int calculateScoreOfString(String input) {

		int score = 0;

		Character prev = null;
		int count = 0;
		int i = 0;

		for (i = 0; i < input.length(); i++) {

			char ch = input.charAt(i);

			if (prev != null && prev != ch) {

				int n = count * count;
				score = score + ((prev == '0') ? -n : n);
				count = 0;
			}

			prev = ch;
			count++;
		}

		if (i == input.length() && prev != null) {
			int n = count * count;
			score = score + ((prev == '0') ? -n : n);
		}

		return score;
	}

	public static boolean is1Equidistant(String input) {

		Integer distance = null;

		Integer prevIndex = null;

		for (int i = 0; i < input.length(); i++) {

			char ch = input.charAt(i);

			if (ch == '1') {
				if (prevIndex != null) {

					if (distance == null) {
						distance = i - prevIndex;
					} else {
						if (distance != i - prevIndex)
							return false;
					}

				}

				prevIndex = i;
			}

		}

		return true;
	}

	public static boolean isPanagram(String input) {

		int[] cache = new int[26];

		input = input.toLowerCase();

		for (int i = 0; i < input.length(); i++) {

			char ch = input.charAt(i);

			if (Character.isAlphabetic(ch)) {
				cache[ch - 'a']++;
			}

		}

		for (int i = 0; i < 26; i++) {
			if (cache[i] == 0)
				return false;
		}

		return true;
	}

	public static String getMissingCharactersFromPanagram(String input) {

		int[] cache = new int[26];

		input = input.toLowerCase();

		String output = "";

		for (int i = 0; i < input.length(); i++) {

			char ch = input.charAt(i);

			if (Character.isAlphabetic(ch)) {
				cache[ch - 'a']++;
			}

		}

		for (int i = 0; i < 26; i++) {
			if (cache[i] == 0)
				output = output + ((char) (i + 'a'));
		}

		return output;

	}

	public static boolean isPanagramicLipogram(String input) {
		int[] cache = new int[26];

		input = input.toLowerCase();

		for (int i = 0; i < input.length(); i++) {

			char ch = input.charAt(i);

			if (Character.isAlphabetic(ch)) {
				cache[ch - 'a']++;
			}

		}

		int zeroCount = 0;
		for (int i = 0; i < 26; i++) {
			if (cache[i] == 0)
				zeroCount++;
		}

		return zeroCount == 1;
	}

	public static String removeAllPunc(String input) {
		input = input.replaceAll("\\p{Punct}", "");
		return input;
	}

	public static boolean isAnagram(String s1, String s2) {

		int[] cache = new int[256];

		for (int i = 0; i < s1.length(); i++) {
			cache[s1.charAt(i)]++;
		}

		for (int i = 0; i < s1.length(); i++) {
			cache[s1.charAt(i)]--;
		}

		return true;
	}

	public static void printAnagramsTogther(String[] words) {
		List<String> allWords = getAllAnagrams(words);

		for (String word : allWords) {
			System.out.print(word + "  ");
		}

		System.out.println();
	}

	public static void searchAnagram(String text, String pattern) {

		int n = text.length();
		int m = pattern.length();

		int[] textCount = new int[256];
		int[] patternCount = new int[256];

		int i = 0;
		for (; i < m; i++) {
			textCount[text.charAt(i)]++;
			patternCount[pattern.charAt(i)]++;
		}

		for (; i < n; i++) {

			if (Arrays.equals(textCount, patternCount)) {
				System.out.println("Pattern starts at index : " + (i - m));
				return;
			}

		}
	}

	public static List<String> getAllAnagrams(String[] words) {
		List<String> result = new ArrayList<String>();

		Map<String, List<String>> stringsByHashMap = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			String hash = getSortedHash(words[i]);

			if (!stringsByHashMap.containsKey(hash)) {
				stringsByHashMap.put(hash, new ArrayList<String>());
			}

			stringsByHashMap.get(hash).add(words[i]);
		}

		for (Map.Entry<String, List<String>> entry : stringsByHashMap.entrySet()) {

			for (String word : entry.getValue()) {
				result.add(word);
			}

		}

		return result;
	}

	private static String getSortedHash(String input) {
		int[] cache = new int[26];

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			cache[ch - 'a']++;
		}

		String hash = "";
		for (int i = 0; i < input.length(); i++) {

			if (cache[i] > 0) {
				hash += ((char) (cache[i] + 'a'));
			}

		}

		return hash;
	}

	private static boolean isSubSeqRec(String a, String b, int m, int n) {

		if (m == 0 && n == 0)
			return true;

		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			return isSubSeqRec(a, b, m - 1, n - 1);
		}

		return isSubSeqRec(a, b, m, n - 1);
	}

	static class IntCompare implements Comparator<Integer> {
		@Override
		public int compare(Integer arg0, Integer arg1) {
			if (arg0 > arg1)
				return -1;
			else if (arg0 < arg1)
				return 1;
			else
				return 0;
		}
	}

	public static String reverseWords(String input) {

		String[] words = input.split("\\.");
	
		String result = "";
		
		for(int i = words.length - 1; i >= 0; i--) {
			
			result = result + (("".equals(result)) ? "" : ".") + words[i]; 
			
		}
		
		return result;
		
	}
	
	public static void printFrequency(int[] arr, int N) {
		
		Map<Integer, Integer> map = getFrequency(arr);
		
		for(int i = 1; i <= N; i++) {
			System.out.print(map.get(i) + " ");
		}
		System.out.println();
		
	}
	
	public static Map<Integer, Integer> getFrequency(int[] arr) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int val : arr) {
			Integer count = map.get(val);
			
			count = (count == null) ? 1 : count + 1;
			
			map.put(val, count);
		}
		
		return map;
		
	}
}
