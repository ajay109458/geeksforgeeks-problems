package tree;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TreeNode root = TreeCreator.createTree();
		
		// Print in order traversal
		TreeHelper.inorder(root);
		System.out.println();
		
		// Is sum property satisfy
		System.out.println("Is sum property satisfied in the tree : " + TreeHelper.isSumProperty(root));
		
		// Is covered nodes sum and uncovered nodes sum equal
		System.out.println("Is covered nodes and uncovered nodes have equal sum " + TreeHelper.isCoveredAndUncoveredNodesSumEqual(root));
		
		System.out.println("Is given nodes are cousins : " + TreeHelper.isCousinsNode(TreeCreator.createTreeForCousinCheck(), 4, 7));
		
		System.out.println("Is all leaves at same level : " + TreeHelper.checkAllLeafAtSameLevel(TreeCreator.createTreeForLeafLevelCheck()));
		
		System.out.println("If removal devides the tree equally : " + TreeHelper.checkIfEdgeDivideTreeEqually(root));
		
		
		int inOrder[] = {4, 2, 5, 1, 3};  
	    int preOrder[] = {1, 2, 4, 5, 3};  
	    int postOrder[] = {4, 5, 2, 3, 1};  
	    System.out.println("Is all traversals of same tree : " + TreeHelper.checkAllTraversalOfSameTree(preOrder, inOrder, postOrder));
	    
	    
	    /**
	     *   Given the level order traversal of a Complete Binary Tree, determine whether the Binary Tree is a valid Min-Heap
	     */
	    int[] levelOrder = new int[]{10, 15, 14, 25, 30}; 
	    System.out.println("Is min heap : " + TreeHelper.checkIfLevelOrderOfCompleteBinaryTreeSatisfyMinHeap(levelOrder));
	    
	    
	    /**
	     * Check if two trees have same leaf node traversals
	     */
	    TreeNode root1 = TreeCreator.createTree1ForLeafTraversal();
	    TreeNode root2 = TreeCreator.createTree2ForLeafTraversal();
	    
	    System.out.println("Is leaf order traversal same : " + TreeHelper.isLeafOrderTraversalSame(root1, root2));
	    
	    /**
	     * Check if tree is a perfect tree
	     */
	    System.out.println("Is perfect tree : " + TreeHelper.isPerfectTree(TreeCreator.createPerfectTree()));
	}
	
}
