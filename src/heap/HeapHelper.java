package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapHelper {

	public static void printKLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for(int val : arr) {
			pq.add(val);
		}
		
		
		while(k-- > 0) {
			int result = pq.remove();
			System.out.print(result + " ");
		}
		System.out.println();
	}

}
