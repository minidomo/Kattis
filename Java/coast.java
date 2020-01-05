import java.io.*;
import java.util.*;

public class coast {
    static int n, m;
    static char[][] map;
    static boolean[][] visit;
    static int count;

    static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        visit = new boolean[n][m];
        for (int r = 0; r < n; r++)
            map[r] = sc.next().toCharArray();
        for (int r = 0; r < n; r++) {
            if (map[r][0] == '0') {
                if (!visit[r][0])
                    bfs(r, 0);
            } else {
                count++;
            }
            if (map[r][m - 1] == '0') {
                if (!visit[r][m - 1])
                    bfs(r, m - 1);
            } else {
                count++;
            }
        }
        for (int c = 0; c < m; c++) {
            if (map[0][c] == '0') {
                if (!visit[0][c])
                    bfs(0, c);
            } else {
                count++;
            }
            if (map[n - 1][c] == '0') {
                if (!visit[n - 1][c])
                    bfs(n - 1, c);
            } else {
                count++;
            }
        }
        System.out.println(count);
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { r, c });
        visit[r][c] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int x = 0; x < 4; x++) {
                r = cur[0] + dx[x];
                c = cur[1] + dy[x];
                if (r < 0 || c < 0 || r >= n || c >= m || visit[r][c])
                    continue;
                if (map[r][c] == '1') {
                    count++;
                    continue;
                }
                visit[r][c] = true;
                q.offer(new int[] { r, c });
            }
        }
    }
}