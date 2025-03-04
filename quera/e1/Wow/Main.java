
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.printf("W");
        for (int i = 0; i < n; i++) {
            System.out.printf("o");
        }
        System.out.printf("w!");
    }
}
