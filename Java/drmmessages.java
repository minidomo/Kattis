
// https://open.kattis.com/problems/drmmessages
import java.util.Scanner;

public class drmmessages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String encryption = sc.next().toUpperCase();
        int half = encryption.length() / 2;
        String firstSplit = encryption.substring(0, half);
        String secondSplit = encryption.substring(half);

        int[] alphabetPos1 = new int[half];
        int[] alphabetPos2 = new int[half];

        char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        int pos1 = 0, pos2 = 0;
        int index1 = 0, index2 = 0;
        for (int x = 0; x < half; x++) {
            for (int s = 0; s < alphabet.length; s++) {
                if (firstSplit.charAt(x) == alphabet[s]) {
                    pos1 = (pos1 + s) % 26;
                    alphabetPos1[index1] = s;
                    index1++;
                }
                if (secondSplit.charAt(x) == alphabet[s]) {
                    pos2 = (pos2 + s) % 26;
                    alphabetPos2[index2] = s;
                    index2++;
                }
            }
        }
        String merge = "";
        for (int s = 0; s < half; s++) {
            int rotatedPos1 = (alphabetPos1[s] + pos1) % 26;

            int rotatedPos2 = (alphabetPos2[s] + pos2) % 26;

            int newLetterPos = (rotatedPos1 + rotatedPos2) % 26;
            merge += alphabet[newLetterPos];
        }
        System.out.println(merge);
        sc.close();
    }
}