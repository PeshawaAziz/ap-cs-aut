
import java.util.Scanner;

public class Main {
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        in.nextInt();
        in.nextLine();
        String str = in.nextLine();

        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String currentSubstring = str.substring(i, j);
                int currentLength = currentSubstring.length();
                if (isPalindrome(currentSubstring)) {
                    if (currentLength > max)
                        max = currentLength;
                }
            }
        }

        System.out.println(max);
    }
}
