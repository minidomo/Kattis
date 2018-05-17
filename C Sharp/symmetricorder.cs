using System;

public class symmetricorder {
    public static void Main (string[] args) {
        for (int set = 1;; set++) {
            int cases = int.Parse (Console.ReadLine ());
            if (cases == 0)
                break;
            Console.WriteLine ("SET " + set);
            string[] names = new string[cases];
            int x = 0;
            for (int y = names.Length - 1; x < cases / 2; x++, y--) {
                names[x] = Console.ReadLine ();
                names[y] = Console.ReadLine ();
            }
            if ((cases & 1) != 0)
                names[x] = Console.ReadLine ();
            foreach (string s in names)
                Console.WriteLine (s);
        }
    }
}