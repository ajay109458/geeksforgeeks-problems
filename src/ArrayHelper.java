
public class ArrayHelper {

	public static void reverseArray(int[] arr, int left, int right) {
		while (left < right) {
			swap(arr, left++, right--);
		}
	}

	public static void reverseArray(int[] arr) {
		reverseArray(arr, 0, arr.length - 1);
	}
	
	public static void swap(int[] arr, int firstIndex, int lastIndex) {
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[lastIndex];
		arr[lastIndex] = temp;
	}

	
	
}
