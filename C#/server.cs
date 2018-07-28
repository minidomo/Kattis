using System;

public class server {
    public static void Main (string[] args) {
        int time = int.Parse (Console.ReadLine ().Split (' ') [1]);
        int sum = 0, count = 0;
        foreach (string s in Console.ReadLine ().Split (' ')) {
            sum += int.Parse (s);
            if (sum > time)
                break;
            count++;
        }
        Console.WriteLine (count);
    }
}