package lab.daily;

import java.util.ArrayList;
import java.util.List;

public class Jul10 {

	public static void main(String[] args) {
		Jul10 instance = new Jul10();

		int[] result = instance.intersect(new int[] { 1, 2, 2, 1, 1000 }, new int[] { 1000 });

		for (int i : result) {
			System.out.println(i);
		}
	}

	public int[] intersect(int[] nums1, int[] nums2) {
//		int[] cache = new int[1000];

		int[] vals = new int[1001];
		int nums1Size = nums1.length;
		int nums2Size = nums2.length;
		int[] first = nums1Size >= nums2Size ? nums1 : nums2;
		int[] second = nums1Size < nums2Size ? nums1 : nums2;

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < first.length; i++) {
			int num = first[i];
			vals[num]++;
		}

		for (int i = 0; i < second.length; i++) {
			int num = second[i];
			if (vals[num] > 0) {
				result.add(num);
			}
			vals[num]--;
		}

		return result.stream().mapToInt(Integer::intValue).toArray();

	}
}
