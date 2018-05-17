using System;

public class bijele {
    public static void Main (string[] args) {
        int[] ori = { 1, 1, 2, 2, 2, 8 };
        int i = 0;
        foreach (string s in Console.ReadLine ().Split (' '))
            Console.Write (ori[i++] - int.Parse (s) + " ");
    }
}