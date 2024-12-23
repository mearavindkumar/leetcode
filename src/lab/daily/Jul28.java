package lab.daily;

public class Jul28 {

	public static void main(String[] args) {
		Jul28 instance = new Jul28();
		System.out.println();

		for (int i : instance.runningSum(new int[] { 1000000, 1000000, 1000000, 1000000, 1000000 })) {
			System.out.println(i);
		}

	}

	public int[] runningSum(int[] nums) {

		int[] result = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			result[i] = sum;
		}

		return result;

	}
}
