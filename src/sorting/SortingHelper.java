package sorting;

import java.util.Arrays;

public class SortingHelper {

	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int left, int right) {

		if (right <= left) {
			return;
		}

		int mid = (left + right) / 2;

		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);

		merge(arr, left, mid, right);
	}

	private static void merge(int[] arr, int left, int mid, int right) {

		int i = left;
		int j = mid + 1;

		if (left <= right) {

			int[] temp = new int[right - left + 1];

			int index = 0;
			while (i <= mid && j <= right) {
				if (arr[i] <= arr[j]) {
					temp[index++] = arr[i++];
				} else {
					temp[index++] = arr[j++];
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

	}

}
