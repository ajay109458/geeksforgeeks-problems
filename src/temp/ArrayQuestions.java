package temp;

import array.ArrayHelper;

public class ArrayQuestions {

	public void rotateArrayLeft(int[] arr, int k) {

		ArrayHelper.reverseArray(arr, 0, k);
		ArrayHelper.reverseArray(arr, k + 1, arr.length - 1);
		ArrayHelper.reverseArray(arr);

	}
	
	public void rotateArrayRight(int[] arr, int k) {
		ArrayHelper.reverseArray(arr, 0, arr.length - k -1);
		ArrayHelper.reverseArray(arr, k, arr.length -1);
		ArrayHelper.reverseArray(arr);
	}
	
	public int getPivotIndex(int[] arr) {
		int left = 0;
		int right = arr.length -1;
		
		while (left <= right) {
			int mid = left + (right-left)/2;
			
			if (arr[mid] > arr[mid+1]) {
				return mid;
			} else if (arr[mid] > arr[0]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return -1;
	}
 
}
