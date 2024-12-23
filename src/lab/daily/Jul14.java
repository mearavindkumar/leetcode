package lab.daily;

public class Jul14 {

	public static void main(String[] args) {
		Jul14 instance = new Jul14();
		String[] result = instance.findWords(new String[] { "adsdf", "sfd" });
		for (String s : result) {
			System.out.println(s);
		}
	}

	public String[] findWords(String[] words) {
		String[] result = new String[words.length];
		int resultIdx = 0;

		for (String word : words) {
			int initRow = getRow((word.charAt(0) + "").toLowerCase());
			int i = 1;
			for (; i < word.length(); i++) {
				char s = word.charAt(i);
				if (initRow != getRow((s + "").toLowerCase())) {
					break;
				}
			}

			if (i == word.length()) {
				result[resultIdx++] = word;
			}

		}

		String[] output = new String[resultIdx];

		System.arraycopy(result, 0, output, 0, resultIdx);

		return output;

	}

	public int getRow(String s) {
		if ("qwertyuiop".contains(s)) {
			return 1;
		} else if ("asdfghjkl".contains(s)) {
			return 2;
		} else {
			return 3;
		}
	}

}
