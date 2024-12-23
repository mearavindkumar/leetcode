package lab.daily;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import lab.base.ListNode;
import lab.base.TreeNode;

public class Jul4 {

//	[4,2,7,1,3,6,9]

	public static void main(String[] args) {
		Jul4 instance = new Jul4();

		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(2);
		node.right = new TreeNode(7);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);

		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(9);
		List<Integer> result = new ArrayList<Integer>();
		preOrderTraversal(instance.invertTree(node), result);
		System.out.println(result);

//		1,2,3,4

		ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		listNode = instance.reverseKGroup(listNode, 5);

		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode leftNode = root.left;
		TreeNode rightNode = root.right;
		root.left = rightNode;
		root.right = leftNode;
		invertTree(leftNode);
		invertTree(rightNode);
		return root;

	}

	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return head;
		}

		if (head.next == null) {
			return head;
		}

		ListNode headNext = head.next;
		ListNode nextPair = headNext.next;
		headNext.next = head;
		head.next = swapPairs(nextPair);
		return headNext;

	}

	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode dummy = new ListNode(-1);
		int i = 0;
		List<ListNode> nodes = new ArrayList<>();
		ListNode temp = head;
		while (i < k) {
			if (temp == null) {
				break;
			}
			nodes.add(temp);
			temp = temp.next;
			i++;
		}
		if (i < k) {
			return head;
		}
		dummy.next = reverse(nodes);

		if (!nodes.isEmpty()) {
			nodes.get(0).next = reverseKGroup(temp, k);
		}
		return dummy.next;

	}

	public ListNode reverse(List<ListNode> nodes) {
		ListIterator<ListNode> ite = nodes.listIterator(nodes.size());
		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		while (ite.hasPrevious()) {
			ListNode prev = ite.previous();
			temp.next = prev;
			temp = prev;
		}
		return dummy.next;
	}

	static void preOrderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		preOrderTraversal(root.left, result);
		preOrderTraversal(root.right, result);
	}
}
