package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeSumationHelper {
	
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
		
		if(root.left != null && root.left.data == x) {
			return root.data;
		}
		
		if(root.right != null && root.right.data == x) {
			return root.data;
		}
		
		return sumOfParentNodesWithChildX(root.left, x) +
				sumOfParentNodesWithChildX(root.right, x);
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
	
	private static void populateDiagonalSum(TreeNode root, Map<Integer, Integer> diagonalSumByIndexMap, int level, int col) {
		
		if (root == null) {
			return;
		}
		
		int index = level + col;
		
		Integer sum  = diagonalSumByIndexMap.get(index);
		if (sum == null) {
			sum = root.data;
		} else {
			sum += root.data;
		}
		diagonalSumByIndexMap.put(index, sum);
		
		populateDiagonalSum(root.left, diagonalSumByIndexMap, level + 1 , col + 1);
		populateDiagonalSum(root.right, diagonalSumByIndexMap, level + 1 , col - 1);
	}

}
