using System;
using System.Collections.Generic;

public class boatparts {
    public static void Main (string[] args) {
        string[] line = Console.ReadLine ().Split (' ');
        int total = int.Parse (line[0]);
        int days = int.Parse (line[1]);
        bool found = false;
        SortedSet<string> parts = new SortedSet<string> ();
        for (int x = 1; x <= days; x++) {
            parts.Add (Console.ReadLine ());
            if (parts.Count == total) {
                Console.WriteLine (x);
                found = true;
                break;
            }
        }
        if (!found)
            Console.WriteLine ("paradox avoided");
    }
}