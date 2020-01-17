import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import hashing.HashingHelper;
import tree.TreeNode;

public class HashTests {

	/**
	 * Print tree in vertical order
	 */
	@Test
	void checkBinaryTreeVerticalOrder() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		
		HashingHelper.printVerticalOrder(root);
	}
	
	@Test
	void checkIfArrayIsSubset() {
		int arr1[] = {11, 1, 13, 21, 3, 7}; 
	    int arr2[] = {11, 3, 7, 1}; 
	    
	    boolean actualValue = HashingHelper.isSubArray(arr1, arr2);
	    
	    assertEquals(true, actualValue);
	}

}
