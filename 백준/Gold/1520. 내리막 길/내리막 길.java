import java.util.*;
import java.io.*;

public class Main {
	static int m, n;
	static long[][] board, dp;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < m && c >= 0 && c < n;
	}
	
	static long maze(int r, int c) {
		if (r == m - 1 && c == n - 1) return 1;
		if (dp[r][c] != -1) return dp[r][c];
		
		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (isValid(nr, nc) && board[nr][nc] < board[r][c]) {
				dp[r][c] += maze(nr, nc);
			}
		}
		return dp[r][c];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		board = new long[m][n];
		dp = new long[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
			}
		}
		System.out.println(maze(0, 0));
	}
}