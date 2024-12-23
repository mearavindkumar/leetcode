package lab.daily;

public class Jul20 {

	public static void main(String[] args) {
		Jul20 instance = new Jul20();
		System.out.println(instance.detectCapitalUse("lee"));
		System.out.println(instance.detectCapitalUse("leeT"));
		System.out.println(instance.detectCapitalUse("USA"));
		System.out.println(instance.detectCapitalUse("USAa"));
		System.out.println(instance.detectCapitalUse("FlaG"));

		System.out.println(instance.detectCapitalUse("FG"));
		System.out.println(instance.detectCapitalUse("F"));
		System.out.println(instance.detectCapitalUse("fG"));
		System.out.println(instance.detectCapitalUse("aaaaBCC"));
	}

	public boolean detectCapitalUse(String word) {
		char firstChar = word.charAt(0);
		boolean initCaps = firstChar >= 'A' && firstChar <= 'Z';
		int capsCount = initCaps ? 1 : 0;
//		int capsCount = initCaps ? 1 : 0;

		for (int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			boolean isCaps = c >= 'A' && c <= 'Z';
			if (!initCaps && isCaps) {
				return false;
			}

			if (isCaps) {
				capsCount++;
			}

			if (!isCaps && capsCount > 1) {
				return false;
			}

		}

		return capsCount > 1 ? capsCount == word.length() : true;

	}
}
