using System;

public class autori {
    public static void Main (string[] args) {
        char[] name = Console.ReadLine ().ToCharArray ();
        bool isDash = false;
        Console.Write (name[0]);
        foreach (char s in name) {
            if (isDash) {
                Console.Write (s);
                isDash = false;
            }
            if (s == '-')
                isDash = true;
        }
    }
}