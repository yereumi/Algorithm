import java.io.*;
import java.util.*;

public class Main {
    static String key(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(a[i]);
        }
        return sb.toString();
    }

    static boolean isZero(int[] a) {
        for (int v : a) if (v != 0) return false;
        return true;
    }

    static int[] next(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            b[i] = Math.abs(a[i] - a[j]);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cur = new int[n];
            for (int i = 0; i < n; i++) cur[i] = Integer.parseInt(st.nextToken());

            HashSet<String> seen = new HashSet<>();
            while (true) {
                if (isZero(cur)) {
                    out.append("ZERO\n");
                    break;
                }
                String k = key(cur);
                if (!seen.add(k)) {
                    out.append("LOOP\n");
                    break;
                }
                cur = next(cur);
            }
        }
        System.out.print(out.toString());
    }
}
