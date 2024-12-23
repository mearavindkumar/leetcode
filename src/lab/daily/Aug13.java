package lab.daily;

public class Aug13 {

	public static void main(String[] args) {
		Aug13 instance = new Aug13();
		System.out.println(instance.countPrefixes(new String[] { "a", "b", "c", "ab", "bc", "abc" }, "abc"));
	}

	public int countPrefixes(String[] words, String s) {
		int count = 0;
		for (String word : words) {
			if (s.startsWith(word)) {
				count++;
			}
		}
		return count;
	}
}
