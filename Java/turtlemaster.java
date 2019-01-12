import java.util.*;

public class turtlemaster {
    private static char[][] board;
    private static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    private static int i = 0, posr = 7, posc = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> dpos = new ArrayList<>();
        board = new char[8][8];
        for (int r = 0; r < 8; r++) {
            board[r] = sc.nextLine().toCharArray();
            for (int c = 0; c < 8; c++)
                if (board[r][c] == 'D')
                    dpos.add(new int[] { r, c });
        }
        boolean diamond = true;
        for (char a : sc.nextLine().toCharArray()) {
            if (a == 'F' && !forward()) {
                diamond = false;
                break;
            } else if (a == 'L')
                i = i == 0 ? 3 : i - 1;
            else if (a == 'R')
                i = i == 3 ? 0 : i + 1;
            else if (a == 'X' && !shoot()) {
                diamond = false;
                break;
            }
        }
        if (diamond) {
            diamond = false;
            for (int[] x : dpos)
                if (x[0] == posr && x[1] == posc) {
                    diamond = true;
                    break;
                }
        }
        System.out.println(diamond ? "Diamond!" : "Bug!");
        sc.close();
    }

    private static boolean forward() {
        int r = posr + dir[i][0];
        int c = posc + dir[i][1];
        if (r < 0 || r >= 8 || c < 0 || c >= 8)
            return false;
        if (board[r][c] == 'I' || board[r][c] == 'C')
            return false;
        board[posr][posc] = '.';
        board[r][c] = 'T';
        posr = r;
        posc = c;
        return true;
    }

    private static boolean shoot() {
        int r = posr + dir[i][0];
        int c = posc + dir[i][1];
        if (r < 0 || r >= 8 || c < 0 || c >= 8)
            return false;
        if (board[r][c] != 'I')
            return false;
        board[r][c] = '.';
        return true;
    }
}