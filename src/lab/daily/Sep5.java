package lab.daily;

public class Sep5 {

//	https://leetcode.com/problems/reverse-string-ii/submissions/1380249271/

	public void reverse(char[] str, int start, int end) {
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}

	public String reverseStr(String s, int k) {

		char[] arr = s.toCharArray();
		int n = arr.length;
		int i = 0;
		while (i < n) {
			int j = Math.min(i + k - 1, n - 1);
			reverse(arr, i, j);
			i += 2 * k;
		}
		return new String(arr);
	}


}
