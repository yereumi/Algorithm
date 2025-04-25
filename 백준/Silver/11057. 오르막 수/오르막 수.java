import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n + 1][10]; // dp[i][j]: 길이가 i이고, 마지막 자릿수가 j인 오르막 수의 개수
		for (int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				dp[i][j] %= 10007;
			}
		}
		System.out.println(dp[n][9]);
	}
}