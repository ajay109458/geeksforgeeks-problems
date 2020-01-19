package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
	
	/**
	 * Sort a array where each element of the array is k distance
	 * away from its target position
	 * @param arr
	 * @param k
	 */
	public static void sortKsortedArray(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		int i = 0;
		for (; i <=k && i<= arr.length; i++) {
			minHeap.add(arr[i]);
		}
		
		int t=0;
		
		for (; i < arr.length; i++) {
			arr[t++] = minHeap.remove();
			minHeap.add(arr[i]);
		}
		
		while(!minHeap.isEmpty()) {
			arr[t++] = minHeap.remove();
		}
	}
	
	public static int inversionCount(int[] arr) {
		return mergeSort(arr, 0, arr.length-1);
	}
	
	public static int mergeSort(int[] arr, int left, int right) {
		
		int inversionCount = 0;
		
		if (left < right) {
			
			int mid = (left + right) / 2;
			
			
			
			inversionCount += mergeSort(arr, left, mid);
			inversionCount += mergeSort(arr, mid + 1, right);
			
			inversionCount += merge(arr, left, mid, right);
		}
		
		return inversionCount;
	}
	
	public static int merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		
		int count = 0;
		
		int i = left;
		int j = mid + 1;
		int k = 0;
		
		while (i <= mid && j <=  right) {
			
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				count += (mid - i);
			}
		}
		
		while (i <= mid) {
			temp[k++] = arr[i++];
		}	
		
		while(j <= right) {
			temp[k++] = arr[j++];
		}
		
		for (i = left; i <= right; i++) 
	        arr[i] = temp[i-left]; 
		
		return count;
	}
	
	/***
	 * Rearrange an array st. arr[i] = i
	 */
	
	public static void rearrangeArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			
			int x = arr[i];
			
			while ( arr[x] != -1 && arr[x] != x) {
				int y = arr[x];
				
				arr[x] = x;
				
				x = y;
			}
			
			arr[x] = x;
			
			if (arr[x] != -1) {
				arr[x] = -1;
			}
			
		}
	}
	
	public static int maxSubarryProduct(int[] arr) {
		
		int maxPositive = 1;
		int minNegetive = 1;
		int overAllMax = 1;
		
		for (int i = 0; i < arr.length; i++) {
			
			int val = arr[i];
			
			if (val > 0) {
				
				maxPositive = maxPositive * arr[i];
				minNegetive = Math.min(1, minNegetive * val);
				
			} else if (val == 0) {
				
				maxPositive = 1;
				minNegetive = 1;
				
			} else if (val < 0) {
				
				int temp = maxPositive;
				
				maxPositive = Math.max(1, minNegetive * val);
				minNegetive = temp * val;
			} 
			
			if (overAllMax < maxPositive) {
				overAllMax = maxPositive;
			}
		}
		
		return overAllMax;
		
	}

}
