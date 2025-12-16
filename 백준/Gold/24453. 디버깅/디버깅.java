import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] error = new int[M + 2];
        error[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            error[i] = Integer.parseInt(st.nextToken());
        }
        error[M + 1] = N + 1;

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int minFixed = Integer.MAX_VALUE;
        int j = Y + 1;

        for (int i = 0; i <= M; i++) {
            if (j < i + Y + 1) j = i + Y + 1;

            while (j <= M + 1 && error[j] - error[i] - 1 < X) {
                j++;
            }

            if (j <= M + 1) {
                int fixed = j - i - 1;
                if (fixed >= Y) minFixed = Math.min(minFixed, fixed);
            }
        }

        if (minFixed == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(M - minFixed);
    }
}
