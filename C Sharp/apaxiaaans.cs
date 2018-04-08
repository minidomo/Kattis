using System;

public class apaxiaaans {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        string last = "";
        for (int x = 0; x < line.Length - 1; x++)
            if (line[x] != line[x + 1])
                last += line[x];
        Console.WriteLine (last + line[line.Length - 1]);
    }
}