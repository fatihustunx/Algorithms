public class Main {

	public static void main(String[] args) {

		// Aralıklar belirlenir.
		double x1 = 0;
		double x2 = 1;

		// Hata değeri belirlenir.
		double error = 0.001;

		// x(i+1)-xi<Error.
		boolean control = true;

		double y1 = func(x1);
		double y2 = func(x2);

		if (y1 * y2 > 0) {
			System.out.println("Bu aralıkta kök yok.");
			control=false;
		}

		while (control) {
			
			double x = averageX(x1, x2);

			double y = func(x);

			// İlk verilen aralık kontrol edilir.
			if (y * y1 < 0) {
				x2 = x;
				y2 = y;
				if (Math.abs(x2-x1) < error) {
					control = false;
					System.out.println("Kök : " + x);
				}
			// İkinci verilen aralık kontrol edilir.
			} else {
				x1=x;
				y1=y;
				if (Math.abs(x2-x1) < error) {
					control = false;
					System.out.println("Kök : " + x);
				}
			}
		}
	}

	public static double func(double x) {
		return Math.exp(-x) - Math.sin((Math.PI / 2) * x);
	}

	public static double averageX(double x1, double x2) {
		return (x1 + x2) / 2;
	}
}