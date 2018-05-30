using System;
using System.Collections.Generic;

public class cetvrta {
    public static void Main (string[] args) {
        Dictionary<int, int> x = new Dictionary<int, int> ();
        Dictionary<int, int> y = new Dictionary<int, int> ();
        for (int a = 0; a < 3; a++) {
            string line = Console.ReadLine ();
            int space = line.IndexOf (' ');
            int x1 = int.Parse (line.Substring (0, space));
            int y1 = int.Parse (line.Substring (space + 1));
            if (!x.ContainsKey (x1))
                x.Add (x1, 1);
            else
                x[x1] = x[x1] + 1;

            if (!y.ContainsKey (y1))
                y.Add (y1, 1);
            else
                y[y1] = y[y1] + 1;
        }
        int missingx = 0;
        int missingy = 0;
        foreach (KeyValuePair<int, int> s in x)
            if (s.Value == 1)
                missingx = s.Key;
        foreach (KeyValuePair<int, int> s in y)
            if (s.Value == 1)
                missingy = s.Key;
        Console.WriteLine (missingx + " " + missingy);
    }
}