package lab.daily;

public class Jul26 {

	public static void main(String[] args) {
		Jul26 instance = new Jul26();
//		System.out.println(instance.)

	}

	public int subtractProductAndSum(int n) {
		Integer product = 1;
		Integer sum = 0;

		while (n > 0) {
			int remainder = n % 10;
			product *= remainder;
			sum += remainder;
			n = n / 10;
		}

		return product - sum;

	}

}
