
import java.util.Scanner;

public class Main {

    // public static int numLen(long num) {
    //     while (num) {
    //     }
    // }
    public static int countLucky(long num) {
        int n = 0;

        while (num > 0) {
            if (num % 10 == 4 || num % 10 == 7) {
                n++;
            }
            num /= 10;
        }

        return n;
    }

    public static boolean isLucky(long num) {
        if (countLucky(num) == String.valueOf(num).length()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAlmostLucky(long num) {
        if (isLucky(countLucky(num))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long num = in.nextLong();

        if (isAlmostLucky(num)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
