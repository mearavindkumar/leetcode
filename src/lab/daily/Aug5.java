package lab.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aug5 {

	public static void main(String[] args) {
		Aug5 instance = new Aug5();

//		System.out.println(instance.squareIsWhite("a1") + ":EOF");
//		System.out.println(instance.squareIsWhite("h3") + ":EOF");
//		System.out.println(instance.squareIsWhite("c7") + ":EOF");
		System.out.println(instance.kthDistinct(new String[] { "a", "b", "a", "z", "y", "x" }, 1) + ":EOF");

	}

	public String kthDistinct(String[] arr, int k) {
		HashMap<String, Integer> map = new HashMap<>();
		List<String> values = new ArrayList<>();
		int[] cache = new int[arr.length];
		int idx = 0;
		for (String word : arr) {
			if (map.containsKey(word)) {
				int curIdx = map.get(word);
				cache[curIdx]++;
			} else {
				int curIdx = idx++;
				map.put(word, curIdx);
				values.add(word);
				cache[curIdx]++;
			}
		}

		for (int i = 0; i < idx; i++) {
			if (cache[i] != 1) {
				continue;
			}
			k--;
			if (k == 0) {
				return values.get(i);
			}
		}
		return "";
	}

	public String[] divideString(String s, int k, char fill) {
		int length = s.length();
		int remainder = length % k;
		int wordsLength = length / k;
		String[] words = new String[remainder == 0 ? wordsLength : wordsLength + 1];
		int count = 0;
		char[] cArray = s.toCharArray();
		while (wordsLength-- > 0) {
			char[] word = new char[k];
			System.arraycopy(cArray, k * count, word, 0, k);
			words[count++] = String.valueOf(word);
		}

		if (remainder == 0) {
			return words;
		}

		char[] word = new char[k];
		System.arraycopy(cArray, k * count, word, 0, remainder);

		for (int i = remainder; i < k; i++) {
			word[i] = fill;
		}
		words[count] = String.valueOf(word);

		return words;

	}

	public int maxProduct(int[] nums) {
		int max = -1;
		int secondMax = -1;
		for (int num : nums) {
//			secondMax = Math.max(num, secondMax);
//			max = Math.max(num, max);
			if (num > max) {
				secondMax = max;
				max = num;
			} else if (num > secondMax) {
				secondMax = num;
			}

		}
		return (max - 1) * (secondMax - 1);
	}

	public String restoreString(String s, int[] indices) {
		char[] cArray = s.toCharArray();
		char[] output = new char[cArray.length];
		for (int i = 0; i < cArray.length; i++) {
			int idx = indices[i];
			char charAtIdx = cArray[i];
			output[idx] = charAtIdx;
		}
		return String.valueOf(output);
	}

	public int isPrefixOfWord(String sentence, String searchWord) {
		if (sentence.startsWith(searchWord)) {
			return 1;
		}

		String token = sentence.split(" " + searchWord)[0];
		if (sentence.equals(token)) {
			return -1;
		}

		return token.split(" ").length + 1;
	}

	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		return String.join("", word1).equals(String.join("", word2));
	}

	public boolean squareIsWhite(String coordinates) {
		int row = (coordinates.charAt(0) - 'a');
		int col = (coordinates.charAt(1) - '1');
		return row % 2 == 1 && col % 2 == 0 || row % 2 == 0 && col % 2 == 1;
	}
}
