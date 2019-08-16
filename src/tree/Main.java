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
	    
	    /**
	     * print sum of all nodes of the tree
	     */
	    System.out.println("Sum of all nodes of tree: " + BinaryTreeSumationHelper.sumOfNodes(root));
	    
	    /**
	     * Print sum of parent node with child x
	     */
	    System.out.println("Sum of parent nodes : " + BinaryTreeSumationHelper.sumOfParentNodesWithChildX(TreeCreator.createSymmetricTree(), 4));
	    
	    /**
	     * Print sum of the leaf nodes
	     */
	    System.out.println("Sum of the leaf nodes : " + BinaryTreeSumationHelper.sumOfLeaves(root));
	    
	    /**
	     * Sum of the nodes of the perfect tree
	     */
	    System.out.println("Sum of nodes of the perfect tree: " + BinaryTreeSumationHelper.sumOfNodesOfPerfectTree(3));
	    
	    /**
	     * Print diagnoal sum of the tree
	     */
	    
	    TreeNode rootDia = TreeCreator.createTreeForDiagonalSum();
	    
	    System.out.println("Print diagonal sum of the tree : ");
	    BinaryTreeSumationHelper.printDiagonalSum(rootDia);
	    
	    /**
	     * Find if there is a pair in root to a leaf path with sum equals to root’s data
	     * https://www.geeksforgeeks.org/find-pair-root-leaf-path-sum-equals-roots-data/
	     */
	    System.out.println("Is a pair with sum equal to root node exists : " + BinaryTreeSumationHelper.isPairInPathWithSumEqualToRoot(TreeCreator.createTreeForRootSumEqualToTwoNodesSum()));
	    
	    
	    /**
	     * Sum of the longest path
	     */
	    System.out.println("Sum of the longest Path : " + BinaryTreeSumationHelper.sumOfLongestPath(root));
	    
	    /**
	     * Max diameter tree sum 
	     */
	    System.out.println("Max tree diameter sum : " + BinaryTreeSumationHelper.maxDiameterSum(root));
	    
	    
	    /**
	     * Maximum root to leaf path
	     */
	    System.out.println("Maximum path sum : " + BinaryTreeSumationHelper.maxSumPath(root));
	    
	    /**
	     * Non adjacent nodes max sum 
	     */
	    System.out.println("Non adjacent nodes max sum : " + BinaryTreeSumationHelper.nonAdjacentNodesMaxSum(root));
	    
	    /**
	     * Max sub tree sum 
	     * 
	     */
	    System.out.println("Max subtree sum : "  + BinaryTreeSumationHelper.maxSubTreeSum(root));
	    
	    /**
	     * Sum of height of all the nodes 
	     */
	    System.out.println("Sum of heights of all the nodes : " + BinaryTreeSumationHelper.sumOfHeightsOfAllNodes(root));
	    
	    /**
	     * Sub tree exists with a given sum 
	     */
	    System.out.println("Does subtree with a given sum exists : " + BinaryTreeSumationHelper.isSubTreeWithGivenSumExists(root, 16));
	    
	    /**
	     * Count sub tree with given sum
	     */
	    System.out.println("Count subtree with a given sum : " + BinaryTreeSumationHelper.countSubTreeWithGivenSum(root, 16));
	    
	    /**
	     * Difference is sum of even level nodes and odd level nodes
	     */
	    System.out.println("Differnce in sum of nodes of even and odd level : " + BinaryTreeSumationHelper.diffInSumOfOddEvenLevelNodes(root));
	    
	    /**
	     * Sum at each level 
	     */
	    System.out.println("Print sum of nodes at each level : ");
	    BinaryTreeSumationHelper.printSumAtEachLevel(root);
	    
	    /**
	     * Get max sum among level 
	     */
	    System.out.println("Get max sum at level : " + BinaryTreeSumationHelper.getMaxSumAtLevel(root));
	    
	    /**\
	     * Sum of leaf nodes 
	     */
	    System.out.println("Sum of leaf nodes: " + BinaryTreeSumationHelper.sumOfLeafNodes(root));
	    
	    /**
	     * Is root to leaf path equal to a given  no. 
	     */
	    System.out.println("Is root to leaf path exists : " + BinaryTreeSumationHelper.isRootToLeafSumExists(root, 21));
	    
	    System.out.println("Root to leaf path sum " + BinaryTreeSumationHelper.sumOfRootToLeafPath(root));
	    
	    System.out.println("Print vertical sum : ");
	    BinaryTreeSumationHelper.printVerticalSum(root);
	    
	    /**
	     * Construct tree from given inorder and preorder
	     * 
	     */
	    System.out.println("Print tree from given inorder and preorder : ");
	    TreeNode node1 = BinaryTreeConversionHelper.buildTreeFromInOrderAndPreOrder(inOrder, preOrder);
	    BinaryTreeCheckingAndPrintingHelper.inorder(node1);
	    
	    /**
	     * Build tree from level order and in order
	     */
	    System.out.println("Build tree from level order and in order : ");
	    int in[] = new int[]{4, 8, 10, 12, 14, 20, 22}; 
        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14}; 
        TreeNode node2 = BinaryTreeConversionHelper.buildTreeFromInOrderAndLevelOrder(in, level);
        BinaryTreeCheckingAndPrintingHelper.inorder(node2);
        System.out.println();
        
        
        /**
         * Build tree from an array
         */
        System.out.println("Binary tree from an array : ");
        int[] arr1 = {36, 30, 25, 15, 12, 10};
        TreeNode node3 = BinaryTreeConversionHelper.buildTreeFromArray(arr1);
        BinaryTreeCheckingAndPrintingHelper.inorder(node3);
        System.out.println();
        
        /***
         * Print binary tree to list
         */
        TreeNode list = BinaryTreeConversionHelper.binaryTreeToList(root);
        
        
	} 
	
}
