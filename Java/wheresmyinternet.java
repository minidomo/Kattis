import java.io.*;
import java.util.*;

public class wheresmyinternet {
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] tok;
        tok = sc.readLine().split(" ");
        int n = Integer.parseInt(tok[0]);
        int m = Integer.parseInt(tok[1]);
        visit = new boolean[n + 1];
        nodes = new ArrayList<>(n + 1);
        for (int x = 0; x <= n; x++)
            nodes.add(new ArrayList<>());
        while (m-- > 0) {
            tok = sc.readLine().split(" ");
            int a = Integer.parseInt(tok[0]);
            int b = Integer.parseInt(tok[1]);
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        bfs(1);
        StringBuilder ans = new StringBuilder();
        boolean fail = false;
        for (int x = 1; x <= n; x++)
            if (!visit[x]) {
                fail = true;
                ans.append(x).append('\n');
            }
        if (!fail)
            System.out.println("Connected");
        else
            System.out.println(ans);
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