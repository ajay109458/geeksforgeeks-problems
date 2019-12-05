

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
	void searchInPivotedArray() {
		int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		
		int actualIndex = SearchHelper.findInSortedRotatedArray(arr, 3);
		assertEquals(8, actualIndex);
	}

	@Test
	void checkTestMedian() {
		int arr1[] = {1, 12, 15, 26, 38}; 
	    int arr2[] = {2, 13, 17, 30, 45}; 
	    
	    float median = SearchHelper.findMedian(arr1, arr2);
	    
	    System.out.println(median);
	    
	    assertEquals(16, median);
	}
	
	
	
}
