package lab.daily;

import java.util.HashMap;

public class Aug16 {

	public static void main(String[] args) {
		Aug16 instance = new Aug16();
		System.out.println(instance.isIsomorphic("badc", "baba"));
	}

	public boolean isIsomorphic(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		if (sLen != tLen) {
			return false;
		}
		HashMap<String, String> cache = new HashMap<>();
		HashMap<String, String> reverseCache = new HashMap<>();
		for (int i = 0; i < sLen; i++) {
			String sChar = s.charAt(i) + "";
			String tChar = t.charAt(i) + "";
			if (cache.containsKey(sChar)) {
				if (!cache.get(sChar).equals(tChar)) {
					return false;
				}
			} else {
				if (reverseCache.containsKey(tChar)) {
					return false;
				}
				cache.put(sChar, tChar);
				reverseCache.put(tChar, sChar);
			}

		}
		return true;
	}

}
