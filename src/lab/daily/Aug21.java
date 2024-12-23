package lab.daily;

import java.util.ArrayList;
import java.util.List;

public class Aug21 {

	public static void main(String[] args) {
		Aug21 instance = new Aug21();

		System.out.println(instance.commonChars(new String[] { "cool", "lock", "cook" }));
	}

	public List<String> commonChars(String[] words) {

		List<String> result = new ArrayList<>();
		int[] cache = new int[26];

		String cWord = words[0];

		for (int i = 0; i < cWord.length(); i++) {
			cache[cWord.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			int count = cache[i];
			char cc = ((char) ('a' + i));
			String c = cc + "";
			if (count == 0) {
				continue;
			} else if (count == 1) {
				for (int j = 1; j < words.length; j++) {
					if (words[j].indexOf(c) == -1) {
						count = 0;
						continue;
					}
				}
			} else {

				for (int j = 1; j < words.length; j++) {
					String word = words[j];
					int validCount = 0;
					for (int ij = 0; ij < word.length(); ij++) {
						if (word.charAt(ij) == cc) {
							validCount++;
						}
					}
					if (validCount == 0) {
						count = 0;
						continue;
					}
					if (validCount < count) {
						count = validCount;
					}
				}

			}
			for (int j = 0; j < count; j++) {
				result.add(c);
			}

		}

		return result;

	}
}
