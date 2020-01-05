import java.io.*;
import java.util.*;

public class dominoes2 {
    static ArrayList<ArrayList<Integer>> nodes;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();
            visit = new boolean[n + 1];
            nodes = new ArrayList<>(n + 1);
            for (int x = 0; x <= n; x++)
                nodes.add(new ArrayList<>());
            while (m-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                nodes.get(a).add(b);
            }
            while (l-- > 0)
                bfs(sc.nextInt());
            int count = 0;
            for (int x = 1; x <= n; x++)
                if (visit[x])
                    count++;
            System.out.println(count);
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visit[x] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int node : nodes.get(cur))
                if (!visit[node]) {
                    visit[node] = true;
                    q.offer(node);
                }
        }
    }
}