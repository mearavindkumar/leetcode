package lab.daily;

public class Aug22 {

	public static void main(String[] args) {
		Aug22 instance = new Aug22();

		System.out.println(instance.maxDepth("(()(())((()())))"));
	}

	public int maxDepth(String s) {
		int maxCount = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
				count++;
				break;
			case ')':
				if (count > maxCount) {
					maxCount = count;
				}
				count--;
				break;
			default:
				break;
			}
		}

		return maxCount;
	}
}
