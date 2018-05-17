using System;

public class reverserot {
    public static void Main (string[] args) {
        string alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
        for (;;) {
            string[] line = Console.ReadLine ().Split (' ');
            int rot = int.Parse (line[0]);
            if (rot == 0)
                break;
            string msg = line[1];
            string s = "";
            for (int x = msg.Length - 1; x >= 0; x--)
                for (int a = 0; a < alpha.Length; a++)
                    if (alpha[a] == msg[x]) {
                        s += alpha[(a + rot) % alpha.Length];
                        break;
                    }
            Console.WriteLine (s);
        }
    }
}