
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] strs = new String[5];
        boolean[] marks = {false, false, false, false, false};
        boolean empty = true;

        for (int i = 0; i < strs.length; i++) {
            strs[i] = scn.nextLine();
        }

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].contains("HAFEZ") || strs[i].contains("MOLANA")) {
                marks[i] = true;
            }
        }

        for (int i = 0; i < marks.length; i++) {
            if (marks[i]) {
                empty = false;
                System.out.printf("%d ", i + 1);
            }
        }

        if (empty) {
            System.out.println("NOT FOUND!");
        }
    }
}
