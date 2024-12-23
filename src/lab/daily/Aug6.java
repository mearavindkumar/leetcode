package lab.daily;

import java.util.ArrayList;
import java.util.List;

import lab.base.TreeNode;

public class Aug6 {

	public static void main(String[] args) {
		Aug6 instance = new Aug6();

//		System.out.println(instance.twoOutOfThree(new int[] { 2, 15, 10, 11, 14, 12, 14, 11, 9, 1 },
//				new int[] { 8, 9, 13, 2, 11, 8 }, new int[] { 13, 5, 15, 7, 12, 7, 8, 3, 13, 15 }));

		System.out.println(instance.percentageLetter("foobar", 'o'));
	}

	public int percentageLetter(String s, char letter) {
		char[] cArray = s.toCharArray();
		int count = 0;
		for (char c : cArray) {
			if (c == letter) {
				count++;
			}
		}

		return ((count * 100) / cArray.length);
	}

	public int findClosestNumber(int[] nums) {
		Integer closest = Integer.MAX_VALUE;
		for (int num : nums) {
			int distance = Math.abs(0 - num);
			if (Math.abs(closest) > distance) {
				closest = num;
			} else if (Math.abs(closest) == Math.abs(num)) {
				closest = Math.max(closest, num);
			}
		}
		return closest;
	}

	public int smallestEqual(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 10 == i) {
				return nums[i];
			}
		}
		return -1;
	}

	public boolean isPrefixString(String s, String[] words) {
//		int startIdx = 0;
		StringBuilder builder = new StringBuilder();
		for (String word : words) {
			builder.append(word);
			if (builder.length() >= s.length()) {
				return builder.toString().equals(s);
			}
		}
		return false;
	}

	public int finalValueAfterOperations(String[] operations) {
		int x = 0;
		for (String operation : operations) {
			int factor = operation.contains("++") ? 1 : -1;
			x = x + (factor * 1);
		}
		return x;
	}

//	System.out.println(instance.twoOutOfThree(new int[] { 3, 1 }, new int[] { 2, 3 }, new int[] { 1, 2 }));
	public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
		List<Integer> result = new ArrayList<>();
		int[] cache = new int[101];
		for (int num : nums1) {
			cache[num] = 1;
		}

		for (int num : nums2) {
			if (cache[num] == -1 || cache[num] == 10) {
				continue;
			}
			if (cache[num] == 1) {
				result.add(num);
				cache[num] = -1;
			} else {
				cache[num] = 10;
			}
		}

		for (int num : nums3) {
			if (cache[num] == -1) {
				continue;
			}
			if (cache[num] == 10 || cache[num] == 1) {
				result.add(num);
				cache[num] = -1;
			}
		}

		return result;

	}

	public boolean checkTree(TreeNode root) {
		return root.val == (root.left.val + root.right.val);
	}
}
