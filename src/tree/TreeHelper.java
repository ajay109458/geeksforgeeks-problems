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
