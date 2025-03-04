
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] line1 = in.nextLine().toCharArray();
        char[] line2 = in.nextLine().toCharArray();

        int[] bin1 = new int[line1.length];
        int[] bin2 = new int[line2.length];
        int[] result = new int[line1.length + 1];

        for (int i = 0; i < line1.length; i++) {
            bin1[i] = line1[i] - '0';
            bin2[i] = line2[i] - '0';
        }

        int carry = 0;
        for (int i = result.length - 1; i > 0; i--) {
            int sum = bin1[i - 1] + bin2[i - 1] + carry;
            result[i] = sum % 2;
            carry = sum / 2;
        }
        result[0] = carry;

        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) {

            } else
                System.out.print(result[i]);
        }
    }
}
