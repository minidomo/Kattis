using System;

public class drmmessages {
    public static void Main (string[] args) {
        string msg = Console.ReadLine ();
        char[] fhalf = msg.Substring (0, msg.Length / 2).ToCharArray ();
        char[] shalf = msg.Substring (msg.Length / 2).ToCharArray ();
        string alpha = "abcdefghijklmnopqrstuvwxyz".ToUpper ();
        int change1 = 0;
        int change2 = 0;
        for (int x = 0; x < fhalf.Length; x++) {
            change1 += alpha.IndexOf (fhalf[x]);
            change2 += alpha.IndexOf (shalf[x]);
        }
        for (int x = 0; x < fhalf.Length; x++) {
            fhalf[x] = (char) (((fhalf[x] % 'A') + change1) % 26 + 'A');
            shalf[x] = (char) (((shalf[x] % 'A') + change2) % 26 + 'A');
        }
        for (int x = 0; x < fhalf.Length; x++)
            fhalf[x] = (char) (((fhalf[x] + shalf[x]) % 'A') % 26 + 'A');
        Console.WriteLine (fhalf);
    }
}