public class Main {

	public static void main(String[] args) {

		// İlk değer.
		double x0 = 2;

		double error = 0.01;

		// x(i+1)-xi < Error.
		boolean control = true;

		while (control) {

			// func1, func2, func3
			double x1 = func1(x0);

			if (Math.abs(x1-x0) < error) {
				System.out.println("Kök : " + x1);
				control=false;
			}else {
				x0=x1;
			}
		}
	}

	public static double func(double x) {
		return Math.pow(x, 2) - 3 * x + 1;
	}

	public static double func1(double x) {
		return (Math.pow(x, 2) + 1) / 3;
	}
	
	public static double func2(double x) {
		return Math.sqrt(3*x-1);
	}
	
	public static double func3(double x) {
		return 1/(3-x);
	}
}