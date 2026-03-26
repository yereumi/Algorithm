import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] num = new int[T + 1];
		for (int i = 1; i <= T; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[T + 1][W + 1];

		for (int t = 1; t <= T; t++) {
			for (int w = 0; w <= W; w++) {
				int pos = (w % 2 == 0) ? 1 : 2;

				dp[t][w] = dp[t - 1][w];

				if (w > 0) dp[t][w] = Math.max(dp[t][w], dp[t - 1][w - 1]);
				if (pos == num[t]) dp[t][w]++;
			}
		}

		int answer = 0;
		for (int w = 0; w <= W; w++) {
			answer = Math.max(answer, dp[T][w]);
		}

		System.out.println(answer);
	}
}
