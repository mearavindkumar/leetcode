package lab.daily;

public class Jul16 {

	public static void main(String[] args) {
		Jul16 instance = new Jul16();
		System.out.println(instance.canConstruct1("a", "aa"));
	}

	public boolean canConstruct(String ransomNote, String magazine) {

		int[] cache = new int[26];

		for (int i = 0; i < magazine.length(); i++) {
			char c = magazine.charAt(i);
			cache[c - 'a']++;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			int count = --cache[c - 'a'];
			if (count < 0) {
				return false;
			}
		}

		return true;

	}

	public boolean canConstruct1(String ransomNote, String magazine) {
		int[] a = new int[26];
		for (char c : ransomNote.toCharArray()) {
			int idx = a[c % 26];
			int i = magazine.indexOf(c, a[c % 26]);
			if (i == -1)
				return false;
			a[c % 26] = i + 1;
		}
		return true;

	}

}
