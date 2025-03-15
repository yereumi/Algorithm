import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		int n = read();
		int[][] num = new int[n][2];
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			num[i][0] = read();
			num[i][1] = read();
		}
		for (int i = 0; i < n; i++) {
			int t = num[i][0];
			int p = num[i][1];
            if (i + t <= n) dp[i + t] = Math.max(dp[i + t], dp[i] + p);
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[n]);
	}
}