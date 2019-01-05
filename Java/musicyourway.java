import java.io.*;
import java.util.*;

public class musicyourway {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        String[] atr = original.split(" ");
        int size = sc.nextInt();
        Music[] arr = new Music[size];
        sc.nextLine();
        for (int x = 0; x < size; x++)
            arr[x] = new Music(sc.nextLine().split(" "));
        int cases = sc.nextInt();
        sc.nextLine();
        while (cases-- > 0) {
            String line = sc.nextLine();
            int index = 0;
            for (int x = 0; x < atr.length; x++)
                if (atr[x].equals(line)) {
                    index = x;
                    break;
                }
            Arrays.sort(arr, Music.getComp(index));
            System.out.println(original);
            for (Music a : arr)
                System.out.println(a);
            System.out.println();
        }
        sc.close();
    }
}

class Music {
    public String[] arr;

    public Music(String[] arr) {
        this.arr = arr;
    }

    public static Comparator<Music> getComp(int i) {
        return new Comparator<Music>() {
            public int compare(Music a, Music b) {
                return a.arr[i].compareTo(b.arr[i]);
            }
        };
    }

    public String toString() {
        String s = "";
        for (String a : arr)
            s += a + " ";
        return s;
    }
}