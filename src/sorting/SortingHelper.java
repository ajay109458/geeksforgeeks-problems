package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import array.ArrayHelper;
import utils.Pair;

public class SortingHelper {

	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	public static int mergeSortInversionCount(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	private static int mergeSort(int[] arr, int left, int right) {

		if (right <= left) {
			return 0;
		}

		int mid = (left + right) / 2;

		int invCount = mergeSort(arr, left, mid);
		invCount += mergeSort(arr, mid + 1, right);

		invCount += merge(arr, left, mid, right);

		return invCount;
	}

	private static int merge(int[] arr, int left, int mid, int right) {

		int i = left;
		int j = mid + 1;

		int invCount = 0;

		if (left <= right) {

			int[] temp = new int[right - left + 1];

			int index = 0;
			while (i <= mid && j <= right) {
				if (arr[i] <= arr[j]) {
					temp[index++] = arr[i++];
				} else {
					temp[index++] = arr[j++];
					invCount += (mid - i + 1);
				}
			}

			while (i <= mid) {
				temp[index++] = arr[i++];
			}

			while (j <= right) {
				temp[index++] = arr[j++];
			}

			for (i = 0; i < temp.length; i++) {
				arr[left + i] = temp[i];
			}
		}

		return invCount;

	}

	public static void sort012(int[] arr) {

		int i = -1;
		int j = 0;
		int k = arr.length;

		while (j < k) {

			if (arr[j] == 0) {
				ArrayHelper.swap(arr, ++i, j++);
			} else if (arr[j] == 1) {
				j++;
			} else if (arr[j] == 2) {
				ArrayHelper.swap(arr, j, --k);
			}
		}

	}

	public static void sortNearlySortedArray(int[] arr, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int i = 0;
		while (i <= k) {
			pq.add(arr[i++]);
		}

		int rIndex = 0;
		while (i < arr.length) {

			arr[rIndex++] = pq.remove();
			pq.add(arr[i++]);
		}

		
		while(!pq.isEmpty()) {
			arr[rIndex++] = pq.remove();
		}
	}
	
	public static int countDistinctPairWithDiffK(int[] arr, int k) {
		
		Arrays.sort(arr); 
		
		int i = 0;
		int j = 1;
		
		int count = 0;
		
		while(j < arr.length) {
			int diff = arr[j] - arr[i];
			
			if (diff == k) {
				count++;
				i++;
			} else if (diff > k) {
				i++;
			} else {
				j++;
			}
		}
		
		return count;
	}
	
	public static void bubbleSort(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					ArrayHelper.swap(arr, j, j+1);
				}
			}
		}
		
	}
	
	/**
	 * Given a sorted array and a number x, find the pair in array whose sum is closest to x
	 */
	public static Pair getPairWithClosestSum(int[] arr, int x) {
		Pair p = new Pair();
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr.length - 1;
		
		int minDiff = Integer.MAX_VALUE;
		
		while(left < right) {
		
			int currSum = arr[left] + arr[right];
			int diff = currSum - x;
			
			if (Math.abs(diff) < minDiff) {
				minDiff = Math.abs(diff);
				p.x = left;
				p.y = right;
			}
		 
			if (diff > 0) {
				right--;
			} else if (diff < 0) {
				left++;
			} else {
				break;
			}
		}
		
		return p;
	}
	
	public static void waveFormSort(int[] arr) {
		
		int index = 1;
		
		while (index < arr.length) {
			if (arr[index-1] > arr[index]) {
				ArrayHelper.swap(arr, index - 1, index);
			}
			
			if (index + 1 < arr.length && arr[index + 1] > arr[index]) {
				ArrayHelper.swap(arr, index + 1, index);
			}	
			
			index = index + 2;
		}
	}	
	
	public static boolean isIntervalOverlaps(Pair[] pairs) {
		
		Arrays.sort(pairs, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.x > o2.x)
					return 1;
				else if (o1.x < o2.x)
					return -1;
				else 
					return 0;
			}
		});
		
		
		return false;
	}
	

}
