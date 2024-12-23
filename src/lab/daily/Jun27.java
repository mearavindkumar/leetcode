package lab.daily;

import java.util.ArrayList;
import java.util.List;

import lab.base.TreeNode;

public class Jun27 {

	static int sum = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		findTilt(root);
		System.out.println(sum);
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> root1List = new ArrayList();
		List<Integer> root2List = new ArrayList();

		traversal(root1, root1List);
		traversal(root2, root2List);

		return root1List.equals(root2List);
	}

	public static void traversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			result.add(root.val);
		}

		traversal(root.left, result);
		traversal(root.right, result);

	}

	public static int findTilt(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftSum = findTilt(root.left);
		int rightSum = findTilt(root.right);
		sum += Math.abs(leftSum - rightSum);
		return leftSum + rightSum + root.val;

	}

	private int sumSubtree(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return node.val + sumSubtree(node.left) + sumSubtree(node.right);
	}

//	private static int sum = 0;

	private static int helper(TreeNode node) {
		if (node == null)
			return 0;

		int left = helper(node.left);
		int right = helper(node.right);

		sum += Math.abs(left - right);

		return left + right + node.val;
	}

	public static int findTilt1(TreeNode root) {
		helper(root);
		return sum;
	}

}
