import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if (B == 0 && N == 0) break;

            BigInteger target = BigInteger.valueOf(B);

            int lo = 0, hi = B;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                BigInteger p = BigInteger.valueOf(mid).pow(N);
                int cmp = p.compareTo(target);
                if (cmp <= 0) lo = mid + 1;
                else hi = mid - 1;
            }
            int a = hi;
            BigInteger pa = BigInteger.valueOf(a).pow(N);
            BigInteger pb = BigInteger.valueOf(a + 1).pow(N);

            BigInteger diffA = target.subtract(pa).abs();
            BigInteger diffB = pb.subtract(target).abs();

            int ans = (diffA.compareTo(diffB) <= 0) ? a : (a + 1);
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}