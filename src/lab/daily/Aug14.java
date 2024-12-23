package lab.daily;

import java.util.Arrays;

public class Aug14 {

	public static void main(String[] args) {
		Aug14 instance = new Aug14();
//		instance.resultArray(new int[] { 5, 4, 3, 8 });

		System.out.println(instance.frequencySort(new int[] { 1, 5, 0, 5 }));
	}

	public int[] frequencySort(int[] nums) {
		int[][] cache = new int[2][101];
		for (int num : nums) {
			int subIndex = num >= 0 ? 0 : 1;
			num = num >= 0 ? num : -1 * num;
			cache[subIndex][num]++;
		}
		nums = Arrays.stream(nums).boxed().sorted((a, b) -> {
			int subIndexOne = a >= 0 ? 0 : 1;
			int one = a >= 0 ? a : -1 * a;
			int subIndexTwo = b >= 0 ? 0 : 1;
			int two = b >= 0 ? b : -1 * b;
//			if (cache[subIndexTwo][two] == cache[subIndexOne][one]) {
//				System.out.println("equal " + a + " " + b + " " + Integer.compare(b, a) + " " + Integer.compare(a, b));
//			}
			return cache[subIndexTwo][two] == cache[subIndexOne][one] ? Integer.compare(a, b)
					: Integer.compare(cache[subIndexTwo][two], cache[subIndexOne][one]);
		}).mapToInt(i -> i).toArray();

		int[] result = new int[nums.length];
		int idx = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			result[idx++] = nums[i];
//			System.out.println(nums[i]);
		}

		return result;
	}

//	public String frequencySort(String s) {
//
//	}
}
