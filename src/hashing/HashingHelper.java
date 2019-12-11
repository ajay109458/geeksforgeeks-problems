package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import tree.TreeNode;
import utils.Pair;

public class HashingHelper {

	public static boolean isSubArray(int[] arr, int[] subArr) {

		Set<Integer> hash = new HashSet<>();

		for (int num : arr) {
			hash.add(num);
		}

		for (int num : subArr) {
			if (!hash.contains(num)) {
				return false;
			}
		}

		return true;
	}

	public static void printIntersection(int[] arr1, int[] arr2) {

		Set<Integer> hash = new HashSet<>();

		for (int num : arr1) {
			hash.add(num);
		}

		for (int num : arr2) {
			if (hash.contains(num)) {
				System.out.print(num + " ");
			}
		}
	}

	public static Pair getPairForSumX(int[] arr, int sum) {
		Pair result = null;

		Map<Integer, Integer> indexByElement = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			indexByElement.put(arr[i], i);
		}

		for (int i = 0; i < arr.length; i++) {
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

		for (Entry<Integer, Integer> entry : freqByNum.entrySet()) {
			if (maxFreq < entry.getValue())
				maxFreq = entry.getValue();
		}

		return arr.length - maxFreq;

	}

	public static Map<Integer, Integer> getFrequencyByElementMap(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int num : arr) {

			Integer freq = map.get(num);

			if (freq == null) {
				map.put(num, 1);
			} else {
				map.put(num, freq + 1);
			}

		}

		return map;
	}

	/**
	 * Minimum insertions to form a palindrome with permutations allowed
	 * 
	 * Example : Input : geeksforgeeks Output : 2 geeksforgeeks can be changed as:
	 * geeksroforskeeg geeksorfroskeeg and many more
	 */

	public static int minInsersion(String str) {

		Map<Character, Integer> countByChar = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			Integer count = countByChar.get(str.charAt(i));
			if (count == null) {
				count = 0;
			}

			count += 1;
			countByChar.put(str.charAt(i), count);
		}

		int res = 0;

		for (Entry<Character, Integer> entry : countByChar.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				res++;
			}
		}

		return (res == 0) ? 0 : res - 1;

	}

	public static void printVerticalOrder(TreeNode root) {

		Map<Integer, List<TreeNode>> map = new TreeMap<Integer, List<TreeNode>>();

		populateVerticalOrder(root, map, 0);

		for (Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
			for (TreeNode node : entry.getValue()) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}

	private static void populateVerticalOrder(TreeNode root, Map<Integer, List<TreeNode>> map, int colIndex) {

		if (root == null)
			return;

		List<TreeNode> nodes = map.get(colIndex);

		if (nodes == null) {
			nodes = new ArrayList<TreeNode>();
			map.put(colIndex, nodes);
		}

		nodes.add(root);

		populateVerticalOrder(root.left, map, colIndex - 1);
		populateVerticalOrder(root.right, map, colIndex + 1);
	}
}
