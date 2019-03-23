import java.io.*;
import java.util.*;

public class 10kindsofpeople {
    private static int MAX = 1000, MAX2 = 2045952;
    private static int[] H = new int[MAX2];
    private static int[][] grid = new int[MAX][MAX];
    private static boolean[][] visit = new boolean[MAX][MAX];
    private static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
    private static int R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] line = sc.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        for (int r = 0, c = 0; r < R; r++, c = 0)
            for (char a : sc.readLine().toCharArray())
                grid[r][c++] = a - '0';
        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                if (!visit[r][c])
                    bfs(r, c);
        int n = Integer.parseInt(sc.readLine());
        StringBuilder out = new StringBuilder();
        while (n-- > 0) {
            line = sc.readLine().split(" ");
            int r1 = Integer.parseInt(line[0]) - 1;
            int c1 = Integer.parseInt(line[1]) - 1;
            int r2 = Integer.parseInt(line[2]) - 1;
            int c2 = Integer.parseInt(line[3]) - 1;
            boolean[] ans = { false, false };
            ans[grid[r1][c1]] = H[hash(r1, c1)] == H[hash(r2, c2)];
            out.append(ans[0] == ans[1] ? "neither" : (ans[0] ? "binary" : "decimal")).append('\n');
        }
        System.out.println(out);
        sc.close();
    }

    private static void bfs(int r, int c) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { r, c });
        visit[r][c] = true;
        int h = hash(r, c);
        H[h] = h;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r1 = cur[0];
            int c1 = cur[1];
            for (int x = 0; x < 4; x++) {
                int r2 = r1 + dx[x];
                int c2 = c1 + dy[x];
                if (r2 < 0 || c2 < 0 || r2 >= R || c2 >= C || visit[r2][c2] || grid[r2][c2] != grid[r][c])
                    continue;
                visit[r2][c2] = true;
                H[hash(r2, c2)] = h;
                q.offer(new int[] { r2, c2 });
            }
        }
    }

    private static int hash(int a, int b) {
        int res = a * ((1 << 11) - 1);
        return res ^ b;
    }
}