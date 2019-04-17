package tree;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TreeNode root = TreeCreator.createTree();
		
		// Print in order traversal
		BinaryTreeCheckingAndPrintingHelper.inorder(root);
		System.out.println();
		
		// Is sum property satisfy
		System.out.println("Is sum property satisfied in the tree : " + BinaryTreeCheckingAndPrintingHelper.isSumPropertySatisfied(root));
		
		// Is covered nodes sum and uncovered nodes sum equal
		System.out.println("Is covered nodes and uncovered nodes have equal sum " + BinaryTreeCheckingAndPrintingHelper.isCoveredAndUncoveredNodesSumEqual(root));
		
		System.out.println("Is given nodes are cousins : " + BinaryTreeCheckingAndPrintingHelper.isCousinNodes(TreeCreator.createTreeForCousinCheck(), 4, 7));
		
		System.out.println("Is all leaves at same level : " + BinaryTreeCheckingAndPrintingHelper.isLeavesAtSameLevel(TreeCreator.createTreeForLeafLevelCheck()));
		
		System.out.println("If removal devides the tree equally : " + BinaryTreeCheckingAndPrintingHelper.isAnEdgeDivideTreeEqually(root));
		
		
		int inOrder[] = {4, 2, 5, 1, 3};  
	    int preOrder[] = {1, 2, 4, 5, 3};  
	    int postOrder[] = {4, 5, 2, 3, 1};  
	    System.out.println("Is all traversals of same tree : " + BinaryTreeCheckingAndPrintingHelper.isTraversalsFromSameTree(preOrder, inOrder, postOrder));
	    
	    
	    /**
	     *   Given the level order traversal of a Complete Binary Tree, determine whether the Binary Tree is a valid Min-Heap
	     */
	    int[] levelOrder = new int[]{10, 15, 14, 25, 30}; 
	    System.out.println("Is min heap : " + BinaryTreeCheckingAndPrintingHelper.isLevelOrderSatisfyMinHeap(levelOrder));
	    
	    
	    /**
	     * Check if two trees have same leaf node traversals
	     */
	    TreeNode root1 = TreeCreator.createTree1ForLeafTraversal();
	    TreeNode root2 = TreeCreator.createTree2ForLeafTraversal();
	    
	    System.out.println("Is leaf order traversal same : " + BinaryTreeCheckingAndPrintingHelper.isLeavesTraversalHasSameOrder(root1, root2));
	    
	    /**
	     * Check if tree is a perfect tree
	     */
	    System.out.println("Is perfect tree : " + BinaryTreeCheckingAndPrintingHelper.isPerfectTree(TreeCreator.createPerfectTree()));
	    
	    /**
	     * Check if a tree is full binary tree
	     */
	    System.out.println("Is full binary tree : " + BinaryTreeCheckingAndPrintingHelper.isFullBinaryTree(TreeCreator.createFullBinaryTree()));
	    
	    /**
	     * Check if a tree is complete tree
	     * 
	     */
	    System.out.println("Is a complete tree : " + BinaryTreeCheckingAndPrintingHelper.isCompleteTree(TreeCreator.createCompleteTree()));
	    
	    /**
	     * Check if two trees are identical
	     */
	    System.out.println("Are tree identical : " + BinaryTreeCheckingAndPrintingHelper.areIdentical(root, root));
	    
	    
	    /**
	     * Check if S is a subset of the original tree T
	     */
	    TreeNode T = TreeCreator.createMainTreeForSubsetProblem();
	    TreeNode S = TreeCreator.createSubTreeForSubsetProblem();
	    System.out.println("Is tree subset : " + BinaryTreeCheckingAndPrintingHelper.isTreeSubset(T, S));
	    
	    /**
	     * Check if a bianary tree contains duplicate values
	     */
	    System.out.println("Is binary tree contains duplicate values : " + BinaryTreeCheckingAndPrintingHelper.containsDuplicateNodes(T));
	    
	    /**
	     * Check if two tree are mirror
	     */
	    System.out.println("Is tree mirrors : " + BinaryTreeCheckingAndPrintingHelper.isMirror(TreeCreator.createTree1ForMirror(), TreeCreator.createTree2ForMirror()));
	    
	    /**
	     * Check if a tree is symmetric
	     */
	    System.out.println("Is tree symmetric : " + BinaryTreeCheckingAndPrintingHelper.isSymmetric(TreeCreator.createSymmetricTree()));
	    
	    /**
	     * Check if a path exists from root to leaf node
	     */
	    
	    int[] arr = {10, 8, 3};
	    System.out.println("Is path exists : " + BinaryTreeCheckingAndPrintingHelper.isPathExists(root, arr));
	    
	    /**
	     * Print cousin nodes
	     */
	    BinaryTreeCheckingAndPrintingHelper.printCousins(TreeCreator.createTreeForCousins(), 5);
	    
	    /**
	     * Print all paths of the tree
	     */
	    BinaryTreeCheckingAndPrintingHelper.printAllPaths(root);
	    
	    /**
	     * Print max diameter of the tree
	     */
	    System.out.println("Max diameter of tree : " + BinaryTreeCheckingAndPrintingHelper.getMaxDiameter(root));
	    
	    /**
	     * Print nodes at odd level
	     */
	    BinaryTreeCheckingAndPrintingHelper.printNodesAtOddLevel(root);
	    
	    /**
	     * Print full nodes of the tree 
	     */
	    System.out.println("Print full nodes : ");
	    BinaryTreeCheckingAndPrintingHelper.printFullNodes(root);
	    
	    
	    /**
	     * Print nodes between level 
	     */
	    BinaryTreeCheckingAndPrintingHelper.printNodesBetweenLevels(root, 1, 2);
	    
	    /**
	     * Print nodes with sublings
	     */
	    System.out.println("Print nodes without sublings: ");
	    BinaryTreeCheckingAndPrintingHelper.printNodesWithoutSublings2(root);
	    
	    /**
	     * print node with level
	     */
	    System.out.println("Printing tree with level : ");
	    BinaryTreeCheckingAndPrintingHelper.printNodeWithLevel(root);
	    
	    /**
	     * Print a tree vertically
	     */
	    System.out.println("Print a tree vertically");
	    BinaryTreeCheckingAndPrintingHelper.printTreeVertically(root);
	    
	    /**
	     * Print left view of the tree 
	     */
	    System.out.println("Printing left view of the tree : ");
	    BinaryTreeCheckingAndPrintingHelper.printLeftView(root);
	    
	    /**
	     * Print right view of the tree 
	     */
	    System.out.println("Printing left view of the tree : ");
	    BinaryTreeCheckingAndPrintingHelper.printRightView(root);
	    
	}
	
}
