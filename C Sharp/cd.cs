using System;
using System.Collections.Generic;

public class cd {
    public static void Main (string[] args) {
        for (;;) {
            string[] line = Console.ReadLine ().Split (' ');
            if (line[0].Equals ("0") && line[1].Equals ("0"))
                break;
            int total = int.Parse (line[0]) + int.Parse (line[1]);
            HashSet<string> cds = new HashSet<string> ();
            for (int x = 0; x < total; x++)
                cds.Add (Console.ReadLine ());
            Console.WriteLine (total - cds.Count);
        }
    }
}