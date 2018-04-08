using System;

public class trik {
    public static void Main (string[] args) {
        string sequence = Console.ReadLine ();
        int position = 1;
        for (int x = 0; x < sequence.Length; x++) {
            string letter = sequence[x] + "";
            if (letter.Equals ("A")) {
                if (position == 1)
                    position++;
                else if (position == 2)
                    position--;
            } else if (letter.Equals ("B")) {
                if (position == 2)
                    position++;
                else if (position == 3)
                    position--;
            } else {
                if (position == 1)
                    position += 2;
                else if (position == 3)
                    position -= 2;
            }
        }
        Console.WriteLine (position);
    }
}