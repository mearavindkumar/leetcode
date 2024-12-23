package lab.daily;

import java.util.ArrayList;

import lab.base.ListNode;

public class Jun17 {

	public static void main(String args[]) {
		int[] nums = new int[] { 1, 2 };

//		HashMap<K, V>

//		System.out.println(isPowerOfTwo(1));
		System.out.println(isPowerOfTwo(16));
//		System.out.println(isPowerOfTwo(3));
//		rotate1(nums, 3);

//		2,7,4,3,5

//		1,7,5,1,9,2,5,1

//		9,7,6,7,6,9
		ListNode node1 = new ListNode(9);

		node1.next = new ListNode(7);
		node1.next.next = new ListNode(6);
		node1.next.next.next = new ListNode(7);
		node1.next.next.next.next = new ListNode(6);
		node1.next.next.next.next.next = new ListNode(9);
//		node1.next.next.next.next.next.next = new ListNode(5);
//		node1.next.next.next.next.next.next.next = new ListNode(1);
//		node1.next.next.next = null;

//		nums = nextLargerNodes(node1);

//		for (int i = 0; i < nums.length; i++) {
//			System.out.println(nums[i]);
//		}
//		System.out.println(rotate(n, 3));
	}

	public static int reverse(int x) {
		int reverse = 0;
		int y = Math.abs(x);
		while (y > 0) {
			int remainder = y % 10;
			reverse = reverse * 10 + remainder;
			y = y / 10;
		}
		if (Integer.MAX_VALUE < reverse) {
			return 0;
		}
		return x < 0 ? -1 * reverse : (int) reverse;
	}

//	[1,2,3,4,5,6,7]
//	3

//	2

//	-1, -100, 3, 99
//	[3,99,-1,-100]

	public static void rotate(int[] nums, int k) {
		int count = 0;
		int index = 0;
		int prevIndex = 0;
		int size = nums.length;
		int cursor = nums[index];

		int[] visited = new int[nums.length];

		while (count < nums.length) {

			if (visited[index] == -1) {
				index = (index + 1 + k) % size;
				cursor = nums[index];
				continue;
			}
			prevIndex = index;
			index = (index + k) % size;
			int curNumber = cursor;
			cursor = nums[index];
			nums[index] = curNumber;
			visited[prevIndex] = -1;
			count++;
		}

	}

	public static void rotate1(int[] nums, int k) {
		int size = nums.length;
		k = k % nums.length;

		int[] temp = new int[k];

		for (int i = 0; i < k; i++) {
			temp[i] = nums[size - k + i];
		}

		for (int i = size - k - 1; i >= 0; i--) {
			nums[i + k] = nums[i];
		}

		for (int i = 0; i < k; i++) {
			nums[i] = temp[i];
		}

	}

	public static boolean isPowerOfTwo(int n) {
		System.out.println((n & (n - 1)));
		while (n > 1) {
			n = n >> 1;
			System.out.println(n);
		}
		return n == 1;
	}

	public static int[] nextLargerNodes(ListNode head) {

		ArrayList<Integer> allNumbers = new ArrayList<>();

		ArrayList<Integer> numbers = new ArrayList<>();

		ArrayList<Integer> idx = new ArrayList<>();

		int num = head.val;
		int count = 0;
		while (head != null) {
			int curVal = head.val;
			if (curVal > num) {
				numbers.add(curVal);
				idx.add(count);
				num = head.val;
			} else {
				num = curVal;
			}
			head = head.next;
			allNumbers.add(curVal);
			count++;
		}

//		System.out.println(numbers);
		int[] nums = new int[count];

		int j = 0;

		int validIndex = idx.size() > 0 ? idx.get(j) : Integer.MAX_VALUE;
		int curNumber = numbers.size() > 0 ? numbers.get(j) : 0;
		for (int i = 0; i < count; i++) {

			if (i > validIndex - 1) {
				j++;
				validIndex = j < idx.size() ? idx.get(j) : Integer.MAX_VALUE;
				curNumber = j < numbers.size() ? numbers.get(j) : 0;
			}

			int prevNum = allNumbers.get(i);
			if (prevNum < curNumber) {
				nums[i] = curNumber;
			} else if (j >= numbers.size()) {

				nums[i] = 0;
			} else {
				nums[i] = 0;
				for (int k = j; k < numbers.size(); k++) {
					if (prevNum < numbers.get(k)) {
						nums[i] = numbers.get(k);
						break;
					}
				}
			}
		}

		return nums;

	}
}
