
public class ArrayHelper {

	/**
	 * 
	 * Reverse part of array between left and right index
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void reverseArray(int[] arr, int left, int right) {

		if (left < 0 || right >= arr.length)
			return;

		while (left < right) {
			swap(arr, left++, right--);
		}
	}

	/**
	 * Reverse the whole array
	 * 
	 * @param arr
	 */
	public static void reverseArray(int[] arr) {
		reverseArray(arr, 0, arr.length - 1);
	}

	/**
	 * Swap elements at two indices of the array
	 * 
	 * @param arr
	 * @param firstIndex
	 *            *
	 * @param lastIndex
	 */
	public static void swap(int[] arr, int firstIndex, int lastIndex) {
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[lastIndex];
		arr[lastIndex] = temp;
	}

	/**
	 * Shift the array on the left side by the 2.
	 * 
	 * @param arr
	 * @param d
	 */
	public static void rotateArray(int[] arr, int d) {

		reverseArray(arr, 0, d - 1);
		reverseArray(arr, d, arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);

	}

	/**
	 * Search an element in the sorted array.
	 * 
	 * @param arr
	 * @param val
	 * @return
	 */
	public static int binarySearch(int[] arr, int val) {
		int left = 0;
		int right = arr.length;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (arr[mid] == val) {
				return mid;
			} else if (val > arr[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	/**
	 * Return rotation point of the array
	 * 
	 * @param arr
	 * @return
	 */
	public static int findPivotIndex(int[] arr) {

		if (arr.length == 0)
			return -1;

		int pivotIndex = 0;

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {

			int mid = (left + right) / 2;
			
			if (mid == right && arr[mid] > arr[pivotIndex]) {
				return mid;
			} else if (arr[mid + 1] < arr[mid]) {
				return mid;
			} else if (arr[mid] > arr[pivotIndex]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}

		return -1;

	}

}
