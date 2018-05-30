using System;

public class quadrant {
    public static void Main (string[] args) {
        int x = int.Parse (Console.ReadLine ());
        int y = int.Parse (Console.ReadLine ());
        Console.WriteLine (x > 0 ? y > 0 ? 1 : 4 : y > 0 ? 2 : 3);
    }
}