using System;

public class pot {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        int sum = 0;
        while (cases-- > 0) {
            string line = Console.ReadLine ();
            int num = int.Parse (line.Substring (0, line.Length - 1));
            int pow = int.Parse (line.Substring (line.Length - 1));
            sum += (int) Math.Pow (num, pow);
        }
        Console.WriteLine (sum);
    }
}