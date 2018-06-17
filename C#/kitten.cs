using System;
using System.Collections.Generic;
using System.Linq;

public class kitten {
    public static void Main (string[] args) {
        string start = Console.ReadLine ();
        Dictionary<List<string>, string> map = new Dictionary<List<string>, string> ();
        for (;;) {
            string line = Console.ReadLine ();
            if (line.Equals ("-1"))
                break;
            int space = line.IndexOf (' ');
            map.Add (line.Substring (space + 1, line.Length - (space + 1)).Split (' ').ToList (), line.Substring (0, space));
        }
        Console.Write (start + " ");
        bool done = false;
        while (!done) {
            done = true;
            foreach (KeyValuePair<List<string>, string> s in map)
                if (s.Key.Contains (start)) {
                    done = false;
                    start = s.Value;
                    break;
                }
            if (!done)
                Console.Write (start + " ");
        }
    }
}