package hashing;

import java.util.HashSet;
import java.util.Set;

public class HashingHelper {

	public static boolean isSubArray(int[] arr, int[] subArr) {
		
		Set<Integer> hash = new HashSet<>();
		
		for(int num: arr) {
			hash.add(num);
		}
		
		for(int num: subArr) {
			if(!hash.contains(num)) {
				return false;
			}
		}
		
		return true;
	}
	
}
