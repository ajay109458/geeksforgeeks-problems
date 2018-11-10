import java.util.Arrays;

public class ArrayMain {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		// Print an array
		System.out.println(Arrays.toString(arr));
		
		// Get pivoted index of the orignal array
		int pivotIndex = ArrayHelper.findPivotIndex(arr);
		System.out.println("Pivot index is " + pivotIndex);
		
		// Array rotation 
		ArrayHelper.rotateArray(arr, 2);
		System.out.println(Arrays.toString(arr));

		// Get pivoted index of the rotated array
		pivotIndex = ArrayHelper.findPivotIndex(arr);
		System.out.println("Pivot index is " + pivotIndex);
		
		// Search an element in sorted pivoted array
		int searchIndex = ArrayHelper.searchElementInPivotedArray(arr, 4);
		System.out.println("Search index and value : " + searchIndex + " -- " + arr[searchIndex]);
		
		// Rotation sum
		int[] arr1 = {1, 20, 2, 10};
		System.out.println(ArrayHelper.maximumRotationSum(arr1));
		
		// Equilibrium index of an array - where sum on left and right are equal.
		int[] arr2 = {-7, 1, 5, 2, -4, 3, 0};
		System.out.println(ArrayHelper.getEquilibriumIndex(arr2));
		
		// Print duplicate elements in the array
		int[] arr3 = {1, 2, 3, 1, 3, 6, 6};
		System.out.println("Printing duplicate values");
		ArrayHelper.printDuplicates(arr3);
		
		// Print minimum length of unsorted array and sorting which makes complete array
		int[] arr4 = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		System.out.println("Minimum sorted length sorted :");
		ArrayHelper.minimumLengthUnsortedArray(arr4);
		
		
		// Sort an array of 0, 1 and 2
		int[] arr5 = {1, 0, 1, 1, 2, 2, 1, 1, 0, 0};
		ArrayHelper.sortArrayOf012(arr5);
		System.out.println(Arrays.toString(arr5));
	}
	
}
