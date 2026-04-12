import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N][21];
		dp[0][num[0]] = 1;
		
		for (int i = 1; i < N - 1; i++) {
			for (int v = 0; v <= 20; v++) {
                if (dp[i - 1][v] == 0) continue;

                int plus = v + num[i];
                int minus = v - num[i];

                if (plus <= 20) dp[i][plus] += dp[i - 1][v];
                if (minus >= 0) dp[i][minus] += dp[i - 1][v];
            }
		}
		
		System.out.println(dp[N - 2][num[N - 1]]);
	}
}
