package tree;

public class Main {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.left =  new TreeNode(8);
		root.right =  new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		
		// Print inorder traversal
		TreeHelper.inorder(root);
		System.out.println();
		
		// Is sum property satisfy
		System.out.println(TreeHelper.isSumProperty(root));
	}
	
}
