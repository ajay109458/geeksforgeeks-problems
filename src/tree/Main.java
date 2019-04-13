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
		
		// Is covered nodes sum and uncovered nodes sum equal
		System.out.println(TreeHelper.isCoveredAndUncoveredNodesSumEqual(root));
		
		System.out.println("Is given nodes are cousins : " + TreeHelper.isCousinsNode(createTreeForCousinCheck(), 4, 7));
	}
	
	public static TreeNode createTreeForCousinCheck() {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.left.right.right = new TreeNode(15); 
        root.right.left = new TreeNode(6); 
        root.right.right = new TreeNode(7); 
        root.right.left.right = new TreeNode(8); 
        
        return root;
	}
	
}
