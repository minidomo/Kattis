using System;
using System.Collections.Generic;

public class erraticants {
    public static void Main (string[] args) {
        const int MAX = 32000;
        int n = int.Parse (Console.ReadLine ());
        while (n-- > 0) {
            Console.ReadLine ();
            int s = int.Parse (Console.ReadLine ());
            int r = s, c = s;
            HashSet<int>[] arr = new HashSet<int>[MAX];
            for (int x = 0; x < arr.Length; x++)
                arr[x] = new HashSet<int> ();
            for (int x = 0; x < s; x++) {
                int e = hash (r, c);
                char a = Console.ReadLine () [0];
                if (a == 'N')
                    r--;
                else if (a == 'S')
                    r++;
                else if (a == 'W')
                    c--;
                else
                    c++;
                int w = hash (r, c);
                arr[e].Add (w);
                arr[w].Add (e);
            }
            int end = hash (r, c);
            Queue<int[]> q = new Queue<int[]> ();
            bool[] visit = new bool[MAX];
            q.Enqueue (new int[] { hash (s, s), 0 });
            while (q.Count > 0) {
                int[] cur = q.Dequeue ();
                int h = cur[0];
                if (h == end) {
                    Console.WriteLine (cur[1]);
                    break;
                }
                if (visit[h])
                    continue;
                visit[h] = true;
                foreach (int x in arr[h])
                    if (!visit[x])
                        q.Enqueue (new int[] { x, cur[1] + 1 });
            }
        }
    }

    private static int hash (int a, int b) {
        int res = a * ((1 << 8) - 1);
        return res ^ b;
    }
}