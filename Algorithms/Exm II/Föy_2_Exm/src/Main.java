
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kök değerini giriniz\n");
        double x = scanner.nextDouble();
        while (true) {
            System.out.print("\n--------------------------------------\nÇözüm yöntemini seçin\n1- (2x+3)*1/2\n2- (x^2-3)/2\n3- 3/(x-2)\n4- Çıkış\n");
            int i = scanner.nextInt();
            if (i == 1) {
                findRoot1(x);
            } else if (i == 2) {
                findRoot2(x);
            } else if (i == 3) {
                findRoot3(x);
            } else if (i == 4) {
                break;
            } else {
                System.out.println("1-4 arasında sayı giriniz.");
            }
        }
    }

    public static double f1(double x) {
        return Math.sqrt((3 * x) - 1);
    }

    public static double f2(double x) {
        return (Math.pow(x, 2) + 1) / 3;
    }

    public static double f3(double x) {
        return -1 / (x - 3);
    }

    public static void findRoot1(double x0) {
        double e = 0.01;
        double y0 = f1(x0);
        double new_y0 = Math.abs(y0 - x0);
        System.out.printf("x = %f,      h(x) = %f,       E = %f\n", x0, y0, new_y0);
        if (new_y0 > 10000) {
            System.out.println("Iraksak");
        } else if (new_y0 > e) {
            findRoot1(y0);
        } else if (new_y0 <= e) {
            System.out.printf("Kök değeri = %f\n", y0);
        }
        else {
            System.out.println("Hata");
        }
    }

    public static void findRoot2(double x0) {
        double e = 0.01;
        double y0 = f2(x0);
        double new_y0 = Math.abs(y0 - x0);
        System.out.printf("x = %f,      h(x) = %f,       E = %f\n", x0, y0, new_y0);
        if (new_y0 > 10000) {
            System.out.println("Iraksak");
        } else if (new_y0 > e) {
            findRoot2(y0);
        } else if (new_y0 <= e) {
            System.out.printf("Kök değeri = %f\n", y0);
        }
        else {
            System.out.println("Hata");
        }
    }

    public static void findRoot3(double x0) {
        double e = 0.01;
        double y0 = f3(x0);
        double new_y0 = Math.abs(y0 - x0);
        System.out.printf("x = %f,     h(x) = %f,       E = %f\n", x0, y0, new_y0);
        if (new_y0 > 10000) {
            System.out.println("Iraksakdır... kök bulunamadı");
        } else if (new_y0 > e) {
            findRoot3(y0);
        } else if (new_y0 <= e) {
            System.out.printf("Kök değeri = %f\n", y0);
        }
        else {
            System.out.println("Hata");
        }
    }
}
