
import java.util.Scanner;

public class Main {

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        } else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int nextPrime(int n) {
        for (int i = n + 1;; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();

        for (int i = a + 1; i < b; i++) {
            if (isPrime(i)) {
                if (nextPrime(i) < b) {
                    System.out.printf("%d,", i);
                } else {
                    System.out.printf("%d", i);
                }
            }
        }
    }
}
