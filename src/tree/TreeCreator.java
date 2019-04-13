package tree;

public class TreeCreator {
	
	public static TreeNode createTree() {
		TreeNode root = new TreeNode(10);
		root.left =  new TreeNode(8);
		root.right =  new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		return root;
	}
	
	public static TreeNode createTreeForLeafLevelCheck() {
        TreeNode root = new TreeNode(12); 
        root.left = new TreeNode(5); 
        root.left.left = new TreeNode(3); 
        root.left.right = new TreeNode(9); 
        root.left.left.left = new TreeNode(1); 
        root.left.right.left = new TreeNode(1);
        
        return root;
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
