package hashing;

public class HashingMain {

	public static void main(String[] args) {
		
		int arr1[] = {11, 1, 13, 21, 3, 7}; 
        int arr2[] = {11, 3, 7, 1}; 
        
        System.out.println("Is arr2 subarray of arr1 : " + HashingHelper.isSubArray(arr1, arr2));
		
        System.out.println("Print intersection of two array : ");
        HashingHelper.printIntersection(arr1, arr2);
	}
	
}
