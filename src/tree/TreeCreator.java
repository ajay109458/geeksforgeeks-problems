package tree;

public class TreeCreator {

	public static TreeNode createTree() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.right = new TreeNode(2);
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
	
	public static TreeNode createTreeForDiagonalSum() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);

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

	public static TreeNode createTree1ForLeafTraversal() {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);
		return root1;
	}

	public static TreeNode createTree2ForLeafTraversal() {
		TreeNode root1 = new TreeNode(0);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(5);
		root1.left.left = new TreeNode(4);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);
		return root1;
	}

	public static TreeNode createPerfectTree() {
		TreeNode root = null;
		root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);

		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(50);
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(70);
		return root;
	}

	public static TreeNode createFullBinaryTree() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.right = new TreeNode(40);
		root.left.left = new TreeNode(50);
		root.right.left = new TreeNode(60);
		root.left.left.left = new TreeNode(80);
		root.right.right = new TreeNode(70);
		root.left.left.right = new TreeNode(90);
		root.left.right.left = new TreeNode(80);
		root.left.right.right = new TreeNode(90);
		root.right.left.left = new TreeNode(80);
		root.right.left.right = new TreeNode(90);
		root.right.right.left = new TreeNode(80);
		root.right.right.right = new TreeNode(90);
		return root;
	}

	public static TreeNode createCompleteTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		return root;
	}

	public static TreeNode createMainTreeForSubsetProblem() {
		TreeNode root = new TreeNode(26);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left = new TreeNode(10);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(30);
		root.left.right = new TreeNode(6);
		return root;
	}

	public static TreeNode createSubTreeForSubsetProblem() {
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(6);
		root.left = new TreeNode(4);
		root.left.right = new TreeNode(30);
		return root;
	}

	public static TreeNode createTree1ForMirror() {
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(3);
		a.left.left = new TreeNode(4);
		a.left.right = new TreeNode(5);
		return a;
	}

	public static TreeNode createTree2ForMirror() {
		TreeNode b = new TreeNode(1);
		b.left = new TreeNode(3);
		b.right = new TreeNode(2);
		b.right.left = new TreeNode(5);
		b.right.right = new TreeNode(4);
		return b;
	}

	public static TreeNode createSymmetricTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		return root;
	}

	public static TreeNode createTreeForCousins() {
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
	
	public static TreeNode createTreeForRootSumEqualToTwoNodesSum() {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(5);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(12);
		root.left.right.right.right = new TreeNode(2);
		root.right.right = new TreeNode(11);
		root.right.right.left = new TreeNode(3);
		
		return root;
	}
}
