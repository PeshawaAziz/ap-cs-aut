
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        String number = Integer.toString(num);

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
                System.out.printf("NO");
                return;
            }
        }

        System.out.printf("YES");
    }
}
