package lab.daily;

public class Aug30 {

	public static void main(String[] args) {
		Aug30 instance = new Aug30();
		System.out.println(instance.getCommon(new int[] { 1, 2, 3, 6 }, new int[] { 2, 3, 4, 5 }));
	}

	public int getCommon(int[] nums1, int[] nums2) {
		int nums1Len = nums1.length;
		int nums2Len = nums2.length;
//		int[] lesserNum = nums1Len >= nums2Len ? nums2 : nums1;
//		int[] moreNum = nums1Len <= nums2Len ? nums2 : nums1;
		for (int num : nums1) {
			int val = binarySearch(nums2, num);
			if (val != -1) {
				return val;
			}
		}
		return -1;
	}

	private int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}

	private int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				return arr[mid];
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
