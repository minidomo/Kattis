using System;
using System.Linq;

public class lineup {
    public static void Main (string[] args) {
        string[] arr = new string[int.Parse (Console.ReadLine ())];
        for (int x = 0; x < arr.Length; x++)
            arr[x] = Console.ReadLine ();
        bool found = false;
        string[] copy = new string[arr.Length];
        Array.Copy (arr, 0, copy, 0, copy.Length);
        Array.Sort (copy);
        if (Enumerable.SequenceEqual (arr, copy)) {
            Console.WriteLine ("INCREASING");
            found = true;
        }
        Array.Sort (copy, (a, b) => b.CompareTo (a));
        if (Enumerable.SequenceEqual (arr, copy)) {
            Console.WriteLine ("DECREASING");
            found = true;
        }
        if (!found)
            Console.WriteLine ("NEITHER");
    }
}