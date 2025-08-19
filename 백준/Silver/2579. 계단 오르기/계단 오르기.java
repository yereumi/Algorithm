import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} 
		int[][] dp = new int[n][2];
		
		dp[n - 1][0] = arr[n - 1];
		dp[n - 1][1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (i == n - 2) {
				dp[i][0] = dp[i + 1][0] + arr[i];
				dp[i][1] = arr[i];
			} else if (i == n - 3) {
				dp[i][0] = arr[i];
				dp[i][1] = dp[i + 2][0] + arr[i];
			} else {
				dp[i][0] = dp[i + 1][1] + arr[i];
				dp[i][1] = Math.max(dp[i + 2][0], dp[i + 2][1]) + arr[i];
			}
		}
		if (n >= 2) {
			System.out.println(Math.max(Math.max(dp[1][0], dp[1][1]), Math.max(dp[0][0], dp[0][1])));
		} else {
			System.out.println(Math.max(dp[0][0], dp[0][1]));
		}
	}
}
