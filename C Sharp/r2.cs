using System;

public class r2 {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        int space = line.IndexOf (' ');
        int fnum = int.Parse (line.Substring (0, space));
        int avg = int.Parse (line.Substring (space + 1));
        Console.WriteLine ((avg * 2) - fnum);
    }
}