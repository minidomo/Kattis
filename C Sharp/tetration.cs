using System;

public class tetration {
    public static void Main (string[] args) {
        double num = double.Parse (Console.ReadLine ());
        Console.WriteLine ("{0:0.000000}", Math.Pow (num, 1 / num));
    }
}