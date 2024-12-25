package lab.base;

public class WordDictionary {

	WordDictionary[] nodes;
	boolean isWordEnd;

    public WordDictionary() {
		nodes = new WordDictionary[26];
		isWordEnd = false;
    }
    
    public void addWord(String word) {
		WordDictionary current = this;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			WordDictionary node = current.nodes[idx];
			if (node == null) {
				node = new WordDictionary();
				current.nodes[idx] = node;
			}
			current = node;
		}
		current.isWordEnd = true;
    }
    
    public boolean search(String word) {
		WordDictionary current = this;
		int i = 0;
		for (char c : word.toCharArray()) {
			if (c == '.') {
				for (WordDictionary node : current.nodes) {
					if (node != null && node.search(word.substring(i + 1))) {
						return true;
					}
				}
				return false;
			}
			int idx = c - 'a';
			WordDictionary node = current.nodes[idx];
			if (node == null) {
				return false;
			}
			current = node;
			i++;
		}
		return current.isWordEnd;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */