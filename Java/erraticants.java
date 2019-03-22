import java.util.*;

public class erraticants {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int s = sc.nextInt();
            int r = s, c = s;
            HashMap<String, HashSet<String>> nodes = new HashMap<>();
            nodes.put(s + " " + s, new HashSet<>());
            for (int x = 0; x < s; x++) {
                String prev = r + " " + c;
                char a = sc.next().charAt(0);
                if (a == 'N')
                    r--;
                else if (a == 'S')
                    r++;
                else if (a == 'W')
                    c--;
                else
                    c++;
                String cur = r + " " + c;
                if (!nodes.containsKey(cur))
                    nodes.put(cur, new HashSet<>());
                nodes.get(prev).add(cur);
                nodes.get(cur).add(prev);
            }
            int d = 0;
            HashSet<String> visit = new HashSet<>();
            ArrayDeque<Pair> q = new ArrayDeque<>();
            q.offer(new Pair(s + " " + s, 0));
            while (!q.isEmpty()) {
                Pair cur = q.poll();
                if (cur.s.equals(r + " " + c)) {
                    d = cur.c;
                    break;
                }
                if (visit.contains(cur.s))
                    continue;
                visit.add(cur.s);
                for (String a : nodes.get(cur.s))
                    q.offer(new Pair(a, cur.c + 1));
            }
            System.out.println(d);
        }
        sc.close();
    }
}

class Pair {
    String s;
    int c;

    public Pair(String q, int w) {
        s = q;
        c = w;
    }
}