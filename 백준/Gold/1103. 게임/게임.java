import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static char[][] board;
	static int[][] dp;
	static boolean cycle;
	static boolean[][] visited;
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
	
	static int dfs(int r, int c) {
		if (!isValid(r, c) || board[r][c] == 'H') return 0;

        if (cycle) return 0;
        if (dp[r][c] != -1) return dp[r][c];

        if (visited[r][c]) {
            cycle = true;
            return 0;
        }
        
        visited[r][c] = true;

        int step = board[r][c] - '0';
        int best = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d] * step;
            int nc = c + dc[d] * step;
            
            if (!isValid(nr, nc) || board[nr][nc] == 'H') {
                best = Math.max(best, 1);
            } else {
                int next = dfs(nr, nc);
                if (cycle) {
                    visited[r][c] = false;
                    return 0;
                }
                best = Math.max(best, 1 + next);
            }
        }

        visited[r][c] = false;
        dp[r][c] = best;
        return dp[r][c];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		dp = new int[n][m];
		for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        visited = new boolean[n][m];
        cycle = false;	
		
        int ans = dfs(0, 0);
        System.out.println(cycle ? -1 : ans);
    }
}