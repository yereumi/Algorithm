import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(br.readLine());

        long need = (long)(250 - L) * 100;
        long exp = 0;
        long time = 0;

        for (int i = 0; i < V; i++) {
            long remain = need - exp;
            if (remain <= 0) break;
            long rate = C;
            long needMin = (remain + rate - 1) / rate;
            long useMin = Math.min(needMin, 30);
            exp += useMin * rate;
            time += useMin;
            if (exp >= need) {
                System.out.println(time);
                return;
            }
        }

        for (int i = 0; i < S; i++) {
            long remain = need - exp;
            if (remain <= 0) break;
            long rate = B;
            long needMin = (remain + rate - 1) / rate;
            long useMin = Math.min(needMin, 30);
            exp += useMin * rate;
            time += useMin;
            if (exp >= need) {
                System.out.println(time);
                return;
            }
        }

        long remain = need - exp;
        if (remain > 0) {
            long needMin = (remain + A - 1) / A;
            time += needMin;
        }

        System.out.println(time);
    }
}
