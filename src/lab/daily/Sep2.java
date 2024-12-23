package lab.daily;

public class Sep2 {

	public int findMiddleIndex(int[] nums) {
		int totalSum = 0;
		int len = nums.length;
		int[] cache = new int[len];
		cache[0] = 0;
		totalSum = nums[0];
		for (int i = 1; i < len; i++) {
			cache[i] = cache[i - 1] + nums[i - 1];
			totalSum += nums[i];
		}

		for (int i = 0; i < len; i++) {
			if (cache[i] == (totalSum - nums[i] - cache[i])) {
				return i;
			}
		}
		return -1;

	}

	public int pivotIndex(int[] nums) {
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum = totalSum - nums[i];
			if (totalSum == sum) {
				return i;
			}
			sum += nums[i];
		}

		return -1;
	}

}
