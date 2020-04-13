import java.io.*;
import java.util.*;

public class guessthedatastructure {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        while (sc.hasNext()) {
            stack.clear();
            queue.clear();
            pq.clear();
            int n = sc.nextInt();
            boolean[] pos = { true, true, true };
            for (int x = 0; x < n; x++) {
                int t = sc.nextInt();
                int v = sc.nextInt();
                if (t == 1) {
                    stack.push(v);
                    queue.offer(v);
                    pq.offer(v);
                } else {
                    if (stack.size() > 0 && stack.peek() == v)
                        stack.pop();
                    else
                        pos[0] = false;
                    if (queue.size() > 0 && queue.peek() == v)
                        queue.poll();
                    else
                        pos[1] = false;
                    if (pq.size() > 0 && pq.peek() == v)
                        pq.poll();
                    else
                        pos[2] = false;
                }
            }
            int count = 0;
            int idx = 0;
            for (int x = 0; x < 3; x++) {
                if (pos[x]) {
                    count++;
                    idx = x;
                }
            }
            if (count == 1) {
                if (idx == 0)
                    System.out.println("stack");
                else if (idx == 1)
                    System.out.println("queue");
                else
                    System.out.println("priority queue");
            } else if (count == 0) {
                System.out.println("impossible");
            } else {
                System.out.println("not sure");
            }
        }
    }
}