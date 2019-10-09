package temp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.TreeNode;

public class TreeHelper {
	
	private static int k = 0;

	public static void inOrder(TreeNode root) {

		if (root == null)
			return;

		inOrder(root.left);

		System.out.println(root.data + " ");

		inOrder(root.right);

	}

	public static void preOrder(TreeNode root) {

		if (root == null)
			return;

		System.out.println(root.data + " ");

		inOrder(root.left);
		inOrder(root.right);
	}

	public static void levelOrderTraversal(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {

			TreeNode currentNode = queue.remove();
			System.out.println(currentNode.data);

			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}

			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
	}

	public static void printLevelOrderTraversalLineWise(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {

			TreeNode currentNode = queue.remove();

			if (currentNode == null) {
				
				System.out.println();
				
				if (!queue.isEmpty())
					queue.add(null);
				
			} else {
				System.out.print(currentNode.data + " ");

				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}

				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
		}

	}
	
	public static void inOrderWithoutRecursion(TreeNode root) {
		
		if (root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(true) {
			
			while(root != null) {
				stack.add(root);
				root = root.left;
			}
			
			if (stack.isEmpty())
				break;
			
			root = stack.pop();
			
			System.out.print(root.data +  " ");
			
			root = root.right;
		}
		
	}
	
	public static void printNthNodeOfInOrder(TreeNode root, int n) {
		k = n;
		printNthNodeOfInOrder(root);
	}
	
	private static void printNthNodeOfInOrder(TreeNode root) {
		
		if (root == null) {
			return;
		}
		
		printNthNodeOfInOrder(root.left);
		k--;
		if (k == 0) {
			System.out.println(root.data + " ");
		}
		printNthNodeOfInOrder(root.right);
	}
	
	public static void levelOrderTraversalSpiral(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
	
		boolean isRight = true;
		

		while (!queue.isEmpty()) {

			TreeNode currentNode = queue.remove();

			if (currentNode == null) {
				
				System.out.println();
				isRight = !isRight;
				
				if (!queue.isEmpty())
					queue.add(null);
				
			} else {
				System.out.print(currentNode.data + " ");

				if (isRight) {
					if (currentNode.right != null) {
						queue.add(currentNode.right);
					}
					
					if (currentNode.left != null) {
						queue.add(currentNode.left);
					}
				} else {
					if (currentNode.left != null) {
						queue.add(currentNode.left);
					}
					
					if (currentNode.right != null) {
						queue.add(currentNode.right);
					}
				}
			}
		}
	}
	
	public static void leverOrderTraversalReverse(TreeNode root) {
		
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!queue.isEmpty()) {

			TreeNode currentNode = queue.remove();

			if (currentNode == null) {
				
				System.out.println();
				
				if (!queue.isEmpty()) {
					queue.add(null);
					stack.add(null);
				}
				
			} else {
				stack.add(currentNode);
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}

				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}

			}
		}
		
		while(!stack.isEmpty()) {
			
			TreeNode node = stack.pop();
			
			if (node == null) {
				System.out.println();
			} else {
				System.out.print(node.data + " ");
			}
			
		}
		
	}

}
