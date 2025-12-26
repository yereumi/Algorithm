import java.io.*;
import java.util.*;

public class Main {

    static boolean isAllSame(int[] c) {
        int first = c[0];
        for (int x : c) {
            if (x != first) return false;
        }
        return true;
    }

    static void makeEven(int[] c) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] % 2 == 1) c[i]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] c = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }

            makeEven(c);

            int count = 0;

            while (!isAllSame(c)) {
                int[] half = new int[N];

                for (int i = 0; i < N; i++) {
                    half[i] = c[i] / 2;
                    c[i] -= half[i];
                }

                for (int i = 0; i < N; i++) {
                    c[(i + 1) % N] += half[i];
                }

                makeEven(c);

                count++;
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb.toString());
    }
}
