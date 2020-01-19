package practice;

import java.util.Stack;

import tree.TreeNode;

public class TreePractice {

	public static void inorder(TreeNode root) {
		if (root == null)
			return;
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	
	public static void preorder(TreeNode root) {
		
		if (root == null)
			return;
		
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);		
	}
	
	public static void postorder(TreeNode root) {
		
		if (root == null) {
			return;
		}
		
		postorder(root.left);
		postorder(root.right);
		
		System.out.println(root.data);
	}
	
	public static void inorderWithoutRecursion(TreeNode root) {
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		if (root == null)
			return;
		
		s.push(root);
		
		while(true) {
			
			while(root.left != null) {
				s.push(root.left);
				root = root.left;
			}
			
			if (s.isEmpty()) {
				break;
			}
			
			root = s.pop();
			
			System.out.println(root.data);
			
			root = root.right;
		}
		
	}
	
}
