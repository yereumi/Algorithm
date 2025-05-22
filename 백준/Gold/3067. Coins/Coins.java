import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] coin = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			int money = Integer.parseInt(br.readLine());
			int[] dp = new int[money + 1];
			dp[0] = 1;
			
			for (int i = 0; i < n; i++) {
				for (int j = coin[i]; j <= money; j++) {
					dp[j] += dp[j - coin[i]];
				}
			}
			sb.append(dp[money]).append("\n");
		}
		System.out.println(sb);
	}
}