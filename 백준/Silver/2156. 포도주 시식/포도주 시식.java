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
		int n = read();
		int[] wine = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			wine[i] = read();
		}
		int[] dp = new int[n + 2];
		dp[1] = wine[1];
		if (n >= 2) dp[2] = dp[1] + wine[2];
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + wine[i]), dp[i - 3] + wine[i - 1]+ wine[i]);
		}
		System.out.println(dp[n]);
	}
}
