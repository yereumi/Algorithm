import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] items = new int[l][2]; // { 무게, 가치 }
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[l + 1][c + 1];
		for (int i = 1; i <= l; i++) {
			for (int j = 1; j <= c; j++) {
				if (j >= items[i - 1][0]) {
					dp[i][j] = 
							Math.max(dp[i - 1][j], dp[i - 1][j - items[i - 1][0]] + items[i - 1][1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[l][c]);
	}
}
