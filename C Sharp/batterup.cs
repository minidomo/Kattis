using System;

public class batterup {
    public static void Main (string[] args) {
        double cases = int.Parse (Console.ReadLine ());
        double total = 0;
        foreach (string s in Console.ReadLine ().Split (' ')) {
            if (!s.Equals ("-1") && !s.Equals ("0"))
                total += int.Parse (s);
            else if (s.Equals ("-1"))
                cases--;
        }
        Console.WriteLine (total / cases);
    }
}