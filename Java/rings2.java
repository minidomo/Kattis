import java.io.*;
import java.util.*;

public class rings2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int MAX = 200;
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { 1, -1, 0, 0 };
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] map = new char[R][C];
        int[][] ring = new int[R][C];
        Queue<Node> q = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            map[r] = sc.next().toCharArray();
            for (int c = 0; c < C; c++) {
                if (map[r][c] == '.')
                    continue;
                ring[r][c] = MAX;
                if (r == 0 || c == 0 || r == R - 1 || c == C - 1) {
                    ring[r][c] = 1;
                } else {
                    boolean edge = false;
                    for (int x = 0; x < 4; x++) {
                        int a = r + dx[x];
                        int b = c + dy[x];
                        edge = map[a][b] == '.';
                    }
                    if (!edge)
                        q.offer(new Node(r, c));
                }
            }
        }
        int attempt = 100;
        while (attempt-- > 0) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();
                q.offer(cur);
                int min = MAX;
                for (int x = 0; x < 4; x++) {
                    int r = cur.r + dx[x];
                    int c = cur.c + dy[x];
                    min = Math.min(min, ring[r][c]);
                }
                ring[cur.r][cur.c] = min + 1;
            }
        }
        int maxRing = 0;
        for (int[] r : ring)
            for (int c : r)
                maxRing = Math.max(maxRing, c);
        StringBuilder res = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (maxRing < 10) {
                    if (map[r][c] == '.')
                        res.append("..");
                    else
                        res.append(pad(ring[r][c], 2));
                } else {
                    if (map[r][c] == '.')
                        res.append("...");
                    else
                        res.append(pad(ring[r][c], 3));
                }
            }
            res.append('\n');
        }
        System.out.println(res);
    }

    static String pad(int a, int len) {
        StringBuilder ret = new StringBuilder(len);
        ret.append(a);
        while (ret.length() < len)
            ret.insert(0, '.');
        return ret.toString();
    }

    static class Node {
        int r, c;

        public Node(int a, int b) {
            r = a;
            c = b;
        }
    }
}