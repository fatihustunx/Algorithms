using System;

class GaussSeidel
{
    static void Main()
    {
        // Example system of equations:
        // 3x + y - z = 9
        // x - 4y + 2z = 2
        // -2x + y + 7z = -5

        double[,] coefficients = { { 10, 2, 1, 7 }, { 1, 5, 1, -8 }, { 2, 3, 10, 6 } };

        int iterations = 25;
        double tolerance = 0.001;

        double[] solution = Solve(coefficients, iterations, tolerance);

        Console.WriteLine("Solution:");
        for (int i = 0; i < solution.Length; i++)
        {
            Console.WriteLine($"x{i + 1} = {solution[i]}");
        }
    }

    static double[] Solve(double[,] coefficients, int iterations, double tolerance)
    {
        int n = coefficients.GetLength(0);
        double[] x = new double[n];

        for (int k = 0; k < iterations; k++)
        {
            double[] x_new = new double[n];

            for (int i = 0; i < n; i++)
            {
                double sum = 0.0;
                for (int j = 0; j < n; j++)
                {
                    if (j != i)
                    {
                        sum += coefficients[i, j] * x[j];
                    }
                }
                x_new[i] = (coefficients[i, n] - sum) / coefficients[i, i];
            }

            // Check for convergence
            double maxDiff = 0.0;
            for (int i = 0; i < n; i++)
            {
                double diff = Math.Abs(x_new[i] - x[i]);
                if (diff > maxDiff)
                {
                    maxDiff = diff;
                }
            }

            // Update the solution
            x = x_new;

            // Check for convergence
            if (maxDiff < tolerance)
            {
                Console.WriteLine($"Converged after {k + 1} iterations.");
                break;
            }
        }

        return x;
    }
}