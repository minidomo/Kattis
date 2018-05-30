using System;

public class skocimis {
    public static void Main (string[] args) {
        string[] line = Console.ReadLine ().Split (' ');
        int a = int.Parse (line[0]);
        int b = int.Parse (line[1]);
        int c = int.Parse (line[2]);
        int max = Math.Max (b - a - 1, c - b - 1);
        Console.WriteLine (max);
    }
}