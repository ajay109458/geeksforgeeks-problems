package Search;

public class SearchHelper {
	
	/**
	 * You are given a list of n-1 integers and these integers are in the range of 1 to n. 
	 * There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
	 * @param arr
	 * @return
	 */
	public static int findMissingNumber(int[] arr) {
		
		int sumOfArray = 0;
		
		for(int ele : arr) {
			sumOfArray += ele;
		}
		
		int n = arr.length + 1;
		
		int sumN = ( n * (n+1))/2;
		
		return sumN - sumOfArray;
	}

}
