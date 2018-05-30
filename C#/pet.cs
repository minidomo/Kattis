using System;

public class pet {
    public static void Main (string[] args) {
        int max = 0;
        int index = 0;
        for (int x = 1; x <= 5; x++) {
            int sum = 0;
            foreach (string s in Console.ReadLine ().Split (' '))
                sum += int.Parse (s);
            if (sum > max) {
                max = sum;
                index = x;
            }
        }
        Console.WriteLine (index + " " + max);
    }
}