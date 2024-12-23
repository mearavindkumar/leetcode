package lab.daily;

public class Aug2 {

	public static void main(String[] args) {
		Aug2 instance = new Aug2();

		System.out.println(instance.secondHighest("ck0"));

	}

	public int secondHighest(String s) {
		char[] aa = s.toCharArray();
		int[] cache = new int[10];
		for (char a : aa) {
			int idx = a - 48;
			if (idx < 10) {
				cache[idx]++;
			}
		}

		int i = 9;
		for (; i >= 0; i--) {
			if (cache[i] > 0) {
				i--;
				break;
			}
		}

		for (; i >= 0; i--) {
			if (cache[i] > 0) {
				return i;
			}
		}

		return -1;
	}
}
