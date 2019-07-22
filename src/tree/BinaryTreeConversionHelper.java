package tree;

import java.util.LinkedList;
import java.util.Queue;

import array.ArrayHelper;

public class BinaryTreeConversionHelper {
	
	public static int preIndex = 0;
	
	public static TreeNode buildTreeFromInOrderAndPreOrder(int[] inOrder, int[] preOrder) {
		
		preIndex = 0;
		return buildTree(inOrder, preOrder, 0, inOrder.length - 1);
		
	}
	
	public static TreeNode buildTreeFromInOrderAndLevelOrder(int[] inOrder, int[] levelOrder) {
		TreeNode startNode = null;
		return buildTreeFromInOrderAndLevelOrder(startNode, inOrder, levelOrder, 0, inOrder.length - 1);
	}
	
	public static TreeNode buildTreeFromArray(int[] arr) {
		
		if(arr.length == 0)
			return null;
		
		
		int index = 0;
		
		TreeNode root = new TreeNode(arr[index++]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		TreeNode result = root;
		
		while (index < arr.length && !queue.isEmpty())
		{
			root = queue.poll();
			
			if (root == null)
				break;
			
			TreeNode left = new TreeNode(arr[index++]);
			queue.add(left);
			root.left = left;

			if (index >= arr.length)
				break;
			
			TreeNode right = new TreeNode(arr[index++]);
			
			queue.add(right);
			
			root.right = right;
		}
		
		return result;
	}
	
	public static TreeNode binaryTreeToList(TreeNode root) {
		
		if (root == null)
			return root;
		
		root = binaryTreeToList(root);
		
		while(root.left != null)
			root = root.left;
		
		return root;
	}
	
	private static TreeNode binaryTreeToListUtils(TreeNode root) {
		
		if (root == null)
			return root;
		
		if (root.left != null) {
			TreeNode left = binaryTreeToList(root.left);
			left.right = root;
			root.left = left;
		}
		
		if (root.right != null) {
			TreeNode right = binaryTreeToList(root.right);
			right.left = root;
			root.right = right;
		}
		
		return root;
		
	}
	
	private static TreeNode buildTreeFromInOrderAndLevelOrder(TreeNode startNode, int[] inOrder, int[] levelOrder, int startIndex, int endIndex) {
		
		if (startIndex > endIndex)
			return null;
		
		if (startIndex == endIndex)
			return new TreeNode(inOrder[startIndex++]);
	
		int index = 0;
		
		for (int i = 0; i < levelOrder.length; i++) {
			int data = levelOrder[i];			
			
			index = ArrayHelper.linearSearch(inOrder, data, startIndex, endIndex);
			
			System.out.println(index);
			
			if (index != -1) {
				startNode = new TreeNode(data);
				break;
			}
		}
		
		if (startNode != null) {
			startNode.left = buildTreeFromInOrderAndLevelOrder(startNode, inOrder, levelOrder, startIndex, index - 1);
			startNode.right = buildTreeFromInOrderAndLevelOrder(startNode, inOrder, levelOrder, index + 1, endIndex);			
		}
		
		return startNode;
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
