package practice;

import java.util.HashMap;
import java.util.Map;

import array.ArrayHelper;

public class ArrayPractice {

	public static void printDuplicates(int arr[], int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		boolean isDuplicate = false;
		for (int val : arr) {
			Integer count = map.get(val);

			if (count == null) {
				count = 1;
			} else {
				isDuplicate = true;
				count++;
			}

			map.put(val, count);
		}

		for (int val : arr) {
			Integer count = map.get(val);

			if (count > 1) {
				System.out.print(count + " ");
			}
		}

		if (!isDuplicate) {
			System.out.print("-1");
		}

		System.out.println();
	}
	
	public static void printParanthesis(int n) {
		printParantesis(0, 0, n, "");
	}
	
	private static void printParantesis(int openCount, int closedCount, int n, String input) {
		
		if (closedCount == n) {
			System.out.println(input);
		}
		
		if (closedCount < openCount) {
			printParantesis(openCount, closedCount + 1, n, input + ")");
		}

		if (openCount < n) {
			printParantesis(openCount + 1, closedCount, n, input + "(");
		}
	}
	
	
	/**
	 * 
	 * @param arr
	 */
	public static void alternateSorting(int[] arr) {
		
		for (int i = 1; i < arr.length; i = i + 2) {
			if (arr[i-1] > arr[i]) {
				ArrayHelper.swap(arr, i-1, i);
			}
			
			if (i+1 < arr.length && arr[i+1] > arr[i]) {
				ArrayHelper.swap(arr, i+1, i);
			}
		}
		
	}

}
