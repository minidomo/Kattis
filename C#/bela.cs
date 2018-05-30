using System;

public class bela {
    public static void Main (string[] args) {
        string line = Console.ReadLine ();
        int space = line.IndexOf (' ');
        int hands = int.Parse (line.Substring (0, space)) * 4;
        char suit = line[space + 1];
        int points = 0;
        for (int x = 0; x < hands; x++) {
            string s = Console.ReadLine ();
            switch (s[0]) {
                case 'A':
                    points += 11;
                    break;
                case 'K':
                    points += 4;
                    break;
                case 'Q':
                    points += 3;
                    break;
                case 'J':
                    if (s[1] == suit)
                        points += 20;
                    else
                        points += 2;
                    break;
                case 'T':
                    points += 10;
                    break;
                case '9':
                    if (s[1] == suit)
                        points += 14;
                    break;
                default:
                    break;
            }
        }
        Console.WriteLine (points);
    }
}