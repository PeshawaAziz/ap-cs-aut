
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1) {
                    System.out.printf("*");
                } else {
                    if (j == 0 || j == n - 1) {
                        System.out.printf("*");
                    } else {
                        System.out.printf(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
