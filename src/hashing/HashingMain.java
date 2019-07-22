package hashing;

import utils.Pair;

public class HashingMain {

	public static void main(String[] args) {
		
		int arr1[] = {11, 1, 13, 21, 3, 7}; 
        int arr2[] = {11, 3, 7, 1}; 
        
        System.out.println("Is arr2 subarray of arr1 : " + HashingHelper.isSubArray(arr1, arr2));
		
        System.out.println("Print intersection of two array : ");
        HashingHelper.printIntersection(arr1, arr2);
        
        System.out.println("Check if an pair exists with given sum in the array :");
        int arr3[] = {1, 4, 45, 6, 10, -8}; 
        Pair pair = HashingHelper.getPairForSumX(arr3, 16);
        if (pair != null) {
        	System.out.println("Piar elements : " + pair.x + " - " + pair.y);
        }
        
        int[] arr4 = {4, 3, 4, 4, 2, 4};
        System.out.println("Minimum delete operation to make all equals : " + HashingHelper.minDeleteOperationsToMakeAllSame(arr4));

        /**
         * Min insersion 
         */
        System.out.println("Min insertions : " + HashingHelper.minInsersion("geeksforgeeks"));
        
	}
	
}
