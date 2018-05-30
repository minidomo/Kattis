using System;

public class touchscreenkeyboard {
    public static void Main (string[] args) {
        string[] keyboard = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };

        int cases = int.Parse (Console.ReadLine ());
        while (cases-- > 0) {
            string[] given = Console.ReadLine ().Split (' ');
            int length = int.Parse (given[1]);

            string[] dict = new string[length];

            for (int x = 0; x < length; x++) {
                string word = Console.ReadLine ();
                int dist = 0, i = 0;
                foreach (char c in word.ToCharArray ()) {
                    char a = given[0][i++];
                    if (a == c)
                        continue;
                    dist += distance (keyboard, a, c);
                }
                dict[x] = word + " " + dist;
            }
            Array.Sort (dict, (a, b) => {
                int z = int.Parse (a.Split (' ') [1]);
                int x = int.Parse (b.Split (' ') [1]);
                return z == x ? a.CompareTo (b) : z - x;
            });
            foreach (string s in dict)
                Console.WriteLine (s);
        }
    }

    private static int distance (string[] arr, char a, char b) {
        int[] ax = coords (arr, a);
        int[] bx = coords (arr, b);
        return Math.Abs (ax[0] - bx[0]) + Math.Abs (ax[1] - bx[1]);
    }

    private static int[] coords (string[] arr, char a) {
        for (int x = 0; x < arr.Length; x++)
            if (arr[x].Contains ("" + a))
                return new int[] { x, arr[x].IndexOf ("" + a) };
        return new int[] {-1, -1 };
    }
}
