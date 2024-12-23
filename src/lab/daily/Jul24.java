package lab.daily;

public class Jul24 {

	public static void main(String[] args) {
		Jul24 instance = new Jul24();
//		System.out.println(instance.)

	}

	public int dominantIndex(int[] nums) {
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (max < num) {
				maxIdx = i;
				max = num;
			}
		}

		for (int num : nums) {
			if (num != max && (num * 2) > max) {
				return -1;
			}
		}
		return maxIdx;
	}
}
