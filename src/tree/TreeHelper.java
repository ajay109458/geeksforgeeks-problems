package tree;

import java.util.Arrays;

import array.ArrayHelper;

public class TreeHelper {

	// Reset it always before builidng tree using inorder and pre order traversal
	public static int preIndex = 0;
	public static int traversalIndex = 0;

	public static void inorder(TreeNode root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static boolean isSumProperty(TreeNode root) {

		if (root == null || (root.left == null && root.right == null))
			return true;

		int leftSum = (root.left == null) ? 0 : root.left.data;
		int rightSum = (root.right == null) ? 0 : root.right.data;

		return isSumProperty(root.left) && isSumProperty(root.right) && (root.data == leftSum + rightSum);

	}

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
		int unCoveredNodesSum = totalSum - coveredNodesSum;

		return coveredNodesSum == unCoveredNodesSum;

	}

	public static int sumOfNodes(TreeNode root) {
		if (root == null)
			return 0;

		return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
	}

	public static int getLevelOfNode(TreeNode root, int val) {
		return getLevel(root, 0, val);
	}

	public static boolean isSublings(TreeNode root, int a, int b) {
		if (root == null)
			return false;

		if (root.left == null || root.right == null)
			return false;

		return (root.left.data == a && root.right.data == b) || (root.left.data == b && root.right.data == a)
				|| isSublings(root.left, a, b) || isSublings(root.right, a, b);

	}

	public static boolean isCousinsNode(TreeNode root, int a, int b) {
		return (getLevelOfNode(root, a) == getLevelOfNode(root, b) && !isSublings(root, a, b));
	}

	public static int heightOfTree(TreeNode root) {
		if (root == null)
			return 0;

		return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
	}

	public static int sizeOfTree(TreeNode root) {
		if (root == null)
			return 0;

		return sizeOfTree(root.left) + sizeOfTree(root.right) + 1;
	}

	public static boolean checkIfEdgeDivideTreeEqually(TreeNode root) {

		int sizeOfTree = sizeOfTree(root);

		return checkIfSubtreeSizeIsHalf(root, sizeOfTree);

	}

	private static boolean checkIfSubtreeSizeIsHalf(TreeNode root, int treeSize) {

		int subTreeSize = sizeOfTree(root);

		if (subTreeSize * 2 == treeSize)
			return true;

		if (subTreeSize == 0)
			return false;

		return checkIfSubtreeSizeIsHalf(root.left, treeSize) || checkIfSubtreeSizeIsHalf(root.right, treeSize);
	}

	public static boolean checkAllLeafAtSameLevel(TreeNode root) {
		int heightOfTree = heightOfTree(root);
		return checkIfLeafsAreAtALevel(root, heightOfTree);
	}

	public static boolean checkIfLeafsAreAtALevel(TreeNode root, int level) {
		if (root == null) {
			return true;
		}

		if (root.left == null && root.right == null)
			return level == 1;

		return checkIfLeafsAreAtALevel(root.left, level - 1) && checkIfLeafsAreAtALevel(root.right, level - 1);
	}

	public static void postOrder(TreeNode root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

	public static boolean checkAllTraversalOfSameTree(int[] preOrder, int[] inOrder, int[] postOrder) {
		TreeNode root = buildTree(inOrder, preOrder);

		int[] postOrderArray = populatePostOrder(root);

		System.out.println(Arrays.toString(postOrder));
		System.out.println(Arrays.toString(postOrderArray));

		return Arrays.equals(postOrder, postOrderArray);
	}

	public static TreeNode buildTree(int[] inOrder, int[] preOrder) {
		preIndex = 0;
		return buildTree(inOrder, preOrder, 0, inOrder.length - 1);
	}

	public static int[] populatePostOrder(TreeNode root) {
		traversalIndex = 0;
		int[] arr = new int[sizeOfTree(root)];

		fillPostOrder(root, arr);
		return arr;
	}
	
	public static boolean checkIfLevelOrderOfCompleteBinaryTreeSatisfyMinHeap(int[] levelOrder) {
		
		for(int i = 0; i < levelOrder.length /2; i++) {
			if (levelOrder[i]  > levelOrder[2*i + 1]) {
				return false;
			}
			
			if ((2*i + 2 < levelOrder.length) && levelOrder[i] > levelOrder[2*i+2]) {
				return false;
			}
		}
		
		return true;
	}

	private static void fillPostOrder(TreeNode root, int[] arr) {
		if (root == null)
			return;

		fillPostOrder(root.left, arr);
		fillPostOrder(root.right, arr);
		arr[traversalIndex++] = root.data;
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

	private static int sumLeftUncovered(TreeNode root) {
		if (root == null)
			return 0;

		return root.data + ((root.left != null) ? sumLeftUncovered(root.left) : sumLeftUncovered(root.right));
	}

	private static int sumRightUncovered(TreeNode root) {
		if (root == null)
			return 0;

		return root.data + ((root.right != null) ? sumLeftUncovered(root.right) : sumLeftUncovered(root.left));
	}
}
