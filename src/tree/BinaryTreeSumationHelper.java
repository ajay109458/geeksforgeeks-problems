package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import utils.MaxLenSum;

public class BinaryTreeSumationHelper {

	static class INT {
		int v;

		INT(int a) {
			v = a;
		}
	}

	/**
	 * Give an algorithm for finding the sum of all elements in a binary tree.
	 * 
	 * @param root
	 * @return
	 */
	public static int sumOfNodes(TreeNode root) {

		if (root == null)
			return 0;

		return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
	}

	/**
	 * Sum of all the parent nodes with child X
	 */
	public static int sumOfParentNodesWithChildX(TreeNode root, int x) {

		if (root == null) {
			return 0;
		}

		if (root.left != null && root.left.data == x) {
			return root.data;
		}

		if (root.right != null && root.right.data == x) {
			return root.data;
		}

		return sumOfParentNodesWithChildX(root.left, x) + sumOfParentNodesWithChildX(root.right, x);
	}

	public static int sumOfLeaves(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (BinaryTreeCheckingAndPrintingHelper.isLeafNode(root)) {
			return root.data;
		}

		return sumOfLeaves(root.left) + sumOfLeaves(root.right);
	}

	/**
	 * Find sum of nodes of a perfect sum tree
	 * https://www.geeksforgeeks.org/find-sum-nodes-given-perfect-binary-tree/
	 * 
	 * @param level
	 * @return
	 */
	public static int sumOfNodesOfPerfectTree(int level) {

		int leafNodesCount = (int) Math.pow(2, level - 1);

		int sumLastLevel = (leafNodesCount * (leafNodesCount + 1)) / 2;

		return level * sumLastLevel;
	}

	public static void printDiagonalSum(TreeNode root) {
		Map<Integer, Integer> diagonalSumByIndexMap = new HashMap<>();
		populateDiagonalSum(root, diagonalSumByIndexMap, 0, 0);

		List<Integer> keys = new ArrayList<Integer>(diagonalSumByIndexMap.keySet());
		Collections.sort(keys);

		for (Integer key : keys) {
			System.out.print(diagonalSumByIndexMap.get(key) + " ");
		}
		System.out.println();
	}

	public static boolean isPairInPathWithSumEqualToRoot(TreeNode root) {

		if (root == null)
			return false;

		return isTwoNodesWithSumExists(root.left, root.data) || isTwoNodesWithSumExists(root.right, root.data);
	}

	public static boolean isTwoNodesWithSumExists(TreeNode root, int sum) {
		return isTwoNodesWithSumExists(root, sum, new HashSet<Integer>());
	}

	public static int sumOfLongestPath(TreeNode root) {
		MaxLenSum maxLenSum = new MaxLenSum();
		sumOfLongestPath(root, 0, 0, maxLenSum);
		return maxLenSum.maxSum;
	}

	public static int maxDiameterSum(TreeNode root) {
		if (root == null)
			return 0;

		int leftTreePathSum = maxSumPath(root.left);
		int rightTreePathSum = maxSumPath(root.right);

		return Math.max(Math.max(maxDiameterSum(root.left), maxDiameterSum(root.right)),
				leftTreePathSum + rightTreePathSum + root.data);
	}

	public static int maxSumPath(TreeNode root) {
		if (root == null)
			return 0;

		return root.data + Math.max(maxSumPath(root.left), maxSumPath(root.right));
	}

	public static int nonAdjacentNodesMaxSum(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<>();
		return nonAdjacentNodesMaxSum(root, map);
	}

	public static int maxSubTreeSum(TreeNode root) {
		return maxSubTreeSum(root, new INT(0));
	}

	public static int sumOfHeightsOfAllNodes(TreeNode root) {

		if (root == null)
			return 0;

		return BinaryTreeCheckingAndPrintingHelper.height(root) + sumOfHeightsOfAllNodes(root.left)
				+ sumOfHeightsOfAllNodes(root.right);

	}

	public static boolean isSubTreeWithGivenSumExists(TreeNode root, int sum) {
		INT currSum = new INT(0);
		return isSubTreeWithGivenSumExists(root, currSum, sum);
	}

	public static int countSubTreeWithGivenSum(TreeNode root, int sum) {
		INT currSum = new INT(0);
		return countSubTreeWithGivenSum(root, currSum, sum);
	}

