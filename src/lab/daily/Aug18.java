package lab.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aug18 {

	public static void main(String[] args) {
		Aug18 instance = new Aug18();
		System.out.println(instance.frequencySort("tree"));
	}

	public String frequencySort(String s) {
//		int[][] cache = new int[2][26];
		HashMap<String, Integer> cache = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			String c = s.charAt(i) + "";
			cache.put(c, cache.getOrDefault(c, 0) + 1);
		}

		List<Map.Entry<String, Integer>> sortedByValue = new ArrayList(cache.entrySet());
		Collections.sort(sortedByValue, Collections.reverseOrder(Map.Entry.comparingByValue()));
		StringBuilder str = new StringBuilder();

		for (Map.Entry<String, Integer> entry : sortedByValue) {
			int count = entry.getValue();
			while (count-- > 0) {
				str.append(entry.getKey());
			}
		}

		return str.toString();

	}

}
