package lab.daily;

import lab.base.TreeNode;

public class Jul2 {

	public int findSecondMinimumValue(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return -1;
		}
		return findSecondMinimumValue(root, root.val);

	}

	public int findSecondMinimumValue(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}

		if (root.val > k) {
			return root.val;
		}

		int leftVal = findSecondMinimumValue(root.left, root.val);
		int rightVal = findSecondMinimumValue(root.right, root.val);

		if (leftVal == -1 && rightVal == -1) {
			return -1;
		}

		if (leftVal == -1) {
			return rightVal;
		}

		if (rightVal == -1) {
			return leftVal;
		}

		return Math.min(leftVal, rightVal);

	}
}
