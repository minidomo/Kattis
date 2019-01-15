import java.io.*;
import java.util.*;

public class countingstars {
    private static char[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int cnum = 1; sc.hasNextLine(); cnum++) {
            int rows = sc.nextInt(), cols = sc.nextInt();
            sc.nextLine();
            map = new char[rows][cols];
            visit = new boolean[rows][cols];
            Queue<int[]> stars = new LinkedList<>();
            for (int r = 0; r < rows; r++) {
                map[r] = sc.nextLine().toCharArray();
                for (int c = 0; c < cols; c++)
                    if (map[r][c] == '#')
                        visit[r][c] = true;
                    else
                        stars.offer(new int[] { r, c });
            }
            int count = 0;
            while (!stars.isEmpty()) {
                int[] cur = stars.poll();
                if (visit[cur[0]][cur[1]])
                    continue;
                count++;
                flood(cur[0], cur[1]);
            }
            System.out.println("Case " + cnum + ": " + count);
        }
        sc.close();
    }

    private static void flood(int r, int c) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[r].length)
            return;
        if (visit[r][c])
            return;
        visit[r][c] = true;
        flood(r - 1, c);
        flood(r + 1, c);
        flood(r, c - 1);
        flood(r, c + 1);
    }
}