import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long[][] dp = new long[65][10];
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= 64; i++) {
			dp[i][0] = dp[i - 1][0];
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			long sum = 0;
			for (int j = 0; j <= 9; j++) {
				sum += dp[n][j];
			}
			System.out.println(sum);
		}
	}
}