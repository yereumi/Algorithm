import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n + 1];
		for (int i = 1; i <= 3; i++) {
			if (i <= n) dp[i] = i;
		}
		for (int i = 4; i <= n; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1] + 1);
			for (int j = 2; j <= i - 2; j++) {
				dp[i] = Math.max(dp[i], dp[i - j - 1] * j);
			}
		}
		System.out.println(dp[n]);
	}
}