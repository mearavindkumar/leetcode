package lab.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import lab.base.ListNode;

public class Aug7 {

	public static void main(String[] args) {
		Aug7 instance = new Aug7();
		ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		root = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, new ListNode(2))))));

		root = instance.modifiedList(new int[] { 1 }, root);

		while (root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}

//		ArrayList<Integer> a = new ArrayList<>();
//		a.add(1);
//		a.add(2);
//		ListIterator<Integer> a1 = (ListIterator<Integer>) a.iterator();
//		System.out.println(a1.next());
//		System.out.println(a1.previous());
	}

//	1 -> 2 -> 3->4->5
//	1->2->1->2->1->2
	public ListNode modifiedListOpt(int[] nums, ListNode head) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cursor = dummy;
		while (head != null) {
			int val = head.val;
			if (set.contains(val)) {
				cursor.next = head.next;
				head = head.next;
				continue;
			}
			cursor.next = head;
			cursor = head;
			head = head.next;
		}
		return dummy.next;

	}

	public ListNode modifiedList(int[] nums, ListNode head) {
		   if(head==null || nums.length==0)
	        {
	            return head;
	        }
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		ListNode dummy = new ListNode(-1);
		ListNode cursor = dummy;
		while (head != null) {
			int val = head.val;
			if (set.contains(val)) {
				head = head.next;
				continue;
			}
			cursor.next = new ListNode(val);
			cursor = cursor.next;
			head = head.next;
		}
		return dummy.next;

	}

//	Input: pattern = "abba", s = "dog cat cat dog"
//			Output: true

	public boolean wordPattern(String pattern, String s) {
		char[] cArray = pattern.toCharArray();
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, String> reverseMap = new HashMap<>();
		String[] words = s.split(" ");
		if (cArray.length != words.length) {
			return false;
		}
		for (int i = 0; i < cArray.length; i++) {
			String p = cArray[i] + "";
			String word = words[i];
			if (map.containsKey(p)) {
				String sP = map.get(p);
				if (!sP.equals(word)) {
					return false;
				}
			} else {
				if (reverseMap.containsKey(word)) {
					return false;
				}
				map.put(p, word);
				reverseMap.put(word, p);
			}
		}
		return true;
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] cArray = s.toCharArray();
		int[] cache = new int[26];
		for (char c : cArray) {
			cache[c - 'a']++;
		}
		cArray = t.toCharArray();
		for (char c : cArray) {
			int idx = c - 'a';
			cache[idx]--;
			if (cache[idx] < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindrome(String s) {

		char[] cArray = s.toCharArray();
		int start = 0;
		int end = cArray.length - 1;
		while (start <= end) {
			char startC = (char) (cArray[start] | 32);
			char endC = (char) (cArray[end] | 32);
			if (!((startC >= 'a' && startC <= 'z') || (startC >= '0' && startC <= '9'))) {
				start++;
			} else if (!((endC >= 'a' && endC <= 'z') || (endC >= '0' && endC <= '9'))) {
				end--;
			} else {
				if ((startC) != (endC)) {
					return false;
				}
				start++;
				end--;
			}

		}
		return true;

//		StringBuilder builder = new StringBuilder();
//
//		for (char c : s.toCharArray()) {
//			if (Character.isLetterOrDigit(c)) {
//				builder.append(Character.toLowerCase(c));
//			}
//		}
//
//		return builder.toString().equals(builder.reverse().toString());
	}

	public String multiply(String num1, String num2) {
		char[] c1Array = num1.toCharArray();
		int c1num = 0;
		for (char c : c1Array) {
			int i = c - '0';
			c1num = c1num * 10 + i;
		}

		char[] c2Array = num2.toCharArray();
		int c2num = 0;
		for (char c : c2Array) {
			int i = c - '0';
			c2num = c2num * 10 + i;
		}
		return (c1num * c2num) + "";
	}

	public String largestGoodInteger(String num) {
		for (int i = 9; i >= 0; i--) {
			String n = i == 0 ? "000" : (i * 111) + "";
			if (num.contains(n)) {
				return n;
			}
		}
		return "";
	}

	public String largestOddNumber(String num) {
//		char[] cArray = num.toCharArray();
		for (int i = num.length() - 1; i >= 0; i--) {
			int n = num.charAt(i) - '0';
			if (n % 2 != 0) {
				return num.substring(0, i + 1);
			}
		}
		return "";
	}

	public int mostFrequentEven(int[] nums) {
		HashSet<Integer> cacheVals = new HashSet<>();
		int[] cache = new int[100001];
		for (int num : nums) {
			cache[num]++;
			cacheVals.add(num);
		}
		int max = -1;
		int idx = -1;
		Iterator<Integer> ite = cacheVals.iterator();
		while (ite.hasNext()) {
			int i = ite.next();
			if (i % 2 != 0) {
				continue;
			}
			if (cache[i] > max) {
				max = cache[i];
				idx = i;
			}
			if (cache[i] == max) {
				idx = idx > i ? i : idx;
			}
		}
		return idx;
	}

//	public String frequencySort(String s) {
//		
//	}
}
