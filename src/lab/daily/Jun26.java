package lab.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lab.base.Node;
import lab.base.TreeNode;

public class Jun26 {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
		System.out.println(maxProfit(new int[] { 2, 4, 1, 1, 10 }));
		System.out.println(maxProfit(new int[] { 1, 2, 3, 100, 1000, 1, 100000 }));

		Node n = new Node(1);
		n.children = Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4));
		System.out.println(maxDepth(n));
//		Node 
	}

	public static int maxProfit(int[] prices) {
		Integer min = Integer.MAX_VALUE;
		Integer max = Integer.MIN_VALUE;
		Integer profit = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			Integer val = prices[i];

			if (val > max) {
				max = val;
			}

			if (val < min) {
				min = val;
				max = val;

			}

			if ((max - min) > profit) {
				profit = max - min;
			}

		}

		return profit;
	}

	public static List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<>();
		preOrderTraversal(root, root.children, result);
		return result;
	}

	public static List<Integer> postorder(Node root) {
		List<Integer> result = new ArrayList<>();
		postOrderTraversal(root, result);
		return result;
	}

	public static int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		return depthTraversal(root);
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {

		return false;
	}

	private static Integer depthTraversal(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.children == null) {
			return 1;
		}
		Integer max = 0;
		for (Node n : root.children) {
			max = Math.max(max, depthTraversal(n));
		}
		return max + 1;
	}

	private static void preOrderTraversal(Node root, List<Node> children, List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		if (children == null) {
			return;
		}
		for (Node n : children) {
			preOrderTraversal(n, n.children, result);
		}
	}

	private static void postOrderTraversal(Node root, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.children != null) {
			for (Node n : root.children) {
				postOrderTraversal(n, result);
			}
		}

		result.add(root.val);
	}

}
