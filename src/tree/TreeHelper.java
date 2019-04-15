package tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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

	public static boolean isSumPropertySatisfied(TreeNode root) {

		if (root == null || (root.left == null && root.right == null))
			return true;

		int leftSum = (root.left == null) ? 0 : root.left.data;
		int rightSum = (root.right == null) ? 0 : root.right.data;

		return isSumPropertySatisfied(root.left) && isSumPropertySatisfied(root.right) && (root.data == leftSum + rightSum);

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

	public static boolean isSublingNodes(TreeNode root, int a, int b) {
		if (root == null)
			return false;

		if (root.left == null || root.right == null)
			return false;

		return (root.left.data == a && root.right.data == b) || (root.left.data == b && root.right.data == a)
				|| isSublingNodes(root.left, a, b) || isSublingNodes(root.right, a, b);

	}

	public static boolean isCousinNodes(TreeNode root, int a, int b) {
		return (getLevelOfNode(root, a) == getLevelOfNode(root, b) && !isSublingNodes(root, a, b));
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

	public static void postOrder(TreeNode root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

	public static boolean isTraversalsFromSameTree(int[] preOrder, int[] inOrder, int[] postOrder) {
		TreeNode root = buildTree(inOrder, preOrder);

		int[] postOrderArray = populatePostOrder(root);
		return Arrays.equals(postOrder, postOrderArray);
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
	
	public static boolean isLevelOrderSatisfyMinHeap(int[] levelOrder) {
		
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
	
	/**
	 * Leaf traversal is sequence of leaves traversed from left to right. The problem is to check if 
	 * leaf traversals of two given Binary Trees are same or not.
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
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			
			if (s1.isEmpty() || s2.isEmpty())
				return false;
			
			TreeNode temp1 = s1.pop();
			while(temp1 != null && !isLeafNode(temp1)) {
				if (temp1.right != null) {
					s1.push(temp1.right);
				}
				
				if (temp1.left != null) {
					s1.push(temp1.left);
				}
				
				temp1 = s1.pop();
			}
			
			TreeNode temp2 = s2.pop();
			while(temp2 != null && !isLeafNode(temp2)) {
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
	
	public static boolean isCompleteTree(TreeNode root) {
		
		if (root == null)
			return true;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		boolean isNonFullNodeAlreadyExist = false;
		
		while(!queue.isEmpty()) {
			
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
	
	public static boolean areIdentical(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		
		if (root1 != null && root2 != null) {
			return root1.data == root2.data &&
					areIdentical(root1.left, root2.left) &&
					areIdentical(root1.right, root2.right);
		}
		
		return false;	
	}
	
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
	
	public static boolean containsDuplicateNodes(TreeNode root) {
		Set<Integer> nodeDataSet = new HashSet<Integer>();	
		return containsDuplicateNodes(root, nodeDataSet);
	}
	
	public static boolean isMirror(TreeNode root1, TreeNode root2) {
		
		if (root1 == null && root2 == null)
			return true;
		
		if (root1 == null || root2 == null)
			return false;
		
		return root1.data == root2.data &&
				isMirror(root1.left, root2.right) &&
				isMirror(root1.right, root2.left);
		
	}
	
	public static boolean isSymmetric(TreeNode root) {
		
		if (root == null)
			return true;
		
		return isMirror(root.left, root.right);
	}
	
	public static boolean isPathExists(TreeNode root, int[] arr) {
		return isPathExists(root, arr, 0);
	}
	
	public static void printCousins(TreeNode root, int val) {
		int level = getLevelOfNode(root, val);
		printCousinNodesAtLevel(root, val, level);
		System.out.println();
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
			for(int i = 0; i <= index; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		printAllPaths(root.left, arr, index + 1);
		printAllPaths(root.right, arr, index + 1);
	}
	
	private static boolean isPathExists(TreeNode root, int[] arr, int level) {
		
		if (root == null) {
			return level == arr.length;
		}
		
		if (level >= arr.length) {
			return false;
		}
		
		return root.data == arr[level] &&
				(isPathExists(root.left, arr, level + 1) ||
						isPathExists(root.right, arr, level+1));
	}
	
	private static boolean containsDuplicateNodes(TreeNode root, Set<Integer> nodeDataSet) {
		
		if (root == null)
			return false;
		
		if(nodeDataSet.contains(root.data)) {
			return true;
		} else {
			nodeDataSet.add(root.data);
		}
		
		return containsDuplicateNodes(root.left, nodeDataSet) || containsDuplicateNodes(root.right, nodeDataSet);
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
	 * A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isFullBinaryTree(TreeNode root) {
		if (root == null)
			return true;
		
		if (isLeafNode(root))
			return true;
		
		if (root.left != null 
				&& root.right != null
				&& isFullBinaryTree(root.left)
				&& isFullBinaryTree(root.right))
			return true;
		return false;
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

		return root.data + ((root.left != null) ? sumLeftUncovered(root.left) : sumRightUncovered(root.right));
	}

	private static int sumRightUncovered(TreeNode root) {
		if (root == null)
			return 0;

		return root.data + ((root.right != null) ? sumLeftUncovered(root.right) : sumLeftUncovered(root.left));
	}
}
