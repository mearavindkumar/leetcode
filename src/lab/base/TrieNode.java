package lab.base;

public class TrieNode {

	TrieNode[] nodes;

	boolean wordEnd;

	int count;

	public TrieNode() {
		nodes = new TrieNode[26];

		count = 0;

		wordEnd = false;
	}

	public boolean has(char c) {
		int idx = c - 'a';
		return nodes[idx] != null;

	}

	public TrieNode get(char c) {
		int idx = c - 'a';
		return nodes[idx];

	}

	public boolean isWordEnd() {
		return wordEnd;
	}

	public void insert(String key) {
		insert(this, key);
	}

	public static void insert(TrieNode root, String key) {
		TrieNode current = root;
		for (char c : key.toCharArray()) {
			int idx = c - 'a';
			TrieNode n = current.nodes[idx];
			if (n == null) {
				n = new TrieNode();
				current.nodes[idx] = n;
			}
			n.count++;
			current = n;
		}
		current.wordEnd = true;
	}

	public static boolean search(TrieNode root, String key) {
		TrieNode current = root;
		for (char c : key.toCharArray()) {
			int idx = c - 'a';
			if (current.nodes[idx] == null) {
				return false;
			}
			current = current.nodes[idx];
		}
		return current.wordEnd;
	}

	public static boolean searchSubString(TrieNode root, String key) {
		TrieNode current = root;
		for (char c : key.toCharArray()) {
			int idx = c - 'a';
			if (current.nodes[idx] == null) {
				return false;
			}
			current = current.nodes[idx];
		}
		return true;
	}

	public static String searchCommonSubString(TrieNode root, String key, int count) {
		TrieNode current = root;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			int idx = c - 'a';
			TrieNode n = current.nodes[idx];
			if (n != null && n.count == count) {
				current = n;
			} else {
				return key.substring(0, i);
			}
		}
		return key;
	}

}
