
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (check(str.substring(i, j + 1))) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static boolean check(String str) {
        int a = 0, b = 0, c = 0;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'A':
                    a++;
                    break;
                case 'B':
                    b++;
                    break;
                case 'C':
                    c++;
                    break;
                default:
                    break;
            }
        }

        return a == b && b == c;
    }
}
