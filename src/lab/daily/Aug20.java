package lab.daily;

import java.util.HashSet;

public class Aug20 {

	public static void main(String[] args) {
		Aug20 instance = new Aug20();
//		instance.resultArray(new int[] { 5, 4, 3, 8 });

		System.out.println(instance.similarPairs(new String[] { "aba", "aabb", "abcd", "bac", "aabc" }));
	}

	public int similarPairs(String[] words) {
		int len = words.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			String word = words[i];
			for (int j = i + 1; j < len; j++) {
				String compareWord = words[j];
				if (similarPair(word, compareWord)) {
					count++;
				}
			}

		}

		return count;

	}

	private boolean similarPair(String word1, String word2) {
		HashSet<Character> cache1 = new HashSet<>();
		HashSet<Character> cache2 = new HashSet<>();
		for (int i = 0; i < word1.length(); i++) {
			cache1.add(word1.charAt(i));
		}

		for (int i = 0; i < word2.length(); i++) {
			cache2.add(word2.charAt(i));
		}
		return cache1.equals(cache2);

	}
}
