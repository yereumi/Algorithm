import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] time = new int[k][2];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n + 1];
		int max = 0;
		
		for (int i = 0; i < k; i++) {
			for (int j = n; j >= time[i][1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - time[i][1]] + time[i][0]);
				max = Math.max(max, dp[j]);
			}
		}
		
		System.out.println(max);
	}
}
