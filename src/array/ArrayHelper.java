package array;

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
		int right = arr.length - 1;

		return binarySearch(arr, left, right, val);
	}

	public static int binarySearch(int[] arr, int left, int right, int val) {
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

	/**
	 * Search an element in pivoted sorted array
	 * 
	 * @param arr
	 * @param val
	 * @return
	 */
	public static int searchElementInPivotedArray(int[] arr, int val) {

		int pivotIndex = findPivotIndex(arr);
		int searchIndex = binarySearch(arr, 0, pivotIndex, val);

		if (searchIndex == -1) {
			searchIndex = binarySearch(arr, pivotIndex, arr.length - 1, val);
		}

		return searchIndex;
	}

	/**
	 * Find maximum value of Sum( i*arr[i]) with only rotations on given array
	 * allowed
	 * 
	 * @param arr
	 * @return
	 */
	public static int maximumRotationSum(int[] arr) {
		int sum = 0;
		int currSum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			currSum += (i * arr[i]);
		}

		int result = currSum;

		for (int i = 1; i < arr.length; i++) {

			int newSum = currSum + sum - (arr.length * arr[arr.length - i]);

			result = Math.max(newSum, result);

			currSum = newSum;
		}

		return result;
	}

	/**
	 * Equilibrium index is an index of the array where sum on left and right of the
	 * array are equal.
	 * 
	 * @param arr
	 * @return
	 */
	public static int getEquilibriumIndex(int[] arr) {

		int index = -1;

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum -= arr[i];

			if (currSum == sum)
				return i;

			currSum += arr[i];
		}

		return index;
	}

	/**
	 * Elements lies in range 0 to n - 1
	 * 
	 * @param arr
	 */
	public static void printDuplicates(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] < 0) {
				System.out.println(Math.abs(arr[i]));
			} else {
				arr[Math.abs(arr[i])] *= -1;
			}
		}

	}

	/**
	 * Print minimum length of unsorted array. Sorting which makes complete array
	 * sorted.
	 * 
	 * @param arr
	 */
	public static void minimumLengthUnsortedArray(int[] arr) {

		int s = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				s = i;
				break;
			}
		}

		int t = arr.length - 1;

		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				t = i;
				break;
			}
		}

		int min = arr[s];
		int max = arr[s];
		for (int i = s; i <= t; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		while (true) {
			if (s > 0 && arr[s - 1] > min)
				s--;
			else
				break;
		}

		while (true) {
			if (t < arr.length - 1 && arr[t + 1] < max)
				t++;
			else
				break;
		}

		System.out.println("Max length : " + (t - s + 1));
	}

	/**
	 * Sort an array of 0, 1 and 2
	 * 
	 * @param arr
	 */
	public static void sortArrayOf012(int[] arr) {
		int i = -1;
		int j = 0;
		int k = arr.length;

		while (j < k) {

			if (arr[j] == 0) {
				swap(arr, ++i, j++);
			} else if (arr[j] == 1) {
				j++;
			} else if (arr[j] == 2) {
				swap(arr, --k, j);
			}
		}
	}
	
	
	/**
	 * Search a ceil element in the array. Ceil element means element equal to an element or just greater than the element.
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @param val
	 * @return
	 */
	public static int ceilSearch(int[] arr, int left, int right, int val) {
		
		if(right > left)
			return -1;
		
		if(val <= arr[left]) {
			return left;
		}
		
		if (arr[right] < val)
			return -1;
		
		int mid = (left + right) / 2;
		
		if (arr[mid] ==  val) {
			return mid;
		} else if (arr[mid] < val && val < arr[mid+1]) {
			return mid + 1;
		} else if (arr[mid] < val) {
			return ceilSearch(arr, left, mid - 1, val);
		} else {
			return ceilSearch(arr, mid + 1, right, val);
		}
	}
	
	public static void printUnionOfTwoSortedArray(int[] arr1, int[] arr2) {
		
		int i = 0; 
		int j = 0;
		
		while ( i < arr1.length && j < arr2.length) {
			
			if (arr1[i] == arr2[j]) {
				System.out.print(arr1[i++] + " ");
				j++;
			} else if (arr1[i] < arr2[j]) {
				System.out.print(arr1[i++] + " ");
			} else {
				System.out.print(arr2[j++] + " ");
			}
		}
		
		while(i < arr1.length) {
			System.out.print(arr1[i++] + " ");
		}
		
		while (j < arr2.length) {
			System.out.print(arr2[j++] + " ");
		}
	}
	
	public static int linearSearch(int[] arr, int val) {
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == val)
				return i;
		}
		
		return -1;
	}
}