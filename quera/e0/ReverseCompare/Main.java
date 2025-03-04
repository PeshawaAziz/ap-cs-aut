
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);

        int a = scn.nextInt();
        int b = scn.nextInt();

        int t1 = a, t2 = b;

        int x = 0, y = 0;

        while (t1 > 0 && t2 > 0) {
            x *= 10;
            x += t1 % 10;
            t1 /= 10;

            y *= 10;
            y += t2 % 10;
            t2 /= 10;
        }

        if (x < y) {
            System.out.printf("%d < %d", a, b);
        } else if (y < x) {
            System.out.printf("%d < %d", b, a);
        } else {
            System.out.printf("%d = %d", a, b);
        }
    }
}
