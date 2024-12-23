package lab.daily;

import java.util.HashSet;

public class Jul21 {

	public static void main(String[] args) {
		Jul21 instance = new Jul21();
		System.out.println(instance.numberOfSpecialCharsOpt("aaAbcBC"));
		System.out.println(instance.numberOfSpecialCharsOpt("abc"));
		System.out.println(instance.numberOfSpecialCharsOpt("abBCab"));

	}

	public int numberOfSpecialChars(String word) {

		int count = 0;
		HashSet<String> toCheck = new HashSet<String>();
		HashSet<String> cache = new HashSet<String>();

		for (char c : word.toCharArray()) {

			String str = c + "";
			String toAdd = Character.isUpperCase(c) ? (c + "").toLowerCase() : (c + "").toUpperCase();
			if (cache.contains(str.toLowerCase()) || toCheck.contains(toAdd)) {
				continue;
			}

			if (toCheck.contains(str)) {
				count++;
				cache.add(str.toLowerCase());

			} else {

				toCheck.add(toAdd);
			}

		}

		return count;
	}

	public int numberOfSpecialCharsOpt(String word) {
		int[] lowerCase = new int[26];
		int[] upperCase = new int[26];
		int specialCharactersCount = 0;
		for (int i = 0; i < word.length(); i++) {
			char currLetter = word.charAt(i);
			char lowerCaseLetter = Character.toLowerCase(currLetter);
			char upperCaseLetter = Character.toUpperCase(currLetter);
			int lowerCaseLetterIdx = lowerCaseLetter - 'a';
			int upperCaseLetterIdx = upperCaseLetter - 'A';
			if (lowerCase[lowerCaseLetterIdx] == -1 || upperCase[upperCaseLetterIdx] == -1) {
				continue;
			}

			if (currLetter >= 'A' && currLetter <= 'Z') {
				upperCase[upperCaseLetterIdx]++;
				if (lowerCase[lowerCaseLetterIdx] > 0) {
					specialCharactersCount++;
					lowerCase[lowerCaseLetterIdx] = -1;
				}
			} else {
				lowerCase[lowerCaseLetterIdx]++;

				if (upperCase[upperCaseLetterIdx] > 0) {
					specialCharactersCount++;
					upperCase[upperCaseLetterIdx] = -1;
				}
			}
		}

		return specialCharactersCount;
	}

}
