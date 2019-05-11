package sorting;

import java.util.Arrays;

import array.ArrayHelper;

public class SortMain {

	public static void main(String[] args) {
		
		/**
		 * Sort elements by frequency
		 */
		
		int[] arr1 = {2, 5, 2, 8, 5, 6, 8, 8};
		ArrayHelper.sortArrayByFreq(arr1);
		System.out.println(Arrays.toString(arr1));
		
		
		/**
		 * Sort an array by merge sort
		 */
		System.out.println("Sorting array by merge sort : ");
		SortingHelper.mergeSort(arr1);
		System.out.println(Arrays.toString(arr1));
	}
	
}
