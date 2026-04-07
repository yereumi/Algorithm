import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 0; t < 3; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] num = new int[N][2];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				num[i][0] = Integer.parseInt(st.nextToken());
				num[i][1] = Integer.parseInt(st.nextToken());
				sum += num[i][0] * num[i][1];
			}
			
			if (sum % 2 == 1) {
				sb.append(0).append("\n");
				continue;
			}
			
			int half = sum / 2;
			int[] dp = new int[half + 1];
			Arrays.fill(dp, -1);
			dp[0] = 0;
			
			for (int i = 0; i < N; i++) {
				int coin = num[i][0];
				int cnt = num[i][1];
				
				for (int j = 0; j <= half; j++) {
					if (dp[j] >= 0) {
						dp[j] = cnt;
					} else if (j >= coin && dp[j - coin] > 0) {
						dp[j] = dp[j - coin] - 1;
					}
				}
			}
			
			sb.append(dp[half] >= 0 ? 1 : 0).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
