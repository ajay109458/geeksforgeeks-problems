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
		//SortingHelper.mergeSort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		/**
		 * Print inversion count using merge sort
		 */
		System.out.println("Print inversion count of the array : " + SortingHelper.mergeSortInversionCount(arr1));
		
		int[] arr2 = {0, 1, 2, 0, 1, 2};
		System.out.println("Sorting array of 012 : ");
		SortingHelper.sort012(arr2);
		System.out.println(Arrays.toString(arr2));
		
		/**
		 * Sort a nearly sorted array
		 */
		int[] arr3 = {6, 5, 3, 2, 8, 10, 9};
		System.out.println("Sort a nearly sorted array : ");
		SortingHelper.sortNearlySortedArray(arr3, 3);
		System.out.println(Arrays.toString(arr3));
		
		/**
		 * Count all distinct pairs with difference equal to k
		 */
		int arr4[] = {1, 5, 3, 4, 2};
		System.out.println("Distint pairs count with diff equal to k : " + SortingHelper.countDistinctPairWithDiffK(arr4, 3));
		
		/**
		 * Sort an array using bubble sort
		 */
		int[] arr5 = {2, 5, 2, 8, 5, 6, 8, 8};
		SortingHelper.bubbleSort(arr5);
		System.out.println(Arrays.toString(arr5));
	}
	
}
