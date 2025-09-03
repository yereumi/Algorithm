import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dp = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int page = Integer.parseInt(st.nextToken());
			
			for (int j = n; j >= day; j--) {
				dp[j] = Math.max(dp[j], dp[j - day] + page);
			}
		}
		System.out.println(dp[n]);
	}
}