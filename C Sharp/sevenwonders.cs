using System;

public class sevenwonders {
    public static void Main (string[] args) {
        int t = 0;
        int c = 0;
        int g = 0;
        string line = Console.ReadLine ();
        for (int x = 0; x < line.Length; x++) {
            if (line[x] == 'T')
                t++;
            else if (line[x] == 'C')
                c++;
            else
                g++;
        }
        int min = t <= c && t <= g ? t : c <= t && c <= g ? c : g;
        Console.WriteLine ((int) (Math.Pow (t, 2) + Math.Pow (c, 2) + Math.Pow (g, 2) + (min * 7)));
    }
}