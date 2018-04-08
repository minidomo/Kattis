using System;

public class ladder {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        int space = line.IndexOf (' ');
        double height = double.Parse (line.Substring (0, space));
        double degrees = double.Parse (line.Substring (space + 1));
        Console.WriteLine ((int) Math.Ceiling (height / Math.Sin (degrees * (Math.PI / 180))));
    }
}