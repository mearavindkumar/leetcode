package lab.daily;

import java.util.Arrays;
import java.util.HashSet;

public class Aug31 {

	public static void main(String[] args) {
		Aug31 instance = new Aug31();
		System.out.println(-4 >>> 1);
		System.out.println(4 >>> 1);

		System.out.println(-4 >> 1);
		System.out.println(4 >> 1);
		System.out.println(instance.checkIfExist(new int[] { 7, 1, 14, 11 }));
	}

//	private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
//		int low = fromIndex;
//		int high = toIndex - 1;
//
//		while (low <= high) {
//			int mid = (low + high) >>> 1;
//			int midVal = a[mid];
//
//			if (midVal < key)
//				low = mid + 1;
//			else if (midVal > key)
//				high = mid - 1;
//			else
//				return mid; // key found
//		}
//		return -(low + 1); // key not found.
//	}

	public boolean checkIfExist(int[] arr) {
		HashSet<Integer> check = new HashSet<>();
		for (int num : arr) {
			int numMulTwo = num * 2;
			if (check.contains(numMulTwo) || (num % 2 == 0 && check.contains(num / 2))) {
				return true;
			}
			check.add(num);

			Arrays.binarySearch(arr, arr[0] * 2);
		}
		return false;
	}

//	1, 4, 11, 14

	private static int binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];
			if (midVal < key) {
				low = mid + 1;
			} else if (midVal > key) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -(low + 1);
	}
}
