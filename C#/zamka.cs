using System;

public class zamka {
    public static void Main (string[] args) {
        int low = int.Parse (Console.ReadLine ()) - 1;
        int high = int.Parse (Console.ReadLine ());
        int x = int.Parse (Console.ReadLine ());
        int min = 0;
        int max = 0;
        while (low++ <= high) {
            char[] digits = low.ToString ().ToCharArray ();
            int sum = 0;
            foreach (char s in digits)
                sum += int.Parse (s + "");
            if (sum == x) {
                if (min == 0) {
                    min = low;
                    max = low;
                }
                max = low;
            }
        }
        Console.WriteLine (min + "\n" + max);
    }
}