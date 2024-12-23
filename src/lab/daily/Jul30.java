package lab.daily;

public class Jul30 {

	public static void main(String[] args) {
		Jul30 instance = new Jul30();
		System.out.println(instance.average(new int[] { 4000, 3000, 1000, 2000 }));
	}

	public double average(int[] salary) {
		double sum = 0;
		Integer max = Integer.MIN_VALUE;
		Integer min = Integer.MAX_VALUE;
		for (int i : salary) {
			sum += i;
			if (i < min) {
				min = i;
			}
			if (i > max) {
				max = i;
			}
		}

		return (sum - (max + min)) / (salary.length - 2);
	}

}
