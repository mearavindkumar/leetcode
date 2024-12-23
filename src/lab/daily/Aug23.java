package lab.daily;

import java.util.HashMap;
import java.util.HashSet;

public class Aug23 {

	public static void main(String[] args) {
		Aug23 instance = new Aug23();

		System.out.println(instance.mostCommonWord("a b b", new String[] { "hit" }));
	}

	public String mostCommonWord(String paragraph, String[] banned) {

		paragraph = paragraph + " ";
		HashSet<String> bannedWords = new HashSet<>();
		HashMap<String, Integer> cache = new HashMap<>();

		for (String bannedWord : banned) {
			bannedWords.add(bannedWord.toLowerCase());
		}

		StringBuilder tokenizer = new StringBuilder();
		int maxCount = -1;
		String maxWord = "";
		for (int i = 0; i < paragraph.length(); i++) {
			char c = (char) ((paragraph.charAt(i) | 32));
			if (c >= 'a' && c <= 'z') {
				tokenizer.append(c);
			} else {
				String word = tokenizer.toString();
				if (!word.isEmpty() && !bannedWords.contains(word)) {
					int count = cache.getOrDefault(word, 0) + 1;
					if (count > maxCount) {
						maxCount = count;
						maxWord = word;
					}
					cache.put(word, count);
				}
				tokenizer = new StringBuilder();
			}
		}

		return maxWord;

	}
}
