package lab.daily;

public class Jul15 {

	public static void main(String[] args) {
		Jul15 instance = new Jul15();
		System.out.println(instance.hammingDistance(3, 1));
	}

	public int hammingDistance(int x, int y) {
		int j = x ^ y;
		int count = 0;
		while (j != 0) {
			count += j & 1;
			j >>= 1;
		}

		return count;

	}

//	 int count = 0;
//	    while (number != 0) {
//	        count += number & 1; // Check the least significant bit
//	        number >>= 1; // Right shift the number by 1 bit
//	    }
//	    return count;
}
