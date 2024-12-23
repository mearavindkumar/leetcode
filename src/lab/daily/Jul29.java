package lab.daily;

import java.util.Collections;
import java.util.HashSet;

public class Jul29 {

	public static void main(String[] args) {
		Jul29 instance = new Jul29();
		instance.findLucky(new int[] { 2, 2, 3, 4 });
		instance.findLucky(new int[] { 1, 2, 2, 3, 3, 3 });
		instance.findLucky(new int[] { 2, 2, 2, 3, 3 });
	}

	public int findLucky(int[] arr) {
		int[] cache = new int[501];
		for (int i : arr) {
			cache[i]++;
		}

		for (int i = 500; i > 0; i--) {
			if (cache[i] == i) {
				return i;
			}
		}
		return -1;

	}

	public int findLuckyOpti(int[] arr) {
		int[] cache = new int[501];
		HashSet<Integer> result = new HashSet<Integer>();
		for (int i : arr) {
			cache[i]++;
			if (cache[i] == i) {
				result.add(i);
			} else {
				result.remove(i);
			}
		}

		return result.isEmpty() ? -1 : Collections.max(result);

	}
}
