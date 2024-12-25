package lab.base;

public class Trie {

	Trie[] nodes;
	boolean wordEnd;

	public Trie() {
		nodes = new Trie[26];
		wordEnd = false;
	}

	public boolean isWordEnd() {
		return wordEnd;
	}

	public void insert(String word) {
		Trie current = this;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			Trie n = current.nodes[idx];
			if (n == null) {
				n = new Trie();
				current.nodes[idx] = n;
			}
			current = n;

		}
		current.wordEnd = true;

	}

	public boolean search(String word) {
		Trie current = this;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			Trie n = current.nodes[idx];
			if (n == null) {
				return false;
			}
			current = n;
		}
		return current.wordEnd;
	}

	public boolean startsWith(String prefix) {
		Trie current = this;
		for (char c : prefix.toCharArray()) {
			int idx = c - 'a';
			Trie n = current.nodes[idx];
			if (n == null) {
				return false;
			}
			current = n;
		}
		return true;
	}

	public Trie getNode(char c) {
		int idx = c - 'a';
		return nodes[idx];
	}

}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
