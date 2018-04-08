using System;
using System.Collections.Generic;

public class cups {
    public static void Main (string[] args) {
        SortedDictionary<int, string> sort = new SortedDictionary<int, string> ();
        int cases = int.Parse (Console.ReadLine ());
        while (cases-- > 0) {
            string[] line = Console.ReadLine ().Split (' ');
            string color;
            int d;
            if (line[0][0] >= '0' && line[0][0] <= '9') {
                color = line[1];
                d = int.Parse (line[0]);
            } else {
                color = line[0];
                d = int.Parse (line[1]) * 2;
            }
            sort.Add (d, color);
        }
        foreach (KeyValuePair<int, string> s in sort)
            Console.WriteLine (s.Value);
    }
}