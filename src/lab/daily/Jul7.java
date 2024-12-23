package lab.daily;

import java.util.HashSet;

public class Jul7 {

	public static void main(String[] args) {
		Jul7 instance = new Jul7();

		int[] nums = new int[] { 0, 1, 0, 2, 3, 0, 4 };

		char[] c = new char[] { 'h', 'e', 'l', 'l', 'o', '0' };

		c = new char[] {};

		instance.reverseString(c);

		for (char i : c) {
			System.out.println(i);
		}

		int[] nums1 = new int[] { 4, 9, 5 };
		int[] nums2 = new int[] { 9, 4, 9, 8, 4 };

		int[] result = instance.intersection(nums1, nums2);

//		for (int i : result) {
//			System.out.println(i);
//		}

	}

	public int[] intersection(int[] nums1, int[] nums2) {

		HashSet<Integer> intersection1 = new HashSet<>();
		HashSet<Integer> result = new HashSet<>();

		for (int i : nums1) {
			intersection1.add(i);
		}

		for (int i : nums2) {
			if (intersection1.contains(i)) {
				result.add(i);
			}
		}

		return result.stream().mapToInt(Integer::intValue).toArray();

	}

	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;
		while (left <= right) {
			char t = s[left];
			s[left] = s[right];
			s[right] = t;
			left++;
			right--;
		}
	}
}
