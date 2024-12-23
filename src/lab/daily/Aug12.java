package lab.daily;

public class Aug12 {

	public static void main(String[] args) {
		Aug12 instance = new Aug12();
//		System.out.println(instance.prefixCount("Hello how are you Contestant", 4));
	}

	public int prefixCount(String[] words, String pref) {
		int count = 0;
		for (String word : words) {
			if (word.startsWith(pref)) {
				count++;
			}
		}
		return count;
	}
}
