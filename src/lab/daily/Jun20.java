package lab.daily;

import java.util.HashMap;

public class Jun20 {
//	static double area;
//	int b = 3, h = 3;

//	String myStr = "9090";

//	int num;tif

	static float height;

	public float j(long x) {
		System.out.println("jump1");
		return height + x;
	}

	public static void main(String[] args) {
		Jun20 j = new Jun20();
		System.out.println(j.j(10));

//		new MyString();
	}

	public static int majorityElement1(int[] nums) {
		return recursivemaj(nums, 0, nums[0]);
	}

	public static int recursivemaj(int[] nums, int start, int value) {
		int count = 0;
		for (int i = start; i < nums.length; i++) {
			if (nums[i] == value) {
				count++;
			} else {
				count--;
			}
			if (count == -1) {
				return recursivemaj(nums, i, nums[i]);
			}
		}
		return value;
	}

	public static int majorityElement(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		int compareNum = nums.length / 2;
		int maxNumber = -1;
		int maxOccurence = -1;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (map.containsKey(num)) {
				int sum = map.get(num) + 1;
				if (sum > compareNum && sum > maxOccurence) {
					maxNumber = num;
					maxOccurence = sum;
				}
				map.put(num, sum);
			} else {
				map.put(num, 1);
			}
		}
		return maxNumber;
	}
}
