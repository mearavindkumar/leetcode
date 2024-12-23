package lab.daily;

public class Jul11 {

	int GUESS = 8;

	public static void main(String[] args) {
		Jul11 instance = new Jul11();
		System.out.println(instance.guessNumber(10));
	}

	public int guessNumber(int n) {
		int low = 0;
		int high = n;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			int guess = guess(mid);
			if (guess == 0) {
				return mid;
			}
			if (guess == -1) {
				high = mid - 1;
			}
			if (guess(mid) == 1) {
				low = mid + 1;
			}
		}

		return -1;


    }

	public int guessNumber(int start, int end) {
		int mid = start + ((end - start) / 2);
		int guess = guess(mid);
		if (guess == 0) {
			return mid;
		}
		if (guess == -1) {
			return guessNumber(start, mid - 1);
		}
		if (guess == 1) {
			return guessNumber(mid + 1, end);
		}
		return -1;

	}


	int guess(int n) {
		if (n == GUESS) {
			return 0;
		}
		if (n > GUESS) {
			return -1;
		}
		return 1;

	}
}
