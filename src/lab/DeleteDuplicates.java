package lab;

import java.util.HashMap;

import lab.base.ListNode;

public class DeleteDuplicates {

	public static void main(String[] args) {
//		[1,2,3,3,4,4,5]
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(3);
		node1.next.next.next = new ListNode(3);
		node1.next.next.next.next = new ListNode(3);
		node1.next.next.next.next.next = new ListNode(4);
		node1.next.next.next.next.next.next = new ListNode(5);

		ListNode.printNode(deleteDuplicates(node1));

	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode cursor = dummy;
		Integer skipNumber = null;
		while (head != null) {
			int val = head.val;
			if (skipNumber != null && val == skipNumber.intValue()) {
				head = head.next;
				continue;
			}
			ListNode forward = head.next;
			int nextVal = forward == null ? 0 : forward.val;
			if (val != nextVal) {
				cursor.next = new ListNode(val);
				cursor = cursor.next;
				skipNumber = null;
			} else {
				skipNumber = val;
			}
			head = head.next;
		}

		return dummy.next;
	}

	public ListNode deleteDuplicates1(ListNode head) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		ListNode cursor = head;
		while (head != null) {
			Integer val = head.val;
			if (map.containsKey(val)) {
				map.put(val, true);
			} else {
				map.put(val, false);
			}
			head = head.next;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = cursor;

		ListNode prevNode = dummy;

		while (cursor != null) {
			Integer value = cursor.val;
			if (map.get(value)) {
				prevNode.next = cursor.next;
				cursor = cursor.next;
			} else {
				prevNode = cursor;
				cursor = cursor.next;
			}

		}

		return dummy.next;
	}

}
