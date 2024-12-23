package lab.daily;

import java.util.HashMap;

public class FindSumPairs {

//	["FindSumPairs","count","add","count","count","add","add","count"]
//	[              ,[7]    ,[3,2], [8]   ,[4]    ,[0,1],[1,1],[7]]

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 1, 2, 2, 2, 3 };
		int[] nums2 = new int[] { 1, 4, 5, 2, 5, 4 };
		FindSumPairs f = new FindSumPairs(nums1, nums2);
		System.out.println(f.count(7));
		f.add(3, 2);
		System.out.println(f.count(8));
		System.out.println(f.count(4));
	}

	int[] nums1;
	int[] nums2;
	HashMap<Integer, Integer> nums2Cache = new HashMap<Integer, Integer>();

	public FindSumPairs(int[] nums1, int[] nums2) {
		this.nums1 = nums1;
		this.nums2 = nums2;
		for (int num : nums2) {
			nums2Cache.put(num, nums2Cache.getOrDefault(num, 0) + 1);
		}
	}

	public void add(int index, int val) {
		int key = nums2[index];
		nums2Cache.put(key, nums2Cache.getOrDefault(key, 0) - 1);
		nums2[index] += val;
		nums2Cache.put(nums2[index], nums2Cache.getOrDefault(nums2[index], 0) + 1);
	}

	public int count(int tot) {
		int count = 0;
		for (int num : nums1) {
			int remainder = tot - num;

			count += nums2Cache.getOrDefault(remainder, 0);
		}
		return count;
	}
}
