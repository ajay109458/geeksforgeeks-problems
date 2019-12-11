package practice;

import java.util.HashMap;
import java.util.Map;

public class ArrayPractice {

	public static void printDuplicates(int arr[], int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		boolean isDuplicate = false;
		for (int val : arr) {
			Integer count = map.get(val);

			if (count == null) {
				count = 1;
			} else {
				isDuplicate = true;
				count++;
			}

			map.put(val, count);
		}

		for (int val : arr) {
			Integer count = map.get(val);

			if (count > 1) {
				System.out.print(count + " ");
			}
		}

		if (!isDuplicate) {
			System.out.print("-1");
		}

		System.out.println();
	}

}
