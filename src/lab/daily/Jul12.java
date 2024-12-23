package lab.daily;

public class Jul12 {

	public static void main(String[] args) {
		Jul12 instance = new Jul12();
		String input = " a  b   ";
		System.out.println(instance.countSegments(input));
	}

	public int countSegments(String s) {
		return s.trim().length() == 0 ? 0 : s.trim().split("\\s+").length;
//		if (s == null || s.isEmpty()) {
//			return 0;
//		}
//		StringTokenizer st = new StringTokenizer(s);
//		return st.countTokens();
//		return s.split(" ").length;
	}
}
