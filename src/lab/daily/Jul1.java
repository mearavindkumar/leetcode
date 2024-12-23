package lab.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import lab.base.TreeNode;

public class Jul1 {

	public static void main(String[] args) {

		TreeNode tree = new TreeNode(2);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(3);
//		tree.right.left = new TreeNode(1277);
//		tree.right.left.left = new TreeNode(519);

//		tree.left.left = new TreeNode(2);
//		tree.left.right = new TreeNode(4);

//		tree.right.right = new TreeNode(2776);

		System.out.println(new Jul1().findTarget(tree, 1));

		HashSet<Integer> result = new HashSet();

		System.out.println(new Jul1().find(result, tree, 1));

	}

	public boolean findTarget(TreeNode root, int k) {
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
//		result.put(0, 0);
		return findTarget(root, k, result);
	}

	public boolean findTarget(TreeNode root, int k, HashMap<Integer, Integer> remainder) {
		if (root == null) {
			return false;
		}

		if (remainder.containsKey(k - root.val)) {
			return true;
		}

		remainder.put(root.val, 1);

		return findTarget(root.left, k, remainder) || findTarget(root.right, k, remainder);

	}

	boolean find(Set<Integer> s, TreeNode root, int k) {
		if (root == null)
			return false;
		if (s.contains(k - root.val))
			return true;
		s.add(root.val);
		return find(s, root.left, k) || find(s, root.right, k);
	}
}
