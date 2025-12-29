import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int b1 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[] order = new int[m];
		for (int i = 0; i < m; i++) {
			order[i] = Integer.parseInt(br.readLine());
		}

		int[][][] dp = new int[m + 1][n + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}

		dp[0][b1][b2] = 0;
		for (int i = 0; i < m; i++) {
			int next = order[i];
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					if (dp[i][a][b] == Integer.MAX_VALUE) continue;

					// 이미 열려 있으면 그대로
					if (next == a || next == b) {
						dp[i + 1][a][b] = Math.min(dp[i + 1][a][b], dp[i][a][b]);
					} else {
						// a를 이동
						int na = Math.min(next, b);
						int nb = Math.max(next, b);
						dp[i + 1][na][nb] = Math.min(dp[i + 1][na][nb], dp[i][a][b] + Math.abs(a - next));

						// b를 이동
						na = Math.min(a, next);
						nb = Math.max(a, next);
						dp[i + 1][na][nb] = Math.min(dp[i + 1][na][nb], dp[i][a][b] + Math.abs(b - next));
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				min = Math.min(min, dp[m][i][j]);
			}
		}
		System.out.println(min);
	}
}
