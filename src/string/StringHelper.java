package string;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StringHelper {
	
	/**
	 * @param n
	 * Find the smallest number such that the sum of its digits is N and it is divisible by 10^N.
	 */
	public static void printDigitNum(int n) {
		
		if (n == 0)
			System.out.println("0");
		
		if ( n % 9 > 0) {
			System.out.print(n%9);
		}
		
		for (int i = 0; i < n/9; i++) {
			System.out.print(9);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(0);
		}
		
		System.out.println();
		
	}
	
	/**
	 * Minimum sum of squares of character counts in a given string after removing k characters
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
		
		for(int i = 0; i < len; i++) {
			freq[input.charAt(i) - 'a']++;
		}
		
		Comparator<Integer> c = new IntCompare();
		
		PriorityQueue<Integer> q = new PriorityQueue<>(c);
		
		for(int i = 0; i < freq.length; i++) {
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
		while(!q.isEmpty()) {
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
		
		while(i < input1Len && j < input2Len) {
			
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
	
	private static boolean isSumSubstringUtils(String input, int beg, int len1, int len2) {
		
		String s1 = input.substring(beg, len1);
		String s2 = input.substring(beg + len1, len2);
		
		//TODO : Get S3
		String s3 = "";
		
		if (s3.length() > input.length() - (beg + len1 + len2))
			return false;
		
		if (s3.equals(input.substring(beg + len1 + len2, s3.length()))) {
			
			if(beg + len1 + len2 + s3.length() == input.length())
				return true;
			
			
			return isSumSubstringUtils(input, beg + len1, len2, s3.length());
		}
		
		return false;
	}
	
	static class IntCompare implements Comparator<Integer>{ 
        @Override
        public int compare(Integer arg0, Integer arg1) { 
            if(arg0 > arg1) 
                return -1; 
            else if(arg0 < arg1) 
                return 1; 
            else
                return 0; 
        } 
    } 

}
