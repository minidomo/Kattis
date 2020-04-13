import java.io.*;
import java.util.*;

public class islands3 {
    static int R, C;
    static char[][] arr;
    static boolean[][] visit;

    static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        arr = new char[R][C];
        visit = new boolean[R][C];
        Queue<Land> q = new ArrayDeque<>();
        for (int r = 0; r < R; r++) {
            String row = sc.next();
            for (int c = 0; c < C; c++) {
                arr[r][c] = row.charAt(c);
                if (arr[r][c] == 'L')
                    q.offer(new Land(r, c));
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            Land cur = q.poll();
            if (visit[cur.r][cur.c])
                continue;
            bfs(cur);
            count++;
        }
        System.out.println(count);
    }

    static void bfs(Land source) {
        Queue<Land> q = new ArrayDeque<>();
        q.offer(source);
        while (!q.isEmpty()) {
            Land cur = q.poll();
            if (visit[cur.r][cur.c])
                continue;
            visit[cur.r][cur.c] = true;
            for (int x = 0; x < dx.length; x++) {
                int r = cur.r + dx[x];
                int c = cur.c + dy[x];
                if (r < 0 || c < 0 || r >= R || c >= C || arr[r][c] == 'W')
                    continue;
                q.offer(new Land(r, c));
            }
        }
    }

    static class Land {
        int r, c;

        public Land(int a, int b) {
            r = a;
            c = b;
        }
    }
}
