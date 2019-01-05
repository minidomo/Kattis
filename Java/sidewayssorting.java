import java.io.*;
import java.util.*;

public class sidewayssorting {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            int row = sc.nextInt(), col = sc.nextInt();
            if (row == 0 && col == 0)
                break;
            sc.nextLine();
            String[] arr = new String[col];
            for (int r = 0; r < row; r++) {
                String line = sc.nextLine();
                for (int c = 0; c < col; c++) {
                    if (r == 0)
                        arr[c] = "";
                    arr[c] += line.charAt(c);
                }
            }
            Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++)
                    System.out.print(arr[c].charAt(r));
                System.out.println();
            }
            System.out.println();
        }
        sc.close();
    }
}