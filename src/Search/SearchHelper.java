package Search;

import java.util.Arrays;

public class SearchHelper {
	
	/**
	 * You are given a list of n-1 integers and these integers are in the range of 1 to n. 
	 * There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
	 * @param arr
	 * @return
	 */
	public static int findMissingNumber(int[] arr) {
		
		int sumOfArray = 0;
		
		for(int ele : arr) {
			sumOfArray += ele;
		}
		
		int n = arr.length + 1;
		
		int sumN = ( n * (n+1))/2;
		
		return sumN - sumOfArray;
	}
	
	
	public static void printPairWithSumClosestToZero(int[] arr) {
		
		Arrays.sort(arr);
		
		int left = 0; 
		int right = arr.length - 1;
		
		int minSum = Integer.MAX_VALUE;
		
		int minL;
		int minR;
		
		
		while (left < right) {
			
			int sum = arr[left] + arr[right];
			
			if (Math.abs(sum) < minSum) {
				minSum = Math.abs(sum);
				minL = left;
				minR =right;
			}
			
			if (sum > 0) {
				right--;
			} else {
				left ++;
			}
			
			
		}
		
		System.out.println("Min abs possible sum is : " + minSum);
		
	}
	
	public static int findSecondLargest(int[] arr) {
		
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
			} else if (arr[i] > secondLargest) {
				secondLargest = arr[i];
			}
			
		}
		
		return secondLargest;
	}

}
