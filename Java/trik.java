
// https://open.kattis.com/problems/trik
import java.util.Scanner;

public class trik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] position = { 1, 0, 0 };
        String moves = sc.nextLine();
        for (int x = 0; x < moves.length(); x++) {
            if (moves.charAt(x) == 'A') {
                int temp = position[1];
                position[1] = position[0];
                position[0] = temp;
            } else if (moves.charAt(x) == 'B') {
                int temp = position[1];
                position[1] = position[2];
                position[2] = temp;
            } else if (moves.charAt(x) == 'C') {
                int temp = position[0];
                position[0] = position[2];
                position[2] = temp;
            }
        }
        System.out.println(position[0] == 1 ? 1 : position[1] == 1 ? 2 : 3);
        sc.close();
    }
}