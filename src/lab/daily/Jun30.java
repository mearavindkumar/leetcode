package lab.daily;

public class Jun30 {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE == -2147483648);
		System.out.println(thirdMax(new int[] { 2, 2, 3, 1 }));
	}

	public static int thirdMax(int[] nums) {
		Integer firstMax = null;
		Integer secondMax = null;
		Integer thirdMax = null;
		for (int i = 0; i < nums.length; i++) {
			Integer num = nums[i];
			if (num.equals(firstMax) || num.equals(secondMax) || num.equals(thirdMax)) {
				continue;
			}
			if (firstMax == null || num > firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = num;

			} else if (secondMax == null || num > secondMax) {
				thirdMax = secondMax;
				secondMax = num;
			} else if (thirdMax == null || num > thirdMax) {
				thirdMax = num;
			}
		}
		return (thirdMax == null) ? firstMax : thirdMax;
	}

}
