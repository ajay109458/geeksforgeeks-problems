package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import utils.Pair;

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
	
	public static void printIntersection(int[] arr1, int[] arr2) {
		
		Set<Integer> hash = new HashSet<>();
		
		for(int num: arr1) {
			hash.add(num);
		}
		
		for(int num: arr2) {
			if(hash.contains(num)) {
				System.out.print(num + " ");
			}
		}
	}
	
	public static Pair getPairForSumX(int[] arr, int sum) {
		Pair result = null;
		
		Map<Integer, Integer> indexByElement = new HashMap<>();
		
		for(int i = 0;  i < arr.length; i++) {
			indexByElement.put(arr[i], i);
		}
		
		for(int i = 0; i < arr.length; i++) {
			Integer index = indexByElement.get(sum - arr[i]);
			
			if (index != null) {
				result = new Pair();
				result.x = arr[index];
				result.y = arr[i];
			}
		}
		
		return result;
	}
	
	public static int minDeleteOperationsToMakeAllSame(int[] arr) {
		
		Map<Integer, Integer> freqByNum = getFrequencyByElementMap(arr);
		
		int maxFreq = 0;
		
		for(Entry<Integer, Integer> entry : freqByNum.entrySet()) {
			if (maxFreq < entry.getValue())
				maxFreq = entry.getValue();
		}
		
		return arr.length - maxFreq;
		
	}
	
	public static Map<Integer, Integer> getFrequencyByElementMap(int[] arr) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int num : arr ) {
			
			Integer freq = map.get(num);
			
			if (freq == null) {
				map.put(num, 1);
			} else {
				map.put(num, freq + 1);
			}
			
		}
		
		return map;
	}
	
}
