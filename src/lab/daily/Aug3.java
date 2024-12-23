package lab.daily;

public class Aug3 {

	public static void main(String[] args) {
		Aug3 instance = new Aug3();
//		System.out.println(instance.sortSentence("Myself2 Me1 I4 and3") + "EOF");
//
//		System.out.println(instance.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles 1"));
//
//		System.out.println(instance.checkString("ba"));
//
//		int[] result = instance.getConcatenation(new int[] { 1, 2, 3 });
//
//		for (int i : result) {
//			System.out.print(i);
//		}
//		System.out.println(instance.addSpaces("LeetcodeHelpsMeLearn", new int[] {}));

		System.out.println(instance.largestMultipleOfThree(new int[] { 3, 3, 5, 5, 8, 8, 8 }));
	}

	public String sortSentence(String s) {

		String[] tokens = s.split(" ");
		String[] result = new String[tokens.length];

		for (String token : tokens) {
			int idx = 0;
			char[] cs = token.toCharArray();
			StringBuilder tokenB = new StringBuilder();
			for (char c : cs) {
				if (c >= '1' && c <= '9') {
					idx = c - '1';
				} else {
					tokenB.append(c);
				}
			}
			result[idx] = tokenB.toString();
		}

		return String.join(" ", result);
	}

	public boolean areNumbersAscending(String s) {
		String[] tokens = s.split(" ");
		Integer curNumer = -1;
		for (String token : tokens) {
			char f = token.charAt(0);
			if (f >= '1' && f <= '9') {
				Integer num = Integer.parseInt(token);
				if (num <= curNumer) {
					return false;
				}
				curNumer = num;
			}
		}
		return true;
	}

	public boolean checkString(String s) {
		int idx = s.indexOf("b");
		return idx == -1 || s.indexOf("a", idx + 1) == -1;
	}

	public int[] getConcatenation(int[] nums) {
		int length = nums.length;
		int[] dest = new int[length * 2];
		System.arraycopy(nums, 0, dest, 0, length);
		System.arraycopy(nums, 0, dest, length, length);
		return dest;
	}

	public String addSpaces(String s, int[] spaces) {
		StringBuilder builder = new StringBuilder();
		char[] sArray = s.toCharArray();
		int spaceIdx = 0;
		int addSpaceAt = spaces.length > 0 ? spaces[spaceIdx] : -1;

		for (int i = 0; i < sArray.length; i++) {
			if (i == addSpaceAt) {
				builder.append(" ");
				spaceIdx++;
				if (spaceIdx >= spaces.length) {
					addSpaceAt = -1;
				} else {
					addSpaceAt = spaces[spaceIdx];
				}
			}
			builder.append(sArray[i]);
		}

		return builder.toString();
	}

	public String largestMultipleOfThree(int[] digits) {
		int sum = 0;
		int[] cache = new int[10];
		int[] remainderOne = new int[10];
		int[] remainderTwo = new int[10];
		int hasRemainderOne = 0;
		int hasRemainderTwo = 0;
		for (int i : digits) {
			cache[i]++;
			int currentRemainder = i % 3;
			if (currentRemainder == 1) {
				remainderOne[i]++;
				hasRemainderOne++;
			} else if (currentRemainder == 2) {
				remainderTwo[i]++;
				hasRemainderTwo++;
			}
			sum += i;
		}
		int remainder = sum % 3;
		if (remainder == 0) {
			return largestMultipleOfThreeJoinArray(cache);
		}

		if (hasRemainderOne == 0 && hasRemainderTwo == 0) {
			return "";
		}

		switch (remainder) {
		case 1:

			if (hasRemainderOne != 0) {
				for (int i = 0; i < remainderOne.length; i++) {
					if (remainderOne[i] != 0) {
						cache[i]--;
						break;
					}
				}
			} else if (hasRemainderTwo <= 1) {
				return "";
			} else {
				for (int i = 0, j = 0; i < remainderTwo.length; i++) {

					int count = remainderTwo[i];

					while (count-- > 0) {
						cache[i]--;
						j++;
						if (j == 2) {
							break;
						}
					}

					if (j == 2) {
						break;
					}

				}
			}
			return largestMultipleOfThreeJoinArray(cache);
		case 2:
			if (hasRemainderTwo != 0) {
				for (int i = 0; i < remainderTwo.length; i++) {
					if (remainderTwo[i] != 0) {
						cache[i]--;
						break;
					}
				}
			} else if (hasRemainderOne <= 1) {
				return "";
			} else {
				for (int i = 0, j = 0; i < remainderOne.length; i++) {
					int count = remainderOne[i];
					while (count-- > 0) {
						cache[i]--;
						j++;
						if (j == 2) {
							break;
						}
					}
					if (j == 2) {
						break;
					}
				}
			}
			return largestMultipleOfThreeJoinArray(cache);
		default:
			return "";
		}

	}

	private String largestMultipleOfThreeJoinArray(int[] digits) {
		StringBuilder builder = new StringBuilder();
		int startingDigit = -1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int count = digits[i];
			if (count == 0) {
				continue;
			}
			while (count-- > 0) {
				if (startingDigit == -1 && i == 0) {
					return "0";
				}
				builder.append(i);
				if (startingDigit == -1) {
					startingDigit = i;
				}
			}
		}
		String input = builder.toString();
		return input;
	}

//	private String largestMultipleOfThreeJoinArray(int[] digits) {
//		StringBuilder builder = new StringBuilder();
//		for (int i = digits.length - 1; i >= 0; i--) {
//			builder.append(digits[i]);
//		}
//		return builder.toString();
//	}

}
