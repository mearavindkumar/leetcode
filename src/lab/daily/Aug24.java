package lab.daily;

public class Aug24 {

	public static void main(String[] args) {
		Aug24 instance = new Aug24();

		System.out.println(instance.isHappy(19));
	}

	public boolean isHappy(int n) {
		int slow = n;
		int fast = n;
		do {
			slow = getSquare(slow);
			fast = getSquare(getSquare(fast));
		} while (slow != fast);
		return slow == 1;
	}

	private static int getSquare(int n) {
		int ans = 0;
		while (n > 0) {
			int remainder = n % 10;
			ans += (remainder * remainder);
			n /= 10;
		}
		return ans;
	}

}
