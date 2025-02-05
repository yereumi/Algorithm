import java.util.*;
import java.io.*;

public class Main {	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] rgb = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long answer = Integer.MAX_VALUE;
		long[][] dp = new long[n + 1][3];
		
		// 1번째 집이 r일 때
		dp[1][0] = rgb[1][0];
		dp[1][1] = dp[1][2] = Integer.MAX_VALUE;
		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
		}
		answer = Math.min(answer, dp[n][1]);
		answer = Math.min(answer, dp[n][2]);
		
		// 1번째 집이 g일 때
		dp[1][1] = rgb[1][1];
		dp[1][0] = dp[1][2] = Integer.MAX_VALUE;
		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
		}
		answer = Math.min(answer, dp[n][0]);
		answer = Math.min(answer, dp[n][2]);
	
		// 1번째 집이 b일 때
		dp[1][2] = rgb[1][2];
		dp[1][0] = dp[1][1] = Integer.MAX_VALUE;
		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
		}
		answer = Math.min(answer, dp[n][0]);
		answer = Math.min(answer, dp[n][1]);
		
		System.out.println(answer);
	}
}
