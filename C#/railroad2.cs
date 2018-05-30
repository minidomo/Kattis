using System;

public class railroad2 {
    public static void Main (string[] args) {
        Console.WriteLine ((int.Parse (Console.ReadLine ().Split (' ') [1]) & 1) == 0 ? "possible" : "impossible");
    }
}