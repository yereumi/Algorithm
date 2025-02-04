import java.util.*;
import java.io.*;

public class Main {	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] rgb = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) { // r일 때
					dp[i][j] = rgb[i - 1][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
				} else if (j == 1) { // g일 때
					dp[i][j] = rgb[i - 1][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
				} else if (j == 2) { // b일 때
					dp[i][j] = rgb[i - 1][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			answer = Math.min(answer, dp[n][i]);
		}
		System.out.println(answer);
	}
}
