
// https://open.kattis.com/problems/2048
import java.util.Scanner;

public class i2048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[4][4];
        for (int x = 0, i = 0; x < 4; x++)
            for (String s : sc.nextLine().split(" ")) {
                board[x][i++] = Integer.parseInt(s);
                if (i == 4)
                    i = 0;
            }
        int direction = sc.nextInt();
        if (direction == 0)
            board = left(board);
        else if (direction == 1)
            board = up(board);
        else if (direction == 2)
            board = right(board);
        else
            board = down(board);

        print(board);

        sc.close();
    }

    private static int[][] left(int[][] arr) {
        for (int r = 0; r < 4; r++) {
            boolean[] change = new boolean[4];
            for (int c = 1; c < 4; c++)
                if (arr[r][c] != 0) {
                    for (int pos = c; pos > 0; pos--) {
                        if (arr[r][pos - 1] == 0) {
                            arr[r][pos - 1] = arr[r][pos];
                            arr[r][pos] = 0;
                            boolean temp = change[pos - 1];
                            change[pos - 1] = change[pos];
                            change[pos] = temp;
                        } else if (arr[r][pos - 1] == arr[r][pos] && (!change[pos - 1] && !change[pos])) {
                            arr[r][pos - 1] *= 2;
                            arr[r][pos] = 0;
                            change[pos - 1] = true;
                        }
                    }
                }
        }
        return arr;
    }

    private static int[][] right(int[][] arr) {
        for (int r = 0; r < 4; r++) {
            boolean[] change = new boolean[4];
            for (int c = 2; c >= 0; c--)
                if (arr[r][c] != 0) {
                    for (int pos = c; pos < 3; pos++) {
                        if (arr[r][pos + 1] == 0) {
                            arr[r][pos + 1] = arr[r][pos];
                            arr[r][pos] = 0;
                            boolean temp = change[pos + 1];
                            change[pos + 1] = change[pos];
                            change[pos] = temp;
                        } else if (arr[r][pos + 1] == arr[r][pos] && (!change[pos + 1] && !change[pos])) {
                            arr[r][pos + 1] *= 2;
                            arr[r][pos] = 0;
                            change[pos + 1] = true;
                        }
                    }
                }
        }
        return arr;
    }

    private static int[][] up(int[][] arr) {
        return reverse(left(rotate(arr)));
    }

    private static int[][] down(int[][] arr) {
        return reverse(right(rotate(arr)));
    }

    private static int[][] rotate(int[][] arr) {
        int[][] temp = new int[4][4];
        for (int c = 3, row = 0; c >= 0; c--, row++)
            for (int r = 0, col = 0; r < 4; r++, col++)
                temp[row][col] = arr[r][c];
        return temp;
    }

    private static int[][] reverse(int[][] arr) {
        int[][] temp = new int[4][4];
        for (int r = 0, col = 3; r < 4; r++, col--)
            for (int c = 0, row = 0; c < 4; c++, row++)
                temp[row][col] = arr[r][c];
        return temp;
    }

    private static void print(int[][] arr) {
        for (int[] a : arr) {
            for (int s : a)
                System.out.print(s + " ");
            System.out.println();
        }
    }
}