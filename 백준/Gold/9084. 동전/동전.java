import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int t = read();
		while (t-- > 0) {
			int n = read();
			int[] coin = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				coin[i] = read();
			}
			Arrays.sort(coin);
			int m = read();
			int[] dp = new int[m + 1];
			dp[0] = 1;
			for (int c : coin) {
				for (int i = c; i <= m; i++) {
					dp[i] += dp[i - c];
				}
			}
			sb.append(dp[m] / 2).append("\n");
		}
		System.out.println(sb);	
	}
}