package lab.daily;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lab.base.TreeNode;

public class BSTIterator {

	List<Integer> result = new ArrayList<>();
	Iterator<Integer> ite;
	TreeNode _root;

	public BSTIterator(TreeNode root) {
		inOrderTraversal(root, result);
		ite = result.iterator();
	}

	public int next() {
		return ite.next();
	}

	public boolean hasNext() {
		return ite.hasNext();

	}

	static void inOrderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left, result);
		result.add(root.val);
		inOrderTraversal(root.right, result);
	}

	static void inOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.val + "->");
		inOrderTraversal(root.right);
	}
}
