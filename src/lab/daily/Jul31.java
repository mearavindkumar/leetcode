package lab.daily;

public class Jul31 {

	public static void main(String[] args) {
		Jul31 instance = new Jul31();

		System.out.println(instance.countOdds(8, 10));
		System.out.println(instance.countOdds(3, 7));
		System.out.println(instance.countOdds(1, 10));
	}

	public int countOdds(int low, int high) {
		int result = 0;
		if (low % 2 == 1) {
			low++;
			result++;
		}

		if (high % 2 == 1) {
			high--;
			result++;
		}
		return result + (high - low) / 2;
	}

}
