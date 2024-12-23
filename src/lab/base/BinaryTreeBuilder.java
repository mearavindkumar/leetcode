package lab.base;

public class BinaryTreeBuilder {
	private static int index;

	public static TreeNode buildTree(int[] preorder) {
		index = 0;
		return buildTreeHelper(preorder);
	}

	private static TreeNode buildTreeHelper(int[] preorder) {
		if (index >= preorder.length || preorder[index] == -1) {
			index++;
			return null;
		}

		TreeNode node = new TreeNode(preorder[index++]);
		node.left = buildTreeHelper(preorder);
		node.right = buildTreeHelper(preorder);

		return node;
	}

	public static void main(String[] args) {
		int[] preorder = { 1, 2, 2, 3, 4, 4, 3 };
		TreeNode root = buildTree(preorder);

		// Test the tree by printing the values
		printTree(root);
	}

//	public static

	private static void printTree(TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.val + " ");
		printTree(node.left);
		printTree(node.right);
	}
}
