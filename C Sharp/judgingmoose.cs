using System;

public class judgingmoose {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        int space = line.IndexOf (' ');
        int left = int.Parse (line.Substring (0, space));
        int right = int.Parse (line.Substring (space + 1));
        Console.WriteLine (left + right == 0 ? "Not a moose" : left == right ? "Even " + (right << 1) : "Odd " + (right > left ? right << 1 : left << 1));
        }
    }