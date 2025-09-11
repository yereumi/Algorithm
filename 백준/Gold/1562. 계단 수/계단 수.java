import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 1_000_000_000L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][][] dp = new long[n + 1][10][1024];
		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}
		for (int len = 2; len <= n; len++) {
            for (int last = 0; last <= 9; last++) {
                for (int mask = 0; mask < 1024; mask++) {
                    long add = 0;

                    if (last - 1 >= 0) {
                        add = dp[len - 1][last - 1][mask];
                        if (add != 0) {
                            int nextMask = mask | (1 << last);
                            dp[len][last][nextMask] = (dp[len][last][nextMask] + add) % MOD;
                        }
                    }
                    if (last + 1 <= 9) {
                        add = dp[len - 1][last + 1][mask];
                        if (add != 0) {
                            int nextMask = mask | (1 << last);
                            dp[len][last][nextMask] = (dp[len][last][nextMask] + add) % MOD;
                        }
                    }
                }
            }
        }
		long sum = 0;
		int FULL = (1<<10) - 1;
		for (int i = 0; i <= 9; i++) {
			sum = (sum + dp[n][i][FULL]) % MOD;
		}
		System.out.println(sum);
	}
}