	public static int diffInSumOfOddEvenLevelNodes(TreeNode root) {
		int oddLevelNodesSum = sumOfAlternateLevelNodes(root, true);

		int evenLevelNodesSum = 0;

		if (root.left != null)
			evenLevelNodesSum += sumOfAlternateLevelNodes(root.left, true);

		if (root.right != null)
			evenLevelNodesSum += sumOfAlternateLevelNodes(root.right, true);

		return Math.abs(evenLevelNodesSum - oddLevelNodesSum);
	}

	public static void printSumAtEachLevel(TreeNode root) {
		Map<Integer, Integer> sumAtEachLevelMap = getSumAtEachLevel(root);
		List<Integer> keys = new ArrayList<Integer>(sumAtEachLevelMap.keySet());
		Collections.sort(keys);

		for (Integer key : keys) {
			System.out.println(sumAtEachLevelMap.get(key));
		}
		System.out.println();
	}

	public static int getMaxSumAtLevel(TreeNode root) {
		Map<Integer, Integer> sumByLevelMap = getSumAtEachLevel(root);

		int max = 0;

		for (Entry<Integer, Integer> entry : sumByLevelMap.entrySet()) {
			if (entry.getValue() > max)
				max = entry.getValue();
		}

		return max;
	}

	public static int sumOfLeafNodes(TreeNode root) {
		if (root == null)
			return 0;

		if (BinaryTreeCheckingAndPrintingHelper.isLeafNode(root)) {
			return root.data;
		}

		return sumOfLeafNodes(root.left) + sumOfLeafNodes(root.right);
	}

	public static Map<Integer, Integer> getSumAtEachLevel(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		sumAtEachLevel(root, map, 0);
		return map;
	}

	public static void sumAtEachLevel(TreeNode root, Map<Integer, Integer> map, int currLevel) {

		if (root == null)
			return;

		Integer currSum = map.get(currLevel);

		if (currSum == null) {
			map.put(currLevel, root.data);
		} else {
			map.put(currLevel, root.data + currSum);
		}

		sumAtEachLevel(root.left, map, currLevel + 1);
		sumAtEachLevel(root.right, map, currLevel + 1);
	}

	public static boolean isRootToLeafSumExists(TreeNode root, int sum) {

		if (root == null)
			return sum == 0;

		return isRootToLeafSumExists(root.left, sum - root.data) || isRootToLeafSumExists(root.right, sum - root.data);
	}

	public static int sumOfRootToLeafPath(TreeNode root) {
		return sumOfRootToLeafPath(root, 0, 0);
	}
	
	public static void printVerticalSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		populateVerticalSum(root, map, 0);
		
