import java.util.*;

@SuppressWarnings("unchecked")
public class erraticants {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int s = sc.nextInt();
            int r = s, c = s;
            HashSet<Integer>[] nodes = new HashSet[32000];
            for (int x = 0; x < nodes.length; x++)
                nodes[x] = new HashSet<>();
            for (int x = 0; x < s; x++) {
                int q = hash(r, c);
                char a = sc.next().charAt(0);
                if (a == 'N')
                    r--;
                else if (a == 'S')
                    r++;
                else if (a == 'W')
                    c--;
                else
                    c++;
                int w = hash(r, c);
                nodes[w].add(q);
                nodes[q].add(w);
            }
            int end = hash(r, c);
            HashSet<Integer> visit = new HashSet<>();
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offer(new int[] { hash(s, s), 0 });
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int h = cur[0];
                if (h == end) {
                    System.out.println(cur[1]);
                    break;
                }
                if (visit.contains(h))
                    continue;
                visit.add(h);
                for (int x : nodes[h])
                    if (!visit.contains(x))
                        q.offer(new int[] { x, cur[1] + 1 });
            }
        }
        sc.close();
    }

    private static int hash(int a, int b) {
        int res = a * ((1 << 8) - 1);
        return res ^ b;
    }
}