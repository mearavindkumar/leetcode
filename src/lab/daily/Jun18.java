package lab.daily;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Jun18 {

	abstract class test {
		public void print() {

		}
	}

	public Jun18() {

	}

	void Jun18() {

	}

	public static void main(String[] args) {

	}

	interface I {
		void meth();

		int x = 10;

		public default int method() {
			return 5;
		}

		static String toString1() {
			return "";
		}
	}

	interface I1 extends I {
		int x = 10;

		@Override
		public default int method() {
			return 5;
		}

		static String toString1() {
			return "";
		}
	}

//	[1,2,3,4,5,6,7,8,9,11,12,15,22]

	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			int num = i;
			while (num > 0) {
				int rem = num % 10;
				if (rem == 0 || i % rem != 0) {
					break;
				}
				num = num / 10;
			}
			if (num == 0) {
				result.add(i);
			}

		}
		return result;
	}

	public int maximumProduct(int[] nums) {
		int i = 0;
		int j = nums.length;
		int product = 1;

		while (i < j) {

		}
		return product;
	}

	public static String addStrings(String num1, String num2) {
		BigDecimal sum = BigDecimal.valueOf(Long.parseLong(num1)).add(BigDecimal.valueOf(Long.parseLong(num2)));
		return sum.toString();
	}

	public static List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			boolean div3 = i % 3 == 0;
			boolean div5 = i % 5 == 0;
			if (div3 && div5) {
				result.add("FizzBuzz");
			} else if (div3) {
				result.add("Fizz");
			} else if (div5) {
				result.add("Buzz");
			} else {
				result.add(i + "");
			}
		}

		return result;
	}

	public static boolean isPerfectSquare(int num) {
		int sqrt = (int) Math.sqrt(num);
		return Math.pow(sqrt, 2) == num;
	}

	public static boolean isPowerOfThree(int n) {

		if (n < 0 || n % 3 != 0) {
			return false;
		}
		while (n % 3 == 0) {
			n /= 3;
		}
		return n == 1;

	}

	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = ans ^ i ^ nums[i - 1];
		}
		return ans;
	}

	public static int countPrimes1(int n) {
		boolean[] visited = new boolean[n];
		int count = n / 2;
		for (int i = 3; i < Math.sqrt(n); i = i + 2) {
			if (visited[i]) {
				continue;
			}
			for (long j = (long) i * i; j < n; j += i) {
				if (j % 2 == 0) {
					continue;
				}
				if (!visited[(int) j]) {
					visited[(int) j] = true;
					count--;
				}

			}
		}
		return count;
	}

	public static int countPrimes(int n) {
		Timestamp start = new Timestamp(System.currentTimeMillis());
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		Timestamp end = new Timestamp(System.currentTimeMillis());
//		System.out.println(end.getTime() - start.getTime());
		return count;
	}

	private static boolean isPrime(int n) {
		if (n == 2 || n == 3) {
			return true;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int addDigits(int num) {
		int sum = num;
		int result = 0;
		while (sum >= 10) {
			num = sum;
			while (num > 0) {
				result += (num % 10);
				num = num / 10;
			}
			sum = result;
			result = 0;

		}

		return sum;

	}

	public static boolean isUgly(int n) {
		if (n < 0) {
			return false;
		}

		while (n % 2 == 0) {
			n = n / 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i++) {
			while (n % i == 0) {
				n = n / i;
			}
			if (i > 5) {
				return false;
			}
		}
		return n <= 5;
	}
}
