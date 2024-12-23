package lab.daily;

import lab.base.TreeNode;

public class Jun29 {

	public static void main(String[] args) {

	}

	public int countNodes(TreeNode root) {
		return traversal(root, 0);
	}

	public int traversal(TreeNode root, int count) {
		if (root == null) {
			return 0;
		}
		return 1 + traversal(root.left, count) + traversal(root.right, count);
	}
}
