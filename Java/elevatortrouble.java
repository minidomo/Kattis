import java.io.*;
import java.util.*;

public class elevatortrouble {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();
        boolean[] visit = new boolean[f + 1];
        Queue<A> q = new LinkedList<>();
        q.offer(new A(s, 0));
        A min = new A(1, Integer.MAX_VALUE);
        while (!q.isEmpty()) {
            A cur = q.poll();
            if (cur.steps < min.steps && cur.floor == g)
                min = cur;
            if (visit[cur.floor])
                continue;
            visit[cur.floor] = true;
            int down = cur.floor - d;
            int up = cur.floor + u;
            if (down >= 1)
                q.offer(new A(down, cur.steps + 1));
            if (up <= f)
                q.offer(new A(up, cur.steps + 1));
        }
        System.out.println(min.steps == Integer.MAX_VALUE ? "use the stairs" : min.steps);
    }

    static class A {
        int steps, floor;

        public A(int a, int b) {
            floor = a;
            steps = b;
        }
    }
}