import java.io.*;
import java.util.*;

public class flipfive {
    static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        while (p-- > 0) {
            boolean[][] arr = new boolean[3][3];
            for (int r = 0; r < 3; r++) {
                String line = sc.next();
                for (int c = 0; c < 3; c++)
                    arr[r][c] = line.charAt(c) == '.';
            }
            HashSet<A> visit = new HashSet<>();
            Queue<A> q = new LinkedList<>();
            A init = new A(arr, 0);
            q.offer(init);
            q.add(init);
            int min = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                A cur = q.poll();
                if (cur.countOn() == 9) {
                    min = Math.min(min, cur.count);
                    continue;
                }
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        A press = cur.press(r, c);
                        if (visit.contains(press))
                            continue;
                        visit.add(press);
                        q.offer(press);
                    }
                }
            }
            System.out.println(min);
        }
    }

    static class A {
        boolean[][] arr;
        int count;

        public A(boolean[][] a, int b) {
            arr = a;
            count = b;
        }

        int countOn() {
            int on = 0;
            for (boolean[] r : arr)
                for (boolean c : r)
                    if (c)
                        on++;
            return on;
        }

        A press(int nr, int nc) {
            boolean[][] t = new boolean[3][3];
            for (int r = 0; r < 3; r++)
                for (int c = 0; c < 3; c++)
                    t[r][c] = arr[r][c];
            t[nr][nc] = !t[nr][nc];
            for (int x = 0; x < 4; x++) {
                int r = nr + dx[x];
                int c = nc + dy[x];
                if (r < 0 || c < 0 || r >= 3 || c >= 3)
                    continue;
                t[r][c] = !t[r][c];
            }
            return new A(t, count + 1);
        }

        public boolean equals(Object o) {
            A other = (A) o;
            return Arrays.deepEquals(arr, other.arr);
        }

        public int hashCode() {
            return Arrays.deepHashCode(arr);
        }
    }
}