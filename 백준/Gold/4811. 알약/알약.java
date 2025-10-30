import java.io.*;
import java.util.*;

public class Main {

    static long[][] dp = new long[31][31];

    static long dfs(int w, int h) {
        if (w == 0 && h == 0) return 1;
        if (dp[w][h] != 0) return dp[w][h];

        long ways = 0;

        if (w > 0) ways += dfs(w - 1, h + 1);
        if (h > 0) ways += dfs(w, h - 1);

        return dp[w][h] = ways;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            System.out.println(dfs(n, 0));
        }
    }
}