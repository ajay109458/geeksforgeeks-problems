import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import practice.ArrayPractice;

public class PracticeTest {
	
	@Test
	void checkParanthesis() {
		ArrayPractice.printParanthesis(3);
	}
	
	@Test
	@DisplayName("Test : Alternate sorting of the array")
	void checkArrayAlternateSorting() {
		int[] arr = { 7, 1, 2, 3, 4, 5, 6 };

		ArrayPractice.alternateSorting(arr);

		assertArrayEquals(new int[] { 1, 7, 2, 4, 3, 6, 5 }, arr);
	}
	
	@Test
	@DisplayName("Test : Sort a k sorted array")
	void checkKSortedArray() {
		int[] arr = { 6, 5, 3, 2, 8, 10, 9 };

		ArrayPractice.sortKsortedArray(arr, 3);

		assertArrayEquals(new int[] { 2, 3, 5, 6, 8, 9, 10 }, arr);
	}
	
	@Test
	@DisplayName("Test: Inversion count") 
	void inversionCount() {
		int arr[] = { 1, 20, 6, 4, 5 }; 
		
		//int inversionCount = ArrayPractice.inversionCount(arr);
		
		//assertEquals(5, inversionCount);
	}
	
	@Test
	@DisplayName("Test: Max subarray product")
	void checkSubarrayProduct() {
		int[] arr = {6, -3, -10, 0, 2};
		
		int maxProduct = ArrayPractice.maxSubarryProduct(arr);
		
		assertEquals(180, maxProduct);
	}

}
