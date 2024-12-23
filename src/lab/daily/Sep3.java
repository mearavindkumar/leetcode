package lab.daily;

import java.util.HashSet;

public class Sep3 {

	public int numJewelsInStones(String jewels, String stones) {
		HashSet<Character> skip = new HashSet<>();
		int count = 0;
		for (int i = 0; i < stones.length(); i++) {
			char c = stones.charAt(i);

			if (skip.contains(c)) {
				continue;
			}

			if (jewels.contains(c + "")) {
				count++;
			} else {
				skip.add(c);
			}
		}
		return count;
	}
}
