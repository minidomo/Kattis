import java.io.*;
import java.util.*;

public class shortestpath1 {
    private static int[] dist;
    private static ArrayList<Edge>[] nodes;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        for (;;) {
            String line = sc.readLine();
            if (line.equals("0 0 0 0"))
                break;
            String[] arr = line.split(" ");
            int N, M, Q, S;
            N = Integer.parseInt(arr[0]);
            M = Integer.parseInt(arr[1]);
            Q = Integer.parseInt(arr[2]);
            S = Integer.parseInt(arr[3]);
            dist = new int[N];
            nodes = new ArrayList[N];
            for (int x = 0; x < N; x++)
                nodes[x] = new ArrayList<Edge>();
            while (M-- > 0) {
                arr = sc.readLine().split(" ");
                int u, v, w;
                u = Integer.parseInt(arr[0]);
                v = Integer.parseInt(arr[1]);
                w = Integer.parseInt(arr[2]);
                nodes[u].add(new Edge(v, w));
            }
            dijkstra(S);
            while (Q-- > 0) {
                int a = Integer.parseInt(sc.readLine());
                dc.write(dist[a] == Integer.MAX_VALUE ? "Impossible\n" : dist[a] + "\n");
            }
            dc.write('\n');
        }
        dc.close();
        sc.close();
    }

    private static void dijkstra(int source) {
        PriorityQueue<Edge> q = new PriorityQueue<Edge>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        q.add(new Edge(source, 0));
        while (!q.isEmpty()) {
            Edge cur = q.poll();
            if (cur.weight > dist[cur.to])
                continue;
            for (Edge nxt : nodes[cur.to]) {
                int d = cur.weight + nxt.weight;
                if (d < dist[nxt.to])
                    q.add(new Edge(nxt.to, dist[nxt.to] = d));
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    public int weight, to;

    public Edge(int a, int b) {
        to = a;
        weight = b;
    }

    public int compareTo(Edge a) {
        return weight - a.weight;
    }
}