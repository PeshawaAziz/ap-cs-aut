import java.util.Scanner;

public class Main {

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        var scn = new Scanner(System.in);

        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        int max = max(max(a, b), c);
        int min = min(min(a, b), c);
        int mid = a + b + c - max - min;

        if (min * min + mid * mid == max * max) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
