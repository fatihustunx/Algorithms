public class Main {
    public static void main(String[] args) {
    	
        double[][] A = {
            {10, 2, 1},
            {1, 5, 1},
            {2, 3, 10}
        };
        double[] b = {7, -8, 6};
        double[] x = {0, 0, 0};

        gaussSeidel(A, b, x);
    }

    public static void gaussSeidel(double[][] A, double[] b, double[] x) {
    	
        int n = A.length;
        
        double[] yeniX = {0,0,0};
        
        boolean control=true;
        double error=0.001;

        while (control) {
            for (int i = 0; i < n; i++) {
                double sum = b[i];
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        sum -= A[i][j] * yeniX[j];
                    }
                }
                yeniX[i] = sum / A[i][i];
            }

            control=false;
            // Error control
            for (int i = 0; i < n; i++) {
                if(!(Math.abs(yeniX[i] - x[i])<error)) {
                	control=true;
                }
            }

            System.arraycopy(yeniX, 0, x, 0, n);
        }

        for (int i=1;i<=n;i++) {
            System.out.println("x" + i + " : " + x[i-1]);
        }
    }
}