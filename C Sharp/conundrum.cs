using System;

public class conundrum {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        int day = 0;
        for (int x = 0; x < line.Length; x += 3) {
            if (line[x] != 'P')
                day++;
            if (line[x + 1] != 'E')
                day++;
            if (line[x + 2] != 'R')
                day++;
        }
        Console.WriteLine (day);
    }
}