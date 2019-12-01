

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Search.SearchHelper;
import array.ArrayHelper;

public class SearchTests {
	
	@Test
	void checkMissingElement() {
		int[]  arr1 = {1, 2, 3, 5, 6, 7, 8};
		
		int actualMissingNumber = SearchHelper.findMissingNumber(arr1);
		assertEquals(4, actualMissingNumber);
	}
	
	@Test
	void checkElementInPivotedArray() {
		int[] arr2 =  {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int actualSearchIndex = ArrayHelper.searchElementInPivotedArray(arr2, 3);
	
	}

	public static void main(String[] args) {
		
		
		
		
		
		
		/*int[] arr3 = {1, 60, -10, 70, -80, 85}; 
		SearchHelper.printPairWithSumClosestToZero(arr3);
		
		System.out.println("Second largets element in the given array : " + SearchHelper.findSecondLargest(arr3));
		
		System.out.println("Print k largest elements");
		SearchHelper.printKLargest(arr2, 3);
		
		
		/**
		 * Get median of two sorted array of different size 
		 */
		/*int ar4[] = {900};  
	    int ar5[] = {5, 8, 10, 20};  
		System.out.println("Median of the above arrays : " + SearchHelper.getMedian1(ar4, ar5));
		*/
		
		/**
		 * Get peak element in the array
		 */
		//int[] arr6 = {1, 3, 20, 4, 1, 0}; 
		//System.out.println("Get peak element in the array linearly : " + SearchHelper.findPeakLinearly(arr6));
		//System.out.println("Get peak element in the array BS : " + SearchHelper.findPeakBS(arr6));
		
		
	}
	
}
