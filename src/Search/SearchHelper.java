package Search;

import java.util.Arrays;
import java.util.PriorityQueue;

import array.ArrayHelper;
import utils.HeapNode;
import utils.Pair;

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

	public static int findInSortedRotatedArray(int[] arr, int val) {

		int pivotIndex = ArrayHelper.findPivotIndex(arr);

		if (pivotIndex != -1) {
			int searchIndex = ArrayHelper.binarySearch(arr, 0, pivotIndex, val);
			if (searchIndex != -1) {
				return searchIndex;
			}
		}

		return ArrayHelper.binarySearch(arr, pivotIndex + 1, arr.length, val);

	}

	/**
	 * Find median in two sorted array of same size
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static float findMedian(int[] arr1, int[] arr2) {

		int i = 0;
		int j = 0;

		int n = arr1.length - 1;

		for (int count = 0; count < n; count++) {
			if (arr1[i] < arr2[j]) {

				i = (count == n) ? i : i + 1;
			} else {
				j = (count == n) ? j : j + 1;
			}
		}

		System.out.println("ELements are : " + arr1[i] + ",  " + arr2[j]);

		return (arr1[i] + arr2[j]) / 2;

	}

	public static float findMedian1(int[] arr1, int[] arr2) {
		return findMedian1(arr1, arr2, 0, 0, arr1.length);
	}

	private static float findMedian1(int[] arr1, int[] arr2, int left1, int left2, int n) {

		if (n == 0) {
			return -1;
		} else if (n == 1) {
			return (arr1[left1] + arr2[left2]) / 2;
		} else if (n == 2) {
			return (Math.max(arr1[left1], arr2[left2]) + Math.min(arr1[left1 + 1], arr2[left2 + 1])) / 2;
		}

		float m1 = getMedian(arr1, left1, n);
		float m2 = getMedian(arr2, left2, n);

		if (m1 == m2) {
			return m1;
		}

		if (m1 < m2) {

			if (n % 2 == 0) {
				return findMedian1(arr1, arr2, left1 + n / 2 - 1, left2, n - n / 2 + 1);
			} else {
				return findMedian1(arr1, arr2, left1 + n / 2, left2, n - n / 2);
			}
		}

		if (n % 2 == 0) {
			return findMedian1(arr1, arr2, left1, left2 + n / 2 - 1, n - n / 2 + 1);
		} else {
			return findMedian1(arr1, arr2, left1, left2 + n / 2, n - n / 2);
		}
	}

	public static float getMedian(int[] arr, int left, int n) {

		if (n == 0)
			return -1;

		if (n == 1) {
			return arr[left];
		}

		if (n % 2 == 0) {
			return (arr[left + n / 2 - 1] + arr[left + n / 2 + 1]);
		} else {
			return arr[left + n / 2];
		}
	}

	public static Pair printPairWithSumClosestToZero(int[] arr) {

		Arrays.sort(arr);

		int left = 0;
		int right = arr.length - 1;

		int minSum = Integer.MAX_VALUE;

		int minL = -1;
		int minR = -1;

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

		return new Pair(arr[minL], arr[minR]);

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

			if (i > 0) {
				isPeak = (arr[i] > arr[i - 1]);
			}

			if (i < arr.length - 1) {
				isPeak = (arr[i] > arr[i + 1]);
			}

			if (isPeak)
				return arr[i];

		}

		return -1;
	}

	public static int findPeakBS(int[] arr) {
		return findPeakBS(arr, 0, arr.length - 1);
	}

	public static int findKthSmallest(int[][] mat, int k) {

		PriorityQueue<HeapNode> pq = new PriorityQueue<HeapNode>();

		for (int j = 0; j < mat[0].length; j++) {
			HeapNode hNode = new HeapNode(mat[0][j], 0, j);
			pq.add(hNode);
		}

		HeapNode lastNode = null;

		for (int i = 0; i < k; i++) {
			lastNode = pq.poll();

			pq.add(new HeapNode(mat[lastNode.row + 1][lastNode.col], lastNode.row + 1, lastNode.col));
		}

		return lastNode.val;
	}

	public static void printKclosestElements(int[] arr, int val, int k) {

		int left = getCrossoverPoint(arr, val);
		int right = left + 1;

		if (left != -1 && arr[left] == val) {
			left = left - 1;
		}

		int count = 0;
		while (left >= 0 && right < arr.length && count < k) {

			int leftDiff = Math.abs(val - arr[left]);
			int rightDiff = Math.abs(arr[right] - val);

			if (leftDiff < rightDiff) {
				System.out.print(arr[left--] + " ");
			} else {
				System.out.print(arr[right++] + " ");
			}

			count++;
		}

		while (left >= 0 && count < k) {
			System.out.print(arr[left--] + " ");
			count++;
		}

		while (right < arr.length && count < k) {
			System.out.print(arr[right++] + " ");
			count++;
		}

	}

	public static int getCrossoverPoint(int[] arr, int val) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] <= val && (mid == arr.length || arr[mid + 1] > val)) {
				return mid;
			} else if (arr[mid] < val) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;

	}

	private static int findPeakBS(int[] arr, int left, int right) {

		int mid = (left + right) / 2;

		if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] < arr[mid])) {
			return arr[mid];
		} else if (mid > 0 && arr[mid - 1] > arr[mid]) {
			return findPeakBS(arr, left, mid - 1);
		} else {
			return findPeakBS(arr, mid + 1, right);
		}

	}

	public static int searchInAltSwapArray(int[] arr, int val) {

		int left = 0;
		int right = arr.length;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (arr[mid] == val) {
				return mid;
			} else if  (mid != 0 && arr[mid - 1] == val) {
				return mid -1;
			} else if (mid != arr.length - 1 && arr[mid + 1] == val) {
				return mid + 1;
			} else if (val < arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		return right;

	}

}
