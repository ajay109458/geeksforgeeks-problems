package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Node {
	public int data;
	public Node next;
}

public class LinkListPairWithSumX {

	public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
		Map<Integer, Integer> head1Map = new HashMap<>();


		for (int num : head1) {

			Integer count = head1Map.get(num);

			count = (count == null) ? 1 : count + 1;

			head1Map.put(num, count);

		}

		int result = 0;

		for (int num : head2) {

			Integer count = head1Map.get(num);

			if (count != null)
				result += count;

		}

		return result;

	}

}
