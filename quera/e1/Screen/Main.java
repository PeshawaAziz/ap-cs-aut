import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line1 = in.nextLine();
        String line2 = in.nextLine();

        String shortStr;
        String longStr;

        if (line1.length() > line2.length()) {
            longStr = line1;
            shortStr = line2;
        } else {
            longStr = line2;
            shortStr = line1;
        }

        int same = 0;
        for (int i = 0; i < shortStr.length(); i++) {
            if (shortStr.substring(0, i + 1).equals(longStr.substring(0, i + 1))) {
                same++;
            }
        }

        int result = line1.length() + line2.length() - (same != 0 ? same - 1 : 0);

        System.out.println(result);
    }
}
