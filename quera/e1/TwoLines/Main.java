
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        String line1 = in.nextLine();
        String line2 = in.nextLine();

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (line1.charAt(i) != line2.charAt(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
