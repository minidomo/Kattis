using System;

public class icpcawards {
    public static void Main (string[] args) {
        int cases = int.Parse (Console.ReadLine ());
        string[] teams = new string[12];
        int i = 0;
        bool isDone = false;
        while (cases-- > 0) {
            string line = Console.ReadLine ();
            if (!isDone) {
                int space = line.IndexOf (' ');
                string uni = line.Substring (0, space);
                string team = line.Substring (space);
                bool seen = false;
                foreach (string s in teams)
                    if (!String.IsNullOrEmpty (s) && s.Contains (uni)) {
                        seen = true;
                        break;
                    }
                if (!seen) {
                    teams[i++] = uni + team;
                    if (i == 12)
                        isDone = true;
                }
            }
        }
        foreach (string s in teams)
            Console.WriteLine (s);
    }
}