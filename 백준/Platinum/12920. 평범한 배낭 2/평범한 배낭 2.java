import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dp = new int[m + 1];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 1; k > 0; j++) {
				int take = Math.min(j, k);
				int nv = v * take;
				int nc = c * take;
				
				for (int p = m - nv; p >= 0; p--) {
					dp[p + nv] = Math.max(dp[p] + nc, dp[p + nv]);
				}
				k -= take;
			}
		}
		System.out.println(dp[m]);
	}
}