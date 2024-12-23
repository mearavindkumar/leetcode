package lab.daily;

public class Sep4 {

	public static void main(String[] args) {
		Sep4 instance = new Sep4();
		System.out.println(instance.checkDistances("abcabc",
				new int[] { 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
	}

	public boolean checkDistances1(String s, int[] distance) {
		int[] pos = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			int n = s.charAt(i) - 'a';
			if (pos[n] > 0 && distance[n] != i - pos[n]) {
				return false;
			}
			pos[n] = i + 1;
		}
		return true;
	}

	public boolean checkDistances(String s, int[] distance) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int idx = c - 'a';
			int cDistance = distance[idx];
			if (cDistance < 0) {
				continue;
			}
			int endIdx = s.lastIndexOf(c);
			if (endIdx - (i + 1) != cDistance) {
				return false;
			}
			distance[idx] = -1;
		}
		return true;
	}
}
