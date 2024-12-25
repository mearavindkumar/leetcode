package lab;

import java.util.Arrays;
import java.util.List;

import lab.base.TrieNode;

public class TrieNodeLearn {


	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		List<String> arr = Arrays.asList("and", "ant", "do", "geek", "dad", "ball");
		for (String s : arr) {
			TrieNode.insert(root, s);
		}

		// One by one search strings
		List<String> searchKeys = Arrays.asList("do", "ant", "an");
		for (String s : searchKeys) {
			System.out.println("Key : " + s);
			if (TrieNode.searchSubString(root, s))
				System.out.println("Present");
			else
				System.out.println("Not Present");
		}
	}
}
