package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountSubSeqABC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.nextLine();
		while(N-- > 0) {
			String input = sc.nextLine();
			System.out.println(countSubSeq(input));
		}
	}
	
	public static int countSubSeq(String input) {
		
		List<String> results = new ArrayList<String>();
		
		countSubSeqUtils(input, 0, results, "");
		
		return results.size();
		
	}
	
	private static void countSubSeqUtils(String input, int index, List<String> result, String curr) {
		
		if (input == null || "".equals(input)) {
			return;
		}
		
		if ( index >=  input.length()) {
			return; 
		}
		
		char ch = input.charAt(index);
		
		int currLastIndex = curr.length() - 1;
		
		if (ch == 'a') {
			
			if ("".equals(curr) || curr.charAt(currLastIndex) == 'a') {
				countSubSeqUtils(input, index + 1, result, curr + 'a');
			}
			
			countSubSeqUtils(input, index + 1, result, curr);
			
		} else if (ch == 'b') {
			
			if (! "".equals(curr)  && (curr.charAt(currLastIndex) == 'a' || curr.charAt(currLastIndex) == 'b')) {
				countSubSeqUtils(input, index + 1, result, curr + 'b');
			}
			
			countSubSeqUtils(input, index + 1, result, curr);
		} else if (ch == 'c') {
			
			
			
			if (! "".equals(curr)  && (curr.charAt(currLastIndex) == 'b' || curr.charAt(currLastIndex) == 'c')) {
				countSubSeqUtils(input, index + 1, result, curr + 'c');
				result.add(curr + 'c');
			}
			
			countSubSeqUtils(input, index + 1, result, curr);
			
		}
		
		
		return;
	}
	
}
