package lab.daily;

import java.util.HashSet;

import lab.base.ListNode;

class Solution {

	public static void main(String[] args ) {
		ListNode n = new ListNode(1);
		ListNode head = n;
		for (int i = 2; i <= 5; i++) {
			ListNode c = new ListNode(i);
			n.next = c;
			n = c;
		}
		ListNode headT = head;
		while (headT != null) {
			System.out.println(headT.val);
			headT = headT.next;
		}
		headT = head;
		ListNode headRT = reverseList1(headT);

		System.out.println("");
		while (headRT != null) {
			System.out.println(headRT.val);
			headRT = headRT.next;
		}

	}

//	1 -> 2 -> 3 -> 4 -> 5
//	

	public static ListNode reverseList1(ListNode head) {
		ListNode curNode = head;
		if (head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = head.next;
		curNode.next = null;
		while (nextNode != null) {
			ListNode temp = nextNode.next;
			nextNode.next = curNode;
			curNode = nextNode;
			nextNode = temp;
		}

		return curNode;

	}

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}


	public static ListNode reverseList(ListNode head) {

		ListNode curNode = head;
		if (head == null || head.next == null) {
			return head;
		}
		ListNode nextNode = head.next;
		head.next = null;
		while (nextNode != null) {
			ListNode temp = nextNode.next;
			nextNode.next = curNode;
			curNode = nextNode;
			nextNode = temp;
        }
		return curNode;
    }
}