import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[2][3];
		for (int i = 0; i < 3; i++) {
			dp[0][i] = dp[1][i] = num[0][i];
		}
		int[][] new_dp = new int[2][3];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				new_dp[0][j] = new_dp[1][j] = num[i][j];
				
				if (j == 0) {
					new_dp[0][j] += Math.max(dp[0][j], dp[0][j + 1]);
					new_dp[1][j] += Math.min(dp[1][j], dp[1][j + 1]);
				} else if (j == 2) {
					new_dp[0][j] += Math.max(dp[0][j - 1], dp[0][j]);
					new_dp[1][j] += Math.min(dp[1][j - 1], dp[1][j]);
				} else {
					new_dp[0][j] += Math.max(dp[0][j], Math.max(dp[0][j - 1], dp[0][j + 1]));
					new_dp[1][j] += Math.min(dp[1][j], Math.min(dp[1][j - 1], dp[1][j + 1]));
				}
			}
			
			for (int j = 0; j < 3; j++) {
				dp[0][j] = new_dp[0][j];
				dp[1][j] = new_dp[1][j];
			}
		}
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dp[0][i]);
			min = Math.min(min, dp[1][i]);
		}
		System.out.println(max + " " + min);
	}
}