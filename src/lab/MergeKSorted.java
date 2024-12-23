package lab;

import java.util.HashSet;

import lab.base.ListNode;

public class MergeKSorted {

	public static int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int prev = 1, cur = 1;
		for (int i = 2; i <= n; i++) {
			int temp = cur;
			cur = temp + prev;
			prev = temp;
		}
		return cur;
//		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;

		int k = m + n - 1;

		while (j >= 0) {
			if (i >= 0 && nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}

	}

	public static ListNode detectCycle(ListNode head) {

		HashSet<ListNode> s = new HashSet<ListNode>();
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				while (true) {
					if (s.contains(slow)) {
						return slow;
					}
					slow = slow.next;
				}
			}
			s.add(slow);

		}
		return null;

	}

	public static ListNode detectCycle1(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast == null || fast.next == null)
			return null;
		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}
		System.out.println(head.val);
		return head;
	}

	public static int[] plusOne(int[] digits) {

//		int[] digits = { 1, 2, 3 };

		System.out.println(climbStairs(45));

		int n = digits.length;
		int carry = 1;

		for (int i = n - 1; i >= 0; i--) {
			System.out.print(digits[i]);
			int sum = digits[i] + carry;
			digits[i] = sum % 10;
			carry = sum / 10;
		}

		if (carry > 0) {
			int[] result = new int[n + 1];
			result[0] = carry;
			System.arraycopy(digits, 0, result, 1, n);
			digits = result;
		}
		return digits;
//        System.out.println(Arrays.toString(digits));
	}

	public static void main(String[] args) {

	}

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(-1);

		ListNode cursor = dummy;
		ListNode curNode;

		while ((curNode = getCurNode(lists)) != null) {
			cursor.next = curNode;
			cursor = curNode;
			curNode = curNode.next;
		}

		for (int i = 0; i < lists.length; i++) {
			ListNode cur = lists[i];
			if (cur == null) {
				continue;
			}
			cursor.next = cur;
		}
		return dummy.next;

	}

	public static ListNode getCurNode(ListNode[] lists) {
		int count = 0;
		int compareValue = -1;
		ListNode returnNode = null;
		int index = 0;
		for (int i = 0; i < lists.length; i++) {
			ListNode cur = lists[i];
			if (cur == null) {
				continue;
			}
			if (cur.val < compareValue || count == 0) {
				returnNode = cur;
				compareValue = cur.val;
				index = i;
			}
			count++;
		}
		if (count >= 2) {
			lists[index] = returnNode.next;
		}
		return count >= 2 ? returnNode : null;
	}

}