		List<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		
		for(Integer key : keys) {
			System.out.println(map.get(key));
		}
		System.out.println();
	}
	
	private static void populateVerticalSum(TreeNode root, Map<Integer, Integer> map, int col) {
		
		if (root == null)
			return;
		
		Integer currSum = map.get(col);
		
		if (currSum == null) {
			map.put(col, root.data);
		} else {
			map.put(col, currSum + root.data);
		}
		
		populateVerticalSum(root.left, map, col - 1);
		populateVerticalSum(root.right, map, col + 1);
	}

	private static int sumOfRootToLeafPath(TreeNode root, int currResult, int number) {

		if (root == null)
			return 0;

		number = number * 10 + root.data;

		if (BinaryTreeCheckingAndPrintingHelper.isLeafNode(root)) {
			currResult += number;
			return currResult;
		}

		currResult = sumOfRootToLeafPath(root.left, currResult, number);
		currResult = sumOfRootToLeafPath(root.right, currResult, number);
		
		return currResult;
	}

	private static int sumOfAlternateLevelNodes(TreeNode root, boolean shouldAdd) {
		if (root == null)
			return 0;

		int currSum = 0;

		if (shouldAdd) {
			currSum += root.data;
		}

		shouldAdd = !shouldAdd;

		currSum += sumOfAlternateLevelNodes(root.left, shouldAdd);
		currSum += sumOfAlternateLevelNodes(root.right, shouldAdd);

		return currSum;
	}

	private static int countSubTreeWithGivenSum(TreeNode root, INT currSum, int sum) {
		if (root == null) {
			currSum = new INT(0);
			return 0;
		}

		INT leftSum = new INT(0);
		INT rightSum = new INT(0);

		boolean isLeftSubTreeExists = isSubTreeWithGivenSumExists(root.left, leftSum, sum);
		boolean isRightSubTreeExists = isSubTreeWithGivenSumExists(root.right, rightSum, sum);

		currSum.v = leftSum.v + rightSum.v + root.data;

		return (isLeftSubTreeExists || isRightSubTreeExists || currSum.v == sum) ? 1 : 0;
	}

	private static boolean isSubTreeWithGivenSumExists(TreeNode root, INT currSum, int sum) {
		if (root == null) {
			currSum = new INT(0);
			return false;
		}

		INT leftSum = new INT(0);
		INT rightSum = new INT(0);

		boolean isLeftSubTreeExists = isSubTreeWithGivenSumExists(root.left, leftSum, sum);
		boolean isRightSubTreeExists = isSubTreeWithGivenSumExists(root.right, rightSum, sum);

		currSum.v = leftSum.v + rightSum.v + root.data;

		return isLeftSubTreeExists || isRightSubTreeExists || currSum.v == sum;
	}

	private static int maxSubTreeSum(TreeNode root, INT maxSum) {

		if (root == null)
			return 0;

		int currSum = root.data + maxSubTreeSum(root.left) + maxSubTreeSum(root.right);

		maxSum.v = Math.max(currSum, maxSum.v);

		return maxSum.v;
	}

	private static int nonAdjacentGrandChildNodesSum(TreeNode root, Map<TreeNode, Integer> map) {
		int sum = 0;

		if (root.left != null) {
			sum += nonAdjacentNodesMaxSum(root.left.left, map) + nonAdjacentNodesMaxSum(root.left.right, map);
		}

		if (root.right != null) {
			sum += nonAdjacentNodesMaxSum(root.right.left, map) + nonAdjacentNodesMaxSum(root.right.right, map);
		}

		return sum;
	}

	private static int nonAdjacentNodesMaxSum(TreeNode root, Map<TreeNode, Integer> map) {

		if (root == null)
			return 0;

		if (map.containsKey(root))
			return map.get(root);

		int incl = root.data + nonAdjacentGrandChildNodesSum(root, map);
		int excl = nonAdjacentNodesMaxSum(root.left, map) + nonAdjacentNodesMaxSum(root.right, map);

		map.put(root, Math.max(incl, excl));

		return map.get(root);
	}

	private static void sumOfLongestPath(TreeNode root, int len, int sum, MaxLenSum maxLenSum) {

		if (root == null) {
			if (len > maxLenSum.maxLen) {
				maxLenSum.maxLen = len;
				maxLenSum.maxSum = sum;
			} else if (len == maxLenSum.maxLen && sum > maxLenSum.maxSum) {
				maxLenSum.maxSum = sum;
			}
			return;
		}

		sumOfLongestPath(root.left, len + 1, sum + root.data, maxLenSum);
		sumOfLongestPath(root.right, len + 1, sum + root.data, maxLenSum);
	}

	private static boolean isTwoNodesWithSumExists(TreeNode root, int sum, Set<Integer> pathNodes) {

		if (root == null)
			return false;

		if (pathNodes.contains(sum - root.data)) {
			return true;
		} else {
			pathNodes.add(root.data);
		}

		boolean isSumExist = isTwoNodesWithSumExists(root.left, sum, pathNodes)
				|| isTwoNodesWithSumExists(root.right, sum, pathNodes);

		pathNodes.remove(root.data);

		return isSumExist;
	}

	private static void populateDiagonalSum(TreeNode root, Map<Integer, Integer> diagonalSumByIndexMap, int level,
			int col) {

		if (root == null) {
			return;
		}

		int index = level + col;

		Integer sum = diagonalSumByIndexMap.get(index);
		if (sum == null) {
			sum = root.data;
		} else {
			sum += root.data;
		}
		diagonalSumByIndexMap.put(index, sum);

		populateDiagonalSum(root.left, diagonalSumByIndexMap, level + 1, col + 1);
		populateDiagonalSum(root.right, diagonalSumByIndexMap, level + 1, col - 1);
	}

}
