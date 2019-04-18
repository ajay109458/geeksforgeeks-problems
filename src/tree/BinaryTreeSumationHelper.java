package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

		List<Integer> keys = new ArrayList(diagonalSumByIndexMap.keySet());
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
		
		return BinaryTreeCheckingAndPrintingHelper.height(root) + 
				sumOfHeightsOfAllNodes(root.left) + 
				sumOfHeightsOfAllNodes(root.right);
		
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
