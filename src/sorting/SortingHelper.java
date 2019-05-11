package sorting;

import java.util.Arrays;

import array.ArrayHelper;

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
		
		while ( j < k) {
			
			if (arr[j] == 0) {
				ArrayHelper.swap(arr, ++i, j++);
			} else if (arr[j] == 1) {
				j++;
			} else if(arr[j] == 2) {
				ArrayHelper.swap(arr, j, --k);
			}
		}
		
	}

}
