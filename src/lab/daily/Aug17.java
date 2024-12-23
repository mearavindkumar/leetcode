package lab.daily;

import java.util.HashSet;

public class Aug17 {

	public static void main(String[] args) {
		Aug17 instance = new Aug17();
		System.out.println(instance.uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" }));
	}

	public int uniqueMorseRepresentations(String[] words) {
		String[] codes = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
				".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
				"--.." };
		HashSet<String> result = new HashSet<>();
		for (String word : words) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int idx = c - 'a';
				builder.append(codes[idx]);
			}
			String code = builder.toString();
			result.add(code);

		}
		return result.size();
	}
}
