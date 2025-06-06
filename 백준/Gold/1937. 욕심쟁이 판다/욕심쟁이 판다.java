import java.util.*;
import java.io.*;

public class Main {
	
	static int n, max = 0;
	static int[][] board, dp;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	
	static int dfs(int r, int c) {
        if (dp[r][c] != 0) return dp[r][c];

        dp[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isValid(nr, nc) && board[nr][nc] > board[r][c]) {
                dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
            }
        }
        return dp[r][c];
    }

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dfs(i, j));
			}
		}
		System.out.println(max);
	}
}
