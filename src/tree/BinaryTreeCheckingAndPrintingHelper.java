package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import array.ArrayHelper;

public class BinaryTreeCheckingAndPrintingHelper {

	// Reset it always before builidng tree using inorder and pre order traversal
	public static int preIndex = 0;
	public static int traversalIndex = 0;
	
	
	/**
	 * 1-2, 10. Check for children sum property in binary search tree
	 * 
	 */
	public static boolean isSumPropertySatisfied(TreeNode root) {

		if (root == null || (root.left == null && root.right == null))
			return true;

		int leftSum = (root.left == null) ? 0 : root.left.data;
		int rightSum = (root.right == null) ? 0 : root.right.data;

		return isSumPropertySatisfied(root.left) && isSumPropertySatisfied(root.right)
				&& (root.data == leftSum + rightSum);

	}

	public static void inorder(TreeNode root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	

	/**
	 * 3. Check if sum of covered nodes and uncovered nodes in equal
	 */
	public static boolean isCoveredAndUncoveredNodesSumEqual(TreeNode root) {

		int rootSum = 0;
		int leftUncovered = 0;
		int rightUncovered = 0;
		int totalSum = sumOfNodes(root);

		if (root != null) {
			rootSum = root.data;

			if (root.left != null) {
				leftUncovered = sumLeftUncovered(root.left);
				rightUncovered = sumLeftUncovered(root.right);
			}
		}

		int coveredNodesSum = leftUncovered + rootSum + rightUncovered;
		int unCoveredNodesSum = totalSum - coveredNodesSum; // - sum of non overlapping leaf nodes;

		return coveredNodesSum == unCoveredNodesSum;

	}
	
	private static int sumLeftUncovered(TreeNode root) {
		if (root == null)
			return 0;

		return root.data + ((root.left != null) ? sumLeftUncovered(root.left) : sumRightUncovered(root.right));
	}

	private static int sumRightUncovered(TreeNode root) {
		if (root == null)
			return 0;

		return root.data + ((root.right != null) ? sumLeftUncovered(root.right) : sumLeftUncovered(root.left));
	}

	public static int sumOfNodes(TreeNode root) {
		if (root == null)
			return 0;

		return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
	}

	/**
	 * 4. Check if two nodes of a tree are cousins or not
	 */
	public static boolean isCousinNodes(TreeNode root, int a, int b) {
		return (getLevelOfNode(root, a) == getLevelOfNode(root, b) && !isSublingNodes(root, a, b));
	}
	
	public static int getLevelOfNode(TreeNode root, int val) {
		return getLevel(root, 0, val);
	}

	public static boolean isSublingNodes(TreeNode root, int a, int b) {
		if (root == null)
			return false;

		if (root.left == null || root.right == null)
			return false;

		return (root.left.data == a && root.right.data == b) || (root.left.data == b && root.right.data == a)
				|| isSublingNodes(root.left, a, b) || isSublingNodes(root.right, a, b);

	}
	
	

	public static int height(TreeNode root) {
		if (root == null)
			return 0;

		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public static int size(TreeNode root) {
		if (root == null)
			return 0;

		return size(root.left) + size(root.right) + 1;
	}
	
	/**
	 * 5. Check if all leaves at same level
	 */
	public static boolean isLeavesAtSameLevel(TreeNode root) {
		int heightOfTree = height(root);
		return isLeavesAtSameLevel(root, heightOfTree);
	}

	public static boolean isLeavesAtSameLevel(TreeNode root, int level) {
		if (root == null) {
			return true;
		}

		if (root.left == null && root.right == null)
			return level == 1;

		return isLeavesAtSameLevel(root.left, level - 1) && isLeavesAtSameLevel(root.right, level - 1);
	}

	/**
	 * 6. Check if removing an edge of the binary tree divides in two equal halves
	 */
	public static boolean isAnEdgeDivideTreeEqually(TreeNode root) {
		int sizeOfTree = size(root);
		return isSubTreeHalfSized(root, sizeOfTree);
	}

	private static boolean isSubTreeHalfSized(TreeNode root, int treeSize) {

		int subTreeSize = size(root);

		if (subTreeSize * 2 == treeSize)
			return true;

		if (subTreeSize == 0)
			return false;

		return isSubTreeHalfSized(root.left, treeSize) || isSubTreeHalfSized(root.right, treeSize);
	}
	
	
	/**
	 * 7. Check if given preorder, inorder and post order traversals are from the same tree. 
	 */
	public static boolean isTraversalsFromSameTree(int[] preOrder, int[] inOrder, int[] postOrder) {
		TreeNode root = buildTree(inOrder, preOrder);

		int[] postOrderArray = populatePostOrder(root);
		return Arrays.equals(postOrder, postOrderArray);
	}
	
	public static void postOrder(TreeNode root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

	public static TreeNode buildTree(int[] inOrder, int[] preOrder) {
		preIndex = 0;
		return buildTree(inOrder, preOrder, 0, inOrder.length - 1);
	}

	public static int[] populatePostOrder(TreeNode root) {
		traversalIndex = 0;
		int[] arr = new int[size(root)];

		fillPostOrder(root, arr);
		return arr;
	}

	/**
	 * 8. Given level order traversal of tree, check if it satisfies the min heap properties.
	 */
	public static boolean isLevelOrderSatisfyMinHeap(int[] levelOrder) {

		for (int i = 0; i < levelOrder.length / 2; i++) {
			if (levelOrder[i] > levelOrder[2 * i + 1]) {
				return false;
			}

			if ((2 * i + 2 < levelOrder.length) && levelOrder[i] > levelOrder[2 * i + 2]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 9. Leaf traversal is sequence of leaves traversed from left to right. The
	 * problem is to check if leaf traversals of two given Binary Trees are same or
	 * not.
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean isLeavesTraversalHasSameOrder(TreeNode root1, TreeNode root2) {

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		s1.push(root1);
		s2.push(root2);

		while (!s1.isEmpty() || !s2.isEmpty()) {

			if (s1.isEmpty() || s2.isEmpty())
				return false;

			TreeNode temp1 = s1.pop();
			while (temp1 != null && !isLeafNode(temp1)) {
				if (temp1.right != null) {
					s1.push(temp1.right);
				}

				if (temp1.left != null) {
					s1.push(temp1.left);
				}

				temp1 = s1.pop();
			}

			TreeNode temp2 = s2.pop();
			while (temp2 != null && !isLeafNode(temp2)) {
				if (temp2.right != null) {
					s2.push(temp2.right);
				}

				if (temp2.left != null) {
					s2.push(temp2.left);
				}

				temp2 = s2.pop();
			}

			if (temp1 == null && temp2 != null)
				return false;

			if (temp1 != null && temp2 == null)
				return false;

			if (temp1 != null && temp2 != null) {
				if (temp1.data != temp2.data)
					return false;
			}
		}

		return true;
	}

	public static boolean isLeafNode(TreeNode root) {
		if (root == null)
			return false;

		return (root.left == null && root.right == null);
	}

	/**
	 * 14. Check if a tree is a complete tree or not
	 */
	public static boolean isCompleteTree(TreeNode root) {

		if (root == null)
			return true;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		boolean isNonFullNodeAlreadyExist = false;

		while (!queue.isEmpty()) {

			root = queue.poll();

			if (root.left != null) {
				queue.add(root.left);

				if (isNonFullNodeAlreadyExist) {
					return false;
				}

			} else {
				isNonFullNodeAlreadyExist = true;
			}

			if (root.right != null) {
				queue.add(root.right);

				if (isNonFullNodeAlreadyExist) {
					return false;
				}
			} else {
				isNonFullNodeAlreadyExist = true;
			}
		}

		return true;

	}

	/**
	 * 22. Check if two binary tree are identical or not
	 */
	public static boolean areIdentical(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 != null && root2 != null) {
			return root1.data == root2.data && areIdentical(root1.left, root2.left)
					&& areIdentical(root1.right, root2.right);
		}

		return false;
	}

	/**
	 * 16. Check if a tree is sub tree of another tree or not
	 */
	public static boolean isTreeSubset(TreeNode root, TreeNode sRoot) {

		if (sRoot == null)
			return true;

		if (root == null)
			return false;

		if (areIdentical(root, sRoot)) {
			return true;
		}

		return isTreeSubset(root.left, sRoot) || isTreeSubset(root.right, sRoot);
	}

	/**
	 * 17. Check if a binary tree contains duplicate values or not
	 */
	public static boolean containsDuplicateNodes(TreeNode root) {
		Set<Integer> nodeDataSet = new HashSet<Integer>();
		return containsDuplicateNodes(root, nodeDataSet);
	}
	
	private static boolean containsDuplicateNodes(TreeNode root, Set<Integer> nodeDataSet) {

		if (root == null)
			return false;

		if (nodeDataSet.contains(root.data)) {
			return true;
		} else {
			nodeDataSet.add(root.data);
		}

		return containsDuplicateNodes(root.left, nodeDataSet) || containsDuplicateNodes(root.right, nodeDataSet);
	}

	/**
	 * 20. Check if two binary tree are mirror or not
	 */
	public static boolean isMirror(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		return root1.data == root2.data && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);

	}

	public static boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;

		return isMirror(root.left, root.right);
	}

	/**
	 * 25. Check if a path exists from root to leaf
	 */
	public static boolean isPathExists(TreeNode root, int[] arr) {
		return isPathExists(root, arr, 0);
	}

	/**
	 * 27. Print cousins of a given node
	 */
	public static void printCousins(TreeNode root, int val) {
		int level = getLevelOfNode(root, val);
		printCousinNodesAtLevel(root, val, level);
		System.out.println();
	}

	/**
	 * 29. Print diameter of tree, Print longest leaf to leaf path
	 */
	public static int getMaxDiameter(TreeNode root) {
		if (root == null)
			return 0;

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		return Math.max(Math.max(getMaxDiameter(root.left), getMaxDiameter(root.right)), leftHeight + rightHeight + 1);
	}

	public static void printNodesAtOddLevel(TreeNode root) {
		System.out.println("Print nodes at odd levels : ");
		printNodesAtOddLevel(root, true);
		System.out.println();
	}

	public static void printFullNodes(TreeNode root) {

		if (root == null) {
			return;
		}

		if (root.left != null && root.right != null) {
			System.out.print(root.data + " ");
		}

		printFullNodes(root.left);
		printFullNodes(root.right);
	}

	private static void printNodesAtOddLevel(TreeNode root, boolean shouldPrint) {

		if (root == null) {
			return;
		}

		if (shouldPrint)
			System.out.print(root.data + " ");

		shouldPrint = !shouldPrint;

		printNodesAtOddLevel(root.left, shouldPrint);
		printNodesAtOddLevel(root.right, shouldPrint);
	}

	private static void printCousinNodesAtLevel(TreeNode root, int val, int level) {

		if (root == null || level == 0)
			return;

		if (root.left == null && root.right == null)
			return;

		if (level == 1) {

			if ((root.left != null && root.left.data == val) || (root.right != null && root.right.data == val))
				return;

			if (root.left != null) {
				System.out.print(root.left.data + " ");
			}

			if (root.right != null) {
				System.out.print(root.right.data + " ");
			}

			return;
		}

		printCousinNodesAtLevel(root.left, val, level - 1);
		printCousinNodesAtLevel(root.right, val, level - 1);
	}

	public static void printNodesAtLevel(TreeNode root, int level) {

		if (root == null)
			return;

		if (level == 0) {
			System.out.print(root.data + " ");
		}

		printNodesAtLevel(root.left, level - 1);
		printNodesAtLevel(root.right, level - 1);

	}

	public static void printAllPaths(TreeNode root) {
		int heightOfTree = height(root);
		int[] arr = new int[heightOfTree];
		System.out.println("Printing all paths : ");
		printAllPaths(root, arr, 0);
	}

	public static void printAllPaths(TreeNode root, int[] arr, int index) {

		if (root == null)
			return;

		arr[index] = root.data;

		if (isLeafNode(root)) {
			for (int i = 0; i <= index; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		printAllPaths(root.left, arr, index + 1);
		printAllPaths(root.right, arr, index + 1);
	}

	public static void printNodesBetweenLevels(TreeNode root, int low, int high) {

		System.out.println("Printing nodes between levels : " + low + " and " + high);

		printNodesBetweenLevels(root, low, high, 0);

		System.out.println();

		return;
	}

	public static void printNodesWithoutSublings1(TreeNode root) {

		if (root == null)
			return;

		if (root.left != null && root.right != null) {
			printNodesWithoutSublings1(root.left);
			printNodesWithoutSublings1(root.right);
			return;
		}

		if (root.left != null) {
			System.out.println(root.left.data + " ");
			printNodesWithoutSublings1(root.left);
		}

		if (root.right != null) {
			System.out.println(root.right.data + " ");
			printNodesWithoutSublings1(root.right);
		}

	}

	public static void printNodesWithoutSublings2(TreeNode root) {
		printNodesWithoutSublings2(root, null);
	}

	private static void printNodesWithoutSublings2(TreeNode root, TreeNode parent) {

		if (root == null) {
			return;
		}

		if (parent == null) {
			System.out.println(root.data + " ");
		} else {

			if (parent.left != null && parent.right == null) {
				System.out.println(root.data + " ");
			}

			if (parent.right != null && parent.left == null) {
				System.out.println(root.data + " ");
			}
		}

		printNodesWithoutSublings2(root.left, root);
		printNodesWithoutSublings2(root.right, root);

	}

	private static void printNodesBetweenLevels(TreeNode root, int low, int high, int currentLevel) {

		if (root == null)
			return;

		if (currentLevel >= low && currentLevel <= high) {
			System.out.print(root.data + " ");
		}

		printNodesBetweenLevels(root.left, low, high, currentLevel + 1);
		printNodesBetweenLevels(root.right, low, high, currentLevel + 1);
	}

	private static boolean isPathExists(TreeNode root, int[] arr, int level) {

		if (root == null) {
			return level == arr.length;
		}

		if (level >= arr.length) {
			return false;
		}

		return root.data == arr[level]
				&& (isPathExists(root.left, arr, level + 1) || isPathExists(root.right, arr, level + 1));
	}

	

	private static void fillPostOrder(TreeNode root, int[] arr) {
		if (root == null)
			return;

		fillPostOrder(root.left, arr);
		fillPostOrder(root.right, arr);
		arr[traversalIndex++] = root.data;
	}

	public static boolean isPerfectTree(TreeNode root) {
		int heightOfTree = height(root);
		int leafNodes = countLeafNodes(root);
		return leafNodes == Math.pow(2, heightOfTree - 1);
	}

	public static int countLeafNodes(TreeNode root) {
		if (root == null)
			return 0;

		if (isLeafNode(root)) {
			return 1;
		}

		return countLeafNodes(root.left) + countLeafNodes(root.right);
	}

	/**
	 * A full binary tree is defined as a binary tree in which all nodes have either
	 * zero or two child nodes
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isFullBinaryTree(TreeNode root) {
		if (root == null)
			return true;

		if (isLeafNode(root))
			return true;

		if (root.left != null && root.right != null && isFullBinaryTree(root.left) && isFullBinaryTree(root.right))
			return true;
		return false;
	}

	public static void printNodeWithLevel(TreeNode root) {
		printNodeWithLevel(root, 1);
	}

	public static void printTreeVertically(TreeNode root) {
		Map<Integer, List<TreeNode>> nodesByColMap = new HashMap<>();
		populateVerticalTree(root, 0, nodesByColMap);

		List<Integer> keys = new ArrayList(nodesByColMap.keySet());
		Collections.sort(keys);

		for (Integer key : keys) {
			List<TreeNode> nodes = nodesByColMap.get(key);

			for (TreeNode node : nodes) {
				System.out.print(node.data + " ");
			}

			System.out.println();
		}
	}

	public static void printLeftView(TreeNode root) {
		Map<Integer, TreeNode> nodeByLevelMap = new HashMap<Integer, TreeNode>();
		
		populateLeftView(root, 0, nodeByLevelMap);
		
		List<Integer> keys = new ArrayList(nodeByLevelMap.keySet());
		Collections.sort(keys);
		
		for (Integer key : keys) {
			TreeNode node = nodeByLevelMap.get(key);

			System.out.print(node.data + " ");
		}
		
		System.out.println();
	}

	public static void printRightView(TreeNode root) {
		Map<Integer, TreeNode> nodeByLevelMap = new HashMap<Integer, TreeNode>();
		
		populateRightView(root, 0, nodeByLevelMap);
		
		List<Integer> keys = new ArrayList(nodeByLevelMap.keySet());
		Collections.sort(keys);
		
		for (Integer key : keys) {
			TreeNode node = nodeByLevelMap.get(key);

			System.out.print(node.data + " ");
		}
		
		System.out.println();
	}

	private static void populateRightView(TreeNode root, int currLevel, Map<Integer, TreeNode> nodeByLevelMap) {

		if (root == null)
			return;

		TreeNode node = nodeByLevelMap.get(currLevel);
		
		if (node == null) {
			nodeByLevelMap.put(currLevel, root);
		}

		populateRightView(root.right, currLevel + 1, nodeByLevelMap);
		populateRightView(root.left, currLevel + 1, nodeByLevelMap);

	}
	
	private static void populateLeftView(TreeNode root, int currLevel, Map<Integer, TreeNode> nodeByLevelMap) {

		if (root == null)
			return;

		TreeNode node = nodeByLevelMap.get(currLevel);
		
		if (node == null) {
			nodeByLevelMap.put(currLevel, root);
		}

		populateLeftView(root.left, currLevel + 1, nodeByLevelMap);
		populateLeftView(root.right, currLevel + 1, nodeByLevelMap);

	}
	
	

	private static void populateVerticalTree(TreeNode root, int currCol, Map<Integer, List<TreeNode>> nodesByColMap) {

		if (root == null)
			return;

		List<TreeNode> nodes = nodesByColMap.get(currCol);
		if (nodes == null) {
			nodes = new ArrayList<TreeNode>();
			nodesByColMap.put(currCol, nodes);
		}

		nodes.add(root);

		populateVerticalTree(root.left, currCol - 1, nodesByColMap);
		populateVerticalTree(root.right, currCol + 1, nodesByColMap);

	}

	private static void printNodeWithLevel(TreeNode root, int level) {

		if (root == null)
			return;

		printNodeWithLevel(root.left, level + 1);
		System.out.println("Level of " + root.data + " is " + level);
		printNodeWithLevel(root.right, level + 1);
	}

	private static TreeNode buildTree(int[] inOrder, int[] preOrder, int startIndex, int endIndex) {

		if (startIndex > endIndex)
			return null;

		TreeNode node = new TreeNode(preOrder[preIndex++]);

		if (startIndex == endIndex) {
			return node;
		}

		int indexOfNode = ArrayHelper.linearSearch(inOrder, node.data);

		node.left = buildTree(inOrder, preOrder, startIndex, indexOfNode - 1);
		node.right = buildTree(inOrder, preOrder, indexOfNode + 1, endIndex);

		return node;
	}

	private static int getLevel(TreeNode root, int currentLevel, int val) {

		if (root == null)
			return -1;

		if (root.data == val)
			return currentLevel;

		int leftLevel = getLevel(root.left, currentLevel + 1, val);

		if (leftLevel != -1)
			return leftLevel;

		return getLevel(root.right, currentLevel + 1, val);
	}
}
