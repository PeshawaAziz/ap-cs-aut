
import java.util.Scanner;

public class Main {

    public static int modulo(int x, int n) {
        if (x > 0) {
            return x % n;
        } else if (x < 0) {
            int k = (-x - 1) / n + 1;
            return x + k * n;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), k = in.nextInt();
        int[] sequence = new int[n];
        int[] shifted = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            shifted[modulo(i - k, n)] = sequence[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", shifted[i]);
        }
    }
}
