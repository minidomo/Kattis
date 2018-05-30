using System;

public class spavanac {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        int space = line.IndexOf (' ');
        int hour = int.Parse (line.Substring (0, space));
        int min = int.Parse (line.Substring (space + 1)) - 45;
        if (min < 0) {
            min += 60;
            hour--;
            if (hour < 0)
                hour = 23;
        }
        Console.WriteLine (hour + " " + min);
    }
}