package tree;

import java.awt.image.ColorConvertOp;

public class TreeHelper {

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
		
		int rootSum  = 0;
		int leftUncovered = 0;
		int rightUncovered = 0;
		int totalSum = sumOfNodes(root);
		
		if ( root != null) {
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
		
		return (root.left.data == a && root.right.data == b) 
				|| (root.left.data == b && root.right.data == a)
				|| isSublings(root.left, a, b)
				|| isSublings(root.right, a, b);
				
	}
	
	public static boolean isCousinsNode(TreeNode root, int a, int b) {
		return (getLevelOfNode(root, a) == getLevelOfNode(root, b) &&  !isSublings(root, a, b));
	}
	
	public static int heightOfTree(TreeNode root) {
		if (root == null)
			return 0;
		
		return Math.max(heightOfTree(root.left),  heightOfTree(root.right)) + 1;
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
		
		return checkIfLeafsAreAtALevel(root.left, level - 1) 
				&& checkIfLeafsAreAtALevel(root.right, level - 1);
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
