
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        char[][] matrix = new char[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            char[] line = in.nextLine().toCharArray();

            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '*') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
