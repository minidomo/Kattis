using System;
using System.Linq;

public class nodup {
    public static void Main (string[] args) {
        string[] words = Console.ReadLine ().Split (' ');
        Console.WriteLine (words.Distinct ().Count () != words.Count () ? "NO" : "YES");
    }
}