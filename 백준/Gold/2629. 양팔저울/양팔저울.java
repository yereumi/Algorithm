import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_SUM = 15000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum += num[i];
        }

        int m = Integer.parseInt(br.readLine());
        int[] ans = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) ans[i] = Integer.parseInt(st.nextToken());

        boolean[] dp = new boolean[MAX_SUM + 1];
        dp[0] = true;
        
        for (int w : num) {
            boolean[] next = new boolean[MAX_SUM + 1];
            for (int d = 0; d <= MAX_SUM; d++) {
                if (!dp[d]) continue;
                next[d] = true;
                if (d + w <= MAX_SUM) next[d + w] = true;
                int diff = Math.abs(d - w);
                next[diff] = true;
            }
            dp = next;
        }

        StringBuilder sb = new StringBuilder();
        for (int x : ans) {
            if (x > sum || x > MAX_SUM) sb.append('N').append(' ');
            else sb.append(dp[x] ? 'Y' : 'N').append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}