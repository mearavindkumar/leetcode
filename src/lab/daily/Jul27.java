package lab.daily;

public class Jul27 {

	public static void main(String[] args) {
		Jul27 instance = new Jul27();
		System.out.println(instance.findNumbers(new int[] { 12, 345, 2, 6, 7896 }));

	}

	public int findNumbers(int[] nums) {
		int result = 0;
		for (int num : nums) {
			System.out.println(Math.log10(num));
			int count = 0;
			while (num > 0) {

				num = num / 10;
				count++;
			}
			if (count % 2 == 0) {
				result++;
			}
		}
		return result;
	}

}
