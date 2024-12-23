package lab.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import lab.base.ListNode;

public class Aug9 {

//	[1,2,3,4,5]

	public static void main(String[] args) {
		Aug9 instance = new Aug9();
//		instance.resultArray(new int[] { 5, 4, 3, 8 });

		System.out.println(instance.countPairs(new int[] { 3, 1, 2, 2, 2, 1, 3 }, 2));
	}

	public int countPairs(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j] && ((i * j) % k) == 0) {
					count++;
				}
			}
		}
		return count;
	}

	public int countKDifferenceO(int[] nums, int k) {
		final int kMax = 100;
		int ans = 0;
		int[] count = new int[kMax + 1];

		for (final int num : nums)
			++count[num];

		for (int i = k + 1; i <= kMax; ++i)
			ans += count[i] * count[i - k];

		return ans;
	}

	public int countKDifference(int[] nums, int k) {
		int count = 0;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (Math.abs(nums[i] - nums[j]) == k) {
					count++;
				}
			}
		}
		return count;
	}

	public int distinctAverages(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		int length = nums.length;
		int i = 0;
		int j = length - 1;
		Arrays.sort(nums);
		while (i < j) {
			int num = nums[i++] + nums[j--];
			set.add(num);
		}
		return set.size();
	}

	public double minimumAverage(int[] nums) {
		int length = nums.length;
		int i = 0;
		int j = length - 1;
		Arrays.sort(nums);
		int sum = Integer.MAX_VALUE;
		while (i < j) {
			int num = nums[i++] + nums[j--];
			sum = num < sum ? num : sum;
		}
		return sum / 2.0;
	}

	public String[] uncommonFromSentences(String s1, String s2) {
		String[] words1 = s1.split(" ");
		String[] words2 = s2.split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words1) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		for (String word : words2) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		return map.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey)
				.toArray(String[]::new);
	}

	public int countWords(String[] words1, String[] words2) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words1) {
			if (map.containsKey(word)) {
				map.put(word, -1);
			} else {
				map.put(word, 1);
			}

		}
		for (String word : words2) {
			if (map.containsKey(word)) {
				Integer count = map.get(word);
				if (count == -1) {
					continue;
				}
				map.put(word, count + 1);
			}
		}
		return (int) map.values().stream().filter(value -> value == 2).count();
	}

	public String getEncryptedString(String s, int k) {
		int len = s.length();
		char[] result = new char[len];
		for (int i = 0; i < len; i++) {
			int idx = (i + k) % len;
			result[i] = s.charAt(idx);
		}
		return String.valueOf(result);
	}

	public String greatestLetter(String s) {
		for (int i = 'z'; i >= 'a'; i--) {
			String lower = String.valueOf(((char) (i)));
			String upper = String.valueOf((char) (i - 32));
			if (s.contains(lower) && s.contains(upper)) {
				return upper;
			}
		}

		return "";
	}

	public String greatestLetterOpt(String s) {
		int[] cache = new int[26];
		int max = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			int idx = (c | 32) - 'a';
			if (cache[idx] == -1) {
				continue;
			}
			int lowerCaseVal = (c | 32);
			int upperCaseVal = (c & ~32);
			int actualVal = c;
			if (cache[idx] == 0 || cache[idx] == actualVal) {
				cache[idx] = actualVal;
				continue;
			}
			if (cache[idx] == lowerCaseVal && actualVal == upperCaseVal) {
				if (upperCaseVal > max) {
					max = upperCaseVal;
				}
				cache[idx] = -1;
			} else if (cache[idx] == upperCaseVal && actualVal == lowerCaseVal) {
				if (upperCaseVal > max) {
					max = upperCaseVal;
				}
				cache[idx] = -1;
			}
		}
		return max == -1 ? "" : ((char) max) + "";
	}

	public boolean isSubstringPresent(String s) {
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i == 0) {
				return false;
			}
			String sub = s.charAt(i) + "" + s.charAt(i - 1);
			if (s.contains(sub)) {
				return true;
			}
		}
		return false;
	}

	public int sumOfEncryptedInt(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			if (num <= 9) {
				sum += num;
			} else {
				int max = 1;
				int product = 0;
				while (num > 0) {
					int remainder = num % 10;
					product = product * 10 + 1;
					num = num / 10;
					if (remainder > max) {
						max = remainder;
					}
				}
				sum += (product * max);
			}
		}
		return sum;
	}

	public int minimumBoxes(int[] apple, int[] capacity) {
		int sum = 0;
		int max = -1;
		int min = 51;
		int[] cache = new int[51];
		for (int num : apple) {
			sum += num;
		}
		for (int num : capacity) {
			cache[num]++;
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}
		int count = 0;
		for (int i = max; i >= min; i--) {
			int boxes = cache[i];
			while (boxes-- > 0) {
				sum = sum - i;
				count++;
				if (sum <= 0) {
					return count;
				}
			}
		}
		return -1;
	}

	public int[] resultArray(int[] nums) {
		int length = nums.length;
		int[] arr1 = new int[length];
		int[] arr2 = new int[length];
		arr1[0] = nums[0];
		arr2[0] = nums[1];
		int arr1Count = 0;
		int arr2Count = 0;
		for (int i = 2; i < nums.length; i++) {
			int num = nums[i];
			if (arr1[arr1Count] > arr2[arr2Count]) {
				arr1[++arr1Count] = num;
			} else {
				arr2[++arr2Count] = num;
			}
		}
		int[] result = new int[length];
		System.arraycopy(arr1, 0, result, 0, arr1Count + 1);
		System.arraycopy(arr2, 0, result, arr1Count + 1, arr2Count + 1);

		return result;
	}

	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null) {
			slow = slow.next;
			ListNode temp = fast.next;
			fast = temp != null ? temp.next : temp;
		}
		return slow;
	}

	public ListNode deleteMiddle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode preSlow = null;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null) {
			preSlow = slow;
			slow = slow.next;
			ListNode temp = fast.next;
			fast = temp != null ? temp.next : temp;
		}
		preSlow.next = slow.next;

		return head;
	}

	public void testing() {
//		ListNode root = new ListNode(1,
//		new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

//root = new ListNode(1);

//ListNode pRoot = root;
//
//while (pRoot != null) {
//	System.out.print(pRoot.val);
//	pRoot = pRoot.next;
//}
//
//ListNode mroot = instance.middleNode(root);
//ListNode droot = instance.deleteMiddle(root);
//
//System.out.println("");
//while (mroot != null) {
//	System.out.print(mroot.val);
//	mroot = mroot.next;
//}
//System.out.println("");
//while (droot != null) {
//	System.out.print(droot.val);
//	droot = droot.next;
//}
	}

}
