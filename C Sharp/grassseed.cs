using System;

public class grassseed {
    public static void Main (string[] args) {
        double cost = double.Parse (Console.ReadLine ());
        int cases = int.Parse (Console.ReadLine ());
        double total = 0;
        while (cases-- > 0) {
            string line = Console.ReadLine ();
            int space = line.IndexOf (' ');
            double w = double.Parse (line.Substring (0, space));
            double h = double.Parse (line.Substring (space + 1));
            total += (w * h) * cost;
        }
        Console.WriteLine ("{0:0.0000000}", total);
    }
}