import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import array.ArrayHelper;
import utils.Pair;

class ArrayTests {

	@Test
	@DisplayName("Test : find pivot index in rotated array")
	void checkFindPivotIndexInRotatedArray() {
		int[] arr = { 3, 4, 5, 6, 7, 1, 2 };

		int actualPivotedIndex = ArrayHelper.findPivotIndex(arr);
		int expectedPivotedIndex = 4;
		assertEquals(expectedPivotedIndex, actualPivotedIndex);
	}

	@Test
	@DisplayName("Test : find pivot index in a non-rotated array")
	void checkFindPivotIndexInNonRotatedArray() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		int actualPivotedIndex = ArrayHelper.findPivotIndex(arr);
		int expectedPivotedIndex = arr.length - 1;
		assertEquals(expectedPivotedIndex, actualPivotedIndex);
	}

	@Test
	@DisplayName("Test : Rotate an array")
	void checkArrayRotation() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		ArrayHelper.rotateArray(arr, 2);

		assertArrayEquals(new int[] { 3, 4, 5, 6, 7, 1, 2 }, arr);
	}

	@Test
	@DisplayName("Test : Search an element in rotated array")
	void checkSearchInRotatedArray() {
		int[] arr = { 3, 4, 5, 6, 7, 1, 2 };

		int actualSearchIndex = ArrayHelper.searchElementInPivotedArray(arr, 4);
		int expectedSearchIndex = 1;

		assertEquals(expectedSearchIndex, actualSearchIndex);
	}

	@Test
	@DisplayName("Test : Find maximum rotation sum")
	void checkMaximumRotationSum() {
		int[] arr = { 1, 20, 2, 10 };

		int actualRotationSum = ArrayHelper.maximumRotationSum(arr);
		int expectedRotationSum = 72;

		assertEquals(expectedRotationSum, actualRotationSum);
	}

	@Test
	@DisplayName("Test : Equilibrium index of an array")
	void checkEquilibriumIndexOfArray() {
		int[] arr = { -7, 1, 5, 2, -4, 3, 0 };

		int actualIndex = ArrayHelper.getEquilibriumIndex(arr);
		int expectedIndex = 3;

		assertEquals(expectedIndex, actualIndex);
	}

	@Test
	@DisplayName("Test : Print duplicate values")
	void checkPrintDuplicateValues() {
		int[] arr = { 1, 2, 3, 1, 3, 6, 6 };
		System.out.print("Printing dupicate values : ");
		ArrayHelper.printDuplicates(arr);
	}

	@Test
	@DisplayName("Test : Get minimum unsorted array sorting which makes whole array sorted")
	void checkGetMinimumUnsortedArray() {
		int[] arr = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };

		int actualUnsortedArrayLength = ArrayHelper.getMinimumLengthUnsortedArray(arr);
		int expectedUnsortedArrayLength = 6;

		assertEquals(expectedUnsortedArrayLength, actualUnsortedArrayLength);
	}

	@Test
	@DisplayName("Test : Sort 0 1 2")
	void checkSort012() {

		int[] arr = { 1, 0, 1, 1, 2, 2, 1, 1, 0, 0 };

		ArrayHelper.sortArrayOf012(arr);

		assertArrayEquals(new int[] { 0, 0, 0, 1, 1, 1, 1, 1, 2, 2 }, arr);
	}

	@Test
	@DisplayName("Test : Print union of the array")
	void printUnionOfArray() {
		int[] arr1 = { 1, 4, 5, 8, 10 };
		int[] arr2 = { 1, 3, 5, 7, 10 };
		System.out.print("Printing union of the array : ");
		ArrayHelper.printUnionOfTwoSortedArray(arr1, arr2);
		System.out.println();
	}

	@Test
	@DisplayName("Test : Get missing element in array")
	void printMissingElement() {
		int[] arr = { 1, 2, 3, 5 };

		int actualMissingElement = ArrayHelper.findMissingElement(arr);
		int expectedMissingElement = 4;

		assertEquals(expectedMissingElement, actualMissingElement);
	}

	@Test
	@DisplayName("Test : Bubble sort")
	void checkBubbleSort() {
		int[] arr = { 5, 4, 3, 1, 2 };
		ArrayHelper.bubbleSort(arr);
		
		assertArrayEquals(new int[] {1, 2, 3, 4, 5}, arr);
	}
	
	@Test
	@DisplayName("Test : Print sum close to X")
	void printSumCloseToX() {
		int[] arr = {10, 22, 28, 29, 30, 40};
		ArrayHelper.printPairWithSumClosestToX(arr, 54);
	}
	
	@Test
	@DisplayName("Test : Print array in wave form")
	void checkSortArrayInWaveFormat() {
		int[] arr = {10, 5, 6, 3, 2, 20, 100, 88};
		ArrayHelper.sortArrayInWaveForm(arr);
		
		assertArrayEquals(new int[] {5, 10, 3, 6, 2, 100, 20, 88}, arr);
	}
	
	@Test
	@DisplayName("Test : Check if pairs overlap")
	void checkIfPairsOverlap() {
		Pair[] pairs = new Pair[4];
		pairs[0] = new Pair(1,3);
		pairs[1] = new Pair(5,7);
		pairs[2] = new Pair(2, 4);
		pairs[3] = new Pair(6, 8);
		
		assertTrue(ArrayHelper.checkIfTwoIntervalsOverlap(pairs));
	}
	
	@Test
	@DisplayName("Test : AP dearrangements")
	void checkCountOfDearrangement() {
		int[] arr = {8, 6, 10, 4, 2};
		int actualDearrangements = ArrayHelper.countDearrangementsInAP(arr);
		int expectedDearrangements = 3;
		assertEquals(expectedDearrangements, actualDearrangements);
	}
	
	@Test
	@DisplayName("Test : Min product dearragements count")
	void checkMinProductDearrangements() {
		int[] arrr1 = {4, 3, 2};
		int[] arr2 = {7, 12, 5};
		
		int actualDearrangements = ArrayHelper.minDearrangementsForProductArray(arrr1, arr2);
		int expectedDearrangements = 3;
		assertEquals(expectedDearrangements, actualDearrangements);
	}
	
	@Test
	@DisplayName("Test : Position of an element after stable sort")
	void checkPositionAfterStableSort() {
		int[] arr = {3, 4, 3, 5, 2, 3, 4, 3, 1, 2, 5};
		int actualPosistion = ArrayHelper.positionAfterStableSort(arr, 5);
		int expectedPosition = 6;
		assertEquals(expectedPosition, actualPosistion);
	}
	
	@Test
	@DisplayName("Test : Min diff of chocolate distribution")
	void checkMinDiffChocolateDistribution() {
		int[] arr16 = {7, 3, 2, 4, 9, 12, 56};
		int actualMinDiff = ArrayHelper.minDiffChocolateDistribution(arr16, 3);
		int exxpectedMinDiff = 2;
		assertEquals(exxpectedMinDiff, actualMinDiff);
	}
	
	@Test
	@DisplayName("Test: Sort even and odd numbers")
	void checkSortEvenOdd() {
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
		ArrayHelper.sortEvenOddElements(arr);
		
		assertArrayEquals(new int[] {0, 2, 4, 6, 1, 3, 5, 7}, arr);
		
	}
	
	@Test
	@DisplayName("Test : Possible permutation with sum at each index > k")
	void checkPossibleSumGreaterThanK() {
		int[] arr1 = {2, 1, 3};
		int[] arr2 = {7, 8, 9};
		
		assertTrue(ArrayHelper.isPossiblePermutationGreaterThanK(arr1, arr2, 10));
	}
	
	@Test
	@DisplayName("Test : Alternate sort")
	void checkAlternateSort() {
		int[] arr = {7, 1, 2, 3, 4, 5, 6};
		ArrayHelper.alternateSort(arr);
		
		assertArrayEquals(new int[] {1, 7, 2, 6, 3, 5, 4}, arr);
	}
	
	@Test
	@DisplayName("Test : Sort a nearly sorted array")
	void checkSortNearlySortedArray() {
		int[] arr = {6, 5, 3, 2, 8, 10, 9};
		ArrayHelper.sortNearlySortArray(arr, 3);
		assertArrayEquals(new int[] {2, 3, 5, 6, 8, 9, 10}, arr);
	}
	
	@Test
	@DisplayName("Test : Count good pairs in array")
	void checkGoodPairs() {
		int[] arr = {2, 3, 2};
		int actual = ArrayHelper.countGoodPairs(arr);
		assertEquals(2, actual);
	}
	
}
