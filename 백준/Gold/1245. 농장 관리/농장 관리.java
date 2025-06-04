import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, cnt;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = new int[] { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dc = new int[] { 0, 0, -1, 1, -1, 1, 1, -1 };
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
	
	static void bfs(int r, int c) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { r, c });
		boolean[][] boardVisited = new boolean[n][m];
		boardVisited[r][c] = true;
		boolean flag = false;

		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			
			for (int i = 0; i < 8; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if (isValid(nr, nc)) {
					if (!boardVisited[nr][nc] && board[nr][nc] == board[r][c]) {
						dq.offer(new int[] { nr, nc });
						boardVisited[nr][nc] = true;
						visited[nr][nc] = true;
					} else if (board[nr][nc] > board[r][c]) {
						flag = true;
					}
				}
			}
			
			if (flag) return;
		}
		
		if (!flag) {
			cnt++;
//			System.out.println(r + ", " + c);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
	}
}
