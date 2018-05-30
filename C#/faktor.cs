using System;

public class faktor {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        int space = line.IndexOf (' ');
        int publish = int.Parse (line.Substring (0, space));
        int impact = int.Parse (line.Substring (space + 1)) - 1;
        Console.WriteLine ((publish * impact) + 1);
    }
}