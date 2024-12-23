package lab.daily;

import java.util.HashSet;

public class Sep1 {

	public static void main(String[] args) {
		Sep1 instance = new Sep1();
		System.out.println(instance.findFinalValue(new int[] { 2, 7, 9 }, 4));
	}

	public int findFinalValue(int[] nums, int original) {
		HashSet<Integer> cache = new HashSet<Integer>();
		for (int num : nums) {
			cache.add(num);
		}
		while (cache.contains(original)) {
			original = original * 2;
		}
		return original;
	}
}
