import java.io.*;
import java.util.*;

public class Main {

	static int n, m, max;
	static int[][] mars;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		mars = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				mars[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = 0;
		dp = new int[n][m];

		dp[0][0] = mars[0][0];
		for (int x = 1; x < m; x++) {
			dp[0][x] = dp[0][x - 1] + mars[0][x];
		}

		for (int y = 1; y < n; y++) {
			int[] left = new int[m];
			int[] right = new int[m];

			// 왼 -> 오
			left[0] = dp[y - 1][0] + mars[y][0];
			for (int x = 1; x < m; x++) {
				left[x] = Math.max(left[x - 1], dp[y - 1][x]) + mars[y][x];
			}

			// 오 -> 왼
			right[m - 1] = dp[y - 1][m - 1] + mars[y][m - 1];
			for (int x = m - 2; x >= 0; x--) {
				right[x] = Math.max(right[x + 1], dp[y - 1][x]) + mars[y][x];
			}

			// 둘 중 최대값으로 dp 업데이트
			for (int x = 0; x < m; x++) {
				dp[y][x] = Math.max(left[x], right[x]);
			}
		}

		System.out.println(dp[n - 1][m - 1]);
		br.close();
	}
}
