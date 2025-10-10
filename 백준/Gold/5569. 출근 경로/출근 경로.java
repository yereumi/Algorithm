import java.io.*;
import java.util.*;

public class Main {
	
	static int MOD = 100000;
	static int w, h;
	static int[][][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		dp = new int[2][2][w + 1][h + 1];
		
		for (int i = 2; i <= w; i++) dp[0][0][i][1] = 1; // 첫 행
        for (int j = 2; j <= h; j++) dp[1][0][1][j] = 1; // 첫 열

        for (int i = 2; i <= w; i++) {
            for (int j = 2; j <= h; j++) {
                // 동쪽 도착
                dp[0][0][i][j] = (dp[0][0][i - 1][j] + dp[0][1][i - 1][j]) % MOD; // 직진
                dp[0][1][i][j] = dp[1][0][i - 1][j]; // 북→동 회전

                // 북쪽 도착
                dp[1][0][i][j] = (dp[1][0][i][j - 1] + dp[1][1][i][j - 1]) % MOD; // 직진
                dp[1][1][i][j] = dp[0][0][i][j - 1]; // 동→북 회전
            }
        }

        int ans = (dp[0][0][w][h] + dp[0][1][w][h] + dp[1][0][w][h] + dp[1][1][w][h]) % MOD;
        System.out.println(ans);
	}
}
