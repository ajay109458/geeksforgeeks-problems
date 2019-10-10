package array;
import java.util.*;
import utils.*;

public class ArrayMain {

	public static void main(String[] args) {
		
		int[] arr17 = {0, 1, 2, 3, 4, 5, 6, 7};
		ArrayHelper.sortEvenOddElements(arr17);
		System.out.println("Sort even odd : " + Arrays.toString(arr17));
		
		int[] arr18 = {2, 1, 3};
		int[] arr19 = {7, 8, 9};
		
		System.out.println("Is possible permutation that sum at each index greater than k : " + ArrayHelper.isPossiblePermutationGreaterThanK(arr18, arr19, 10));
		
		int[] arr20 = {7, 1, 2, 3, 4, 5, 6};
		ArrayHelper.alternateSort(arr20);
		System.out.println("Alternate sort : " + Arrays.toString(arr20));
		
		int[] arr21 = {6, 5, 3, 2, 8, 10, 9};
		ArrayHelper.sortNearlySortArray(arr21, 3);
	    System.out.println(Arrays.toString(arr21));
	}
	
	
	
	public static void inputUtils() {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
		}
	}
	
}
