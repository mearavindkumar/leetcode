package lab.daily;

public class Jul22 {

	public static void main(String[] args) {
		Jul22 instance = new Jul22();

//		System.out.println((char) ('A' + 'a'));

//		System.out.println('a' - 'A');

		char ch = 'b';
//		System.out.println((char) (ch - 32));

		System.out.println(instance.numberOfSpecialCharsOpt("aaAbcBC"));
		System.out.println(instance.numberOfSpecialCharsOpt("abc"));
		System.out.println(instance.numberOfSpecialCharsOpt("AbBCab"));

		System.out.println(instance.numberOfSpecialCharsOpt("AbcbDBdD"));

//		System.out.println(instance.numberOfSpecialCharsOpt("bcbB"));

	}

//	public int numberOfSpecialChars(String word) {
//
//	}

	public int numberOfSpecialCharsOpt(String word) {
		int[] lowerCase = new int[26];
		int[] upperCase = new int[26];
		int[] cache = new int[26];
		int specialCharactersCount = 0;
		for (int i = 0; i < word.length(); i++) {
			char currLetter = word.charAt(i);

			boolean isUpperCase = currLetter >= 'A' && currLetter <= 'Z';

			char upperCaseLetter = isUpperCase ? currLetter : (char) (currLetter - 32);

			int upperCaseLetterIdx = upperCaseLetter - 'A';

			if (upperCase[upperCaseLetterIdx] == -1) {
				continue;
			}

			char lowerCaseLetter = isUpperCase ? (char) (currLetter + 32) : currLetter;
			int lowerCaseLetterIdx = lowerCaseLetter - 'a';

			if (isUpperCase) {
				upperCase[upperCaseLetterIdx]++;
				if (lowerCase[lowerCaseLetterIdx] > 0 && cache[lowerCaseLetterIdx] != -1) {
					specialCharactersCount++;
					cache[lowerCaseLetterIdx] = -1;
				}
			} else {
				lowerCase[lowerCaseLetterIdx]++;

				if (upperCase[upperCaseLetterIdx] > 0) {
					if (cache[lowerCaseLetterIdx] == -1) {
						specialCharactersCount--;
					}
					upperCase[upperCaseLetterIdx] = -1;
				}
			}
		}

		return specialCharactersCount;
	}
}
