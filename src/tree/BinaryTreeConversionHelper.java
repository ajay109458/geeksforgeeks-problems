package tree;

import array.ArrayHelper;

public class BinaryTreeConversionHelper {
	
	public static int preIndex = 0;
	
	public static TreeNode buildTree(int[] inOrder, int[] preOrder) {
		
		preIndex = 0;
		return buildTree(inOrder, preOrder, 0, inOrder.length - 1);
		
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

}
