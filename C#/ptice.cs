using System;

public class ptice {
    public static void Main (string[] args) {
        string a = "ABC";
        string b = "BABC";
        string g = "CCAABB";
        int ac = 0, bc = 0, gc = 0;
        int i1 = 0, i2 = 0, i3 = 0;
        int high = 0;
        Console.ReadLine ();
        foreach (char c in Console.ReadLine ().ToCharArray ()) {
            if (c == a[i1])
                ac++;
            if (c == b[i2])
                bc++;
            if (c == g[i3])
                gc++;
            i1 = i1 == 2 ? 0 : i1 + 1;
            i2 = i2 == 3 ? 0 : i2 + 1;
            i3 = i3 == 5 ? 0 : i3 + 1;
            high = ac > high ? ac : bc > high ? bc : gc > high ? gc : high;
        }
        Console.WriteLine (high);
        if (ac == high)
            Console.WriteLine ("Adrian");
        if (bc == high)
            Console.WriteLine ("Bruno");
        if (gc == high)
            Console.WriteLine ("Goran");
    }
}