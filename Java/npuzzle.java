import java.io.*;
import java.util.*;

public class npuzzle {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int['O' + 1][2];
        map['A'][0] = map['B'][0] = map['C'][0] = map['D'][0] = 0;
        map['E'][0] = map['F'][0] = map['G'][0] = map['H'][0] = 1;
        map['I'][0] = map['J'][0] = map['K'][0] = map['L'][0] = 2;
        map['M'][0] = map['N'][0] = map['O'][0] = map['.'][0] = 3;
        map['A'][1] = map['E'][1] = map['I'][1] = map['M'][1] = 0;
        map['B'][1] = map['F'][1] = map['J'][1] = map['N'][1] = 1;
        map['C'][1] = map['G'][1] = map['K'][1] = map['O'][1] = 2;
        map['D'][1] = map['H'][1] = map['L'][1] = map['.'][1] = 3;
        int dist = 0;
        for (int r = 0, c = 0; r < 4; r++, c = 0)
            for (char a : sc.nextLine().toCharArray()) {
                if (a == '.') {
                    c++;
                    continue;
                }
                dist += dist(r, c++, map[a][0], map[a][1]);
            }
        System.out.println(dist);
        sc.close();
    }

    private static int dist(int r, int c, int r1, int c1) {
        return Math.abs(r - r1) + Math.abs(c - c1);
    }
}
