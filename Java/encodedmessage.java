
// https://open.kattis.com/problems/encodedmessage
import java.util.Scanner;

public class encodedmessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        sc.nextLine();
        while (cases-- > 0) {
            char[] encoded = sc.nextLine().toCharArray();
            int side = (int) Math.sqrt(encoded.length);
            char[][] letters = new char[side][side];
            int i = 0;
            for (int row = 0; row < side; row++)
                for (int col = 0; col < side; col++)
                    letters[row][col] = encoded[i++];

            for (int col = side - 1; col >= 0; col--)
                for (int row = 0; row < side; row++)
                    System.out.print(letters[row][col]);
            System.out.println();
        }
        sc.close();
    }
}