package lab.daily;

import lab.base.TreeNode;

public class Jul19 {

	public static void main(String[] args) {
//		[4,2,7,1,3]
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);

		Jul19 instance = new Jul19();
		instance.inOrderPrint(root);

		TreeNode output = instance.searchBST(root, 2);
		System.out.println();
		instance.inOrderPrint(output);
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.val == val) {
			return root;
		}
		return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
//		return left == null ? searchBST(root.right, val) : left	;
	}

	public void inOrderPrint(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val);
		inOrderPrint(root.left);
		inOrderPrint(root.right);
	}
}
