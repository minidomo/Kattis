import java.io.*;
import java.util.*;

public class reachableroads {
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> nodes;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int m = sc.nextInt();
            visit = new boolean[m];
            nodes = new ArrayList<>(m);
            for (int x = 0; x < m; x++)
                nodes.add(new ArrayList<>());
            int r = sc.nextInt();
            while (r-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                nodes.get(a).add(b);
                nodes.get(b).add(a);
            }
            int count = 0;
            for (int x = 0; x < m; x++)
                if (!visit[x]) {
                    count++;
                    bfs(x);
                }
            System.out.println(count - 1);
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