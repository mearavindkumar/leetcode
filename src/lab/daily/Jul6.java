package lab.daily;

public class Jul6 {

	public static void main(String[] args) {
		Jul6 instance = new Jul6();

		int[] nums = new int[] { 0, 1, 0, 2, 3, 0, 4 };

		instance.moveZeroes(nums);

		for (int i : nums) {
			System.out.println(i);
		}

	}

	public void moveZeroes(int[] nums) {
		int zeroIndex = 0;

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num != 0) {
				nums[i] = 0;
				nums[zeroIndex++] = num;
			}

		}
	}

}
