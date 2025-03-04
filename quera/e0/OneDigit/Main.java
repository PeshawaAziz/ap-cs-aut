
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long num = in.nextLong();

        long sum = num;
        while (sum > 9) {
            long temp = 0;
            while (sum > 0) {
                temp += sum % 10;
                sum /= 10;
            }
            sum = temp;
        }

        System.out.println(sum);
    }
}
