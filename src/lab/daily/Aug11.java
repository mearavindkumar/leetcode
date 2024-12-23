package lab.daily;

public class Aug11 {

	public static void main(String[] args) {
		Aug11 instance = new Aug11();
		System.out.println(instance.truncateSentence("Hello how are you Contestant", 4));
	}

	public String truncateSentence(String s, int k) {
		String[] words = s.split(" ");
		String[] truncated = new String[k];
		System.arraycopy(words, 0, truncated, 0, k);
		return String.join(" ", truncated);
	}
}
