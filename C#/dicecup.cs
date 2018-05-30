using System;
using System.Collections.Generic;

public class dicecup {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        int space = line.IndexOf (' ');
        int die1 = int.Parse (line.Substring (0, space));
        int die2 = int.Parse (line.Substring (space + 1));
        int max = 0;
        SortedDictionary<int, int> sums = new SortedDictionary<int, int> ();
        for (int x = 1; x <= die1; x++) {
            for (int a = 1; a <= die2; a++) {
                int sum = a + x;
                if (sums.ContainsKey (sum))
                    sums[sum] = sums[sum] + 1;
                else
                    sums.Add (sum, 1);

                if (sums[sum] > max)
                    max = sums[sum];
            }
        }
        foreach (KeyValuePair<int, int> s in sums)
            if (s.Value == max)
                Console.WriteLine (s.Key);
    }
}