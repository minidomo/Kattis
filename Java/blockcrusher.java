import java.io.*;
import java.util.*;

public class blockcrusher {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] dx = { 1, 1, 1, -1, -1, -1, 0, 0 };
        int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1 };
        StringBuilder ans = new StringBuilder();
        for (;;) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            if (R == 0 && C == 0)
                break;
            char[][] arr = new char[R][C];
            int[][] s = new int[R][C];
            for (int r = 0; r < R; r++) {
                arr[r] = sc.next().toCharArray();
                for (int c = 0; c < C; c++)
                    s[r][c] = Integer.MAX_VALUE;
            }
            Queue<Node> q = new PriorityQueue<>();
            TreeSet<Node> set = new TreeSet<>();
            for (int c = 0; c < C; c++)
                q.offer(new Node(0, c, arr[0][c] - '0', null));
            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (cur.r == R - 1)
                    set.add(cur);
                for (int x = 0; x < dx.length; x++) {
                    int r = cur.r + dx[x];
                    int c = cur.c + dy[x];
                    if (r < 0 || c < 0 || r >= R || c >= C)
                        continue;
                    int str = cur.str + arr[r][c] - '0';
                    if (str < s[r][c])
                        q.offer(new Node(r, c, s[r][c] = str, cur));
                }
            }
            Node cur = set.first();
            while (cur != null) {
                arr[cur.r][cur.c] = ' ';
                cur = cur.prev;
            }
            for (char[] r : arr) {
                for (char c : r)
                    ans.append(c);
                ans.append('\n');
            }
            ans.append('\n');
        }
        System.out.print(ans);
    }

    static class Node implements Comparable<Node> {
        int r, c, str;
        Node prev;

        public Node(int q, int w, int e, Node p) {
            r = q;
            c = w;
            str = e;
            prev = p;
        }

        public int compareTo(Node o) {
            return str - o.str;
        }
    }
}