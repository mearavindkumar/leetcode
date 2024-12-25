package lab.base;

import lab.daily.Dec24;

public class MagicDictionary {

	public static void main(String[] args) {
		Dec24 instance = new Dec24();
		MagicDictionary magicDictionary = new MagicDictionary();
		magicDictionary.buildDict(new String[] { "hello", "hallo", "leetcode", "judge" });
		System.out.println(magicDictionary.search("judge")); // return False
//		System.out.println(magicDictionary.search("hhlli"));
//		System.out.println(magicDictionary.search("hell"));
//		System.out.println(magicDictionary.search("leetcoded"));
//		System.out.println(magicDictionary.search("hellii"));
//		magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
//		magicDictionary.search("hell"); // return False
//		magicDictionary.search("leetcoded"); // return False

	}

	Node node;

	public MagicDictionary() {
		node = new Node();
	}

	public void buildDict(String[] dictionary) {
		for (String word : dictionary) {
			node.insert(word);
		}

	}

	public boolean search(String searchWord) {
		return node.search(searchWord);
	}

	class Node {
		Node[] nodes;
		boolean isEnd;

		Node() {
			nodes = new Node[26];
		}

		public void insert(String word) {
			Node current = this;
			for (char c : word.toCharArray()) {
				int idx = c - 'a';
				Node n = current.nodes[idx];
				if (n == null) {
					n = new Node();
					current.nodes[idx] = n;
				}
				current = n;

			}
			current.isEnd = true;
		}

		public boolean search(String searchWord) {
//			return node.search(searchWord, 0);
			return node.searchDFS(searchWord, 0, 0);
		}

		public boolean searchDFS(String searchWord, int idx, int missingCount) {
			if (idx == searchWord.length()) {
				return missingCount == 1 && this.isEnd;
			}
			char c = searchWord.charAt(idx);
			int nIdx = c - 'a';
			Node n = this.nodes[nIdx];
			System.out.println(c + " " + missingCount);
			if (n != null) {
				if (n.searchDFS(searchWord, idx + 1, missingCount)) {
					return true;
				}
			}
			if (missingCount == 0) {
				for (Node k : this.nodes) {
					if (k == null || k.equals(n)) {
						continue;
					}
					if (k.searchDFS(searchWord, idx + 1, 1)) {
						return true;
					}
				}
			}
			return false;
		}

		public boolean search(String searchWord, int missingCount) {
			Node current = this;
			for (int i = 0; i < searchWord.length(); i++) {
				char c = searchWord.charAt(i);
				int idx = c - 'a';
				Node n = current.nodes[idx];
				if (n == null) {
					if (missingCount == 1) {
						return false;
					}
					for (Node node : current.nodes) {
						if (node == null) {
							continue;
						}
						if (node.search(searchWord.substring(i + 1), 1)) {
							return true;
						}
					}
					return false;
				}
				current = n;

			}

			return missingCount == 1 && current.isEnd;
		}

	}
}