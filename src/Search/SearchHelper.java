package Search;

import java.util.Arrays;

public class SearchHelper {

	/**
	 * You are given a list of n-1 integers and these integers are in the range of 1
	 * to n. There are no duplicates in list. One of the integers is missing in the
	 * list. Write an efficient code to find the missing integer.
	 * 
	 * @param arr
	 * @return
	 */
	public static int findMissingNumber(int[] arr) {

		int sumOfArray = 0;

		for (int ele : arr) {
			sumOfArray += ele;
		}

		int n = arr.length + 1;

		int sumN = (n * (n + 1)) / 2;

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
				minR = right;
			}

			if (sum > 0) {
				right--;
			} else {
				left++;
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

	public static void printKLargest(int[] arr, int k) {

		Arrays.sort(arr);

		for (int i = 0; i < k; i++) {
			System.out.print(arr[arr.length - i - 1] + " ");
		}
		System.out.println();
	}

	public static int getMedian1(int[] arr1, int[] arr2) {

		int m = arr1.length;
		int n = arr2.length;

		int m1 = 0;
		int m2 = 0;

		int i = 0;
		int j = 0;

		int totalSize = m + n;

		for (int k = 0; k <= totalSize / 2; k++) {

			if (totalSize % 2 == 0) {
				m2 = m1;
			}

			if (i != m && j != n) {
				m1 = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++];
			} else if (i < n) {
				m1 = arr1[i++];
			} else {
				m1 = arr2[j++];
			}
		}

		return (totalSize % 2 == 1) ? m1 : (m1 + m2) / 2;

	}
	
	
	public static int findPeakLinearly(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean isPeak = true;
			
			if ( i > 0) {
				isPeak = (arr[i] > arr[i-1]);
			}
			
			if (i < arr.length - 1) {
				isPeak = (arr[i] > arr[i+1]);
			}
			
			if (isPeak)
				return arr[i];
			
		}
		
		return -1; 
	}

}
