package lab.daily;

import lab.base.ListNode;
import lab.base.TreeNode;

public class Jul5_pending {

//	Input: head = [5,2,13,3,8]
//			Output: [13,8]

	public static void main(String[] args) {
		Jul5_pending instance = new Jul5_pending();

		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(3);
		node.right = new TreeNode(7);

		ListNode listNode = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
		instance.removeNodes(listNode);

		System.out.println(instance.hasPathSum(node, 6));

//		[1,3,-1,-3,5,3,6,7]

		int[] result = instance.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
	}

	public ListNode removeNodes(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode max = removeNodes(head.next);

		head.next = max;

		if (max == null || head.val >= max.val) {
			return head;
		}

		return max;
	}

	public ListNode removeNodesF(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = removeNodesF(head.next);

		if (dummy.next == null || head.val >= dummy.next.val) {
			return head;
		}

		return dummy.next;

	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			return targetSum == root.val;
		}

		int curVal = targetSum - root.val;
		return hasPathSum(root.left, curVal) || hasPathSum(root.right, curVal);

	}

	public int[] maxSlidingWindow(int[] nums, int k) {

		int j = 0;
		int size = nums.length;

		int[] result = new int[size - k + 1];
		int max = Integer.MIN_VALUE;
//		int maxIdx 

		boolean windowStart = false;

		for (int i = 0; i < size; i++) {
			if (!windowStart && i == (k - 1)) {
				windowStart = true;
			}
			int val = nums[i];
			if (val > max) {
				max = val;
			}

			if (windowStart) {
				result[j++] = max;
			}

		}

		return result;
	}

//	private int getMaxIdx(int[] nums, int k) {
//		int max = Integer.MIN_VALUE;
//		int maxIdx = 0;
//		for (int i = 0; i < k; i++) {
//			int val = nums[i];
//
//		}
//	}

}
