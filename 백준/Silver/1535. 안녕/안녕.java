import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stamina = new int[n + 1];
		int[] delight = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) stamina[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) delight[i] = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n + 1][100];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < stamina[i]; j++) dp[i][j] = dp[i - 1][j];
			for (int j = stamina[i]; j < 100; j++) {
				if (j - stamina[i] < 0) continue;
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stamina[i]] + delight[i]);
			}
		}
		System.out.println(dp[n][99]);
		br.close();
	}
}
