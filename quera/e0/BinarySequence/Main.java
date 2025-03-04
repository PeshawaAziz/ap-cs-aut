
import java.util.Scanner;

public class Main {

    public static String inverse(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] == '1') {
                chars[i] = '0';
            } else if (chars[i] == '0') {
                chars[i] = '1';
            }
        }
        str = String.valueOf(chars);

        return str;
    }

    public static int raise(int base, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= base;
        }

        return result;
    }

    ;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int n = 0;

        String sequence = "1";

        for (int i = 0; raise(2, i) < b; i++) {
            n = i;
        }

        for (int i = 0; i < n + 1; i++) {
            String inv = inverse(sequence);
            sequence = sequence.concat(inv);
        }

        for (int i = a - 1; i < b; i++) {
            System.out.printf("%c", sequence.charAt(i));
        }
    }
}
