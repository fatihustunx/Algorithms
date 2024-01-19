public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 3;
		int y = 4;

		double matris[][] = { { 2, 1, -1, 8 }, { 3, 2, 1, 11 }, { 1, 1, 1, 4 } };

		double temp[] = new double[y];

		for (int i = 0; i < x; i++) {

			double bölüm = matris[i][i];

			for (int j = 0; j < y; j++) {
				matris[i][j] = matris[i][j] / bölüm;
			}

			for (int k = i + 1; k < x; k++) {
				double carpim = matris[k][i];
				for (int j = 0; j < y; j++) {
					temp[j] = matris[i][j] * carpim;
					matris[k][j] = matris[k][j] - temp[j];
				}
			}
		}

		x=x-1; y=y-1;
		
		double x3 = matris[x][y];
		double x2 = matris[x-1][y] - matris[x-1][y-1] * x3;
		double x1 = matris[x-2][y] - matris[x-2][y-2] * x2 - matris[x-2][y-1] * x3;

		System.out.println("x1 : " + x1);
		System.out.println("x2 : " + x2);
		System.out.println("x3 : " + x3);
	}
}