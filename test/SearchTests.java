
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Search.SearchHelper;
import utils.Pair;

public class SearchTests {

	@Test
	void checkMissingElement() {
		int[] arr1 = { 1, 2, 3, 5, 6, 7, 8 };

		int actualMissingNumber = SearchHelper.findMissingNumber(arr1);
		assertEquals(4, actualMissingNumber);
	}

	@Test
	void searchInPivotedArray() {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };

		int actualIndex = SearchHelper.findInSortedRotatedArray(arr, 3);
		assertEquals(8, actualIndex);
	}

	@Test
	void checkTestMedian() {
		int arr1[] = { 1, 12, 15, 26, 38 };
		int arr2[] = { 2, 13, 17, 30, 45 };

		float median = SearchHelper.findMedian1(arr1, arr2);

		System.out.println(median);

		assertEquals(16, median);
	}

	@Test
	void checkPairsWithSumClosestToZero() {

		int arr[] = { 1, 60, -10, 70, -80, 85 };

		Pair pair = SearchHelper.printPairWithSumClosestToZero(arr);

		assertEquals(-80, pair.x);
		assertEquals(85, pair.y);

	}

	@Test
	void checkSecondLargest() {
		int arr[] = { 12, 13, 1, 10, 34, 1 };

		int actualSecondLargest = SearchHelper.findSecondLargest(arr);

		assertEquals(13, actualSecondLargest);
	}

	@Test
	void checkKthSmallestElement() {
		int[][] mat = { {10, 20, 30, 40}, 
                {15, 25, 35, 45}, 
                {25, 29, 37, 48}, 
                {32, 33, 39, 50}, 
              };
		
		int actualKthSmallest = SearchHelper.findKthSmallest(mat, 7);
		
		//System.out.println(actualKthSmallest);
		
		assertEquals(30, actualKthSmallest);
	}
	
	@Test
	void checkPrintKClosest() {
		int arr[] ={12, 16, 22, 30, 35, 39, 42, 
	               45, 48, 50, 53, 55, 56}; 
		SearchHelper.printKclosestElements(arr, 35, 4);
	}
	
	@Test
	void checkSearchInAltSwapArray() {
		int arr[] = {3, 2, 10, 4, 40};
		int x = 4;
		
		int actualIndex = SearchHelper.searchInAltSwapArray(arr, x);
		
		System.out.println(actualIndex);
		
		assertEquals(3, actualIndex);
	} 

}
