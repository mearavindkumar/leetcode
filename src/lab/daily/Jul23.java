package lab.daily;

import java.util.Arrays;
import java.util.Iterator;

public class Jul23 {

	public static void main(String[] args) {
		Jul23 instance = new Jul23();
		System.out.println(instance.capitalizeTitle("capiTalIze tHe titLe"));
		System.out.println(instance.capitalizeTitle("First leTTeR of EACH Word"));
		System.out.println(instance.capitalizeTitle("i lOve leetcode"));

		System.out.println((char) ('a' | 32));
		System.out.println((char) ('A' | 32));

		System.out.println((char) ('a' & ~32));
		System.out.println((char) ('A' & ~32));

	}

//	You are given a string title consisting of one or more words separated by a single space, where each word consists of English letters. Capitalize the string by changing the capitalization of each word such that:
//
//		If the length of the word is 1 or 2 letters, change all letters to lowercase.
//		Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
//		Return the capitalized title.

	public String capitalizeTitleOpt(String title) {

		StringBuilder builder = new StringBuilder();
		Iterator<String> ite = Arrays.asList(title.split(" ")).iterator();

		while (ite.hasNext()) {
			String token = ite.next();
			if (token.length() <= 2) {
				builder.append(token.toLowerCase());

			} else {
				builder.append((char) (token.charAt(0) & ~32)).append(token.substring(1, token.length()).toLowerCase());
			}

			if (ite.hasNext()) {
				builder.append(" ");
			}

		}

		return builder.toString();

	}

	public String capitalizeTitle(String title) {
		return null;
		

//		char[] str = title.toCharArray();
//		int beginningIdx = 0;
//		int curLength = 0;
//		
//		for (int i = 0; i < str.length(); i++) {
//			char c = title.charAt(0);
//			if(c == ' ') {
//				if(curLength <= 0) {
//					str[beginningIdx] |= 32;
//				}
//				
//				beginningIdx = i + 1;
//				curLength = 0;
//			} else {
//				curLength++;
//			}
//			
//		}
//
//		return title;

	}
}
