package lab.daily;

import lab.base.TreeNode;

public class Dec28 {

	public boolean binarySearch(TreeNode root, int target) {
		if (root == null) {
			return false;
		}
		if (root.val == target) {
			return true;
		}
		return root.val < target ? binarySearch(root.right, target) : binarySearch(root.left, target);
	}

	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
		return dfs(root1, root2, target);
	}

	public boolean dfs(TreeNode root1, TreeNode root2, int target) {
		if (root1 == null) {
			return false;
		}
		if (binarySearch(root2, target - root1.val)) {
			return true;
		}

		return dfs(root1.left, root2, target) || dfs(root1.right, root2, target);
	}



}
