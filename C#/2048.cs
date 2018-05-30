using System;

public class 2048 {
    public static void Main (string[] args) {
        int[, ] board = new int[4, 4];
        for (int r = 0, c = 0; r < 4; r++)
            foreach (string s in Console.ReadLine ().Split (' ')) {
                board[r, c++] = int.Parse (s);
                if (c == 4)
                    c = 0;
            }

        string dir = Console.ReadLine ();

        if (dir.Equals ("0"))
            print (left (board));
        else if (dir.Equals ("1"))
            print (up (board));
        else if (dir.Equals ("2"))
            print (right (board));
        else
            print (down (board));
    }

    private static int[, ] left (int[, ] arr) {
        for (int r = 0; r < 4; r++) {
            bool[] swap = new bool[4];
            for (int c = 1; c < 4; c++) {
                if (arr[r, c] == 0)
                    continue;
                for (int C = c; C > 0; C--) {
                    if (arr[r, C - 1] == 0) {
                        arr[r, C - 1] = arr[r, C];
                        arr[r, C] = 0;
                        bool temp = swap[C];
                        swap[C] = swap[C - 1];
                        swap[C - 1] = temp;
                    } else if (arr[r, C - 1] == arr[r, C] && !(swap[C] || swap[C - 1])) {
                        arr[r, C - 1] <<= 1;
                        arr[r, C] = 0;
                        swap[C - 1] = true;
                    }
                }
            }
        }
        return arr;
    }

    private static int[, ] right (int[, ] arr) {
        return rotate (rotate (left (rotate (rotate (arr)))));
    }

    private static int[, ] up (int[, ] arr) {
        return rotate (rotate (rotate (left (rotate (arr)))));
    }

    private static int[, ] down (int[, ] arr) {
        return rotate (left (rotate (rotate (rotate (arr)))));
    }

    private static int[, ] rotate (int[, ] arr) {
        int[, ] temp = new int[4, 4];
        for (int c = 3, R = 0; c >= 0; c--, R++)
            for (int r = 0, C = 0; r < 4; r++, C++)
                temp[R, C] = arr[r, c];
        return temp;
    }

    private static void print (int[, ] arr) {
        int i = 0;
        foreach (int x in arr) {
            Console.Write (x + " ");
            i++;
            if (i == 4) {
                Console.WriteLine ();
                i = 0;
            }
        }
    }
}
