package lab.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lab.base.ListNode;
import lab.base.TreeNode;

public class Dec26 {

	Map<Integer, Integer> result = new HashMap<>();
	List<Integer> cache = new ArrayList<>();
	int max = Integer.MIN_VALUE;

	ListNode current;
	boolean stop;

	public void reorderList(ListNode head) {
		if (current == null) {
			current = head;
		}
		if (head == null) {
			return;
		}
		reorderList(head.next);
		if (!stop) {
			ListNode t = current.next;
			current.next = head;
			head.next = t;
			current = t;
		}

		if (current != null && current.next == head) {
			current.next = null;
			stop = true;
		}
	}


	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;

		}
		boolean isPal = isPalindrome(head.next) && head.val == current.val;
		current = current.next;
		return isPal;
	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}
		return isSubtreeIdentical(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public boolean isSubtreeW(TreeNode root, TreeNode subRoot) {
		if (root == null || subRoot == null) {
			return root == subRoot;
		}

		boolean t = root.val == subRoot.val && isSubtreeW(root.left, subRoot.left)
				&& isSubtreeW(root.right, subRoot.right);
//		if(!t && )

		return t || isSubtreeW(root.val == subRoot.val ? root : root.left, subRoot)
				|| isSubtreeW(root.val == subRoot.val ? root : root.right, subRoot);
	}

	public boolean isSubtreeS(TreeNode root1, TreeNode root2, TreeNode subRoot) {
		if (root1 == null || root2 == null) {
			return root1 == root2;
		}
		boolean ans = false;
		if (root1.val == root2.val) {
			ans = isSubtreeS(root1.left, root2.left, subRoot) && isSubtreeS(root1.right, root2.right, subRoot);
		}
		if (!ans && root1.val == subRoot.val) {
			ans = isSubtreeS(root1.left, subRoot.left, subRoot) && isSubtreeS(root1.right, subRoot.right, subRoot);
		}
		return ans || isSubtreeS(root1.left, subRoot, subRoot) || isSubtreeS(root1.right, subRoot, subRoot);
	}

	public boolean isSubtreeIdentical(TreeNode root, TreeNode subRoot) {
		if (root == null || subRoot == null) {
			return root == subRoot;
		}
		return root.val == subRoot.val && isSubtreeIdentical(root.left, subRoot.left)
				&& isSubtreeIdentical(root.right, subRoot.right);
	}

	public static void main(String[] args) {
//		[1,0,1,0,0,1,1,0]
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(0);
//		root.right = new TreeNode(1);
//		root.left.left = new TreeNode(0);
//		root.left.right = new TreeNode(0);
//		root.right.left = new TreeNode(1);
//		root.right.right = new TreeNode(1);
//		root.left.left.left = new TreeNode(0);
		Dec26 instance = new Dec26();
//		instance.findMode(root);
//
//		System.out.println(instance.isSubtree(root, root));

		ListNode root = new ListNode(1,
				new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		instance.reorderList(root);
	}

	public int[] findMode(TreeNode root) {
		findModeDFS(root);
		return cache.stream().mapToInt(Integer::intValue).toArray();
	}

	public void findModeDFS(TreeNode root) {
		if (root == null) {
			return;
		}
		findModeDFS(root.left);
		int c = 0;
		if (result.containsKey(root.val)) {
			c = result.get(root.val);
		}
		c++;
		if (c > max) {
			max = c;
			cache = new ArrayList<Integer>() {
				{
					add(root.val);
				}
			};
		} else if (c == max) {
			cache.add(root.val);
		}
		result.put(root.val, c);
		findModeDFS(root.right);
	}
}
