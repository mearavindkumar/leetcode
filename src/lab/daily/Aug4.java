package lab.daily;

import java.util.HashSet;

public class Aug4 {

	public static void main(String[] args) {
		Aug4 instance = new Aug4();

		System.out.println(instance.nextGreatestLetter(new char[] { 'x', 'x', 'y', 'y' }, 'z') + ":EOF");
	}

	public int numDifferentIntegers(String word) {

		String[] tokens = word.split("[a-zA-Z]+");
		HashSet<String> result = new HashSet<>();

		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if (token.isEmpty()) {
				continue;
			}
			result.add(token.replaceAll("^0+", ""));
		}
		return result.size();
	}

	public boolean checkIfPangram(String sentence) {
		int[] cache = new int[26];
		for (char c : sentence.toCharArray()) {
			int idx = c - 'a';
			cache[idx]++;
		}

		for (int i : cache) {
			if (i == 0) {
				return false;
			}
		}

		return true;
	}

	public String replaceDigits(String s) {
		char[] cArray = s.toCharArray();
		char prevChar;
		char c = cArray[0];
		for (int i = 1; i < cArray.length; i++) {
			prevChar = c;
			c = cArray[i];
			if (c >= '0' && c <= '9') {
				char shiftChar = (char) (prevChar + (c - '0'));
				cArray[i] = shiftChar;
			}
		}

		return String.valueOf(cArray);
	}

	public String makeFancyString(String s) {
		char[] cArray = s.toCharArray();
		char[] output = new char[cArray.length];
		if (s.length() <= 2) {
			return s;
		}
		int outputIdx = 0;
		char prevChar;
		char c = cArray[0];
		int count = 0;
		output[outputIdx++] = c;
		for (int i = 1; i < cArray.length; i++) {
			prevChar = c;
			c = cArray[i];
			if (c == prevChar) {
				count++;
				if (count < 2) {
					output[outputIdx++] = c;
				}
			} else {
				output[outputIdx++] = c;
				count = 0;
			}

		}

		char[] result = new char[outputIdx];
		System.arraycopy(output, 0, result, 0, outputIdx);

		return String.valueOf(result);
	}

	public String generateTheString(int n) {
		char[] cArray = new char[n];
		cArray[0] = 'a';
		int idx = n % 2 == 0 ? 1 : 0;
		for (int i = idx; i < n; i++) {
			cArray[i] = 'b';
		}
		return String.valueOf(cArray);
	}

	public char nextGreatestLetter(char[] letters, char target) {
		int[] cache = new int[26];

		for (char ch : letters) {
			cache[ch - 'a']++;
		}

		for (char c = (char) (target + 1); c <= 'z'; c = (char) (c + 1)) {
			if (cache[c - 'a'] > 0) {
				return c;
			}
		}
		return letters[0];
	}

//	abbdcfdhe
}
