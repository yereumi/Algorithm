import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            long n = Long.parseLong(br.readLine().trim());

            long S1 = n * (n + 1) / 2;                  // sum k
            long S2 = n * (n + 1) * (2 * n + 1) / 6;    // sum k^2
            long S3 = S1 * S1;                          // sum k^3

            long W = (S3 + 3 * S2 + 2 * S1) / 2;
            sb.append(W).append('\n');
        }

        System.out.print(sb.toString());
    }
}