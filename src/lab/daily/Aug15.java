package lab.daily;

public class Aug15 {

	public static void main(String[] args) {
		Aug15 instance = new Aug15();
//		instance.resultArray(new int[] { 5, 4, 3, 8 });

//		System.out.println(instance.frequencySort(new int[] { 1, 5, 0, 5 }));
	}

	public boolean checkRecord(String s) {
		int absent = 0;
		int lateCount = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'L') {
				lateCount++;
				if (lateCount >= 3) {
					return false;
				}
			} else if (c == 'A') {
				lateCount = 0;
				absent++;
				if (absent >= 2) {
					return false;
				}
			} else {
				lateCount = 0;
			}

		}
		return true;

	}
}
