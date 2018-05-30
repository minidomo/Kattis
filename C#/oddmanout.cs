using System;
using System.Collections.Generic;

public class oddmanout {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        for (int x = 1; x <= cases; x++) {
            Console.ReadLine ();
            List<string> guests = new List<string> ();
            foreach (string s in Console.ReadLine ().Split (' ')) {
                if (guests.Contains (s))
                    guests.Remove (s);
                else
                    guests.Add (s);
            }
            Console.WriteLine ("Case #" + x + ": " + guests[0]);
        }
    }
}