package lab.daily;

import java.util.Collections;
import java.util.List;

public class Aug29 {

	public static void main(String[] args) {
		Aug29 instance = new Aug29();
//		System.out.println(instance.countPairs(new int[] { -1, 0, 3, 5, 9, 12 }, 12));
	}

	public int countPairs(List<Integer> nums, int target) {
//		int count = 0;
//		for (int i = 0; i < nums.size(); i++) {
//			int num = nums.get(i);
//			for (int j = i + 1; j < nums.size(); j++) {
//				if ((num + nums.get(j)) < target) {
//					count++;
//				}
//			}
//		}
//		return count;

		int left = 0;
		int right = nums.size() - 1;
		int count = 0;
		Collections.sort(nums);
		while (left < right) {
			int total = nums.get(left) + nums.get(right);
			if (total < target) {
				count = count + right - left;// Logic Here
				left++;
			} else {
				right--;
			}
		}
		return count;
	}
}
