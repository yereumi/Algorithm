import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine().trim());

        int[] pos = new int[8];
        for (int i = 0; i < 8; i++) pos[i] = i;

        for (int x : a) {
            if (Integer.bitCount(x) != 2) continue; // invalid -> ignore

            int b1 = Integer.numberOfTrailingZeros(x);
            x &= x - 1; // clear lowest set bit
            int b2 = Integer.numberOfTrailingZeros(x);

            int tmp = pos[b1];
            pos[b1] = pos[b2];
            pos[b2] = tmp;
        }

        System.out.println(pos[K]);
    }
}