using System;
using System.Collections.Generic;

public class metaprogramming {
    public static void Main (string[] args) {
        Dictionary<string, int> vars = new Dictionary<string, int> ();

        string line;
        while ((line = Console.ReadLine ()) != null) {
            string[] arr = line.Split (' ');
            if (arr[0].Equals ("define"))
                if (vars.ContainsKey (arr[2]))
                    vars[arr[2]] = int.Parse (arr[1]);
                else
                    vars.Add (arr[2], int.Parse (arr[1]));
            else if (!(vars.ContainsKey (arr[1]) && vars.ContainsKey (arr[3])))
                Console.WriteLine ("undefined");
            else
                Console.WriteLine (arr[2].Equals (">") ? vars[arr[1]] > vars[arr[3]] : (arr[2].Equals ("<") ? vars[arr[1]] < vars[arr[3]] : vars[arr[1]] == vars[arr[3]]));
        }
    }
}