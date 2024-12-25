package lab.daily;

import java.util.HashMap;
import java.util.Map;

import lab.base.TrieNode;

public class Dec23 {

	public static void main(String[] args) {
		Dec23 instance = new Dec23();
//		System.out.println(instance.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		System.out.println(instance.countPrefixSuffixPairs(new String[] { "aba", "acaba" }));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		TrieNode root = new TrieNode();

		for (String str : strs) {
			TrieNode.insert(root, str);
		}

		return TrieNode.searchCommonSubString(root, strs[0], strs.length);
	}

	public int countPrefixSuffixPairs1(String[] words) {
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			String str1 = words[i];
			for (int j = i + 1; j < words.length; j++) {
				String str2 = words[j];
				if (str2.startsWith(str1) && str2.endsWith(str1)) {
					count++;
				}
			}
		}
		return count;
	}

	public int countPrefixSuffixPairs(String[] words) {
		int ans = 0;
		Node trie = new Node(-1);
		for (String s : words) {
			Node node = trie;
			int m = s.length();
			System.out.println("word::" + s + "---" + m);
			for (int i = 0; i < m; ++i) {
				int p = s.charAt(i) * 32 + s.charAt(m - i - 1);

				if (!node.children.containsKey(p)) {
					System.out.println("---");
					node.children.putIfAbsent(p, new Node(p));
				}



				node = node.children.get(p);

				ans += node.cnt;
				System.out.println(p + "---" + s.charAt(i) + "---" + s.charAt(m - i - 1) + "---" + i + "---"
						+ (m - i - 1) + "---" + node.cnt + "---" + (s.charAt(i) * 32) + "---" + (s.charAt(m - i - 1))
						+ "---" + node.cnt + "---" + ans);
			}
			System.out.println(node.p + "---" + (node.cnt + 1));
			++node.cnt;
		}
		return ans;
	}

	class Node {
		int p;
		Map<Integer, Node> children = new HashMap<>();
		int cnt;

		Node(int p) {
			this.p = p;
		}
	}


}
