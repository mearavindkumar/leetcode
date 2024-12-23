package lab.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aug1 {

	public static void main(String[] args) {
		Aug1 instance = new Aug1();
//		System.out.println(instance.countConsistentStrings("ab", new String[] { "ad", "bd", "aaab", "baa", "badab" }));
//		System.out.println((char) ('T' | 32));
//
//		System.out.println(instance.halvesAreAlike("book"));
//		System.out.println(instance.halvesAreAlike("textbook"));
//
//		System.out.println(instance.halvesAreAlike("teitbook"));
//
//		System.out.println(instance.sumOfUnique(new int[] { 1, 2, 3, 2, 1, 3 }));
//
		System.out.println(('a' & 'z') - ('z' & 'd'));

		System.out.println(instance.areAlmostEqual(
				"xkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkx",
				"fkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkf"));
		System.out.println(instance.areAlmostEqual("aa", "ab"));
		System.out.println(instance.areAlmostEqual("aa", "bb"));
		System.out.println(instance.areAlmostEqual("ba", "ba"));
		System.out.println(instance.areAlmostEqual("az", "zd"));

	}

	public int countConsistentStrings(String allowed, String[] words) {
		int result = 0;
		int[] alphabets = new int[26];

		for (int i = 0; i < allowed.length(); i++) {
			alphabets[allowed.charAt(i) - 'a']++;
		}

		for (String word : words) {
			boolean consistent = true;
			for (int i = 0; i < word.length(); i++) {
				if (alphabets[word.charAt(i) - 'a'] == 0) {
					consistent = false;
					break;
				}
			}

			if (consistent) {
				result++;
			}
		}

		return result;
	}

	public boolean halvesAreAlike(String s) {
		int length = s.length();
		int iCount = 0;
		int jCount = 0;
		for (int i = 0, j = length / 2; i < length / 2; i++, j++) {
			char iC = (char) (s.charAt(i) | 32);
			char jC = (char) (s.charAt(j) | 32);
			if (iC == 'a' || iC == 'e' || iC == 'i' || iC == 'o' || iC == 'u') {
				iCount++;
			}

			if (jC == 'a' || jC == 'e' || jC == 'i' || jC == 'o' || jC == 'u') {
				jCount++;
			}
		}
		return iCount == jCount;
	}

	public int sumOfUnique(int[] nums) {
		HashMap<Integer, Integer> cache = new HashMap<>();
		for (int num : nums) {
			if (cache.containsKey(num)) {
				cache.put(num, 2);
			} else {
				cache.put(num, 1);
			}
		}

		return cache.entrySet().stream().filter(entry -> entry.getValue() == 1).mapToInt(entry -> entry.getKey()).sum();
	}

	public boolean areAlmostEqual(String s1, String s2) {
		if (s1.equals(s2)) {
			return true;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				list.add(i);
			}
		}
		return list.size() == 2 && s1.charAt(list.get(0)) == s2.charAt(list.get(1))
				&& s2.charAt(list.get(0)) == s1.charAt(list.get(1));

	}
}
