package Search;

import array.ArrayHelper;

public class SearchMain {

	public static void main(String[] args) {
		
		int[]  arr1 = {1, 2, 3, 5, 6, 7, 8};
		System.out.println("Missing element in array : " + SearchHelper.findMissingNumber(arr1));
		
		
		int[] arr2 =  {5, 6, 7, 8, 9, 10, 1, 2, 3};
		ArrayHelper.searchElementInPivotedArray(arr2, 3);
		
		
		int[] arr3 = {1, 60, -10, 70, -80, 85}; 
		SearchHelper.printPairWithSumClosestToZero(arr3);
		
		System.out.println("Second largets element in the given array : " + SearchHelper.findSecondLargest(arr3));
	}
	
}
