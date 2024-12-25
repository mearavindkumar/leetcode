package lab.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lab.base.MagicDictionary;
import lab.base.Trie;
import lab.base.TrieNode;

public class Dec24 {

	/**
	 * Your Trie object will be instantiated and called as such: Trie obj = new
	 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
	 * = obj.startsWith(prefix);
	 */


	public static void main(String[] args) {
		Dec24 instance = new Dec24();
		MagicDictionary magicDictionary = new MagicDictionary();
		magicDictionary.buildDict(new String[] { "hello", "leetcode" });
		System.out.println(magicDictionary.search("hello")); // return False
		magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
		magicDictionary.search("hell"); // return False
		magicDictionary.search("leetcoded"); // return False

	}

//	i miszkays w gvcfldkiavww v dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dc k w ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy i mengfdydekwttkhbzenk w h ldipovluo a nusquzpmnogtjkklfhta k nxzgnrveghc mpppfhzjkbucv c uwmahhqradjtf i z q yzfragcextvx i i j gzixfeugj rnukjgtjpim h a x h ygelddphxnbh rvjxtlqfnlmwdoezh z i bbfj mhs nenrqfkbf spfpazr w c dtd c dtaxhddidfwqs bgnnoxgyynol h dijhrrpnwjlju muzzrrsypzgwvblf z h q i daee  nlipyfszvxlwqw yoq dewpgtcrzausqwhh q i k bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala q gyvukjpc  mxhlkdaycskj uvwmerplaibeknltuvd ocnn f c pxbd oklwhcppuziixpvihihp
//	i miszkays w gvcfldkiavww v dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dc k w ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy i mengfdydekwttkhbzenk w h ldipovluo a nusquzpmnogtjkklfhta k nxzgnrveghc mpppfhzjkbucv c uwmahhqradjtf i z q yzfragcextvx i i j gzixfeugj rnukjgtjpim h a x h ygelddphxnbh rvjxtlqfnlmwdoezh z i bbfj mhs nenrqfkbf spfpazr w c dtd c dtaxhddidfwqs bgnnoxgyynol h dijhrrpnwjlju muzzrrsypzgwvblf z h q i daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh q i k bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala q gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn f c pxbd oklwhcppuziixpvihihp

	public void lexicalOrder(List<Integer> result, int n, int num) {
		for (int i = 0; i <= 9; i++) {
			int cur = num * 10 + i;
			if (cur == 0) {
				continue;
			}
			if (cur > n) {
				return;
			}
			result.add(cur);
			lexicalOrder(result, n, cur);
		}
	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<Integer>();
		int no = 1;
		for (int i = 0; i < n; i++) {
			result.add(no);
			if (no * 10 <= n) {
				no = no * 10;
			} else {
				while (no % 10 == 9 || (no + 1) > n) {
					no = no / 10;
				}
				no++;
			}
		}

		return result;
	}

	public boolean wordBreakTrie(String s, List<String> wordDict) {

		TrieNode root = new TrieNode();

		for (String w : wordDict) {
			TrieNode.insert(root, w);
		}

		int n = s.length();

		boolean[] dp = new boolean[n + 1];
		dp[0] = true;


		for (int i = 0; i < n; i++) {
			if (!dp[i]) {
				continue;
			}
			TrieNode current = root;

			for (int j = i; j < n; j++) {
				char c = s.charAt(j);

				TrieNode node = current.get(c);
				if (node == null) {
					break;
				}
				if (node.isWordEnd()) {
					dp[j + 1] = true;
				}
				current = node;
			}
		}


		return dp[n];

	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> words = new HashSet<>(wordDict);
		int n = s.length();
		boolean[] f = new boolean[n + 1];
		f[0] = true;
		for(int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && words.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[n];

	}

	public boolean wordBreakRef(String s, List<String> wordDict) {
		Set<String> words = new HashSet<>(wordDict);
		int n = s.length();
		boolean[] f = new boolean[n + 1];
		f[0] = true;
		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j < i; ++j) {
				System.out.println(s.substring(j, i) + "---" + i + "---" + j);
				if (f[j] && words.contains(s.substring(j, i))) {
					System.out.println("valid " + s.substring(j, i) + "---" + i + "---" + j);
					f[i] = true;
					break;
				}
			}
			System.out.println("****************************");
		}
		return f[n];
	}

	public String replaceWords(List<String> dictionary, String sentence) {
		StringBuilder output = new StringBuilder();

		Trie node = new Trie();

		for (String word : dictionary) {
			node.insert(word);
		}

		String[] words = sentence.split(" ");

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int idx = 0;
			Trie current = node;

			for (char c : word.toCharArray()) {
				Trie n = current.getNode(c);

				if (n == null || n.isWordEnd()) {
					output.append(n == null ? word : word.substring(0, idx + 1));
					break;
				}
				current = n;
				idx++;
			}

			if (idx >= word.length()) {
				output.append(word);
			}

			if (i < words.length - 1) {
				output.append(" ");
			}

		}

		return output.toString();
	}

}
