package lab.daily;

import java.util.HashMap;
import java.util.HashSet;

public class Aug27 {

	public static void main(String[] args) {
		Aug27 instance = new Aug27();
		System.out.println(instance.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashSet<Integer> valid = new HashSet<>();
		for (int num : nums1) {
			map.put(num, -1);
		}
		for (int i = 0; i < nums2.length; i++) {
			int num = nums2[i];
			for (Integer key : valid) {
				if (!map.containsKey(key)) {
					continue;
				}
				int val = map.get(key);
				if (val == -1 && key < num) {
					map.put(key, num);

				}
			}
			valid.add(num);
		}
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			result[i] = map.get(nums1[i]);
		}

		for (int i : result) {
			System.out.println(i);
		}

		return result;

	}

}
