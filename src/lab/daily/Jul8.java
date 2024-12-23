package lab.daily;

import java.util.HashSet;

public class Jul8 {

	public static void main(String[] args) {
		Jul8 instance = new Jul8();

		System.out.println(instance.firstUniqChar("leetcode"));
		System.out.println(instance.firstUniqChar("loveleetcode"));
		System.out.println(instance.firstUniqChar("aabb"));

	}

	public int firstUniqChar(String s) {
		int result = -1;

		HashSet<Character> cache = new HashSet<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (cache.contains(c)) {
				continue;
			}

			if (s.indexOf(c) == i && s.lastIndexOf(c) == i) {
				return i;
			}

			cache.add(c);

		}

		return result;
	}
}
