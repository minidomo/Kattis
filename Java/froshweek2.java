import java.io.*;
import java.util.*;

public class froshweek2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] taskTime = new int[N];
        int[] quietTime = new int[M];
        for (int x = 0; x < N; x++)
            taskTime[x] = sc.nextInt();
        for (int x = 0; x < M; x++)
            quietTime[x] = sc.nextInt();
        Arrays.sort(taskTime);
        Arrays.sort(quietTime);
        int count = 0;
        for (int a = 0, b = 0; a < M && b < N;) {
            if (taskTime[b] <= quietTime[a]) {
                b++;
                a++;
                count++;
            } else
                a++;
        }
        System.out.println(count);
        sc.close();
    }
}