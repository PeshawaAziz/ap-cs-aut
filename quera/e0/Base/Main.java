
import java.util.Scanner;

public class Main {

    public static long changeBase(long a, long b) {
        long c = 0, i = 1, x = 1;

        if (a == 0) {
            return 0;
        }
        while (a % b == 0) {
            a /= b;
        }

        while (a > 0) {
            c += (a % b) * i;
            a /= b;
            i *= 10;
            x *= -1;
        }

        c *= x;
        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextInt();
        long b = in.nextInt();
        long c = changeBase(a, b);
        long abs = c >= 0 ? c : -c;
        int sum1 = 0, sum2 = 0;
        int i = 1;

        while (abs > 0) {
            if (c > 0) {
                if (i == 1) {
                    sum1 += abs % 10;
                } else {
                    sum2 += abs % 10;
                }
            } else {
                if (i == 1) {
                    sum2 += abs % 10;
                } else {
                    sum1 += abs % 10;
                }
            }
            i *= -1;
            abs /= 10;
        }

        if (sum1 == sum2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
