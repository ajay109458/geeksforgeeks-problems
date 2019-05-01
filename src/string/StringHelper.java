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
