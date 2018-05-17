using System;
using System.Linq;

public class filip {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        int space = line.IndexOf (' ');
        char[] digits1 = line.Substring (0, space).ToCharArray ();
        char[] digits2 = line.Substring (space + 1).ToCharArray ();
        Array.Reverse (digits1);
        Array.Reverse (digits2);
        string temp = "";
        foreach (char s in digits1)
            temp += s + "";
        int fnum = int.Parse (temp);
        temp = "";
        foreach (char s in digits2)
            temp += s + "";
        int snum = int.Parse (temp);
        Console.WriteLine(fnum > snum ? fnum : snum);
    }
}