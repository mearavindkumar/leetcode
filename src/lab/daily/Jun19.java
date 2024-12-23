package lab.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lab.base.TreeNode;

public class Jun19 {

	public static void main(String[] args) {
		int[] preorder = { 1, 2, 2, 3, 4, 4, 3 };

//		[3,9,20,null,null,15,7]

		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);

//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		root = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);

//		System.out.println(minDepth(root));

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
//		root.right.right = new TreeNode(7);

//		System.out.println(sumOfLeftLeaves(root, 0, false));
//		System.out.println(isSymmetric(root));

		int[] a = new int[] { 1, 0, 1, 1 };
		System.out.println(containsNearbyDuplicate(a, 1));

	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if (heightDiff > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}

	public static int sumOfLeftLeaves(TreeNode root, int sum, boolean isLeft) {

		if (root == null) {
			return sum;
		}

		boolean isLeafNode = root.left == null && root.right == null;

		if (root.left == null) {
			return sumOfLeftLeaves(root.right, isLeft && isLeafNode ? sum + root.val : sum, false);
		}

		if (root.right == null) {
			return sumOfLeftLeaves(root.left, isLeft && isLeafNode ? sum + root.val : sum, true);
		}

		int leftValue = sumOfLeftLeaves(root.left, isLeft && isLeafNode ? sum + root.val : sum, true);
		int rightValue = sumOfLeftLeaves(root.right, sum, false);

		return leftValue + rightValue;

	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (map.containsKey(num)) {
				int idx = map.get(num);
				if (i - idx <= k) {
					return true;
				}
			}
			map.put(num, i);
		}
		return false;
	}

	public static int sumNumbers(TreeNode root, int sum) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return (sum * 10) + root.val;
		}

		if (root.left == null) {
			return sumNumbers(root.right, (sum * 10) + root.val);
		}
		if (root.right == null) {
			return sumNumbers(root.left, (sum * 10) + root.val);
		}

		int rightValue = sumNumbers(root.right, (sum * 10) + root.val);
		int leftValue = sumNumbers(root.left, (sum * 10) + root.val);

		return rightValue + leftValue;

	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return 1 + minDepth(root.right);

		}
		if (root.right == null) {
			return 1 + minDepth(root.left);
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public static int getMinHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getMinHeight(root.left);
		int right = getMinHeight(root.right);
		return Math.min(left, right) + 1;
	}

	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int right = getHeight(root.right);
		int left = getHeight(root.left);
		return Math.max(right, left) + 1;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q;
		}

		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static boolean isSymmetric(TreeNode root) {

		return isSymmetricTree(root.left, root.right);

	}

	public static boolean isSymmetricTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q;
		}

		return p.val == q.val && isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
	}

	public static List<Integer> preOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		preOrderTraversal(root, result);
		return result;
	}

	static void preOrderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		preOrderTraversal(root.left, result);
		preOrderTraversal(root.right, result);
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inOrderTraversal(root, result);
		return result;
	}

	static void inOrderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left, result);
		result.add(root.val);
		inOrderTraversal(root.right, result);
	}
}
