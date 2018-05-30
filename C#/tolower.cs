using System;

public class tolower {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        int space = line.IndexOf (' ');
        int problems = int.Parse (line.Substring (0, space));
        int cases = int.Parse (line.Substring (space + 1));
        int max = problems;
        for (int z = 0; z < problems; z++) {
            bool moreUpper = false;
            for (int x = 0; x < cases; x++) {
                string s = Console.ReadLine ();
                if (!moreUpper) {
                    for (int a = 1; a < s.Length; a++) {
                        if (char.IsUpper (s[a])) {
                            moreUpper = true;
                            break;
                        }
                    }
                }
            }
            if (moreUpper)
                max--;
        }
        Console.WriteLine (max);
    }
}