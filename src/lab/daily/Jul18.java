package lab.daily;

public class Jul18 {

	public static void main(String[] args) {
		Jul18 instance = new Jul18();
		System.out.println(instance.reverseWords("ab ba aabb a ") + "e");
	}

	public String reverseWords(String s) {

		StringBuilder builder = new StringBuilder();
		String[] c = s.split(" ");
		int count = 0;
		for (String str : c) {
			StringBuilder b = new StringBuilder(str);
			builder.append(b.reverse()).append(count < c.length - 1 ? " " : "");
			count++;
		}

		return builder.toString();
	}
}
