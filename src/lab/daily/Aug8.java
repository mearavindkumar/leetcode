package lab.daily;

public class Aug8 {
	public static void main(String[] args) {
		Aug8 instance = new Aug8();

	}

	public boolean canAliceWin(int[] nums) {
		int sum = 0;
		int doubleSum = 0;
		for (int num : nums) {
			if (num <= 9) {
				sum += num;
			} else {
				doubleSum += num;
			}
		}
		return sum != doubleSum;
	}
}
