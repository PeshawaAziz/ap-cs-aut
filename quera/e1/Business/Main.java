
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }

        int diff;
        int max_diff = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                diff = prices[j] - prices[i];
                if (diff > max_diff) {
                    max_diff = diff;
                }
            }
        }

        System.out.println(max_diff);
    }
}
