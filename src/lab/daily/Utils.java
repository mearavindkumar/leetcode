package lab.daily;

public class Utils {

	public static void main(String[] args) {

		System.out.println((char) ('0' | 32));
		System.out.println((char) ('S' | 32));
		System.out.println((char) ('s' | 32));

		System.out.println((char) ('C' & ~32));
		System.out.println((char) ('c' & ~32));

	}

}
