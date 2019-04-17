package tree;

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
	

}
