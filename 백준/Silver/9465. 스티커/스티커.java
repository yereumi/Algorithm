import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] num = new int[2][n];
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					num[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[3][n];
			dp[0][0] = num[0][0];
			dp[1][0] = num[1][0];
			dp[2][0] = 0;
			for (int j = 1; j < n; j++) {
				dp[0][j] = Math.max(dp[1][j - 1], dp[2][j - 1]) + num[0][j];
				dp[1][j] = Math.max(dp[0][j - 1], dp[2][j - 1]) + num[1][j];
				dp[2][j] = Math.max(dp[0][j - 1], dp[1][j - 1]);
			}
			
			int result = Math.max(dp[0][n - 1], dp[1][n - 1]);
			result = Math.max(result, dp[2][n - 1]);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}
