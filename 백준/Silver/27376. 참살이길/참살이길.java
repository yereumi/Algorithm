import java.io.*;
import java.util.*;

public class Main {
    static class Light {
        int x;
        long t, s;
        Light(int x, long t, long s) { this.x = x; this.t = t; this.s = s; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Light[] L = new Light[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            L[i] = new Light(x, t, s);
        }
        Arrays.sort(L, Comparator.comparingInt(o -> o.x));

        long time = 0;
        int prev = 0;

        for (int i = 0; i < k; i++) {
            time += (L[i].x - prev);
            prev = L[i].x;

            long t = L[i].t, s = L[i].s;
            long period = 2L * t;

            if (time < s) {
                time = s;
            } else {
                long r = (time - s) % period;
                if (r >= t) {
                    time += (period - r);
                }
            }
        }

        time += (n - prev);
        System.out.println(time);
    }
}