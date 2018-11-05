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
		
		int searchIndex = ArrayHelper.searchElementInPivotedArray(arr, 4);
		System.out.println("Search index and value : " + searchIndex + " -- " + arr[searchIndex]);
		
	}
	
}
