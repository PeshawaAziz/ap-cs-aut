
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);

        int r = scn.nextInt();
        int c = scn.nextInt();

        if (c >= 1 && c <= 10) {
            System.out.printf("Right ");
        }
        if (c >= 11 && c <= 20) {
            System.out.printf("Left ");
        }

        System.out.printf("%d %d", 11 - r, 21 - c);

    }
}
